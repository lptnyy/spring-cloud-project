package com.wzy.system.configuration.mybitsplus;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import groovy.util.logging.Slf4j;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@Slf4j
@Configuration
@EnableConfigurationProperties(ShardingMastSlaveConfig.class)
@ConditionalOnProperty({"sharding.jdbc.data-sources.ds_master.url", "sharding.jdbc.master-slave-rule.master-data-source-name"})
@Data
public class ShardingDataSourceConfig {

    @Autowired
    private ShardingMastSlaveConfig shardingMastSlaveConfig;

    @Bean("masterSlaveDataSource")
    public DataSource masterSlaveDataSource() throws SQLException {
        shardingMastSlaveConfig.getDataSources().forEach((k, v) -> configDataSource(v));
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        dataSourceMap.putAll(shardingMastSlaveConfig.getDataSources());
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, shardingMastSlaveConfig.getMasterSlaveRule(), Maps.newHashMap());
        return dataSource;
    }

    private void configDataSource(DruidDataSource druidDataSource) {
        druidDataSource.setMaxActive(shardingMastSlaveConfig.maxActive);
        druidDataSource.setInitialSize(shardingMastSlaveConfig.initialSize);
        druidDataSource.setMaxWait(shardingMastSlaveConfig.maxWait);
        druidDataSource.setMinIdle(shardingMastSlaveConfig.minIdle);
        druidDataSource.setTimeBetweenEvictionRunsMillis(shardingMastSlaveConfig.timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(shardingMastSlaveConfig.minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(shardingMastSlaveConfig.validationQuery);
        druidDataSource.setTestWhileIdle(shardingMastSlaveConfig.testWhileIdle);
        druidDataSource.setTestOnBorrow(shardingMastSlaveConfig.testOnBorrow);
        druidDataSource.setTestOnReturn(shardingMastSlaveConfig.testOnReturn);
        druidDataSource.setPoolPreparedStatements(shardingMastSlaveConfig.poolPreparedStatements);
        druidDataSource.setMaxOpenPreparedStatements(shardingMastSlaveConfig.maxOpenPreparedStatements);
        druidDataSource.setUseGlobalDataSourceStat(shardingMastSlaveConfig.useGlobalDataSourceStat);

        try {
            druidDataSource.setFilters("stat,wall,slf4j");
        } catch (SQLException e) {

        }
    }
}
