package ${genpkg};
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.common.annotation.Log;
import ${serviceClassPath};
import ${dtoClassPath};
import ${requestClassPath};
import ${voClassPath};
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
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@RestController
@RequestMapping(value = "${smClassName}")
@Api(value = "${className}Controller", description = "${tableComment}")
@SuppressWarnings("unchecked")
public class ${className}Controller {

    @Autowired
    I${className}Service ${smClassName}Service;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "${tableComment}", value = "分页查询列表", source = "${logSourceName}")
    public ServiceResponse<List<${className}Vo>> getPageList(@RequestBody ${className}Request request) {
        return new ServiceResponse<List<${className}Vo>>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<List<${className}>> response = ${smClassName}Service.getPageList(new ProParameter<>(request)
                            .setRequestPage(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 获取返回的分页信息
                    response.copyPage(serviceResponse);

                    // 获取服务返回的结果
                    List<${className}> resultList = response.getObj();

                    // 组装vo 返回数据 也可以不组装直接返回原始数据
                    List<${className}Vo> returnList = resultList.stream()
                            .map(${smClassName} -> {
                                ${className}Vo ${smClassName}vo = new ${className}Vo();
                                BeanUtils.copyProperties(${smClassName},${smClassName}vo);
                                // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                                return ${smClassName}vo;
                            })
                            .collect(Collectors.toList());

                    return returnList;
                })
                .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "${tableComment}", value = "获取单条信息", source = "${logSourceName}")
    public ServiceResponse<${className}Vo> get(@RequestBody ${className}Request request) {
        return new ServiceResponse<${className}Vo>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<${className}> response = ${smClassName}Service.get(new ProParameter<>(request));

                    // 获取调用服务状态
                    response.checkState();

                    // 组装返回的vo
                    ${className} ${smClassName} = response.getObj();
                    ${className}Vo ${smClassName}Vo = new ${className}Vo();
                    BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
                    return ${smClassName}Vo;
                })
                .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "${tableComment}", value = "保存", source = "${logSourceName}")
    public ServiceResponse<${className}Vo> save(@RequestBody ${className}Request request) {
        return new ServiceResponse<${className}Vo>()
                .run(serviceResponse -> {

                    // 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    ServiceResponse<${className}> response = ${smClassName}Service.get(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
                    response = ${smClassName}Service.save(new ProParameter<>(request));
                    response.beginTransaction();
                    response.checkState();

                    // 获取返回数据
                    ${className} ${smClassName} = response.getObj();
                    ${className}Vo ${smClassName}Vo = new ${className}Vo();
                    BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
                    return ${smClassName}Vo;
                })
                .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @GlobalTransactional
    @Log(name = "${tableComment}", value = "批量删除", source = "${logSourceName}")
    public ServiceResponse<Integer> idsDelete(@RequestBody ${className}Request request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 标记通过enumid删除
                    request.set${pri}(1);

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.idsDelete(new ProParameter<>(request));
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
    @Log(name = "${tableComment}", value = "删除", source = "${logSourceName}")
    public ServiceResponse<Integer> delete(@RequestBody ${className}Request request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.delete(new ProParameter<>(request));
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
    @Log(name = "${tableComment}", value = "修改", source = "${logSourceName}")
    public ServiceResponse<Integer> update(@RequestBody ${className}Request request) {
        return new ServiceResponse<Integer>()
                .run(serviceResponse -> {

                    // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
                    ServiceResponse<Integer> response = ${smClassName}Service.update(new ProParameter<>(request));
                    response.beginTransaction();

                    // 获取调用服务状态
                    response.checkState();

                    return response.getObj();
                })
                .exec();
    }
}
