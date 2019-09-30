package com.wzy.wx.entity;

import lombok.Data;

import java.util.Map;

@Data
public class WeappTemplateMsg {
    String template_id;
    String page;
    String form_id;
    Map<String,String> data;
    String emphasis_keyword;
}
