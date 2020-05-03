package com.wzy.generator.controller.request;

import lombok.Data;

@Data
public class TableInfo {
    String mysql;
    String mysqlDev;
    String apiPkg;
    String controllerPkg;
    String voPkg;
    String servicePkg;
    String serviceImplPkg;
    String mapperPkg;
    String dtoPgk;
    String mysqlUser;
    String msyqlPass;
    String tableName;
    String feignClientService;
    String gateWayPath;
}
