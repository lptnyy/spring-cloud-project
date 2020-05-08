package com.wzy.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 权限自定义拦截器
 */
@Aspect
@Component
public class AuthorityAspect {

    @Autowired
    AuthorityAfter authorityAfter;

    @Pointcut("@annotation(com.wzy.common.annotation.Authority)")
    public void authorityAnnotationPoint(){}

    /**
     * 环绕方法,可自定义目标方法执行的时机
     * @param pjd JoinPoint的子接口,添加了
     *            Object proceed() throws Throwable 执行目标方法
     *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *            两个方法
     * @return 此方法需要返回值,返回值视为目标方法的返回值
     */
    @Around("authorityAnnotationPoint()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;
        if (authorityAfter != null) {
            result = authorityAfter.aroundMethod(pjd);
        }
        return result;
    }
}
