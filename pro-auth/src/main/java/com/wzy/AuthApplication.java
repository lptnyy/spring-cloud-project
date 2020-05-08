package com.wzy;
import com.wzy.common.aspect.AuthorityAspect;
import com.wzy.common.aspect.LogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableFeignClients(
        {"com.wzy.system"
                ,"com.wzy.redis"})
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {LogAspect.class, AuthorityAspect.class})})
@ComponentScans({
        @ComponentScan("com.wzy.redis"),
        @ComponentScan("com.wzy.system")
})
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
