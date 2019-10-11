package com.wzy.service;

import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.ServiceResponseEnum;
import com.wzy.pojo.User;
import com.wzy.pojo.sso.VaRole;
import com.wzy.pojo.sso.VaUser;
import com.wzy.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
            VaRole vaRole = new VaRole();
            vaRole.setId(1);
            vaRole.setName("admin");
            List<VaRole> vaRoleList = new ArrayList<>();
            vaRoleList.add(vaRole);
            VaUser vaUser = new VaUser(user.getUsername(),user.getUserpass(),vaRoleList);
            vaUser.setEnabled(true);
            return vaUser;
        }
        return null;
    }
}
