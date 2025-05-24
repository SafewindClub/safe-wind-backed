package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.WsWall;
/**
 * 海风墙(WsWall)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface WsWallService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WsWall queryById(Long id);


    /**
     * 新增数据
     *
     * @param wsWall 实例对象
     * @return 实例对象
     */
    WsWall insert(WsWall wsWall);

    /**
     * 修改数据
     *
     * @param wsWall 实例对象
     * @return 实例对象
     */
    WsWall update(WsWall wsWall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
