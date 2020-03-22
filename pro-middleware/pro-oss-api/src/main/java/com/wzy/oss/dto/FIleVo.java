package com.wzy.oss.dto;

import lombok.Data;

@Data
public class FIleVo {
    String physicsPath;
    String path;
    String md5;
    String sourceType;
    String fileName;
    String randomFileName;
    String uploadTime;
    String suffix;
    String fileDns;
    byte[] fileDatas;
}
