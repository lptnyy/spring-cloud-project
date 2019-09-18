package com.wzy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProEurekaServiceApplication.class, args);
	}
}
