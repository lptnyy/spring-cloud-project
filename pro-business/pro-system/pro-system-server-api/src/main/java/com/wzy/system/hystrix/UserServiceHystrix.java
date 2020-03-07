package com.wzy.system.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.UserService;
import com.wzy.system.dto.ProUser;
import com.wzy.system.request.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceHystrix implements UserService {

    @Override
    public ServiceResponse<ProUser> userNameGetUser(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> getPageList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<List<ProUser>> findIdsList(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> update(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> save(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse<Integer> delete(ProParameter<User> proParameter) {
        return ServiceResponse.getFAIL();
    }
}
