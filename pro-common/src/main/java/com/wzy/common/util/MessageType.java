package com.wzy.common.util;

/**
 * 定义服务错误码
 */
public enum MessageType {
    SUCCESS(200), // 正常
    AUTHFAIL(401), // 没有全新啊
    BEBUSYFAIL(501), // 服务器忙碌
    FAIL(500); // 服务器异常

    int value;
    MessageType(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
