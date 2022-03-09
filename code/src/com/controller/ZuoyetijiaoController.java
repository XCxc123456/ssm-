package com.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Admins;
import com.entity.Kaoshixx;
import com.entity.Zuoyexx;
import com.entity.Zuoyetijiao;
import com.entity.Ruku;
import com.entity.Tops;
import com.entity.Types;
import com.entity.Users;
import com.service.AdminService;
import com.service.ZuoyexxService;
import com.service.ZuoyetijiaoService;
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
@RequestMapping("/admin/zuoyetijiao")
public class ZuoyetijiaoController {

	private static final int rows = 10;

	@Autowired
	private ZuoyetijiaoService zuoyetijiaoService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ZuoyexxService zuoyexxService;
	
	/**
	 * drop的联动处理
	 * @return
	 */
	@RequestMapping("/getzuoyexxListFro")
	public @ResponseBody String topDelete(Types types, 
			@RequestParam(required=false, defaultValue="0")byte status,
			@RequestParam(required=false, defaultValue="1") int page)
	{
		JSONArray jsonArray=new JSONArray();  
		List<Zuoyexx> list= zuoyexxService.getListByType(types.getId(), page, 20);
		
		for(Zuoyexx g22 : list)
		{
			jsonArray.add(g22);
		}
		
		 System.out.println(jsonArray);
		
		return jsonArray.toString();
	}
	
	/**
	 * 老师添加
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoAdd")
	public String zuoyetijiaoAdd(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		request.setAttribute("typeList", typeService.getList());
		request.setAttribute("teacherList", teacherService.getListForDrop());
		request.setAttribute("zuoyexxList", zuoyexxService.getListForDrop());
		
		return "/admin/zuoyetijiao/add.jsp";
	}
	
	 /**
	 * 老师列表
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoList")
	public String zuoyetijiaoList(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("zuoyetijiaoList", zuoyetijiaoService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, zuoyetijiaoService.getTotal(), page, rows));
		return "/admin/zuoyetijiao/list.jsp";
	}
	 /**
	 * 老师列表
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoList1")
	public String zuoyetijiaoList1(HttpServletRequest request, 
			@RequestParam(required=false, defaultValue="1") int page) {
		request.setAttribute("flag", 5);
		request.setAttribute("zuoyetijiaoList", zuoyetijiaoService.getList(page, rows));
		request.setAttribute("pageTool", PageUtil.getPageTool(request, zuoyetijiaoService.getTotal(), page, rows));
		return "/admin/zuoyetijiao/list1.jsp";
	}
	/**
	 * 老师添加
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zuoyetijiaoSave")
	public String zuoyetijiaoSave(String zuoyexxname, String teachername,String zt,int shuliang,
			MultipartFile zyurl, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		
		Zuoyetijiao zuoye=new Zuoyetijiao();
		zuoye.setZuoyexxname(zuoyexxname);
		zuoye.setShuliang(shuliang);
		zuoye.setTeachername(teachername);
		zuoye.setZt(zt);
		zuoye.setZyurl(UploadUtil.fileUpload(zyurl));
 
		zuoyetijiaoService.add(zuoye);
		
		return "redirect:zuoyetijiaoList?flag=4&page="+page;
	}

	/**
	 * 老师更新
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoEdit")
	public String zuoyetijiaoUp(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("typeList", typeService.getList());
		request.setAttribute("teacherList", teacherService.getListForDrop());
		request.setAttribute("zuoyexxList", zuoyexxService.getListForDrop());
		
		request.setAttribute("zuoyetijiao", zuoyetijiaoService.get(id));
		return "/admin/zuoyetijiao/edit.jsp";
	}

	/**
	 * 老师更新
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zuoyetijiaoUpdate")
	public String zuoyetijiaoUpdate(int id, String zuoyexxname, String teachername,String zt,int shuliang,
			MultipartFile zyurl, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		
		Zuoyetijiao zuoyexx = zuoyetijiaoService.get(id);
		zuoyexx.setZuoyexxname(zuoyexxname);
		zuoyexx.setShuliang(shuliang);
		zuoyexx.setTeachername(teachername);
 
		if (zyurl!=null && !zyurl.isEmpty()) {
			zuoyexx.setZyurl(UploadUtil.fileUpload(zyurl));
		}

		zuoyetijiaoService.update(zuoyexx);
		return "redirect:zuoyetijiaoList?flag=4&page="+page;
	}
	
	/**
	 * 老师更新
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zuoyetijiaoPigai")
	public String zuoyetijiaoPigai(int id, String zuoyexxname, String teachername,String zt,int shuliang,
			MultipartFile zyurl, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception {
		
		Zuoyetijiao zuoyexx = zuoyetijiaoService.get(id);
 
		zuoyexx.setShuliang(shuliang);
		zuoyexx.setZt(zt);
 
 

		zuoyetijiaoService.update(zuoyexx);
		return "redirect:zuoyetijiaoList1?flag=4&page="+page;
	}

	/**
	 * 老师删除
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoDelete")
	public String zuoyetijiaoDelete(Zuoyetijiao zuoyetijiao, 
			@RequestParam(required=false, defaultValue="1") int page) {
		zuoyetijiaoService.delete(zuoyetijiao);
		return "redirect:zuoyetijiaoList?flag=4&page="+page;
	}
	
	/**
	 * 出库审核
	 * 
	 * @return
	 */
	@RequestMapping("/zuoyetijiaoDelete1")
	public String zuoyetijiaoDelete1(int id, HttpServletRequest request) {
		request.setAttribute("flag", 4);
		request.setAttribute("typeList", typeService.getList());
		request.setAttribute("teacherList", teacherService.getListForDrop());
		request.setAttribute("zuoyexxList", zuoyexxService.getListForDrop());
		
		request.setAttribute("zuoyetijiao", zuoyetijiaoService.get(id));
		return "/admin/zuoyetijiao/pigai.jsp";
	}
	
}
