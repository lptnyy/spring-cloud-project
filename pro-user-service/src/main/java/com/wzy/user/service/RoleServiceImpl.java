package com.wzy.user.service;

import com.wzy.user.RoleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleServiceImpl implements RoleService {

    @Override
    public void run() {
        System.out.println("log");
    }
}
