package com.wzy.generator.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.annotation.Log;
import com.wzy.generator.dto.ProGenerator;
import com.wzy.generator.request.ProGeneratorRequest;
import com.wzy.generator.service.IProGeneratorService;
import com.wzy.generator.vo.ProGeneratorVo;
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

/**
 * <p>
    * 代码生成表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-10
 */
@RestController
@RequestMapping(value = "proGenerator")
@Api(value = "ProGeneratorController", description = "代码生成表")
public class ProGeneratorController {

    @Autowired
    IProGeneratorService proGeneratorService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "代码生成表", value = "分页查询列表", source = "generator-service")
    public ServiceResponse<List<ProGeneratorVo>> getPageList(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<List<ProGeneratorVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProGenerator>> response = proGeneratorService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProGenerator> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProGeneratorVo> returnList = resultList.stream()
                            .map(proGenerator -> {
                                ProGeneratorVo proGeneratorvo = new ProGeneratorVo();
                                BeanUtils.copyProperties(proGenerator,proGeneratorvo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proGeneratorvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "代码生成表", value = "获取单条信息", source = "generator-service")
    public ServiceResponse<ProGeneratorVo> get(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<ProGeneratorVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProGenerator> response = proGeneratorService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProGenerator proGenerator = response.getObj();
                    ProGeneratorVo proGeneratorVo = new ProGeneratorVo();
                    BeanUtils.copyProperties(proGenerator,proGeneratorVo);
                    return proGeneratorVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @Log(name = "代码生成表", value = "保存", source = "generator-service")
    public ServiceResponse<ProGeneratorVo> save(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<ProGeneratorVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ProGeneratorRequest results = new ProGeneratorRequest();
                    results.setGenId(request.getGenId());
                    ServiceResponse<ProGenerator> response = proGeneratorService.get(new ProParameter<>(results));

                    // 获取调用服务状态
                    response.checkState();

                    if (response.getObj() != null) {
                        request.setGenId(response.getObj().getGenId());
                        proGeneratorService.update(new ProParameter<>(request)).getObj();
                        ProGeneratorVo proGeneratorVo = new ProGeneratorVo();
                        BeanUtils.copyProperties(request,proGeneratorVo);
                        return proGeneratorVo;
                    } else {
                        // 获取返回结果 包括数据库插入id
                        ProGenerator proGenerator = proGeneratorService.save(new ProParameter<>(request)).getObj();
                        ProGeneratorVo proGeneratorVo = new ProGeneratorVo();
                        BeanUtils.copyProperties(proGenerator,proGeneratorVo);
                        return proGeneratorVo;
                    }
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "代码生成表", value = "批量删除", source = "generator-service")
    public ServiceResponse<Integer> idsDelete(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setGenId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proGeneratorService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "代码生成表", value = "删除", source = "generator-service")
    public ServiceResponse<Integer> delete(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proGeneratorService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "代码生成表", value = "修改", source = "generator-service")
    public ServiceResponse<Integer> update(@RequestBody ProGeneratorRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proGeneratorService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
