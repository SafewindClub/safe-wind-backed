package com.safewind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-21  13:52
 * @Description: TODO
 */
@SpringBootApplication
public class SafeWindApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafeWindApplication.class,args);
        System.out.println("application start");
    }
}
