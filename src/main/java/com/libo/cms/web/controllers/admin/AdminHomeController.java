/**
 * 
 */
package com.libo.cms.web.controllers.admin;

import java.util.Date;

import java.util.List;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libo.cms.domain.Special;

import com.libo.cms.service.SpecialService;
import com.libo.cms.web.controllers.PassportController;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	
	@Resource
	SpecialService specialService;
	
	
	
	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	/**
	 * 开始A卷
	 * */
	
	@RequestMapping("/special")
	public String listSpecial(Model m){
		List<Special> listSpecial = specialService.listSpecial();
		m.addAttribute("listSpecial", listSpecial);
		return "admin/special-manage";
		
	}
	
	@RequestMapping("/getSpecial")
	public String getSpecial(Model m,Integer specialID){
		Special special = specialService.getSpecial(specialID);
		m.addAttribute("special", special);
		
		return "/admin/ArticleInSpecial";
		
	}
	@RequestMapping("/removeArticle")
	@ResponseBody
	public boolean removeArticle(Integer articleID,Integer specialID){
		int i = specialService.removeArticle(articleID, specialID);						
		return i>0;
		
	}
	@RequestMapping("/addArticle")
	@ResponseBody
	public boolean addArticle(Integer articleID,Integer specialID){
		int i = specialService.addArticle(articleID, specialID);			
		return i>0;
		
	}
	
	@RequestMapping("/toChangeSpecial")
	
	public String toChangeSpecial(Model m,Integer articleID,Integer specialID){
		Special special = specialService.getSpecial(specialID);
		m.addAttribute("special", special);
		return "/admin/changeSpecial";
		
	}
	
	@RequestMapping("/changeSpecial")
	public String changeSpecial(Special special){
		
		
		specialService.updateSpecial(special);	
		return "forward:/admin/special";
		
	}
	
	@RequestMapping("/toaddSpecial")
	public String toaddSpecial(){						
		return "/admin/addSpecial";
		
	}
	
	@RequestMapping("/addSpecial")
	public String addSpecial(Special special){						
		special.setCreated(new Date());
		specialService.addSpecial(special);
		return "forward:/admin/special";
		
	}
	
	
	
	
	
	
	
	
	
	/*@RequestMapping("/special")
	public String toSpecial(Model m){
		List<Special> list = specialService.listSpecial();
		m.addAttribute("specialList", list);
		return "/admin/special-manage";
		
	}
	
	@RequestMapping("/getSpecial")
	public String getSpecial(Integer specialID,Model m){
		Special special = specialService.getSpecial(specialID);	
		m.addAttribute("special",special);
		return "/admin/ArticleInSpecial";
		
	}
	//专题栏移除文章
	@RequestMapping("/removeArticle")
	@ResponseBody
	public boolean removeArticle(Integer articleID,Integer specialID){				
		int i =specialService.removeArticle(articleID,specialID);		
		return i>0;
		
	}
	
	//专题栏添加文章
	@RequestMapping("/addArticle")
	@ResponseBody
	public boolean addArticle(Integer articleID,Integer specialID){		
		int i = specialService.addArticle(articleID,specialID);	
		return i>0;		
	}
	//添加页面跳转
	@RequestMapping("/toaddSpecial")	
	public String toaddSpecial(){				
		return "/admin/addSpecial";		
	}
	//修改页面跳转
	@RequestMapping("/toChangeSpecial")	
	public String toChangeSpecial(Integer specialID,Model m){				
		Special special = specialService.getSpecial(specialID);
		m.addAttribute("special", special);
		
		return "/admin/changeSpecial";		
	}
	
	//添加专题
	@RequestMapping("/addSpecial")	
	public String addSpecial(Special special){
		special.setCreated(new Date());
		specialService.addSpecial(special);
		return "forward:/admin/special";
		
	}
	//修改专题
	@RequestMapping("/changeSpecial")	
	public String changeSpecial(Special special){
		specialService.updateSpecial(special);		
		return "forward:/admin/special";
		
	}*/
}
