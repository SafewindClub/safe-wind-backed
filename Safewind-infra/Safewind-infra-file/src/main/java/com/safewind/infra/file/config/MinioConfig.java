package com.safewind.infra.file.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  22:27
 * @Description: minio配置类
 */
@Data
@Configuration
@ConfigurationProperties("minio")
public class MinioConfig {
    private String endpoint;
    private String bucketName;
    private String accessKey;
    private String secretKey;

    /**
     * 注册Minio客户端
     * */
    @Bean
    public MinioClient minioClient(){
        return MinioClient
                .builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
