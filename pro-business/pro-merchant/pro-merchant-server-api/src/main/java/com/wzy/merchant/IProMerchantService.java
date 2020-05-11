package com.wzy.merchant;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.merchant.dto.ProMerchant;
import com.wzy.merchant.request.ProMerchantRequest;
import com.wzy.merchant.hystrix.ProMerchantServiceHystrix;

/**
 * <p>
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-11
 */
@FeignClient(value = "merchant-service", configuration = FeignRequestInterceptor.class,fallback = ProMerchantServiceHystrix.class)
public interface IProMerchantService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProMerchant/getUser", method = RequestMethod.POST)
    ServiceResponse<ProMerchant> get(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProMerchant/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProMerchant>> getList(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProMerchant/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProMerchant>> getPageList(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProMerchant/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProMerchant>> findIdsList(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMerchant/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMerchant/save", method = RequestMethod.POST)
    ServiceResponse<ProMerchant> save(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMerchant/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMerchant/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProMerchantRequest> proParameter) throws Exception;

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProMerchant/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProMerchant>> batchSave(@RequestBody ProParameter<List<ProMerchantRequest>> proParameter) throws Exception;
}