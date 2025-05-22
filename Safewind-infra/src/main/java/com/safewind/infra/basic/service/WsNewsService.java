package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.WsNews;

/**
 * 新闻(WsNews)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface WsNewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WsNews queryById(Long id);


    /**
     * 新增数据
     *
     * @param wsNews 实例对象
     * @return 实例对象
     */
    WsNews insert(WsNews wsNews);

    /**
     * 修改数据
     *
     * @param wsNews 实例对象
     * @return 实例对象
     */
    WsNews update(WsNews wsNews);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
