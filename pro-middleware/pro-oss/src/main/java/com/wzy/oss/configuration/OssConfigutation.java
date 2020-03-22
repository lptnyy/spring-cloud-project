package com.wzy.oss.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfigutation {
    @Value("${oss.type}")
    String type;
    @Value("${oss.local-file-path}")
    String localFilePath;
    @Value("${oss.endpoint}")
    String endpoint;
    @Value("${oss.access-key-id}")
    String accessKeyId;
    @Value("${oss.access-key-secret}")
    String accessKeySecret;
    @Value("${oss.bucket-name}")
    String bucketName;
}
