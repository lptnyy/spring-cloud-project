package com.wzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableFeignClients(
        {"com.wzy.user"
                ,"com.wzy.redis"})
@ComponentScans({
        @ComponentScan("com.wzy.redis"),
        @ComponentScan("com.wzy.user")
})
public class ProStartAuth {
    public static void main(String[] args) {
        SpringApplication.run(ProStartAuth.class, args);
    }
}
