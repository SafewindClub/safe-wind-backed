package com.safewind.infra.basic.dao;

import com.safewind.infra.basic.entity.SysClubDept;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 社团部门映射表(SysClubDept)表数据库访问层
 *
 * @author Darven
 * @since 2025-05-21 21:46:54
 */
public interface SysClubDeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysClubDept queryById(Long id);


    /**
     * 统计总行数
     *
     * @param sysClubDept 查询条件
     * @return 总行数
     */
    long count(SysClubDept sysClubDept);

    /**
     * 新增数据
     *
     * @param sysClubDept 实例对象
     * @return 影响行数
     */
    int insert(SysClubDept sysClubDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysClubDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysClubDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysClubDept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysClubDept> entities);

    /**
     * 修改数据
     *
     * @param sysClubDept 实例对象
     * @return 影响行数
     */
    int update(SysClubDept sysClubDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

