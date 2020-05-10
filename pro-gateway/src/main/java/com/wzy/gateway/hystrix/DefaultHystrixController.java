package com.wzy.gateway.hystrix;

import com.wzy.common.util.ServiceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public ServiceResponse defaultfallback(){
        return ServiceResponse.getBEBUSYFAIL();
    }
}
