package com.wzy.oss.base;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.wzy.common.util.Md5Util;
import com.wzy.common.util.RandomUtil;
import com.wzy.common.util.StringUtil;
import com.wzy.oss.configuration.OssConfiguration;
import com.wzy.oss.dto.FIleVo;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 阿里实现
 */
public class AliOss implements Oss{
    OssConfiguration ossConfiguration;
    String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    String accessKeyId = "<yourAccessKeyId>";
    String accessKeySecret = "<yourAccessKeySecret>";

    @Override
    public void setConfiguration(OssConfiguration ossConfiguration) {
        this.ossConfiguration = ossConfiguration;
        endpoint = ossConfiguration.getEndpoint();
        accessKeyId = ossConfiguration.getAccessKeyId();
        accessKeySecret = ossConfiguration.getAccessKeySecret();
    }

    @Override
    public FIleVo upload(MultipartFile file) {
        FIleVo fileVo = new FIleVo();
        fileVo.setSuffix(StringUtil.getFileSuffix(file.getOriginalFilename()));
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setMd5(Md5Util.getMd5(file));
        String randomFileName = RandomUtil.getOrderNum()+"."+fileVo.getSuffix();
        fileVo.setPath(randomFileName);
        fileVo.setRandomFileName(randomFileName);
        fileVo.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        fileVo.setSourceType("ali");
        fileVo.setFileSize(file.getSize());
        fileVo.setFileDns(ossConfiguration.getFileDnsUrl());
        InputStream inputStream = null;
        OSS ossClient = null;
        try {
            byte[] imgBytes = file.getBytes();
            ossClient = getOSS();
            inputStream = new ByteArrayInputStream(imgBytes);
            ossClient.putObject(ossConfiguration.getBucketName(), fileVo.getRandomFileName(), inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {

                }
            }
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return fileVo;
    }

    @Override
    public FIleVo upload(byte[] fileBytes, String fileName) {
        return null;
    }

    @Override
    public FIleVo readFile(FIleVo fIleVo) {
        return null;
    }

    /**
     * 获取oss连接
     * @return
     */
    public OSS getOSS() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);
        return ossClient;
    }
}
