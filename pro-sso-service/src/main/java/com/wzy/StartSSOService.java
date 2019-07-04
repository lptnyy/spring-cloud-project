package com.wzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@MapperScan("com.wzy.mapper")
@EnableAuthorizationServer
public class StartSSOService {
    public static void main(String[] args) {
        SpringApplication.run(StartSSOService.class, args);
    }
}
