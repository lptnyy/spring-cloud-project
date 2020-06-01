package com.wzy.generator.controller.request;

import lombok.Data;

import java.util.List;

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
    String mysqlPass;
    String tableName;
    String feignClientService;
    String gateWayPath;
    String logSourceName;
    List<TableGenInfo> tableGenInfos;
}
