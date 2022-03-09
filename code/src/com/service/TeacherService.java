package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeacherDao;
import com.entity.Teacher;
import com.entity.Types;
import com.util.SafeUtil;

/**
 * 用户服务
 */
@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class TeacherService {

	@Autowired		//spring注入类对象
	private TeacherDao teacherDao;
	
	/**
	 * 验证用户密码的，一般可不用
	 * @param username
	 * @param password
	 * @return
	 */
	public Teacher checkUser(String username, String password){
		return teacherDao.getByUsernameAndPassword(username, password);
	}
	

	/**
	 * 添加
	 * @param teacher
	 * @return
	 */
	public boolean add(Teacher teacher) {
		return teacherDao.insert(teacher) > 0;
	}
	
	/**
	 * 通过id获取
	 * @param teacherid
	 * @return
	 */
	public Teacher get(int teacherid){
		return teacherDao.selectById(teacherid);
	}
 
	
	/**
	 * 列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Teacher> getList(int page, int rows) {
		return teacherDao.getList(rows * (page-1), rows);
	}

	/**
	 * 获取列表
	 * @return
	 */
	public List<Teacher> getListForDrop(){
		return teacherDao.getListForDrop();
	}
	
	/**
	 * 总数
	 * @return
	 */
	public long getTotal() {
		return teacherDao.getTotal();
	}

	/**
	 * 更新
	 * @param teacher
	 */
	public boolean update(Teacher teacher) {
		return teacherDao.updateById(teacher) > 0;
	}

	/**
	 * 删除
	 * @param id
	 */
	public boolean delete(Teacher teacher) {
		return teacherDao.deleteById(teacher.getId()) > 0;
	}
	
}
