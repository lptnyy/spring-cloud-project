package com.wzy.system.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.wzy.system.dto.ProEnum;
import com.wzy.system.request.ProEnumRequest;
import com.wzy.system.IProEnumService;

/**
 * <p>
    * 枚举表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Component
public class ProEnumServiceHystrix implements IProEnumService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProEnum> get(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProEnum>> getList(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProEnum>> getPageList(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProEnum>> findIdsList(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProEnum> save(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProEnumRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProEnum>> batchSave(ProParameter<List<ProEnumRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}