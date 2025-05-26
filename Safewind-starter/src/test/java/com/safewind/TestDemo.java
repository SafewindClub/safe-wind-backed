package com.safewind;

import com.safewind.infra.basic.dao.SysRoleDao;
import com.safewind.infra.basic.dao.SysUserDao;
import com.safewind.infra.basic.entity.SysRole;
import com.safewind.infra.basic.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-21  15:35
 * @Description: TODO
 */
@SpringBootTest
public class TestDemo {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserDao sysUserDao;

//    @Test
//    public void test(){
//        System.out.println("hello world");
//    }

    @Test
    public void register(){
//        SysRole sysRole = new SysRole();
//        sysRole.setRoleName("超级管理员");
//        sysRole.setRoleKey("admin");
//        sysRole.setDataScope("1");
//        sysRole.setRemark("超级管理员");
//        sysRole.setRoleSort(1);
//        sysRole.setCreateTime(LocalDateTime.now());
//
//        sysRoleDao.insert(sysRole);
//        SysUser user=new SysUser();
//        String admin123 = bCryptPasswordEncoder.encode("admin123");
//        user.setPassword(admin123);
//        user.setStudentId("2220230000");
//        user.setEmail("12345@qq.com");
//
//        sysUserDao.insert(user);
    }
}
