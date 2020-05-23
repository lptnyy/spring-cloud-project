package com.wzy.member;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableSwagger2
@EnableFeignClients({
		"com.wzy.redis"
})
@ComponentScans({
		@ComponentScan("com.wzy.common.exception"), // 载入全局异常管理
		@ComponentScan("com.wzy.redis"),
		@ComponentScan("com.wzy.common.feign"), // 解决 服务调用之间传递 oauth2 头信息
})
@EnableHystrix
@MapperScan("com.wzy.member.mapper")
public class MemberApplication {
    public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}
