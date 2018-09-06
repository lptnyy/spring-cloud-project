package com.wzy.order.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value = "com.wzy.order")
@EnableSwagger2
public class OrderWebStart {

    public static void main(String[] args) {
		SpringApplication.run(OrderWebStart.class, args);
	}
}
