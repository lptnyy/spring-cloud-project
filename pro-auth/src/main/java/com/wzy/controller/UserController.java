package com.wzy.controller;

import com.alibaba.fastjson.JSON;
import com.wzy.common.oauth.VaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
        return user;
    }

    @GetMapping("/userInfo")
    public String me(OAuth2Authentication user) {
        VaUser principal = (VaUser) user.getPrincipal(); // 获得自己实现的类
        return JSON.toJSONString(principal);
    }

    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @Autowired
    AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer;

    @RequestMapping(method = RequestMethod.POST, value = "/oauth/exit")
    public void revokeToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String access_token) throws IOException {
        new SecurityContextLogoutHandler().logout(httpServletRequest, null, null);
        consumerTokenServices.revokeToken(access_token);
    }
}
