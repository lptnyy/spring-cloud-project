package com.wzy.system;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.system.hystrix.ProEnumServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.system.dto.ProEnum;
import com.wzy.system.request.ProEnumRequest;

@FeignClient(value = "system-service", configuration = FeignRequestInterceptor.class,fallback = ProEnumServiceHystrix.class)
public interface IProEnumService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProEnum/getUser", method = RequestMethod.POST)
    ServiceResponse<ProEnum> get(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> getList(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> getPageList(@RequestBody ProParameter<ProEnumRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProEnum/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProEnum>> findIdsList(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/save", method = RequestMethod.POST)
    ServiceResponse<ProEnum> save(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProEnumRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProEnum/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProEnumRequest> proParameter);
}