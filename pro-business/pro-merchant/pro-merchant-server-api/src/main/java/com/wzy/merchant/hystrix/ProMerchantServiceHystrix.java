package com.wzy.merchant.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.wzy.merchant.dto.ProMerchant;
import com.wzy.merchant.request.ProMerchantRequest;
import com.wzy.merchant.IProMerchantService;

/**
 * <p>
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-11
 */
@Component
public class ProMerchantServiceHystrix implements IProMerchantService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProMerchant> get(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> getList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> getPageList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProMerchant>> findIdsList(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProMerchant> save(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProMerchantRequest> proParameter) throws Exception {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProMerchant>> batchSave(ProParameter<List<ProMerchantRequest>> proParameter) throws Exception {
         return ServiceResponse.getFAIL();
     }
}