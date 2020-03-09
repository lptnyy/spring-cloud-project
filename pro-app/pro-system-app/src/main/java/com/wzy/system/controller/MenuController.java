package com.wzy.system.controller;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.redis.RedisService;
import com.wzy.system.IProMenuService;
import com.wzy.system.dto.ProMenu;
import com.wzy.system.request.ProMenuRequest;
import com.wzy.system.vo.ProMenuVo;
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

@RestController
@RequestMapping(value = "menu")
@Api(value = "菜单操作接口")
public class MenuController {

    @Autowired
    IProMenuService proMenuService;

    @Autowired
    RedisService redisService;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    public ServiceResponse<List<ProMenuVo>> getPageList(@RequestBody ProMenuRequest request){
        return new ServiceResponse<List<ProMenuVo>>()
                .run(serviceResponse -> {
                    ServiceResponse<List<ProMenu>> response = proMenuService.getList(new ProParameter<>(request));
                    return response.getObj().stream()
                            .map(proMenu -> {
                                ProMenuVo proMenuVo = new ProMenuVo();
                                BeanUtils.copyProperties(proMenu,proMenuVo);
                                return proMenuVo;
                            })
                            .collect(Collectors.toList());
                })
                .exec();
    }
}
