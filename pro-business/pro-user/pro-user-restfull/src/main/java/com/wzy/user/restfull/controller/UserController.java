package com.wzy.user.restfull.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.page.RequestPage;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.user.ProUser;
import com.wzy.redis.RedisService;
import com.wzy.user.UserService;
import com.wzy.user.parameter.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/userPageList")
    public ServiceResponse<List<ProUser>> getUsers(RequestPage requestPage){
        User user = new User();
        redisService.set("hahaahah","hahha");
        System.out.println(redisService.get("hahaahah"));
        return userService.getPageList(new ProParameter<User>()
                .setObj(user)
                .setRequestPage(requestPage));
    }
}
