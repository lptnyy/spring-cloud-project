package com.wzy.common.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * log注解拦截器
 */
@Aspect
@Component
public class LogAnnotationAspect {

    @Autowired
    LogAfter logAfter;

    @Pointcut("@annotation(com.wzy.common.annotation.Log)")
    public void logAnnotationPoint(){}


    @After("logAnnotationPoint()")
    public void after(JoinPoint joinPoint){
       if (logAfter != null) {
           logAfter.after(joinPoint);
       }
    }
}
