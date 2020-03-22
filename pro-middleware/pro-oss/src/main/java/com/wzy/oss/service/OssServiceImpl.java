package com.wzy.oss.service;

import com.wzy.common.util.ServiceResponse;
import com.wzy.oss.OssService;
import com.wzy.oss.dto.FIleVo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OssServiceImpl implements OssService {

    @Override
    public ServiceResponse<FIleVo> uploadMultipartFile(MultipartFile file) {
        return null;
    }
}
