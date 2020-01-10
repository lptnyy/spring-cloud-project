package com.wzy.user.restfull.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //将web登录和oauth登录的manager共享，不然只能有一方生效
        http.authorizeRequests().antMatchers("/getUser","/instances","/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
