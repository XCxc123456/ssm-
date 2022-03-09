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
import com.entity.Kaoshixx;
import com.entity.Tops;
import com.entity.Types;
import com.entity.Users;
import com.service.AdminService;
import com.service.ZuoyexxService;
import com.service.KaoshixxService;
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
@RequestMapping("/admin/kaoshixx")
public class KaoshixxController {

	private static final int rows = 10;

	@Autowired
	private KaoshixxService kaoshixxService;
 
	/**
	 * 考试添加
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxAdd")
	public String kaoshixxAdd(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		return "/admin/kaoshixx/add.jsp";
	}
	
	 /**
	 * 考试列表
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxList")
	public String kaoshixxList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("kaoshixxList", kaoshixxService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, kaoshixxService.getTotal(), page, rows));
		return "/admin/kaoshixx/list.jsp";
	}
	
	 /**
	 * 考试列表
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxListQ")
	public String kaoshixxListQ(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("kaoshixxList", kaoshixxService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, kaoshixxService.getTotal(), page, rows));
		return "/admin/kaoshixx/listQ.jsp";
	}

	/**
	 * 考试添加
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/kaoshixxSave")
	public String kaoshixxSave(String name, String riqi,String con,
			MultipartFile url, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		
		System.out.println(url);
		
		Kaoshixx kaos=new Kaoshixx();
		kaos.setName(name);
		kaos.setCon(con);
		kaos.setRiqi(riqi);
		kaos.setUrl(UploadUtil.fileUpload(url));
		kaoshixxService.add(kaos);
		return "redirect:kaoshixxList?flag=4&page="+page;
	}
 
	/**
	 * 考试更新
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxEdit")
	public String kaoshixxUp(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("kaoshixx", kaoshixxService.get(id));
		return "/admin/kaoshixx/edit.jsp";
	}

	/**
	 * 考试更新
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxUpdate")
	public String kaoshixxUpdate(Kaoshixx kaoshixx, 
			@RequestParam(required=false, defaultValue="1") int page) {
		kaoshixxService.update(kaoshixx);
		return "redirect:kaoshixxList?flag=4&page="+page;
	}

	/**
	 * 考试删除
	 * 
	 * @return
	 */
	@RequestMapping("/kaoshixxDelete")
	public String kaoshixxDelete(Kaoshixx kaoshixx, 
			@RequestParam(required=false, defaultValue="1") int page) {
		kaoshixxService.delete(kaoshixx);
		return "redirect:kaoshixxList?flag=4&page="+page;
	}
	

}
