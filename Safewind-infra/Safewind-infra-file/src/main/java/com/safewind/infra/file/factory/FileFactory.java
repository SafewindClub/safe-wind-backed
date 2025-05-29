package com.safewind.infra.file.factory;

import com.safewind.infra.file.strategy.FileStrategy;
import com.safewind.infra.file.strategy.MinioFileStrategy;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  22:38
 * @Description: 文件工厂类
 */
@Data
@ConfigurationProperties("file")
@Configuration
public class FileFactory {
    private String type;

    @Bean
    public FileStrategy fileStrategy(){
        if(type.equals("minio")){
            return new MinioFileStrategy();
        }
        // todo 阿里云，腾讯云....
        throw new IllegalArgumentException("无可用文件类型");
    }
}
