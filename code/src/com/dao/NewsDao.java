package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.News;
import com.entity.Teacher;

public interface NewsDao {
    int deleteById(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectById(Integer id);

    int updateByIdSelective(News record);

    int updateById(News record);

/**
 * 获取列表
 * @return
 */
@Select("select * from news order by id desc")
public List<News> getListForDrop();

/**
 * 获取列表 做分页的
 * @param page
 * @param rows
 * @return 无记录返回空集合
 */
@Select("select * from news order by id desc limit #{begin}, #{size}")
public List<News> getList(@Param("begin")int begin, @Param("size")int size);

/**
 * 总数  做分页的
 * @return
 */
@Select("select count(*) from news")
public long getTotal();


}

