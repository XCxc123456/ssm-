package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ZuoyetijiaoDao;
import com.entity.Zuoyetijiao;
import com.entity.Types;
import com.util.SafeUtil;

/**
 * 用户服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class ZuoyetijiaoService {

	@Autowired		//spring注入类对象
	private ZuoyetijiaoDao zuoyetijiaoDao;
	
 

	/**
	 * 添加
	 * @param zuoyetijiao
	 * @return
	 */
	public boolean add(Zuoyetijiao zuoyetijiao) {
		return zuoyetijiaoDao.insert(zuoyetijiao) > 0;
	}
	
	/**
	 * 通过id获取
	 * @param zuoyetijiaoid
	 * @return
	 */
	public Zuoyetijiao get(int zuoyetijiaoid){
		return zuoyetijiaoDao.selectById(zuoyetijiaoid);
	}
 
	
	/**
	 * 列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Zuoyetijiao> getList(int page, int rows) {
		return zuoyetijiaoDao.getList(rows * (page-1), rows);
	}

	/**
	 * 获取列表
	 * @return
	 */
	public List<Zuoyetijiao> getListForDrop(){
		return zuoyetijiaoDao.getListForDrop();
	}
	
	/**
	 * 总数
	 * @return
	 */
	public long getTotal() {
		return zuoyetijiaoDao.getTotal();
	}

	/**
	 * 更新
	 * @param zuoyetijiao
	 */
	public boolean update(Zuoyetijiao zuoyetijiao) {
		return zuoyetijiaoDao.updateById(zuoyetijiao) > 0;
	}

	/**
	 * 删除
	 * @param id
	 */
	public boolean delete(Zuoyetijiao zuoyetijiao) {
		return zuoyetijiaoDao.deleteById(zuoyetijiao.getId()) > 0;
	}
	
}
