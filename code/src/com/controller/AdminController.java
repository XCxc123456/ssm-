package com.controller;

import java.io.UnsupportedEncodingException;
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
import com.entity.Zuoyetijiao;
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
@RequestMapping("/admin")
public class AdminController {

	private static final int rows = 10;

	@Autowired
	private AdminService adminService;
 
	@Autowired
	private UserService userService;
	@Autowired
	private ZuoyexxService zuoyexxService;
	@Autowired
	private TopService topService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private TeacherService teacherService;

	/**
	 * 管理员登录
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/login")
	public String login(Admins admin, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		System.out.println(new String(admin.getUsername().getBytes("ISO-8859-1"),"UTF-8"));
		
		if(new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8").equals("管理员"))
		{
			System.out.println("管理员");
			if (adminService.checkUser(admin.getUsername(), admin.getPassword())) {
				session.setAttribute("username", admin.getUsername());
				session.setAttribute("zyurl", new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("uid", 1);
				session.setAttribute("mname", 1);
				return "redirect:index";
			}
		}
		else if(new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8").equals("老师"))
		{
			System.out.println(admin.getZyurl());
			Teacher mm= teacherService.checkUser(admin.getUsername(), admin.getPassword());
			if (mm != null) {
				session.setAttribute("username", admin.getUsername());
				session.setAttribute("zyurl", new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("uid", mm.getId());
				session.setAttribute("mname", mm.getName());
				return "redirect:index";
			}
		}
		else
		{
			System.out.println(admin.getZyurl());
			Users user= userService.checkUser(admin.getUsername(), admin.getPassword());
			if (user != null) {
				session.setAttribute("username", admin.getUsername());
				session.setAttribute("zyurl", new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8"));
				session.setAttribute("uid", user.getId());
				session.setAttribute("mname", user.getName());
				return "redirect:index";
			}
		}
		
		request.setAttribute("msg", "用户名或密码错误!");
		return "/admin/login.jsp";
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "/admin/login.jsp";
	}
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("msg", "恭喜你! 登录成功了");
		return "/admin/index.jsp";
	}

	 
	 

	/**
	 * 学生管理
	 * 
	 * @return
	 */
	@RequestMapping("/userList")
	public String userList(HttpServletRequest request,
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 2);
		request.setAttribute("userList", userService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, userService.getTotal(), page, rows));
		return "/admin/user_list.jsp";
	}

	/**
	 * 学生添加
	 * 
	 * @return
	 */
	@RequestMapping("/userAdd")
	public String userAdd(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		return "/admin/user_add.jsp";
	}

	/**
	 * 学生添加
	 * 
	 * @return
	 */
	@RequestMapping("/userSave")
	public String userSave(Users user, HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		if (userService.isExist(user.getUsername())) {
			request.setAttribute("msg", "用户名已存在!");
			return "/admin/user_add.jsp";
		}
		userService.add(user);
		return "redirect:userList?flag=2&page="+page;
	}

	/**
	 * 学生密码重置页面
	 * 
	 * @return
	 */
	@RequestMapping("/userRe")
	public String userRe(int id, HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("user", userService.get(id));
		return "/admin/user_reset.jsp";
	}

	/**
	 * 学生密码重置
	 * 
	 * @return
	 */
	@RequestMapping("/userReset")
	public String userReset(Users user, 
			@RequestParam(required=false, defaultValue="1") int page) {
		String password = SafeUtil.encode(user.getPassword());
		user = userService.get(user.getId());
		user.setPassword(password);
		userService.update(user);
		return "redirect:userList?flag=2&page="+page;
	}

	/**
	 * 学生更新
	 * 
	 * @return
	 */
	@RequestMapping("/userEdit")
	public String userEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("user", userService.get(id));
		return "/admin/user_edit.jsp";
	}

	/**
	 * 学生更新
	 * 
	 * @return
	 */
	@RequestMapping("/userUpdate")
	public String userUpdate(Users user, 
			@RequestParam(required=false, defaultValue="1") int page) {
		userService.update(user);
		return "redirect:userList?flag=2&page="+page;
	}
	
	/**
	 * 学生更新
	 * 
	 * @return
	 */
	@RequestMapping("/userEdit1")
	public String userEdit1(int id, HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("user", userService.get(id));
		return "/admin/user_edit1.jsp";
	}

	/**
	 * 学生更新
	 * 
	 * @return
	 */
	@RequestMapping("/userUpdate1")
	public String userUpdate1(Users user, 
			@RequestParam(required=false, defaultValue="1") int page) {
		
		String password = SafeUtil.encode(user.getPassword());
 
		user.setPassword(password);
		
		userService.update(user);
		return "redirect:userEdit1?id="+user.getId();
	}

	/**
	 * 学生删除
	 * 
	 * @return
	 */
	@RequestMapping("/userDelete")
	public String userDelete(Users user, 
			@RequestParam(required=false, defaultValue="1") int page) {
		userService.delete(user);
		return "redirect:userList?flag=2&page="+page;
	}

	/**
	 * 作业列表
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyexxList")
	public String zuoyexxList(Zuoyetijiao zuoyetijiao, @RequestParam(required=false, defaultValue="0")byte status, HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		
		//new String(admin.getZyurl().getBytes("ISO-8859-1"),"UTF-8").equals("老师");
		
		request.setAttribute("flag", 3);
		request.setAttribute("page", page);
		request.setAttribute("status", status);
		request.setAttribute("zuoyexxList", zuoyexxService.getList(status, page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, zuoyexxService.getTotal(status), page, rows));
		return "/admin/zuoyexx_list.jsp";
	}
	
	/**
	 * 作业列表
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/zuoyexxList2")
	public String zuoyexxList2(@RequestParam(required=false, defaultValue="0")byte status, HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page,String mname) throws UnsupportedEncodingException {
		
		String mnameG = new String(mname.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(mnameG);
		
		request.setAttribute("flag", 3);
		request.setAttribute("page", page);
		request.setAttribute("status", status);
		request.setAttribute("zuoyexxList", zuoyexxService.getList2(mnameG, page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, zuoyexxService.getTotal1(status,mnameG), page, rows));
		return "/admin/zuoyexx_list2.jsp";
	}
	
	/**
	 * 作业列表
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyexxList1")
	public String zuoyexxList1(@RequestParam(required=false, defaultValue="0")byte status, HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 3);
		request.setAttribute("page", page);
		request.setAttribute("status", status);
		request.setAttribute("zuoyexxList", zuoyexxService.getList(status, page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, zuoyexxService.getTotal(status), page, rows));
		return "/admin/zuoyexx_list1.jsp";
	}
	
	/**
	 * 作业添加
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyexxAdd")
	public String zuoyexxAdd(HttpServletRequest request) {
		request.setAttribute("flag", 3);
		request.setAttribute("typeList", typeService.getList());
		request.setAttribute("teacherList", teacherService.getListForDrop());
		return "/admin/zuoyexx_add.jsp";
	}

	/**
	 * 作业添加
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zuoyexxSave")
	public String zuoyexxSave(String name, int banji,int shuliang, String intro, String teachername, int renshu, int typeId, 
			MultipartFile cover, MultipartFile image1, MultipartFile image2, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		Zuoyexx zuoyexx = new Zuoyexx();
		zuoyexx.setName(name);
		zuoyexx.setBanji(banji);
		zuoyexx.setIntro(intro);
		zuoyexx.setTeachername(teachername);
		zuoyexx.setRenshu(renshu);
		zuoyexx.setShuliang(shuliang);
		
		zuoyexx.setTypeId(typeId);
		zuoyexx.setCover(UploadUtil.fileUpload(cover));
		zuoyexx.setImage1("/picture/zy.jpg");
		zuoyexx.setImage2(UploadUtil.fileUpload(image2));
		zuoyexxService.add(zuoyexx);
		return "redirect:zuoyexxList?flag=3&page="+page;
	}

	/**
	 * 作业更新
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyexxEdit")
	public String zuoyexxEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 3);
		request.setAttribute("typeList", typeService.getList());
		request.setAttribute("teacherList", teacherService.getListForDrop());
		request.setAttribute("zuoyexx", zuoyexxService.get(id));
		return "/admin/zuoyexx_edit.jsp";
	}

	/**
	 * 作业更新
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zuoyexxUpdate")
	public String zuoyexxUpdate(int id, String name, int banji,int shuliang, String intro, String teachername, int renshu, int typeId,  
			MultipartFile cover, MultipartFile image1, MultipartFile image2,
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		Zuoyexx zuoyexx = zuoyexxService.get(id);
		zuoyexx.setName(name);
		zuoyexx.setBanji(banji);
		zuoyexx.setIntro(intro);
		zuoyexx.setRenshu(renshu);
		zuoyexx.setShuliang(shuliang);
		
		zuoyexx.setTeachername(teachername);
		zuoyexx.setTypeId(typeId);
		if (cover!=null && !cover.isEmpty()) {
			zuoyexx.setCover(UploadUtil.fileUpload(cover));
		}
		if (image1!=null && !image1.isEmpty()) {
			zuoyexx.setImage1(UploadUtil.fileUpload(image1));
		}
		if (image2!=null && !image2.isEmpty()) {
			zuoyexx.setImage2(UploadUtil.fileUpload(image2));
		}
		zuoyexxService.update(zuoyexx);
		return "redirect:zuoyexxList?flag=3&page="+page;
	}

	/**
	 * 作业删除
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyexxDelete")
	public String zuoyexxDelete(int id, 
			@RequestParam(required=false, defaultValue="1") int page) {
		zuoyexxService.delete(id);
		return "redirect:zuoyexxList?flag=3&page="+page;
	}
	
	/**
	 * 添加推荐
	 * @return
	 */
	@RequestMapping("/topSave")
	public @ResponseBody String topSave(Tops tops, 
			@RequestParam(required=false, defaultValue="0")byte status,
			@RequestParam(required=false, defaultValue="1") int page) {
		int id = topService.add(tops);
		return id > 0 ? "ok" : null;
	}
	
	/**
	 * 删除推荐
	 * @return
	 */
	@RequestMapping("/topDelete")
	public @ResponseBody String topDelete(Tops tops, 
			@RequestParam(required=false, defaultValue="0")byte status,
			@RequestParam(required=false, defaultValue="1") int page) {
		boolean flag = topService.delete(tops);
		return flag ? "ok" : null;
	}

	/**
	 * 课程列表
	 * 
	 * @return
	 */
	@RequestMapping("/typeList")
	public String typeList(HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("typeList", typeService.getList());
		return "/admin/type_list.jsp";
	}

	/**
	 * 课程添加
	 * 
	 * @return
	 */
	@RequestMapping("/typeSave")
	public String typeSave(Types type, 
			@RequestParam(required=false, defaultValue="1") int page) {
		typeService.add(type);
		return "redirect:typeList?flag=4&page="+page;
	}

	/**
	 * 课程更新
	 * 
	 * @return
	 */
	@RequestMapping("/typeEdit")
	public String typeUp(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("type", typeService.get(id));
		return "/admin/type_edit.jsp";
	}

	/**
	 * 课程更新
	 * 
	 * @return
	 */
	@RequestMapping("/typeUpdate")
	public String typeUpdate(Types type, 
			@RequestParam(required=false, defaultValue="1") int page) {
		typeService.update(type);
		return "redirect:typeList?flag=4&page="+page;
	}

	/**
	 * 课程删除
	 * 
	 * @return
	 */
	@RequestMapping("/typeDelete")
	public String typeDelete(Types type, 
			@RequestParam(required=false, defaultValue="1") int page) {
		typeService.delete(type);
		return "redirect:typeList?flag=4&page="+page;
	}

	/**
	 * 管理员列表
	 * 
	 * @return
	 */
	@RequestMapping("/adminList")
	public String adminList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("adminList", adminService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, adminService.getTotal(), page, rows));
		return "/admin/admin_list.jsp";
	}

	/**
	 * 管理员修改自己密码
	 * 
	 * @return
	 */
	@RequestMapping("/adminRe")
	public String adminRe(HttpServletRequest request, HttpSession session) {
		request.setAttribute("flag", 5);
		request.setAttribute("admin", adminService.getByUsername(String.valueOf(session.getAttribute("username"))));
		return "/admin/admin_reset.jsp";
	}

	/**
	 * 管理员修改自己密码
	 * 
	 * @return
	 */
	@RequestMapping("/adminReset")
	public String adminReset(Admins admin, HttpServletRequest request) {
		request.setAttribute("flag", 5);
		if (adminService.get(admin.getId()).getPassword().equals(SafeUtil.encode(admin.getPassword()))) {
			admin.setPassword(SafeUtil.encode(admin.getPasswordNew()));
			adminService.update(admin);
			request.setAttribute("admin", admin);
			request.setAttribute("msg", "修改成功!");
		}else {
			request.setAttribute("msg", "原密码错误!");
		}
		return "/admin/admin_reset.jsp";
	}

	/**
	 * 管理员添加
	 * 
	 * @return
	 */
	@RequestMapping("/adminSave")
	public String adminSave(Admins admin, HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		if (adminService.isExist(admin.getUsername())) {
			request.setAttribute("msg", "用户名已存在!");
			return "/admin/admin_add.jsp";
		}
		adminService.add(admin);
		return "redirect:adminList?flag=5&page="+page;
	}

	/**
	 * 管理员修改
	 * 
	 * @return
	 */
	@RequestMapping("/adminEdit")
	public String adminEdit(int id, HttpServletRequest request) {
		request.setAttribute("flag", 5);
		request.setAttribute("admin", adminService.get(id));
		return "/admin/admin_edit.jsp";
	}

	/**
	 * 管理员更新
	 * 
	 * @return
	 */
	@RequestMapping("/adminUpdate")
	public String adminUpdate(Admins admin, 
			@RequestParam(required=false, defaultValue="1") int page) {
		admin.setPassword(SafeUtil.encode(admin.getPassword()));
		adminService.update(admin);
		return "redirect:adminList?flag=5&page="+page;
	}

	/**
	 * 管理员删除
	 * 
	 * @return
	 */
	@RequestMapping("/adminDelete")
	public String adminDelete(Admins admin, 
			@RequestParam(required=false, defaultValue="1") int page) {
		adminService.delete(admin);
		return "redirect:adminList?flag=5&page="+page;
	}
 
	

}
