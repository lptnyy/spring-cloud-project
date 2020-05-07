package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.DateUtil;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.common.annotation.Log;
import com.wzy.system.IProLogService;
import com.wzy.system.dto.ProLog;
import com.wzy.system.request.ProLogRequest;
import com.wzy.system.vo.ProLogVo;
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
    * 操作日志
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-08
 */
@RestController
@RequestMapping(value = "proLog")
@Api(value = "ProLogController", description = "操作日志")
public class ProLogController {

    @Autowired
    IProLogService proLogService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    public ServiceResponse<List<ProLogVo>> getPageList(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<List<ProLogVo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<ProLog>> response = proLogService.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<ProLog> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<ProLogVo> returnList = resultList.stream()
                            .map(proLog -> {
                                ProLogVo proLogvo = new ProLogVo();
                                BeanUtils.copyProperties(proLog,proLogvo);
                                proLogvo.setCreateTime(DateUtil.getyyMMddHHmmss(proLog.getCreateTime()));
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return proLogvo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    public ServiceResponse<ProLogVo> get(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<ProLogVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProLog> response = proLogService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ProLog proLog = response.getObj();
                    ProLogVo proLogVo = new ProLogVo();
                    BeanUtils.copyProperties(proLog,proLogVo);
                    return proLogVo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "操作日志", value = "保存", source = "system-service-app")
    public ServiceResponse<ProLogVo> save(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<ProLogVo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<ProLog> response = proLogService.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回结果 包括数据库插入id
                    ProLog proLog = proLogService.save(new ProParameter<>(request)).getObj();
                    ProLogVo proLogVo = new ProLogVo();
                    BeanUtils.copyProperties(proLog,proLogVo);
                    return proLogVo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.setLogId(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proLogService.idsDelete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proLogService.delete(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ProLogRequest request) throws Exception {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = proLogService.update(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
