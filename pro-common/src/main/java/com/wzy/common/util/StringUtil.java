package com.wzy.common.util;

public class StringUtil {

    /**
     * 返回文件后缀
     * @param fileUrl
     * @return
     */
    public static String getFileSuffix(String fileUrl) {
        return fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
    }
}
