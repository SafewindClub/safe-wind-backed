package com.safewind.infra.redis.constants;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  10:06
 * @Description: 用户相关redis常量
 */
public class UserRedisConstant {

    /**
     * key：用户id
     * value：role key
     */
    public static final String USER_ROLE = "user:role";

    /**
     * key：用户id
     * value：role key
     */
    public static final String USER_PERMISSION = "user:permission";

    /**
     * 构建角色键
     * @param userId 用户id
     * @return 键
     */
    public static String getUserRole(Long userId) {
        return USER_ROLE + userId;
    }

    /**
     * 构建权限键
     * @param userId 用户id
     * @return 键
     */
    public static String getUserPermission(Long userId) {
        return USER_PERMISSION + userId;
    }
}
