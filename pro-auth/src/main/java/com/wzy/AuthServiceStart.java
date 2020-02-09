package com.wzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableFeignClients(
        {"com.wzy.system"
                ,"com.wzy.redis"})
@ComponentScans({
        @ComponentScan("com.wzy.redis"),
        @ComponentScan("com.wzy.system")
})
public class AuthServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceStart.class, args);
    }
}
