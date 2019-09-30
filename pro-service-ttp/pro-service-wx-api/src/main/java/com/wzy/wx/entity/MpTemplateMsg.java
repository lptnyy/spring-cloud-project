package com.wzy.wx.entity;

import lombok.Data;

import java.util.Map;

@Data
public class MpTemplateMsg {
    String appid;
    String template_id;
    String url;
    String miniprogram;
    Map<String,String> data;
}
