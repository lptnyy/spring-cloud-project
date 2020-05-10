package com.wzy.system;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.hystrix.ProRoleMenuServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.system.dto.ProRoleMenu;
import com.wzy.system.request.ProRoleMenuRequest;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-19
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProRoleMenuServiceHystrix.class)
public interface IProRoleMenuService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/getUser", method = RequestMethod.POST)
    ServiceResponse<ProRoleMenu> get(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProRoleMenu>> getList(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProRoleMenu>> getPageList(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProRoleMenu>> findIdsList(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/save", method = RequestMethod.POST)
    ServiceResponse<ProRoleMenu> save(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProRoleMenu/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProRoleMenuRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProRoleMenu/batchSave", method = RequestMethod.POST)
    ServiceResponse<Integer> batchSave(@RequestBody ProParameter<List<ProRoleMenuRequest>> proParameter) throws Exception;
}