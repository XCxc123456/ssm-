package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NewsDao;
import com.entity.News;
import com.entity.Types;
import com.util.SafeUtil;

/**
 * 用户服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class NewsService {

	@Autowired		//spring注入类对象
	private NewsDao newsDao;
	
 
	

	/**
	 * 添加
	 * @param news
	 * @return
	 */
	public boolean add(News news) {
		return newsDao.insert(news) > 0;
	}
	
	/**
	 * 通过id获取
	 * @param newsid
	 * @return
	 */
	public News get(int newsid){
		return newsDao.selectById(newsid);
	}
 
	
	/**
	 * 列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<News> getList(int page, int rows) {
		return newsDao.getList(rows * (page-1), rows);
	}

	/**
	 * 获取列表
	 * @return
	 */
	public List<News> getListForDrop(){
		return newsDao.getListForDrop();
	}
	
	/**
	 * 总数
	 * @return
	 */
	public long getTotal() {
		return newsDao.getTotal();
	}

	/**
	 * 更新
	 * @param news
	 */
	public boolean update(News news) {
		return newsDao.updateById(news) > 0;
	}

	/**
	 * 删除
	 * @param id
	 */
	public boolean delete(News news) {
		return newsDao.deleteById(news.getId()) > 0;
	}
	
}
