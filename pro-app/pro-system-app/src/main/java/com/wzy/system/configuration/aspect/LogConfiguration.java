package com.wzy.system.configuration.aspect;
import com.wzy.common.aspect.LogAfter;
import com.wzy.common.util.ServiceResponse;
import com.wzy.common.util.SystemClock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component
/**
 * 实现一个自定义日志收集aop拦截器，对应注解 com.wzy.common.annotation.Log
 */
public class LogConfiguration implements LogAfter {

    @Override
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        long startTime= SystemClock.now();
        try {
            Object result = pjd.proceed(pjd.getArgs());
            long endTime=SystemClock.now();
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ServiceResponse.getFAIL();
    }
}
