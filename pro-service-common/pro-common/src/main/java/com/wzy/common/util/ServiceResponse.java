package com.wzy.common.util;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    boolean noData = true;
    ObjectMapper mapper = new ObjectMapper();

    public static ServiceResponse SUCCESSServiceResponse = new ServiceResponse();
    public static ServiceResponse FAILServiceResponse = new ServiceResponse();

    public static ServiceResponse getSUCCESS(){
        SUCCESSServiceResponse.setCode(ServiceResponseEnum.SUCCESS.getValue());
        return SUCCESSServiceResponse;
    }

    public static ServiceResponse getFAIL(){
        FAILServiceResponse.setCode(ServiceResponseEnum.FAIL.getValue());
        return FAILServiceResponse;
    }

    public ServiceResponse run(Exceutor exceutor) {
        this.exceutor = exceutor;
        return this;
    }

    public int getDataCount() {
        return dataCount;
    }

    public ServiceResponse setDataCount(int dataCount) {
        this.dataCount = dataCount;
        return this;
    }

    public ServiceResponse setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public List<T> getLsObj() {
        return lsObj;
    }

    public ServiceResponse setLsObj(List<T> lsObj) {
        this.lsObj = lsObj;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ServiceResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public boolean isNoData() {
        return noData;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public String getMsg() {
        return msg;
    }

    public ServiceResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    Exceutor exceutor;
    public ServiceResponse build(){
        try{
            this.obj = (T) exceutor.run();
            if (this.obj == null) {
                this.noData = false;
            }
            this.setCode(ServiceResponseEnum.SUCCESS.getValue());
        } catch (Exception e){
            this.setCode(ServiceResponseEnum.FAIL.getValue());
            throw e;
        }
        return this;
    }

    public interface Exceutor{
        public Object run();
    }

    public T toObjClass(Class srClass){
        return (T) mapper.convertValue(getObj(), srClass);
    }
}
