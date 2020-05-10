package com.wzy.generator.service;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.generator.dto.ProGenerator;
import com.wzy.generator.request.ProGeneratorRequest;

/**
 * <p>
    * 代码生成表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-10
 */
@FeignClient(value = "generator-service", configuration = FeignRequestInterceptor.class)
public interface IProGeneratorService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProGenerator/getUser", method = RequestMethod.POST)
    ServiceResponse<ProGenerator> get(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProGenerator/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProGenerator>> getList(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProGenerator/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProGenerator>> getPageList(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProGenerator/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProGenerator>> findIdsList(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProGenerator/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProGenerator/save", method = RequestMethod.POST)
    ServiceResponse<ProGenerator> save(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProGenerator/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProGenerator/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProGeneratorRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProGenerator/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProGenerator>> batchSave(@RequestBody ProParameter<List<ProGeneratorRequest>> proParameter) throws Exception;
}