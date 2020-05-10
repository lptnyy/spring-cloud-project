package com.wzy.generator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableHystrix
@ComponentScans({
		@ComponentScan("com.wzy.common.exception"), // 载入全局异常管理
		@ComponentScan("com.wzy.common.feign"), // 解决 服务调用之间传递 oauth2 头信息
})
@MapperScan("com.wzy.generator.mapper")
public class GeneratorApplication {
    public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}
}
