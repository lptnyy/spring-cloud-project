package com.wzy.oss.base;
import org.springframework.stereotype.Component;

@Component
public class OssFactory {

    /**
     * 创建对应实现
     * @param type
     * @return
     */
    public Oss createOss(String type) {
        Oss oss = null;
        switch (type) {
            case "ali":
                oss = new AliOss();
                break;
            case "file":
                oss = new FileOss();
                break;
        }
        return oss;
    }
}
