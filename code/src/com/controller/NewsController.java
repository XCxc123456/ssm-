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
import com.entity.News;
import com.entity.Tops;
import com.entity.Types;
import com.entity.Users;
import com.service.AdminService;
import com.service.ZuoyexxService;
 
import com.service.NewsService;
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
@RequestMapping("/admin/news")
public class NewsController {

	private static final int rows = 10;

	@Autowired
	private NewsService newsService;

	
 
 
	/**
	 * 公告添加
	 * 
	 * @return
	 */
	@RequestMapping("/newsAdd")
	public String newsAdd(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		return "/admin/news/add.jsp";
	}
	
	 /**
	 * 公告列表
	 * 
	 * @return
	 */
	@RequestMapping("/newsList")
	public String newsList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("newsList", newsService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, newsService.getTotal(), page, rows));
		return "/admin/news/list.jsp";
	}
	
	 /**
	 * 公告列表
	 * 
	 * @return
	 */
	@RequestMapping("/newsListQ")
	public String newsListQ(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("newsList", newsService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, newsService.getTotal(), page, rows));
		return "/admin/news/listQ.jsp";
	}

	/**
	 * 公告添加
	 * 
	 * @return
	 */
	@RequestMapping("/newsSave")
	public String newsSave(News news, 
			@RequestParam(required=false, defaultValue="1") int page) {
		newsService.add(news);
		return "redirect:newsList?flag=4&page="+page;
	}

	/**
	 * 公告更新
	 * 
	 * @return
	 */
	@RequestMapping("/newsEdit")
	public String newsUp(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("news", newsService.get(id));
		return "/admin/news/edit.jsp";
	}

	/**
	 * 公告更新
	 * 
	 * @return
	 */
	@RequestMapping("/newsUpdate")
	public String newsUpdate(News news, 
			@RequestParam(required=false, defaultValue="1") int page) {
		newsService.update(news);
		return "redirect:newsList?flag=4&page="+page;
	}

	/**
	 * 公告删除
	 * 
	 * @return
	 */
	@RequestMapping("/newsDelete")
	public String newsDelete(News news, 
			@RequestParam(required=false, defaultValue="1") int page) {
		newsService.delete(news);
		return "redirect:newsList?flag=4&page="+page;
	}
	

}
