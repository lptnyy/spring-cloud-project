package com.wzy.common.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(1)
public @interface Authority {
    String[] values(); // 权限数组类型
}
