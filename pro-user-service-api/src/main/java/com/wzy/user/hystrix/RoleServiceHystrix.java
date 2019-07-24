package com.wzy.user.hystrix;

import com.wzy.common.util.ServiceResponse;
import com.wzy.user.RoleService;
import com.wzy.user.UserService;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceHystrix implements RoleService {


    @Override
    public void run() {
        System.out.println("haha");
    }
}
