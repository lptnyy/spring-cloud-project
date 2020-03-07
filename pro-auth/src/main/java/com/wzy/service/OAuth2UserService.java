package com.wzy.service;

import com.wzy.common.method.ProParameter;
import com.wzy.common.oauth.VaRole;
import com.wzy.common.oauth.VaUser;
import com.wzy.common.util.MessageType;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.UserService;
import com.wzy.system.dto.ProUser;
import com.wzy.system.request.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OAuth2UserService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userPar = new User();
        userPar.setUserName(s);
        ServiceResponse<ProUser> response = userService.userNameGetUser(new ProParameter<User>().setObj(userPar));
        if (response.getCode() == MessageType.SUCCESS.getValue()){
            ProUser user = response.getObj();
            VaRole vaRole = new VaRole();
            vaRole.setId(1);
            vaRole.setName("admin");
            List<VaRole> vaRoleList = new ArrayList<>();
            vaRoleList.add(vaRole);
            VaUser vaUser = new VaUser(user.getUserName(),user.getUserPass(),vaRoleList);
            vaUser.setUserface(user.getHeadImg());
            vaUser.setId(user.getUserId().longValue());
            vaUser.setEnabled(true);
            return vaUser;
        }
        return null;
    }
}
