package com.wzy.common.method;

import com.wzy.common.page.RequestPage;
import java.util.Map;

public class ProParameter<T> {

    public ProParameter()
    {

    }

    public ProParameter(T t){
        this.obj = t;
        try{
            this.setRequestPage((RequestPage) t);
        } catch (Exception e) {

        }
    }

    T obj;
    Map<String, Object> parameterMap;
    RequestPage requestPage;

    public T getObj() {
        return obj;
    }

    public ProParameter<T> setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public Map<String, Object> getParameterMap() {
        return parameterMap;
    }

    public ProParameter<T>  setParameterMap(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
        return this;
    }

    public RequestPage getRequestPage() {
        return requestPage;
    }

    public ProParameter<T>  setRequestPage(RequestPage requestPage) {
        this.requestPage = requestPage;
        return this;
    }

    public ProParameter<T> put(String key, Object value){
        parameterMap.put(key, value);
        return this;
    }

    public Object get(String key){
        return parameterMap.get(key);
    }
}
