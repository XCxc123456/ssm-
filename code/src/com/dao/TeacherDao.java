package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Admins;
import com.entity.Teacher;

public interface TeacherDao {
    int deleteById(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectById(Integer id);

    int updateByIdSelective(Teacher record);

    int updateById(Teacher record);
    
    
   // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
	/**
	 * 通过用户名和密码查找 一般可以不用的
	 * @param username
	 * @param password
	 * @return 无记录返回null
	 */
    @Select("select * from teacher where username=#{username} and password=#{password}")
	public Teacher getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
    
    
	/**
	 * 获取列表
	 * @return
	 */
    @Select("select * from teacher order by id desc")
	public List<Teacher> getListForDrop();
	/**
	 * 获取列表 做分页的
	 * @param page
	 * @param rows
	 * @return 无记录返回空集合
	 */
    @Select("select * from teacher order by id desc limit #{begin}, #{size}")
	public List<Teacher> getList(@Param("begin")int begin, @Param("size")int size);

	/**
	 * 总数  做分页的
	 * @return
	 */
    @Select("select count(*) from teacher")
	public long getTotal();
	
	
}