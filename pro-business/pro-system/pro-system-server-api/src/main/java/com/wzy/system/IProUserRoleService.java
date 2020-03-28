package com.wzy.system;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.hystrix.ProUserRoleServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.system.dto.ProUserRole;
import com.wzy.system.request.ProUserRoleRequest;

/**
 * <p>
    * 用户角色关系表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-28
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProUserRoleServiceHystrix.class)
public interface IProUserRoleService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getUser", method = RequestMethod.POST)
    ServiceResponse<ProUserRole> get(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> getList(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> getPageList(@RequestBody ProParameter<ProUserRoleRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProUserRole/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> findIdsList(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/save", method = RequestMethod.POST)
    ServiceResponse<ProUserRole> save(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProUserRole/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProUserRoleRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProUserRole/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProUserRole>> batchSave(@RequestBody ProParameter<List<ProUserRoleRequest>> proParameter);
}