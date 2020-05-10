package com.wzy.oss.configuration.mybitsplus;

import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List sqlParselist = new ArrayList();
        sqlParselist.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParselist);
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setPlugins(new Interceptor[]{
                paginationInterceptor,
                new OptimisticLockerInterceptor()
        });
        mybatisSqlSessionFactoryBean.setDataSource(new DataSourceProxy(dataSource));
        return mybatisSqlSessionFactoryBean.getObject();
    }
}
