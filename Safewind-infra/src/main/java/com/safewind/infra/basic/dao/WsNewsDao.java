package com.safewind.infra.basic.dao;

import com.safewind.infra.basic.entity.WsNews;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 新闻(WsNews)表数据库访问层
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface WsNewsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WsNews queryById(Long id);


    /**
     * 统计总行数
     *
     * @param wsNews 查询条件
     * @return 总行数
     */
    long count(WsNews wsNews);

    /**
     * 新增数据
     *
     * @param wsNews 实例对象
     * @return 影响行数
     */
    int insert(WsNews wsNews);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WsNews> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WsNews> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WsNews> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WsNews> entities);

    /**
     * 修改数据
     *
     * @param wsNews 实例对象
     * @return 影响行数
     */
    int update(WsNews wsNews);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

