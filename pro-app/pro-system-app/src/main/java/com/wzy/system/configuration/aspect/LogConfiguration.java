package com.wzy.system.configuration.aspect;

import com.wzy.common.annotation.Log;
import com.wzy.common.aspect.LogAfter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class LogConfiguration implements LogAfter {

    @Override
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log action = method.getAnnotation(Log.class);
        System.out.println("注解式拦截 "+action.name());
    }
}
