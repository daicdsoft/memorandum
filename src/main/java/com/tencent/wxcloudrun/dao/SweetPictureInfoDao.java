package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.entity.SweetPictureInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (SweetPictureInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 15:33:14
 */
@Mapper
public interface SweetPictureInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SweetPictureInfo queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param sweetPictureInfo 查询条件
     * @return 总行数
     */
    long count(SweetPictureInfo sweetPictureInfo);

    /**
     * 新增数据
     *
     * @param sweetPictureInfo 实例对象
     * @return 影响行数
     */
    int insert(SweetPictureInfo sweetPictureInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SweetPictureInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SweetPictureInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SweetPictureInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SweetPictureInfo> entities);

    /**
     * 修改数据
     *
     * @param sweetPictureInfo 实例对象
     * @return 影响行数
     */
    int update(SweetPictureInfo sweetPictureInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

