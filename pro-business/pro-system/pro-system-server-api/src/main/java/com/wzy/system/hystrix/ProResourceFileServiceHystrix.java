package com.wzy.system.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import com.wzy.system.dto.ProResourceFile;
import com.wzy.system.request.ProResourceFileRequest;
import com.wzy.system.IProResourceFileService;

/**
 * <p>
    * 系统资源文件表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Component
public class ProResourceFileServiceHystrix implements IProResourceFileService {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<ProResourceFile> get(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<ProResourceFile>> getList(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<ProResourceFile>> getPageList(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<ProResourceFile>> findIdsList(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<ProResourceFile> save(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<ProResourceFileRequest> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<ProResourceFile>> batchSave(ProParameter<List<ProResourceFileRequest>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}