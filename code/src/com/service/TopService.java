package com.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TopsDao;
import com.entity.Tops;

/**
 * 作业推荐服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class TopService {

	@Autowired	
	private TopsDao topDao;
	@Autowired
	private ZuoyexxService zuoyexxService;
	
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<Tops> getList(byte type, int page, int size){
		List<Tops> topList = topDao.getList(type, (page-1)*size, size);
		for(Tops top : topList) {
			top.setGood(zuoyexxService.get(top.getGoodId()));
		}
		return topList;
	}
	
	/**
	 * 获取总数
	 * @param type
	 * @return
	 */
	public long getTotal(byte type) {
		return topDao.getTotal(type);
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<Tops> getListByGoodid(int zuoyexxid){
		return topDao.getListByGoodid(zuoyexxid);
	}

	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public Tops get(int id) {
		return topDao.selectById(id);
	}
	
	/**
	 * 添加
	 * @param top
	 * @return
	 */
	public Integer add(Tops top) {
		return topDao.insert(top);
	}

	/**
	 * 更新
	 * @param top
	 */
	public boolean update(Tops top) {
		return topDao.updateById(top) > 0;
	}

	/**
	 * 删除
	 * @param top
	 */
	public boolean delete(Tops top) {
		return (top.getId()!=null) ? (topDao.deleteById(top.getId()) > 0) : 
			topDao.deleteByGoodidAndType(top.getGoodId(), top.getType());
	}
	
	/**
	 * 按作业删除
	 * @param zuoyexxid
	 * @return
	 */
	public boolean deleteByGoodid(int zuoyexxid) {
		return topDao.deleteByGoodid(zuoyexxid);
	}
	
}
