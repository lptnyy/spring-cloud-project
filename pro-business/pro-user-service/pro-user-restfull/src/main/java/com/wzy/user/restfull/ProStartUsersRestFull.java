package com.wzy.user.restfull;
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
@EnableSwagger2
@EnableFeignClients({
		"com.wzy.redis",
		"com.wzy.user"
})
@ComponentScans({
		@ComponentScan("com.wzy.redis"),
		@ComponentScan("com.wzy.user"),
		@ComponentScan("com.wzy.common.feign")
})
@EnableHystrix
public class ProStartUsersRestFull {
    public static void main(String[] args) {
		SpringApplication.run(ProStartUsersRestFull.class, args);
	}
}
