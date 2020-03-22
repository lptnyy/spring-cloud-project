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
}
