package com.safewind.infra.basic.dao;

import com.safewind.infra.basic.entity.SysUserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 成员信息表(SysUserInfo)表数据库访问层
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysUserInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserInfo queryById(Long id);


    /**
     * 统计总行数
     *
     * @param sysUserInfo 查询条件
     * @return 总行数
     */
    long count(SysUserInfo sysUserInfo);

    /**
     * 新增数据
     *
     * @param sysUserInfo 实例对象
     * @return 影响行数
     */
    int insert(SysUserInfo sysUserInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserInfo> entities);

    /**
     * 修改数据
     *
     * @param sysUserInfo 实例对象
     * @return 影响行数
     */
    int update(SysUserInfo sysUserInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

