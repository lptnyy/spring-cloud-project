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
import com.wzy.system.dto.ProResourceFile;
import com.wzy.system.request.ProResourceFileRequest;
import com.wzy.system.hystrix.ProResourceFileServiceHystrix;

/**
 * <p>
    * 系统资源文件表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProResourceFileServiceHystrix.class)
public interface IProResourceFileService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/getUser", method = RequestMethod.POST)
    ServiceResponse<ProResourceFile> get(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProResourceFile>> getList(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProResourceFile>> getPageList(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProResourceFile>> findIdsList(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/save", method = RequestMethod.POST)
    ServiceResponse<ProResourceFile> save(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProResourceFile/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProResourceFileRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProResourceFile/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProResourceFile>> batchSave(@RequestBody ProParameter<List<ProResourceFileRequest>> proParameter) throws Exception;
}