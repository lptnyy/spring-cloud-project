package com.wzy.role;
import com.wzy.common.util.ServiceResponse;
import com.wzy.pojo.Role;
import com.wzy.role.hystrix.RoleServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "role-service", fallback = RoleServiceHystrix.class)
public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping(path = "/addrole", method = RequestMethod.POST)
    ServiceResponse addRole(@RequestBody @RequestParam(value = "role") Role role);

    /**
     * 删除角色
     * @param role
     * @return
     */
    @RequestMapping(path = "/delrole", method = RequestMethod.POST)
    ServiceResponse delRole(@RequestBody @RequestParam(value = "role") Role role);

    /**
     * 更新角色
     * @param role
     * @return
     */
    @RequestMapping(path = "/updaterole", method = RequestMethod.POST)
    ServiceResponse updateRole(@RequestBody @RequestParam(value = "role") Role role);

    /**
     * 获得角色信息
     * @param role
     * @return
     */
    @RequestMapping(path = "/getrole", method = RequestMethod.POST)
    ServiceResponse getRole(@RequestBody @RequestParam(value = "role") Role role);

    /**
     * 获得角色列表
     * @param role
     * @return
     */
    @RequestMapping(path = "/getroles", method = RequestMethod.POST)
    ServiceResponse getRoles(@RequestBody @RequestParam(value = "role") Role role);

    /**
     * 分页查询角色列表
     * @param role
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(path = "/getrolepage", method = RequestMethod.POST)
    ServiceResponse getRoles(@RequestBody @RequestParam(value = "role") Role role,@RequestParam(value = "pageNo") int pageNo,@RequestParam(value = "pageSize") int pageSize);
}
