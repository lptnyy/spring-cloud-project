package com.wzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        System.out.println("get user");
        return user;
    }

    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @Autowired
    AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer;

    @RequestMapping(method = RequestMethod.GET, value = "/oauth/exit")
    public void revokeToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String access_token) throws IOException {
        new SecurityContextLogoutHandler().logout(httpServletRequest, null, null);
        if (consumerTokenServices.revokeToken(access_token)){
            httpServletResponse.sendRedirect(httpServletRequest.getHeader("referer").toString());
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getHeader("referer").toString());
        }
    }
}
