package com.wzy.common.util;

public class PageUtil {

    public static int returnPageNo(int pageNo, int pageSize){
        return (pageNo-1) * pageSize;
    }
}
