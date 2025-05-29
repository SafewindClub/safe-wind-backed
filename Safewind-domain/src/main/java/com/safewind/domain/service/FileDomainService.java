package com.safewind.domain.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  23:25
 * @Description: 文件
 */

public interface FileDomainService {

    String uploadFile(MultipartFile file);
}
