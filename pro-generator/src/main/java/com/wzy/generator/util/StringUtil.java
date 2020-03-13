package com.wzy.generator.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    /**
     * 把表名转类名
     * @param name
     * @return
     */
    public String getClassName(String name) {
        // 通过下划线分割字符串
        String[] names = name.split("_");
        String resultStr = "";
        for(String str: names) {
            char[] cs=str.toLowerCase().toCharArray();
            cs[0]-=32;
            resultStr += String.valueOf(cs);
        }
        return resultStr;
    }

    /**
     * 把列名转成字段名
     * @param name
     * @return
     */
    public String getFieldName(String name) {
        // 通过下划线分割字符串
        String[] names = name.split("_");
        String resultStr = "";
        int i = 0;
        for(String str: names) {
            char[] cs=str.toLowerCase().toCharArray();
            if (names.length == 1) {
               return str.toLowerCase();
            } else {
                if (i != 0) {
                    cs[0]-=32;
                    resultStr += String.valueOf(cs);
                } else {
                    resultStr+=str.toLowerCase();
                }
            }
            i++;
        }
        return resultStr;
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public String getInitialsCapitalization(String name) {
        char[] chars = name.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char)(chars[0] - 32);
        }
        return new String(chars);
    }
}
