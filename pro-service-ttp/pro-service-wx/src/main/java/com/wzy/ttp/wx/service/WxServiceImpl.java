package com.wzy.ttp.wx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wzy.common.cache.Token;
import com.wzy.common.cache.TokenCache;
import com.wzy.common.okhttp.Okhttp;
import com.wzy.common.respones.MessageBody;
import com.wzy.wx.entity.SendMessage;
import com.wzy.wx.entity.WeixinRespones;
import com.wzy.wx.WxService;
import com.wzy.ttp.wx.properties.WxProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Date;

@RestController
@Api("微信相关api")
public class WxServiceImpl implements WxService {
    private final Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);
    Okhttp okhttp = Okhttp.getInstance();
    @Autowired
    WxProperties wxProperties;
    @Autowired
    TokenCache tokenCache;

    @Override
    @ApiOperation(value = "获取openId", notes = "需要微信客户端传申请过来的code，传进来获取用户openID")
    public MessageBody getOpenId(
            @ApiParam(value = "微信返回的code") @RequestParam(value = "code") String code) {

        // 定义返回数据体
        MessageBody<WeixinRespones> messageBody = new MessageBody<>();
        StringBuffer getOpenIdUrl = new StringBuffer();
        getOpenIdUrl.append(wxProperties.getOpenIdUrl()).append("?")
                .append("appid=").append(wxProperties.getAppid())
                .append("&secret=").append(wxProperties.getSecret())
                .append("&js_code=").append(code)
                .append("&grant_type=").append("authorization_code");
        try {
            JSONObject webReturnJson = JSON.parseObject(okhttp.get(null,getOpenIdUrl.toString()));
            WeixinRespones weixinRespones = JSON.toJavaObject(webReturnJson,WeixinRespones.class);
            if (weixinRespones.getErrcode() != null && !weixinRespones.getErrcode().equals(0)) {
                messageBody.setCode(500);
                messageBody.setMessage("微信接口返回失败错误");
                logger.warn("调用获取openId接口失败 code="+code+" result="+weixinRespones.getErrmsg());
            } else
                messageBody.setCode(200);
            messageBody.setData(weixinRespones);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return messageBody;
    }

    @Override
    @ApiOperation(value = "获取AccessToken", notes = "获取微信接口调用凭据")
    public MessageBody getAccessToken() {
        MessageBody<WeixinRespones> messageBody = new MessageBody<>();
        StringBuffer getAccessToken = new StringBuffer();
            getAccessToken.append(wxProperties.getAccessTokenUrl())
                    .append("&appid=").append(wxProperties.getAppid())
                    .append("&secret=").append(wxProperties.getSecret());
        try {
            if (tokenCache.check("wx_tokens")) {
                logger.info("缓存获取token数据");
                Token token = tokenCache.getToken("wx_tokens");
                WeixinRespones weixinRespones = new WeixinRespones();
                messageBody.setCode(200);
                weixinRespones.setAccess_token(token.getToken());
                messageBody.setData(weixinRespones);
                return messageBody;
            }
            JSONObject webReturnJson = JSON.parseObject(okhttp.get(null,getAccessToken.toString()));
            WeixinRespones weixinRespones = JSON.toJavaObject(webReturnJson,WeixinRespones.class);
            if (weixinRespones.getErrcode() != null && !weixinRespones.getErrcode().equals(0)) {
                messageBody.setCode(500);
                messageBody.setMessage("微信接口返回失败错误");
                logger.warn("调用获取openId接口失败 result="+weixinRespones.getErrmsg()+" errcode="+weixinRespones.getErrcode());
            } else {
                logger.info("重新封装获取token数据");
                messageBody.setCode(200);
                Token token = new Token();
                token.setExpires_in(new Date().getTime());
                token.setToken(weixinRespones.getAccess_token());
                tokenCache.setToken("wx_tokens", token);
            }
            messageBody.setData(weixinRespones);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return messageBody;
    }

    @Override
    @ApiOperation(value = "发送消息，小程序，公共平台", notes = "消息体参考微信官方文档")
    public MessageBody sendMessage(SendMessage sendMessage) {
        MessageBody<WeixinRespones> messageBody = new MessageBody<>();
        try {
            StringBuffer sendMessageUrl = new StringBuffer();
            sendMessageUrl.append(wxProperties.getSendMessageUrl())
                    .append("??access_token=").append(sendMessage.getAccess_token());
            JSONObject webReturnJson = JSON.parseObject(okhttp.post(null,sendMessageUrl.toString(),JSON.toJSONString(sendMessage)));
            WeixinRespones weixinRespones = JSON.toJavaObject(webReturnJson,WeixinRespones.class);
            if (weixinRespones.getErrcode() != null && !weixinRespones.getErrcode().equals(0)) {
                messageBody.setCode(500);
                messageBody.setMessage("微信接口返回失败错误");
                logger.warn("发送消息失败 result="+weixinRespones.getErrmsg()+" errcode="+weixinRespones.getErrcode());
            } else {
                messageBody.setCode(200);
            }
            messageBody.setData(weixinRespones);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return messageBody;
    }
}
