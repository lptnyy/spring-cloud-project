package com.wzy.oss;
import com.wzy.common.feign.FeignRequestInterceptor;
import com.wzy.common.util.ServiceResponse;
import com.wzy.oss.dto.FIleVo;
import com.wzy.oss.hystrix.OssServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "oss-service", configuration = FeignRequestInterceptor.class, fallback = OssServiceHystrix.class)
public interface OssService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping(path = "/file/uploadMultipartFile", method = RequestMethod.POST)
    ServiceResponse<FIleVo> uploadMultipartFile(@RequestPart(value = "file", required = false) MultipartFile file);
}
