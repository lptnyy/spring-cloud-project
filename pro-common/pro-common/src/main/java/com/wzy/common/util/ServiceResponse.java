package com.wzy.common.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;

/**
 * 服务之间数据响应载体
 * @param <T>
 */
public class ServiceResponse<T> implements Serializable {
    T obj;
    int code;
    String msg = "ok";
    long count;
    int pageSize;
    int pageNo;
    long pages;
    public T getObj() {
        return obj;
    }
    ObjectMapper mapper = new ObjectMapper();

    public ServiceResponse builder(){
        return new ServiceResponse<T>();
    }

    public static ServiceResponse SUCCESSServiceResponse = new ServiceResponse();
    public static ServiceResponse FAILServiceResponse = new ServiceResponse();

    public static ServiceResponse getSUCCESS(){
        SUCCESSServiceResponse.setCode(MessageType.SUCCESS.getValue());
        return SUCCESSServiceResponse;
    }

    public static ServiceResponse getFAIL(){
        FAILServiceResponse.setCode(MessageType.FAIL.getValue());
        return FAILServiceResponse;
    }

    public ServiceResponse run(Exceutor<T> exceutor) {
        this.exceutor = exceutor;
        return this;
    }

    public long getCount() {
        return count;
    }

    public ServiceResponse setCount(long count) {
        this.count = count;
        return this;
    }

    public ServiceResponse setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ServiceResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ServiceResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    Exceutor<T> exceutor;
    public ServiceResponse exec(){
        try{
            this.obj = exceutor.run(this);
            this.setCode(MessageType.SUCCESS.getValue());
        } catch (Exception e){
            this.setCode(MessageType.FAIL.getValue());
            throw e;
        }
        return this;
    }

    public interface Exceutor<T>{
        public T run(ServiceResponse<T> serviceResponse);
    }

    public int getPageSize() {
        return pageSize;
    }

    public ServiceResponse setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public ServiceResponse setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public ServiceResponse setPages(long pages) {
        this.pages = pages;
        return this;
    }

    public T toObjClass(Class srClass){
        return (T) mapper.convertValue(getObj(), srClass);
    }
}
