package com.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Admins;
import com.entity.Zuoyexx;
import com.entity.Teacher;
import com.entity.Tops;
import com.entity.Types;
import com.entity.Users;
import com.service.AdminService;
import com.service.ZuoyexxService;

import com.service.TeacherService;
import com.service.TopService;
import com.service.TypeService;
import com.service.UserService;
import com.util.PageUtil;
import com.util.SafeUtil;
import com.util.UploadUtil;

/**
 * 后台相关接口
 */
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController {

	private static final int rows = 10;

	@Autowired
	private TeacherService teacherService;

	
	/**
	 * 老师登录修改个人信息
	 * 
	 * @return
	 */
	@RequestMapping("/teacherEdi1t")
	public String teacherEdi1t(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("teacher", teacherService.get(id));
		return "/admin/teacher/edit1.jsp";
	}

	/**
	 * 老师登录修改个人信息
	 * 
	 * @return
	 */
	@RequestMapping("/teacherUpdate1")
	public String teacherUpdate1(Teacher teacher, 
			@RequestParam(required=false, defaultValue="1") int page) {
		teacherService.update(teacher);
		return "redirect:teacherEdi1t?id="+teacher.getId();
	}
 
	/**
	 * 老师添加
	 * 
	 * @return
	 */
	@RequestMapping("/teacherAdd")
	public String teacherAdd(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		return "/admin/teacher/add.jsp";
	}
	
	 /**
	 * 老师列表
	 * 
	 * @return
	 */
	@RequestMapping("/teacherList")
	public String teacherList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("teacherList", teacherService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, teacherService.getTotal(), page, rows));
		return "/admin/teacher/list.jsp";
	}

	/**
	 * 老师添加
	 * 
	 * @return
	 */
	@RequestMapping("/teacherSave")
	public String teacherSave(Teacher teacher, 
			@RequestParam(required=false, defaultValue="1") int page) {
		teacherService.add(teacher);
		return "redirect:teacherList?flag=4&page="+page;
	}

	/**
	 * 老师更新
	 * 
	 * @return
	 */
	@RequestMapping("/teacherEdit")
	public String teacherUp(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("teacher", teacherService.get(id));
		return "/admin/teacher/edit.jsp";
	}

	/**
	 * 老师更新
	 * 
	 * @return
	 */
	@RequestMapping("/teacherUpdate")
	public String teacherUpdate(Teacher teacher, 
			@RequestParam(required=false, defaultValue="1") int page) {
		teacherService.update(teacher);
		return "redirect:teacherList?flag=4&page="+page;
	}

	/**
	 * 老师删除
	 * 
	 * @return
	 */
	@RequestMapping("/teacherDelete")
	public String teacherDelete(Teacher teacher, 
			@RequestParam(required=false, defaultValue="1") int page) {
		teacherService.delete(teacher);
		return "redirect:teacherList?flag=4&page="+page;
	}
	

}
