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
     * 登录用户key
     * */
    public static final String LOGIN_USER_KEY="login_user_key:";

    /**
     * 令牌前缀，存储LOGIN_USER_KEY
     * */
    public static final String LOGIN_TOKENS="login_tokens:";

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

    /**
     * 构建登录用户键
     * @param uuid uuid当作键
     * @return 键
     */
    public static String getLoginUserKey(String uuid) {
        return LOGIN_USER_KEY + uuid;
    }
}
