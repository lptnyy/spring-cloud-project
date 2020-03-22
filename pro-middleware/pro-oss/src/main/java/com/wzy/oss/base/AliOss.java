package com.wzy.oss.base;

import com.wzy.oss.configuration.OssConfiguration;
import com.wzy.oss.dto.FIleVo;
import org.springframework.web.multipart.MultipartFile;

public class AliOss implements Oss{
    OssConfiguration ossConfiguration;

    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        this.ossConfiguration = ossConfiguration;
    }

    @Override
    public FIleVo upload(MultipartFile file) {
        return null;
    }

    @Override
    public FIleVo upload(byte[] fileBytes, String fileName) {
        return null;
    }

    @Override
    public FIleVo readFile(FIleVo fIleVo) {
        return null;
    }
}
