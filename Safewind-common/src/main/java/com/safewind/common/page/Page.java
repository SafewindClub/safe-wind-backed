package com.safewind.common.page;

import lombok.Data;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-17  08:10
 * @Description: 公用分页类
 */
@Data
public class Page {
    /**
     * 当前页码
     * */
    protected Long pageNum=1L;
    /**
     * 当前页数
     * */
    protected Long pageSize=10L;

    // 判断是否合法
    public void setPageNum(Long pageNum){
        if(pageNum==null||pageNum<0L){
            throw new IllegalArgumentException("当前页码必须为正整数");
        }
        this.pageNum=pageNum;
    }

    public void pageSize(Long pageSize){
        if(pageSize==null||pageSize<0L){
            throw new IllegalArgumentException("每页数量必须为正整数");
        }
        this.pageSize=pageSize;
    }
}
