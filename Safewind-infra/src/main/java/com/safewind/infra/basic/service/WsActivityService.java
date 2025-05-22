package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.WsActivity;

/**
 * 申请表(WsActivity)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface WsActivityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WsActivity queryById(Long id);


    /**
     * 新增数据
     *
     * @param wsActivity 实例对象
     * @return 实例对象
     */
    WsActivity insert(WsActivity wsActivity);

    /**
     * 修改数据
     *
     * @param wsActivity 实例对象
     * @return 实例对象
     */
    WsActivity update(WsActivity wsActivity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
