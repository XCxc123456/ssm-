package com.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

import com.entity.Zuoyetijiao;

public interface ZuoyetijiaoDao {
    int deleteById(Integer id);

    int insert(Zuoyetijiao record);

    int insertSelective(Zuoyetijiao record);

    Zuoyetijiao selectById(Integer id);

    int updateByIdSelective(Zuoyetijiao record);

    int updateById(Zuoyetijiao record);
    
 
    @Select("select * from zuoyetijiao order by id desc")
	public List<Zuoyetijiao> getListForDrop();
	/**
 
	 */
    @Select("select * from zuoyetijiao order by id desc limit #{begin}, #{size}")
	public List<Zuoyetijiao> getList(@Param("begin")int begin, @Param("size")int size);

 
    @Select("select count(*) from zuoyetijiao")
	public long getTotal();
	
}