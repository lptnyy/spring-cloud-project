package com.wzy.system;
import org.mybatis.spring.annotation.MapperScan;
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
		"com.wzy.redis"
})
@ComponentScans({
		@ComponentScan("com.wzy.redis"),
		@ComponentScan("com.wzy.common.feign"), // 解决 服务调用之间传递 oauth2 头信息
		@ComponentScan("com.wzy.configuration") // 双数据源配置 必填
})
@EnableHystrix
@MapperScan("com.wzy.mapper")
public class SystemServiceStart {
    public static void main(String[] args) {
		SpringApplication.run(SystemServiceStart.class, args);
	}
}
