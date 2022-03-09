package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Kaoshixx;
import com.entity.News;

public interface KaoshixxDao {
    int deleteById(Integer id);

    int insert(Kaoshixx record);

    int insertSelective(Kaoshixx record);

    Kaoshixx selectById(Integer id);

    int updateByIdSelective(Kaoshixx record);

    int updateById(Kaoshixx record);
    
    /**
     * 获取列表
     * @return
     */
    @Select("select * from kaoshixx order by id desc")
    public List<Kaoshixx> getListForDrop();

    /**
     * 获取列表 做分页的
     * @param page
     * @param rows
     * @return 无记录返回空集合
     */
    @Select("select * from kaoshixx order by id desc limit #{begin}, #{size}")
    public List<Kaoshixx> getList(@Param("begin")int begin, @Param("size")int size);

    /**
     * 总数  做分页的
     * @return
     */
    @Select("select count(*) from kaoshixx")
    public long getTotal();
    
}