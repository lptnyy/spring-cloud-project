package com.wzy.common.cache;

/**
 * 缓存
 */
public interface TokenCache {
    Token getToken(String key);
    void setToken(String key,Token token);
    boolean check(String key);
}
