package com.controller;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Zuoyexx;
import com.entity.Items;
 
import com.entity.Users;
import com.service.ZuoyexxService;

import com.service.TypeService;
import com.service.UserService;
import com.util.SafeUtil;

/**
 * 用户相关接口
 */
@Controller
@RequestMapping("/index")
public class UserController{
	
	private static final String INDENT_KEY = "order";
	
	@Resource
	private UserService userService;
 
	@Resource
	private ZuoyexxService zuoyexxService;
	@Resource
	private TypeService typeService;

	
	/**
	 * 注册用户
	 * @return
	 */
	@RequestMapping("/register")
	public String register(@RequestParam(required=false, defaultValue="0")int flag, Users user, Model model){
		model.addAttribute("typeList", typeService.getList());
		if(flag==-1) {
			model.addAttribute("flag", 5); // 注册页面
			return "/index/register.jsp";
		}
		if (user.getUsername().isEmpty()) {
			model.addAttribute("msg", "用户名不能为空!");
			return "/index/register.jsp";
		}else if (userService.isExist(user.getUsername())) {
			model.addAttribute("msg", "用户名已存在!");
			return "/index/register.jsp";
		}else {
			String password = user.getPassword();
			userService.add(user);
			user.setPassword(password);
			return "redirect:login?flag=-1"; // 注册成功后转去登录
		}
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@RequestParam(required=false, defaultValue="0")int flag, Users user, HttpSession session, Model model) {
		model.addAttribute("typeList", typeService.getList());
		if(flag==-1) {
			flag = 6; // 登录页面
			return "/index/login.jsp";
		}
		/*if(userService.checkUser(user.getUsername(), user.getPassword())){
			session.setAttribute("user", userService.get(user.getUsername()));
			return "redirect:index";
		} else {
			model.addAttribute("msg", "用户名或密码错误!");
			return "/index/login.jsp";
		}*/
		return "/index/login.jsp";
	}

	/**
	 * 注销登录
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("order");
		return "/index/login.jsp";
	}
	
 
 
	
	
	/**
	 * 个人信息
	 * @return
	 */
	@RequestMapping("/my")
	public String my(Users user, HttpSession session, Model model){
		model.addAttribute("flag", 4);
		model.addAttribute("typeList", typeService.getList());
		Users userLogin = (Users) session.getAttribute("user");
		if (userLogin == null) {
			model.addAttribute("msg", "请先登录!");
			return "/index/login.jsp";
		}
		// 进入个人中心
		if (user!=null || user.getId()!=null) {
			return "/index/my.jsp";
		}
		Users u = userService.get(user.getId());
		// 修改资料
		u.setName(user.getName());
		u.setPhone(user.getPhone());
		u.setAddress(user.getAddress());
		userService.update(u);  // 更新数据库
		session.setAttribute("user", u); // 更新session
		model.addAttribute("msg", "信息修改成功!");
		// 修改密码
		if(user.getPasswordNew()!=null && !user.getPasswordNew().trim().isEmpty()) {
			if (user.getPassword()!=null && !user.getPassword().trim().isEmpty() 
					&& SafeUtil.encode(user.getPassword()).equals(u.getPassword())) {
				if (user.getPasswordNew()!=null && !user.getPasswordNew().trim().isEmpty()) {
					u.setPassword(SafeUtil.encode(user.getPasswordNew()));
				}
				userService.update(u);  // 更新数据库
				session.setAttribute("user", u); // 更新session
				model.addAttribute("msg", "密码修改成功!");
			}else {
				model.addAttribute("msg", "原密码错误!");
			}
		}
		return "/index/my.jsp";
	}
	
}