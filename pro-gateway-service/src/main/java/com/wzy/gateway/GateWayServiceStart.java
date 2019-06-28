package com.wzy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class GateWayServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(GateWayServiceStart.class, args);
    }
}

