package com.wzy.system.vo;

import lombok.Data;

@Data
public class MenuMeta {
    String icon;
    String title;
    Boolean hideInMenu = false;
    Boolean hideInBread = true;
}
