package com.wzy.oss.dto;

import lombok.Data;

@Data
public class FIleVo {
    String physicsPath;
    String path;
    String md5;
    String fileName;
    String uploadTime;
}
