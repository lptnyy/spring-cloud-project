package com.wzy.role.web;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
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
@EnableFeignClients(
        {"com.wzy.role"
                ,"com.wzy.redis"})
@EnableSwagger2
@EnableHystrix
@ComponentScans({
        @ComponentScan(value = "com.wzy.redis"),
        @ComponentScan(value = "com.wzy.role")
})
@EnableDistributedTransaction
public class RoleWebServiceStart {

    public static void main(String[] args){
        SpringApplication.run(RoleWebServiceStart.class, args);
    }
}
