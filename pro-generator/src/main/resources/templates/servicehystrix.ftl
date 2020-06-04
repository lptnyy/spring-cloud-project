package ${genpkg}.hystrix;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import java.util.List;
import java.lang.Integer;
import org.springframework.stereotype.Component;
import ${dtoClassPath};
import ${requestClassPath};
import ${serviceClassPath};

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@Component
@SuppressWarnings("unchecked")
public class ${className}ServiceHystrix implements I${className}Service {

    /*
     * 获得单个信息
     * @return
     */
    public ServiceResponse<${className}> get(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    public ServiceResponse<List<${className}>> getList(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 分页查询所有数据
     * @return
     */
    public ServiceResponse<List<${className}>> getPageList(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * ids数组In查询数据
     * @return
     */
    public ServiceResponse<List<${className}>> findIdsList(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> update(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<${className}> save(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> delete(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    public ServiceResponse<Integer> idsDelete(ProParameter<${className}Request> proParameter) {
        return ServiceResponse.getFAIL();
    }

    /**
     * 批量插入
     * @param proParameter
     * @return
     */
     public ServiceResponse<List<${className}>> batchSave(ProParameter<List<${className}Request>> proParameter) {
         return ServiceResponse.getFAIL();
     }
}
