package com.safewind.infra.basic.dao;

import com.safewind.infra.basic.entity.SysUserDept;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户部门映射表(SysUserDept)表数据库访问层
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysUserDeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserDept queryById(Long id);


    /**
     * 统计总行数
     *
     * @param sysUserDept 查询条件
     * @return 总行数
     */
    long count(SysUserDept sysUserDept);

    /**
     * 新增数据
     *
     * @param sysUserDept 实例对象
     * @return 影响行数
     */
    int insert(SysUserDept sysUserDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserDept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserDept> entities);

    /**
     * 修改数据
     *
     * @param sysUserDept 实例对象
     * @return 影响行数
     */
    int update(SysUserDept sysUserDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

