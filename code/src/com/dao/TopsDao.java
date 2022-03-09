package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Tops;

public interface TopsDao {
    int deleteById(Integer id);

    int insert(Tops record);

    int insertSelective(Tops record);

    Tops selectById(Integer id);

    int updateByIdSelective(Tops record);

    int updateById(Tops record);    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    

	/**
	 * 获取列表
	 * @return
	 */
    @Select("select * from tops where type=#{type} order by id desc limit #{begin}, #{size}")
	public List<Tops> getList(@Param("type")byte type, @Param("begin")int begin, @Param("size")int size);
	/**
	 * 获取总数
	 * @param type
	 * @return
	 */
    @Select("select count(*) from tops where type=#{type}")
	public long getTotal(byte type);
	
	/**
	 * 通过作业id获取
	 * @param zuoyexxid
	 * @return
	 */
    @Select("select * from tops where zuoyexx_id=#{zuoyexxid}")
	public List<Tops> getListByGoodid(int zuoyexxid);
	
	/**
	 * 通过作业id和类型删除
	 * @param zuoyexxid
	 * @param type
	 * @return
	 */
    @Delete("delete from tops where zuoyexx_id=#{zuoyexxid} and type=#{type}")
	public boolean deleteByGoodidAndType(@Param("zuoyexxid")int zuoyexxid, @Param("type")byte type);
	
	/**
	 * 通过zuoyexxid删除
	 * @param zuoyexxid
	 * @return
	 */
    @Delete("delete from tops where zuoyexx_id=#{zuoyexxid}")
	public boolean deleteByGoodid(@Param("zuoyexxid")int zuoyexxid);
}