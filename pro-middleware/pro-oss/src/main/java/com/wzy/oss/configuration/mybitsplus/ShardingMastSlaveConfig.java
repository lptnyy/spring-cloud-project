package com.wzy.oss.configuration.mybitsplus;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "sharding.jdbc")
@Data
public class ShardingMastSlaveConfig {
    private Map<String, DruidDataSource> dataSources = new HashMap<>();
    private MasterSlaveRuleConfiguration masterSlaveRule;
    //@Value("${sharding.jdbc.maxActive}")
    Integer maxActive;
    //@Value("${sharding.jdbc.initialSize}")
    Integer initialSize;
    //@Value("${sharding.jdbc.maxWait}")
    Integer maxWait;
    //@Value("${sharding.jdbc.minIdle}")
    Integer minIdle;
    //@Value("${sharding.jdbc.testOnBorrow}")
    Boolean testOnBorrow;
    //@Value("${sharding.jdbc.testOnReturn}")
    Boolean testOnReturn;
    //@Value("${sharding.jdbc.poolPreparedStatements}")
    Boolean poolPreparedStatements;
    //@Value("${sharding.jdbc.maxOpenPreparedStatements}")
    Integer maxOpenPreparedStatements;
    //@Value("${sharding.jdbc.useGlobalDataSourceStat}")
    Boolean useGlobalDataSourceStat;
    //@Value("${sharding.jdbc.timeBetweenEvictionRunsMillis}")
    Integer timeBetweenEvictionRunsMillis;
    //@Value("${sharding.jdbc.minEvictableIdleTimeMillis}")
    Integer minEvictableIdleTimeMillis;
    //@Value("${sharding.jdbc.validationQuery}")
    String validationQuery;
    //@Value("${sharding.jdbc.testWhileIdle}")
    Boolean testWhileIdle;
}
