package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.KaoshixxDao;
import com.entity.Kaoshixx;
import com.entity.Types;
import com.util.SafeUtil;

/**
 * 用户服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class KaoshixxService {

	@Autowired		//spring注入类对象
	private KaoshixxDao kaoshixxDao;
	
 
	

	/**
	 * 添加
	 * @param kaoshixx
	 * @return
	 */
	public boolean add(Kaoshixx kaoshixx) {
		return kaoshixxDao.insert(kaoshixx) > 0;
	}
	
	/**
	 * 通过id获取
	 * @param kaoshixxid
	 * @return
	 */
	public Kaoshixx get(int kaoshixxid){
		return kaoshixxDao.selectById(kaoshixxid);
	}
 
	
	/**
	 * 列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Kaoshixx> getList(int page, int rows) {
		return kaoshixxDao.getList(rows * (page-1), rows);
	}

	/**
	 * 获取列表
	 * @return
	 */
	public List<Kaoshixx> getListForDrop(){
		return kaoshixxDao.getListForDrop();
	}
	
	/**
	 * 总数
	 * @return
	 */
	public long getTotal() {
		return kaoshixxDao.getTotal();
	}

	/**
	 * 更新
	 * @param kaoshixx
	 */
	public boolean update(Kaoshixx kaoshixx) {
		return kaoshixxDao.updateById(kaoshixx) > 0;
	}

	/**
	 * 删除
	 * @param id
	 */
	public boolean delete(Kaoshixx kaoshixx) {
		return kaoshixxDao.deleteById(kaoshixx.getId()) > 0;
	}
	
}
