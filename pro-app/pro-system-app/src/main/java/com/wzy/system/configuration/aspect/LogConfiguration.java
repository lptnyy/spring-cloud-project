package com.wzy.system.configuration.aspect;
import com.alibaba.fastjson.JSON;
import com.wzy.common.annotation.Log;
import com.wzy.common.aspect.ProAfter;
import com.wzy.common.method.ProParameter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.SystemClock;
import com.wzy.system.IProLogService;
import com.wzy.system.request.ProLogRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 实现一个自定义日志收集aop拦截器，对应注解 com.wzy.common.annotation.Log 最好使用异步处理日志
 */
@Component
public class LogConfiguration implements ProAfter {

    @Autowired
    IProLogService proLogService;

    @Override
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        long startTime= SystemClock.now();
        try {
            ProLogRequest proLog = new ProLogRequest();
            String className = pjd.getTarget().getClass().getSimpleName();
            String methodName = pjd.getSignature().getName();
            String bodyJson = JSON.toJSONString(pjd.getArgs());
            Object result = pjd.proceed(pjd.getArgs());
            String returnJson = JSON.toJSONString(result);
            Class<?> classTarget = pjd.getTarget().getClass();
            Class<?>[] par = ((MethodSignature) pjd.getSignature()).getParameterTypes();
            Method objMethod = classTarget.getMethod(methodName, par);
            Log log = objMethod.getAnnotation(Log.class);
            proLog.setName(log.name());
            proLog.setValue(log.value());
            proLog.setSource(log.source());
            proLog.setBody(bodyJson);
            proLog.setClassName(className);
            proLog.setFunctionName(methodName);
            proLog.setReturnBody(returnJson);
            long endTime=SystemClock.now();
            proLog.setRunTime((float) (endTime - startTime));
            proLogService.save(new ProParameter<>(proLog));
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ServiceResponse.getFAIL();
    }
}
