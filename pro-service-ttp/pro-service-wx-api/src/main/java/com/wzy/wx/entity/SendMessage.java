package com.wzy.wx.entity;

import lombok.Data;

@Data
public class SendMessage {
    String access_token;
    String touser;
    WeappTemplateMsg weapp_template_msg;
    MpTemplateMsg mp_template_msg;
}
