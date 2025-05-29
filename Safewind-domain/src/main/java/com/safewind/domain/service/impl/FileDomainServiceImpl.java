package com.safewind.domain.service.impl;

import com.safewind.domain.service.FileDomainService;
import com.safewind.infra.file.strategy.FileStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  23:27
 * @Description: 实现类
 */
@Service
public class FileDomainServiceImpl implements FileDomainService {
    @Autowired
    private FileStrategy fileStrategy;

    @Override
    public String uploadFile(MultipartFile file) {
        return fileStrategy.uploadFile(file);
    }
}
