package com.safewind.common.page;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-18  10:39
 * @Description: 分页工具类
 */
public class PageUtils {
    public static Long getTotalPage(Long total, Long pageSize) {
        if (pageSize == null || pageSize < 1) {
            throw new IllegalArgumentException("pageSize 必须大于等于 1");
        }
        if (total == null || total < 1) {
            total=0L;
        }
        return (total / pageSize) + ((total % pageSize) == 0 ? 0 : 1);
    }

    public static Long getOffset(Long pageNum, Long pageSize) {
        if (pageNum == null || pageNum < 1 || pageSize == null || pageSize < 1) {
            throw new IllegalArgumentException("pageNum 和 pageSize 必须大于等于 1");
        }
        return (pageNum - 1) * pageSize;
    }
}
