package com.safewind.infra.file.strategy;

import com.safewind.infra.file.utils.MinioUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  22:35
 * @Description: minio决策实现类
 */
@Slf4j
@Component
public class MinioFileStrategy implements FileStrategy {

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public String uploadFile(MultipartFile file) {
        log.info("==> 上传minio");
        String url = minioUtil.upload(file);
        log.info("==> 上传成功，地址是{}", url);
        return url;
    }
}
