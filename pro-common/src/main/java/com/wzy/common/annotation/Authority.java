package com.wzy.common.annotation;
import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
    String[] values(); // 权限数组类型
}
