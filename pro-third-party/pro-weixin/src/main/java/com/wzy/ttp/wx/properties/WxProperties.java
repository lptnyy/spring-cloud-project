package com.wzy.ttp.wx.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix="spring.ttp.wx")
@Data
public class WxProperties {
    String openIdUrl;
    String accessTokenUrl;
    Long accessTokenOutTime;
    String accessTokenCacheType;
    String secret;
    String appid;
    String sendMessageUrl;
}
