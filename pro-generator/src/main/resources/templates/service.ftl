package ${genpkg};
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import ${dtoClassPath};
import ${requestClassPath};
import ${hustrixclassPage};

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@FeignClient(value = "${fegionService}", configuration = FeignRequestInterceptor.class,fallback = ${className}ServiceHystrix.class)
@SuppressWarnings("unchecked")
public interface I${className}Service {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/${className}/getUser", method = RequestMethod.POST)
    ServiceResponse<${className}> get(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/${className}/getList", method = RequestMethod.POST)
    ServiceResponse<List<${className}>> getList(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/${className}/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<${className}>> getPageList(@RequestBody ProParameter<${className}Request> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/${className}/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<${className}>> findIdsList(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/${className}/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/${className}/save", method = RequestMethod.POST)
    ServiceResponse<${className}> save(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/${className}/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/${className}/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<${className}Request> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/${className}/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<${className}>> batchSave(@RequestBody ProParameter<List<${className}Request>> proParameter);
}
