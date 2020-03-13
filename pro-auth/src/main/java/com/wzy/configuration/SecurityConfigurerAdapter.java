package com.wzy.configuration;

import com.wzy.service.OAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2UserService userInfoService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/require")//默认跳转的页面接口
                .loginProcessingUrl("/authentication/form")
                .and()
                .authorizeRequests()
                .antMatchers("/require",//设置取消安全验证路径
                        "/**",
                        "/authentication/form",
                        "/oauth/authorize",
                        "/instances",
                        "/user",
                        "/userInfo",
                        "/oauth/token",
                        "/oauth/exit",
                        "/assets/**",
                        "/actuator/**",
                        "/getUser",
                        "/instances",
                        "/swagger-ui.html",
                        "/swagger**",
                        "/webjars/**",
                        "/springfox-swagger-ui/**",
                        "/swagger-resources/**,/v2/**"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfoService).passwordEncoder(new PassWord());
    }

    // 不定义 没有passwod
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
