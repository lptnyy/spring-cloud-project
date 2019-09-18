package com.wzy.order;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan("com.wzy.mapper")
@EnableFeignClients({
        "com.wzy.redis"
})
@ComponentScans({
        @ComponentScan("com.wzy.redis")
})
@EnableHystrix
@EnableDistributedTransaction
public class StartOrderService {
    public static void main(String[] args) {
        SpringApplication.run(StartOrderService.class, args);
    }
}
