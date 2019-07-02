package com.wzy.user.web;

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
				{"com.wzy.user"
				,"com.wzy.redis"
				,"com.wzy.order"})
@EnableSwagger2
@EnableHystrix
@ComponentScans({
		@ComponentScan(value = "com.wzy.user"),
		@ComponentScan(value = "com.wzy.order"),
		@ComponentScan(value = "com.wzy.redis")
})
@EnableDistributedTransaction
public class UserWebStart {

    public static void main(String[] args) {
		SpringApplication.run(UserWebStart.class, args);
	}
}
