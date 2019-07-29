package com.wzy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.ServiceResponseEnum;
import com.wzy.entity.VaUser;
import com.wzy.pojo.User;
import com.wzy.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class SSOUserService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(s);
        ServiceResponse<User> response = userService.userNameGetUser(user);
        if (response.getCode() == ServiceResponseEnum.SUCCESS.getValue()){
            user = response.toObjClass(User.class);
            VaUser vaUser = new VaUser(user.getUsername(),user.getUserpass(),new ArrayList<>());
            vaUser.setEnabled(true);
            return vaUser;
        }
        return null;
    }
}
