package com.wzy.common.util;

/**
 * 定义服务错误码
 */
public enum MessageType {
    SUCCESS(200),
    AUTHFAIL(401),
    FAIL(500);

    int value;
    MessageType(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
