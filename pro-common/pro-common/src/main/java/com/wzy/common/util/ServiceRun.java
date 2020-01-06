package com.wzy.common.util;

/**
 * 执行方法封装
 */
public class ServiceRun {
    public ServiceRun run(ServiceCallBack callback){
        try{
            ServiceResponse response = callback.run();
            if (response.getCode() != MessageType.SUCCESS.value){
                throw new IllegalStateException("service error");
            }
        } catch (Exception e){
            throw new IllegalStateException("service error");
        }
        return this;
    }
}
