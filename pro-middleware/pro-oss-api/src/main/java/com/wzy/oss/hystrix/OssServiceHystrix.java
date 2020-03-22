package com.wzy.oss.hystrix;
import com.wzy.common.util.ServiceResponse;
import com.wzy.oss.OssService;
import com.wzy.oss.dto.FIleVo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class OssServiceHystrix implements OssService {

    @Override
    public ServiceResponse<FIleVo> uploadMultipartFile(MultipartFile file) {
        return ServiceResponse.getFAIL();
    }
}
