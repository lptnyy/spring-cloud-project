package com.wzy.oss.base;
import com.wzy.oss.configuration.OssConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OssFactory {

    @Autowired
    OssConfiguration ossConfiguration;

    /**
     * 创建对应实现
     * @return
     */
    @Bean
    public Oss createOss() {
        Oss oss = null;
        switch (ossConfiguration.getType()) {
            case "ali":
                oss = new AliOss();
                oss.setConfiguration(ossConfiguration);
                break;
            case "file":
                oss = new FileOss();
                oss.setConfiguration(ossConfiguration);
                break;
        }
        return oss;
    }
}
