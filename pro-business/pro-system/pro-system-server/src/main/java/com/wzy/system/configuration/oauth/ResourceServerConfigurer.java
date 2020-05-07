package com.wzy.system.configuration.oauth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Value("${security.oauth2.not-intercept-url}")
    String notInterceptUrl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] interceptUrls = notInterceptUrl.split(",");

        //将web登录和oauth登录的manager共享，不然只能有一方生效
        http.authorizeRequests().antMatchers(interceptUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
