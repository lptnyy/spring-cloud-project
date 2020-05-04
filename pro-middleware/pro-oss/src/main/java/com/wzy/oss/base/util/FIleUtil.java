package com.wzy.oss.base.util;
import com.wzy.common.util.Md5Util;
import com.wzy.common.util.RandomUtil;
import com.wzy.common.util.StringUtil;
import com.wzy.oss.configuration.OssConfiguration;
import com.wzy.oss.dto.FIleVo;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本地文件操作
 */
@Data
public class FIleUtil {
    OssConfiguration ossConfiguration;

    /**
     * 保存文件到本地
     * @return
     */
    public FIleVo saveFileCache(MultipartFile file) {
        FIleVo fileVo = new FIleVo();
        String baseCacheFileStr = System.getProperty("user.dir");
        if (!ossConfiguration.getLocalFilePath().equals("system.dir")) {
            baseCacheFileStr = ossConfiguration.getLocalFilePath();
        }
        // 如果不存在文件夹就创建
        File baseFile = new File(baseCacheFileStr+"/fileCache/");
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        fileVo.setSuffix(StringUtil.getFileSuffix(file.getOriginalFilename()));
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setMd5(Md5Util.getMd5(file));
        String randomFileName = RandomUtil.getOrderNum()+"."+fileVo.getSuffix();
        String path = "/"+fileVo.getSuffix();
        File pathFile = new File(baseFile.getPath()+path);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        fileVo.setPath(path+"/"+randomFileName);
        fileVo.setRandomFileName(randomFileName);
        fileVo.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        fileVo.setPhysicsPath(baseFile.getPath()+path);
        fileVo.setSourceType("file");
        fileVo.setFileSize(file.getSize());
        fileVo.setFileDns(ossConfiguration.getFileDnsUrl());
        try {
            file.transferTo(new File(baseFile.getPath()+fileVo.getPath()));
            //file.getInputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileVo;
    }

    /**
     * 读取本地文件
     * @return
     */
    public FIleVo readFileCache(String path) throws IOException {
        FIleVo fIleVo = new FIleVo();
        String baseCacheFileStr = System.getProperty("user.dir");
        if (!ossConfiguration.getLocalFilePath().equals("system.dir")) {
            baseCacheFileStr = ossConfiguration.getLocalFilePath();
        }
        // 如果不存在文件夹就创建
        File baseFile = new File(baseCacheFileStr+"/fileCache");
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        File file = new File(baseFile.getPath()+path);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while((len = fis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        fIleVo.setFileDatas(bos.toByteArray());
        fis.close();
        bos.close();
        return fIleVo;
    }
}
