package com.wzy.system;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.system.dto.ProLog;
import com.wzy.system.request.ProLogRequest;
import com.wzy.system.hystrix.ProLogServiceHystrix;

/**
 * <p>
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-07
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProLogServiceHystrix.class)
public interface IProLogService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProLog/getUser", method = RequestMethod.POST)
    ServiceResponse<ProLog> get(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProLog/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProLog>> getList(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProLog/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProLog>> getPageList(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProLog/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProLog>> findIdsList(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLog/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLog/save", method = RequestMethod.POST)
    ServiceResponse<ProLog> save(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLog/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProLog/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProLogRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProLog/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProLog>> batchSave(@RequestBody ProParameter<List<ProLogRequest>> proParameter) throws Exception;
}