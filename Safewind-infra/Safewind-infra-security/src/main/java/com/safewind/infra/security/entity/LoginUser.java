package com.safewind.infra.security.entity;

import com.safewind.infra.basic.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  20:26
 * @Description: 登录用户身份权限
 * -- 从数据库查询用户信息，然后封装成Authentication，然后交给Manager对象进行比较,
 * 认证成功之后存储在上下文中，方便获取用户信息
 */
@Data
public class LoginUser implements UserDetails {

    /**
     * 用户唯一标识
     * */
    private Long userId;

    /**
     * token
     * */
    private String token;

    /**
     *  用户信息
     * */
    private SysUser user;

    /**
     * 菜单/权限
     * */
    private Set<String> permissions;

    /**
     * 登录时间
     * */
    private Long loginTime;

    /**
     * 过期时间
     * */
    private Long expireTime;

    public LoginUser(Long userId, SysUser user)
    {
        this.userId = userId;
        this.user = user;
    }

    /**
     * 返回数据库的密码
     * */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 返回用户名，这里是学号
     * */
    @Override
    public String getUsername() {
        return user.getStudentId();
    }

    /**
     * 判断用户账户是否未过期，返回 true 表示账户有效。
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断用户账户是否未被锁定，返回 true 表示账户可用。
     * */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断用户凭证（如密码）是否未过期，返回 true 表示凭证有效。
     * */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断用户是否启用，返回 true 表示用户处于激活状态。
     * */
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
