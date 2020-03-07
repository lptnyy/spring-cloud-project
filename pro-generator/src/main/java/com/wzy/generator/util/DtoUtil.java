package com.wzy.generator.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 此部分需要开发自己定义类型的转换
 */
@Component
public class DtoUtil {

    /**
     * 类型转换
     */
    HashMap<String, String> typesMap = new HashMap() {
        {
            put("varchar", "String");
            put("int", "Integer");
            put("datetime", "Date");
            put("timestamp", "Date");
        }
    };

    /**
     * 需要引入的包名
     */
    static HashMap<String, String>  typesPkgMap = new HashMap() {
        {
            put("varchar", "java.lang.String");
            put("int", "java.lang.Integer");
            put("datetime", "java.util.Date");
            put("timestamp", "java.util.Date");
        }
    };

    /**
     * 获取对应的生成类型
     * @param type
     * @return
     */
    public DbType dbType(String type) {
        DbType dbType = new DbType();
        dbType.setName(typesMap.get(type));
        dbType.setPkg(typesPkgMap.get(type));
        return dbType;
    }

    @Data
    public class DbType{
        String name;
        String pkg;
    }
}
