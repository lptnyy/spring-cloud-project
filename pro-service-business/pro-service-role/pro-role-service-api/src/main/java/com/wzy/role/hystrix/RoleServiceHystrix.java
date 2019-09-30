package com.wzy.role.hystrix;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.Role;
import com.wzy.role.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceHystrix implements RoleService {

    @Override
    public ServiceResponse addRole(Role role) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse delRole(Role role) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse updateRole(Role role) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse getRole(Role role) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse getRoles(Role role) {
        return ServiceResponse.getFAIL();
    }

    @Override
    public ServiceResponse getRoles(Role role, int pageNo, int pageSize) {
        return ServiceResponse.getFAIL();
    }
}
