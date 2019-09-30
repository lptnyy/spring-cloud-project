package com.wzy.wx.hystrix;

import com.wzy.common.respones.MessageBody;
import com.wzy.wx.WxService;
import com.wzy.wx.entity.SendMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WxServiceHystrix implements WxService {

    @Override
    public MessageBody getOpenId(String url) {
        MessageBody messageBody = new MessageBody();
        messageBody.setMessage("微信服务端调用失败");
        messageBody.setCode(500);
        return messageBody;
    }

    @Override
    public MessageBody getAccessToken() {
        MessageBody messageBody = new MessageBody();
        messageBody.setMessage("微信服务器获取AccessToken失败");
        messageBody.setCode(500);
        return messageBody;
    }

    @Override
    public MessageBody sendMessage(SendMessage sendMessage) {
        MessageBody messageBody = new MessageBody();
        messageBody.setMessage("发送小时失败");
        messageBody.setCode(500);
        return messageBody;
    }
}
