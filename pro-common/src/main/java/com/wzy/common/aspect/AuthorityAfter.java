package com.wzy.common.aspect;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 实例化
 */
public interface AuthorityAfter {
    Object aroundMethod(ProceedingJoinPoint pjd);
}
