package com.wzy.system.configuration.aspect;
import com.wzy.common.aspect.AuthorityAfter;
import com.wzy.common.util.ServiceResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 自定义权限认证
 */
@Component
public class AuthortiyConfiguration implements AuthorityAfter {

    @Override
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        return null;
    }
}
