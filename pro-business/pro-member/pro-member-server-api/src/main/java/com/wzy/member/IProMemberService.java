package com.wzy.member;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.lang.Integer;
import com.wzy.member.dto.ProMember;
import com.wzy.member.request.ProMemberRequest;
import com.wzy.member.hystrix.ProMemberServiceHystrix;

/**
 * <p>
    * 会员表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-23
 */
@FeignClient(value = "member-service", configuration = FeignRequestInterceptor.class,fallback = ProMemberServiceHystrix.class)
public interface IProMemberService {

    /*
     * 获得单个信息
     * @return
     */
    @RequestMapping(path = "/ProMember/getUser", method = RequestMethod.POST)
    ServiceResponse<ProMember> get(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 根据查询条件获取所有数据
     * @return
     */
    @RequestMapping(path = "/ProMember/getList", method = RequestMethod.POST)
    ServiceResponse<List<ProMember>> getList(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 分页查询所有数据
     * @return
     */
    @RequestMapping(path = "/ProMember/getPageList", method = RequestMethod.POST)
    ServiceResponse<List<ProMember>> getPageList(@RequestBody ProParameter<ProMemberRequest> proParameter);


    /**
     * ids数组In查询数据
     * @return
     */
    @RequestMapping(path = "/ProMember/getIdsList", method = RequestMethod.POST)
    ServiceResponse<List<ProMember>> findIdsList(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 修改数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMember/update", method = RequestMethod.POST)
    ServiceResponse<Integer> update(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 保存数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMember/save", method = RequestMethod.POST)
    ServiceResponse<ProMember> save(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMember/delete", method = RequestMethod.POST)
    ServiceResponse<Integer> delete(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 通过id数组批量删除数据
     * @param proParameter
     * @return
     */
    @RequestMapping(path = "/ProMember/idsDelete", method = RequestMethod.POST)
    ServiceResponse<Integer> idsDelete(@RequestBody ProParameter<ProMemberRequest> proParameter);

    /**
     * 批量保存
     * @param proParameter
     * @return
    */
    @RequestMapping(path = "/ProMember/batchSave", method = RequestMethod.POST)
    ServiceResponse<List<ProMember>> batchSave(@RequestBody ProParameter<List<ProMemberRequest>> proParameter);
}