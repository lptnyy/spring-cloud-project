package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.DateUtil;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.common.annotation.Log;
import com.wzy.merchant.IProMerchantService;
import com.wzy.merchant.dto.ProMerchant;
import com.wzy.merchant.request.ProMerchantRequest;
import com.wzy.system.vo.ProMerchantVo;
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
    * 商户表 
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-12
 */
@RestController
@RequestMapping(value = "proMerchant")
@Api(value = "ProMerchantController", description = "商户表 ")
public class ProMerchantController {

    @Autowired
    IProMerchantService proMerchantService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "商户表 ", value = "分页查询列表", source = "merchant-service")
    public ServiceResponse<List<ProMerchantVo>> getPageList(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<List<ProMerchantVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProMerchant>> response = proMerchantService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProMerchant> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProMerchantVo> returnList = resultList.stream()
                            .map(proMerchant -> {
                                ProMerchantVo proMerchantvo = new ProMerchantVo();
                                BeanUtils.copyProperties(proMerchant,proMerchantvo);
                                proMerchantvo.setCreateTime(DateUtil.getyyMMddHHmmss(proMerchant.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proMerchantvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "商户表 ", value = "获取单条信息", source = "merchant-service")
    public ServiceResponse<ProMerchantVo> get(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<ProMerchantVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMerchant> response = proMerchantService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProMerchant proMerchant = response.getObj();
                    ProMerchantVo proMerchantVo = new ProMerchantVo();
                    BeanUtils.copyProperties(proMerchant,proMerchantVo);
                    return proMerchantVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "商户表 ", value = "保存", source = "merchant-service")
    public ServiceResponse<ProMerchantVo> save(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<ProMerchantVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProMerchant> response = proMerchantService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回结果 包括数据库插入id
                    ProMerchant proMerchant = proMerchantService.save(new ProParameter<>(request)).getObj();
                    ProMerchantVo proMerchantVo = new ProMerchantVo();
                    BeanUtils.copyProperties(proMerchant,proMerchantVo);
                    return proMerchantVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @GlobalTransactional
    @Log(name = "商户表 ", value = "批量删除", source = "merchant-service")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setMerchantId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMerchantService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @GlobalTransactional
    @Log(name = "商户表 ", value = "删除", source = "merchant-service")
    public ServiceResponse<Integer> delete(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMerchantService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @GlobalTransactional
    @Log(name = "商户表 ", value = "修改", source = "merchant-service")
    public ServiceResponse<Integer> update(@RequestBody ProMerchantRequest request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proMerchantService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
