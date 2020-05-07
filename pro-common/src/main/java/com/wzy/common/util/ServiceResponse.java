package com.wzy.common.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzy.common.page.RequestPage;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * 服务之间数据响应载体
 * @param <T>
 */
public class ServiceResponse<T> implements Serializable {
    T obj;
    int code = 200;
    String msg = "";
    long count;
    int pageSize;
    int pageNo;
    long pages;
    int insertLastId;
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
        SUCCESSServiceResponse.setMsg("ok");
        return SUCCESSServiceResponse;
    }

    public ServiceResponse<T> copyPage(ServiceResponse serviceResponse){
        serviceResponse.count = this.count;
        serviceResponse.pageSize = this.pageSize;
        serviceResponse.pageNo = this.pageNo;
        serviceResponse.pages = this.pages;
        return this;
    }

    public ServiceResponse<T> copyState(ServiceResponse serviceResponse) {
        serviceResponse.setCode(this.getCode());
        serviceResponse.setMsg(this.getMsg());
        return this;
    }

    public static ServiceResponse getFAIL(){
        FAILServiceResponse.setCode(MessageType.FAIL.getValue());
        FAILServiceResponse.setMsg("操作异常");
        return FAILServiceResponse;
    }

    public ServiceResponse<T> run(Exceutor<T> exceutor) {
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
    public ServiceResponse exec() throws Exception {
        try{
            this.obj = exceutor.run(this);
        } catch (Exception e){
            this.setMsg(e.getMessage());
            this.setCode(MessageType.FAIL.getValue());
            throw e;
        }
        return this;
    }

    public interface Exceutor<T>{
        public T run(ServiceResponse<T> serviceResponse) throws Exception;
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

    public int getInsertLastId() {
        return insertLastId;
    }

    public ServiceResponse setInsertLastId(int insertLastId) {
        this.insertLastId = insertLastId;
        return this;
    }

    public void checkState() throws Exception {
        if (this.code != 200) {
            throw new Exception("服务器调用异常");
        }
    }

    public T toObjClass(Class srClass) {
        return (T) mapper.convertValue(getObj(), srClass);
    }
}
