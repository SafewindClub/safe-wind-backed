package com.safewind.infra.basic.dao;

import com.safewind.infra.basic.entity.WsWall;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 海风墙(WsWall)表数据库访问层
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface WsWallDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WsWall queryById(Long id);


    /**
     * 统计总行数
     *
     * @param wsWall 查询条件
     * @return 总行数
     */
    long count(WsWall wsWall);

    /**
     * 新增数据
     *
     * @param wsWall 实例对象
     * @return 影响行数
     */
    int insert(WsWall wsWall);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WsWall> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WsWall> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WsWall> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WsWall> entities);

    /**
     * 修改数据
     *
     * @param wsWall 实例对象
     * @return 影响行数
     */
    int update(WsWall wsWall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

