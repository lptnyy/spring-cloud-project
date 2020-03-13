package com.wzy.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    String notInterceptUrl = "/oauth/exit,/oauth/authorize,/oauth/token,/user/getUser,/instances,/actuator/**,/swagger-ui.html,/swagger**,/webjars/**,/springfox-swagger-ui/**,/swagger-resources/**,/v2/**";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] interceptUrls = notInterceptUrl.split(",");

        //将web登录和oauth登录的manager共享，不然只能有一方生效
        http.authorizeRequests()
                .antMatchers(interceptUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
