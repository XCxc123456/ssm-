package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ZuoyexxDao;
import com.entity.Zuoyexx;
import com.entity.Teacher;
import com.entity.Tops;

/**
 * 作业服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class ZuoyexxService {

	@Autowired	
	private ZuoyexxDao zuoyexxDao;
	@Autowired
	private TopService topService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<Zuoyexx> getListForDrop(){
		return zuoyexxDao.getListForDrop();
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Zuoyexx> getList(int status, int page, int size){
		if (status == 0) {
			return packTopList(zuoyexxDao.getList(size * (page-1), size));
		}
		 
		return packTopList(zuoyexxDao.getList(size * (page-1), size));
	}
	
	/**
	 * 获取库存
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Zuoyexx> getList1(int status, int page, int size){
		if (status == 0) {
			return packTopList(zuoyexxDao.getList1(size * (page-1), size));
		}
		 
		return packTopList(zuoyexxDao.getList1(size * (page-1), size));
	}
	
	public List<Zuoyexx> getList2(String mname, int page, int size){
		return packTopList(zuoyexxDao.getList2(mname,size * (page-1), size));
	}

	/**
	 * 获取作业总数
	 * @return
	 */
	public long getTotal(int status){
		if (status == 0) {
			return zuoyexxDao.getTotal();
		}
		return topService.getTotal((byte)status);
	}
	
	public long getTotal1(int status,String mname){
		return zuoyexxDao.getTotal1(mname);
	}
	
	
	/**
	 * 通过名称获取作业列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Zuoyexx> getListByName(String name, int page, int size){
		return zuoyexxDao.getListByName(name, size * (page-1), size);
	}
	
	/**
	 * 通过名称获取作业总数
	 * @return
	 */
	public long getTotalByName(String name){
		return zuoyexxDao.getTotalByName(name);
	}

	/**
	 * 通过分类搜索
	 * @param typeid
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Zuoyexx> getListByType(int typeid, int page, int size) {
		return typeid > 0 ? zuoyexxDao.getListByType(typeid, size * (page-1), size) : zuoyexxDao.getList(size * (page-1), size);
	}
	
	/**
	 * 获取数量
	 * @param typeid
	 * @return
	 */
	public long getTotalByType(int typeid){
		return typeid > 0 ? zuoyexxDao.getTotalByType(typeid) : zuoyexxDao.getTotal();
	}
	
	/**
	 * 通过id获取
	 * @param productid
	 * @return
	 */
	public Zuoyexx get(int id) {
		Zuoyexx zuoyexx = zuoyexxDao.selectById(id);
		if (zuoyexx!=null) {
			zuoyexx.setType(typeService.get(zuoyexx.getTypeId()));
		}
		return zuoyexx;
	}
	
	/**
	 * 添加
	 * @param product
	 */
	public Integer add(Zuoyexx zuoyexx) {
		return zuoyexxDao.insert(zuoyexx);
	}

	/**
	 * 修改
	 * @param product
	 * @return 
	 */
	public boolean update(Zuoyexx zuoyexx) {
		return zuoyexxDao.updateById(zuoyexx) > 0;
	}
	
	/**
	 * 删除作业
	 * 先删除此作业的推荐信息
	 * @param product
	 */
	public boolean delete(int zuoyexxid) {
		topService.deleteByGoodid(zuoyexxid);
		return zuoyexxDao.deleteById(zuoyexxid) > 0;
	}
	

	/**
	 * 封装作业推荐信息
	 * @param list
	 * @return
	 */
	private List<Zuoyexx> packTopList(List<Zuoyexx> list) {
		for(Zuoyexx zuoyexx : list) {
			zuoyexx.setType(typeService.get(zuoyexx.getTypeId()));
			zuoyexx = packTop(zuoyexx);
		}
		return list;
	}

	/**
	 * 封装作业推荐信息
	 * @param zuoyexx
	 * @return
	 */
	private Zuoyexx packTop(Zuoyexx zuoyexx) {
		if(zuoyexx != null) {
			List<Tops> topList = topService.getListByGoodid(zuoyexx.getId());
			if (topList!=null && !topList.isEmpty()) {
				for(Tops top : topList) {
					if(top.getType()==Tops.TYPE_SCROLL) {
						zuoyexx.setTopScroll(true);
					}else if (top.getType()==Tops.TYPE_LARGE) {
						zuoyexx.setTopLarge(true);
					}else if (top.getType()==Tops.TYPE_SMALL) {
						zuoyexx.setTopSmall(true);
					}
				}
			}
		}
		return zuoyexx;
	}

}