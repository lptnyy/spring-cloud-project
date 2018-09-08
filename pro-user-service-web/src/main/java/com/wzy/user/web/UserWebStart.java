package com.wzy.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = "com.wzy")
@EnableSwagger2
@EnableHystrix
@ComponentScan("com.wzy")
public class UserWebStart {

    public static void main(String[] args) {
		SpringApplication.run(UserWebStart.class, args);
	}
}
