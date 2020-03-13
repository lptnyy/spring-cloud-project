package com.wzy.common.util;

public class Srfactory {

    // 创建一个统一返回
    public static ServiceResponse sr(){
        return new ServiceResponse();
    }

    // 事务串行执行
    public static ServiceRun ru(){
        return new ServiceRun();
    }
}
