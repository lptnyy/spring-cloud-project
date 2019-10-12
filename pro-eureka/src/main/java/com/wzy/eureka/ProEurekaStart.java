package com.wzy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProEurekaStart {

	public static void main(String[] args) {
		SpringApplication.run(ProEurekaStart.class, args);
	}
}
