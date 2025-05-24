package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysApplyForm;

/**
 * 申请表(SysApplyForm)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:27
 */
public interface SysApplyFormService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysApplyForm queryById(Long id);

    /**
     * 新增数据
     *
     * @param sysApplyForm 实例对象
     * @return 实例对象
     */
    SysApplyForm insert(SysApplyForm sysApplyForm);

    /**
     * 修改数据
     *
     * @param sysApplyForm 实例对象
     * @return 实例对象
     */
    SysApplyForm update(SysApplyForm sysApplyForm);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
