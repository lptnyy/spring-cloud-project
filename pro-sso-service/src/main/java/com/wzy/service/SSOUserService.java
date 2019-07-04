package com.wzy.service;

import com.wzy.entity.VaUser;
import com.wzy.mapper.UserMapper;
import com.wzy.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class SSOUserService implements UserDetailsService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUser(s);
        VaUser vaUser = new VaUser("admin","123456",new ArrayList<>());
        vaUser.setEnabled(true);
        return vaUser;
    }
}
