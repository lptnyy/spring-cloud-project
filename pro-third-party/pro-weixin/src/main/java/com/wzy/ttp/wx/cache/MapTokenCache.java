package com.wzy.ttp.wx.cache;
import com.wzy.common.cache.Token;
import com.wzy.common.cache.TokenCache;
import com.wzy.ttp.wx.properties.WxProperties;
import lombok.Data;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
@Data
public class MapTokenCache implements TokenCache {
    ConcurrentHashMap<String,Token> concurrentHashMap = new ConcurrentHashMap();
    WxProperties wxProperties;

    @Override
    public Token getToken(String key) {
        return concurrentHashMap.get(key);
    }

    @Override
    public synchronized void setToken(String key, Token token)
    {
        if (!check(key)) {
            concurrentHashMap.put(key, token);
        }
    }

    @Override
    public boolean check(String key) {
        Token token = concurrentHashMap.get(key);
        if (token == null) {
            return false;
        }
        long times = new Date().getTime();
        if ((times - token.getExpires_in()) < (wxProperties.getAccessTokenOutTime() * 1000))
            return true;
        else
            return false;
    }
}
