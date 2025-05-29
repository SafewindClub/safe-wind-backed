package com.safewind.infra.file.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  22:34
 * @Description: 文件策略接口
 */
public interface FileStrategy {
    /**
     * 文件上传接口
     * @param file 二进制文件
     *
     * @return 文件url
     * */
    String uploadFile(MultipartFile file);
}
