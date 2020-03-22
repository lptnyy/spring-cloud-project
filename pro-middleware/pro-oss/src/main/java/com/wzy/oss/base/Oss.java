package com.wzy.oss.base;
import com.wzy.oss.configuration.OssConfiguration;
import com.wzy.oss.dto.FIleVo;
import org.springframework.web.multipart.MultipartFile;

public interface Oss {

    /**
     * 上传配置
     */
    void setConfiguration(OssConfiguration ossConfiguration);

    /**
     * 上传文件
     * @return
     */
    FIleVo upload(MultipartFile file);

    /**
     * 上传文件
     * @return
     */
    FIleVo upload(byte[] fileBytes, String fileName);

    /**
     * 读取文件
     * @param fIleVo
     * @return
     */
    FIleVo readFile(FIleVo fIleVo);
}
