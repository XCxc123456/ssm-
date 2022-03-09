package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Zuoyexx;
import com.entity.Teacher;

public interface ZuoyexxDao {
    int deleteById(Integer id);

    int insert(Zuoyexx record);

    int insertSelective(Zuoyexx record);

    Zuoyexx selectById(Integer id);

    int updateByIdSelective(Zuoyexx record);

    int updateById(Zuoyexx record);    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
	/**
	 * 获取列表
	 * @return
	 */
    @Select("select * from zuoyexx order by id desc")
	public List<Zuoyexx> getListForDrop();
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
    @Select("select * from zuoyexx order by id desc limit #{begin}, #{size}")
	public List<Zuoyexx> getList(@Param("begin")int begin, @Param("size")int size);
	
    @Select("select * from zuoyexx where   order by id desc limit #{begin}, #{size}")
	public List<Zuoyexx> getList1(@Param("begin")int begin, @Param("size")int size);
    
    @Select("select * from zuoyexx where   teachername = #{mname} order by id desc limit #{begin}, #{size}")
	public List<Zuoyexx> getList2(@Param("mname")String mname,@Param("begin")int begin, @Param("size")int size);
    
	/**
	 * 获取总数
	 * @return
	 */
    @Select("select count(*) from zuoyexx")
	public long getTotal();

    @Select("select count(*) from zuoyexx  where teachername = #{mname} ")
	public long getTotal1(@Param("mname")String mname);
    
	/**
	 * 通过类型获取列表
	 * @param typeid
	 * @param page
	 * @param size
	 * @return
	 */
    @Select("select * from zuoyexx where type_id=#{typeid} order by id desc limit #{begin}, #{size}")
	public List<Zuoyexx> getListByType(@Param("typeid")int typeid, @Param("begin")int begin, @Param("size")int size);
	
	/**
	 * 通过类型获取总数
	 * @param typeid
	 * @return
	 */
    @Select("select count(*) from zuoyexx where type_id=#{typeid}")
	public long getTotalByType(@Param("typeid")int typeid);
	
	/**
	 * 通过名称获取列表
	 * @param name
	 * @param page
	 * @param size
	 * @return
	 */
    @Select("select * from zuoyexx where name like concat('%',#{name},'%') order by id desc limit #{begin}, #{size}")
	public List<Zuoyexx> getListByName(@Param("name")String name, @Param("begin")int begin, @Param("size")int size);
	
	/**
	 * 通过名称获取总数
	 * @param name
	 * @return
	 */
    @Select("select count(*) from zuoyexx where name like concat('%',#{name},'%')")
	public long getTotalByName(@Param("name")String name);
}