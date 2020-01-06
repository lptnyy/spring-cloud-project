package com.wzy.common.annotation;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String name() default "info";
}
