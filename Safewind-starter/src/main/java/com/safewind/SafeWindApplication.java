package com.safewind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-21  13:52
 * @Description: TODO
 */
@SpringBootApplication
@MapperScan("com.safewind.infra.basic.dao")
public class SafeWindApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafeWindApplication.class,args);
        System.out.println("application start");
    }
}
