package com.wzy.oss.base;
import com.wzy.oss.base.util.FIleUtil;
import com.wzy.oss.configuration.OssConfiguration;
import com.wzy.oss.dto.FIleVo;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public class FileOss implements Oss {
    FIleUtil fileUtil;
    OssConfiguration ossConfiguration;

    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        fileUtil = new FIleUtil();
        fileUtil.setOssConfiguration(ossConfiguration);
        this.ossConfiguration = ossConfiguration;
    }

    @Override
    public FIleVo upload(MultipartFile file) {
        return fileUtil.saveFileCache(file);
    }

    @Override
    public FIleVo upload(byte[] fileBytes, String fileName) {
        return null;
    }

    @Override
    public FIleVo readFile(FIleVo fIleVo) {
        try {
            return fileUtil.readFileCache(fIleVo.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
