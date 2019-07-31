package com.wzy.zuul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulServiceStart extends WebSecurityConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceStart.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout()
                .logoutUrl("/reLogin")
                .logoutSuccessUrl("/")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        new SecurityContextLogoutHandler().logout(httpServletRequest, null, null);
                        OAuth2AuthenticationDetails userDetails = (OAuth2AuthenticationDetails) authentication .getDetails();
                        httpServletResponse.setHeader("referer","http://localhost:7071");
                        httpServletResponse.sendRedirect("http://localhost:8083/oauth/exit?access_token="+userDetails.getTokenValue());
                    }
                })
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**","/api/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
