package com.wzy.phone.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.common.annotation.Log;
import com.wzy.member.IProMemberService;
import com.wzy.member.dto.ProMember;
import com.wzy.member.request.ProMemberRequest;
import com.wzy.phone.vo.ProMemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * <p>
    * 会员表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-23
 */
@RestController
@RequestMapping(value = "proMember")
@Api(value = "ProMemberController", description = "会员表 ")
public class ProMemberController {

    @Autowired
    IProMemberService proMemberService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "会员表 ", value = "分页查询列表", source = "phone-app")
    public ServiceResponse<List<ProMemberVo>> getPageList(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<List<ProMemberVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProMember>> response = proMemberService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProMember> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProMemberVo> returnList = resultList.stream()
                            .map(proMember -> {
                                ProMemberVo proMembervo = new ProMemberVo();
                                BeanUtils.copyProperties(proMember,proMembervo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proMembervo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "会员表 ", value = "获取单条信息", source = "phone-app")
    public ServiceResponse<ProMemberVo> get(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<ProMemberVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMember> response = proMemberService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProMember proMember = response.getObj();
                    ProMemberVo proMemberVo = new ProMemberVo();
                    BeanUtils.copyProperties(proMember,proMemberVo);
                    return proMemberVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "会员表 ", value = "保存", source = "phone-app")
    public ServiceResponse<ProMemberVo> save(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<ProMemberVo>()
                .run(serviceResponse -> {

                    // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<ProMember> response = proMemberService.get(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    response = proMemberService.save(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 获取返回数据
                    ProMember proMember = response.getObj();
                    ProMemberVo proMemberVo = new ProMemberVo();
                    BeanUtils.copyProperties(proMember,proMemberVo);
                    return proMemberVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @GlobalTransactional
    @Log(name = "会员表 ", value = "批量删除", source = "phone-app")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setMemberId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMemberService.idsDelete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @GlobalTransactional
    @Log(name = "会员表 ", value = "删除", source = "phone-app")
    public ServiceResponse<Integer> delete(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMemberService.delete(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @GlobalTransactional
    @Log(name = "会员表 ", value = "修改", source = "phone-app")
    public ServiceResponse<Integer> update(@RequestBody ProMemberRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMemberService.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
