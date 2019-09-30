package com.wzy.ttp.wx.cache;

import com.wzy.common.cache.TokenCache;
import com.wzy.ttp.wx.properties.WxProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Autowired
    WxProperties wxProperties;

    @Bean
    public TokenCache getTokenCace() {
        TokenCache tokenCache = null;
        if (wxProperties.getAccessTokenCacheType().equals("map")) {
            tokenCache = new MapTokenCache();
            ((MapTokenCache) tokenCache).setWxProperties(wxProperties);
        } if (wxProperties.getAccessTokenCacheType().equals("redis")) {

        }
        return tokenCache;
    }
}
