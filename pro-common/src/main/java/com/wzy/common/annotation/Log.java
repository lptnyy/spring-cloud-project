package com.wzy.common.annotation;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(2)
public @interface Log {
    String value() default ""; // 日志内容
    String name() default ""; // 日志名称
    String source() default ""; // 添加来源用于区分日志来源 比如某某功能 某某服务 某某业务
}
