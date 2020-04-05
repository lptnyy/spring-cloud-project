package com.wzy.system;
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
		"com.wzy.system"
})
@ComponentScans({
		@ComponentScan("com.wzy.redis"),
		@ComponentScan("com.wzy.common.feign"),
		@ComponentScan("com.wzy.common.aspect")
})
@EnableHystrix
public class SystemAppServiceStart {
    public static void main(String[] args) {
		SpringApplication.run(SystemAppServiceStart.class, args);
	}
}
