package com.wzy.wx.entity;

import lombok.Data;

@Data
public class WeixinRespones {
   Integer errcode;
   String errmsg;
   String access_token;
   String expires_in;
   String openid;
   String session_key;
   String unionid;
}
