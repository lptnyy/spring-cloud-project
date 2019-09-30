package com.wzy.wx;
import com.wzy.common.respones.MessageBody;
import com.wzy.wx.entity.SendMessage;
import com.wzy.wx.hystrix.WxServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 微信对外提供的Api
 */
@FeignClient(value = "weixin-service", fallback = WxServiceHystrix.class)
public interface WxService {

    /**
     * 获取微信用户openId
     * @param code
     * @return
     */
    @RequestMapping(value = "getOpenId", method = RequestMethod.GET)
    MessageBody getOpenId(String code);

    /**
     * 获取accessToken
     * @return
     */
    @RequestMapping(value = "getAccessToken", method = RequestMethod.GET)
    MessageBody getAccessToken();

    /**
     * 发送消息数据
     * @return
     */
    @RequestMapping(value = "sendMessage", method = RequestMethod.GET)
    MessageBody sendMessage(SendMessage sendMessage);
}
