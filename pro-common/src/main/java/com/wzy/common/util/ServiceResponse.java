package com.wzy.common.util;
import java.io.Serializable;
import java.util.List;

/**
 * 服务之间数据响应载体
 * @param <T>
 */
public class ServiceResponse<T> implements Serializable {
    T obj;
    List<T> lsObj;
    int code;
    String msg;
    int dataCount;
    public T getObj() {
        return obj;
    }

    public static ServiceResponse getSUCCESS(){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(ServiceResponseEnum.SUCCESS.getValue());
        return serviceResponse;
    }

    public static ServiceResponse getFAIL(){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(ServiceResponseEnum.FAIL.getValue());
        return serviceResponse;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getLsObj() {
        return lsObj;
    }

    public void setLsObj(List<T> lsObj) {
        this.lsObj = lsObj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
