package com.wzy.user.hystrix;

import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.User;
import com.wzy.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public ServiceResponse hi() {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse updateUser() {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse userNameGetUser(User user) {
        return ServiceResponse.getFAIL();
    }
}
