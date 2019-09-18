package com.wzy.common.util;

/**
 * 定义服务错误码
 */
public enum ServiceResponseEnum {
    SUCCESS(200),
    FAIL(500);

    int value;
    ServiceResponseEnum(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
