package com.safewind.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-01  22:15
 * @Description: 时间工具类
 */
public class DateUtils {
    /**
     * LocalDateTime 转时间戳
     *
     * @param localDateTime 时间
     * @return 时间戳
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
