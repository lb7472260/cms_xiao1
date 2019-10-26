package com.libo.cms.web.controllers.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libo.cms.domain.Article;
import com.libo.cms.service.ArticleService;

@Controller
@RequestMapping("/admin")
public class AdminArticleController {
	@Resource
	private ArticleService articleService;
	
	
	//文章列表
	@RequestMapping("/article/list")
	public String  list(Model m,@RequestParam(defaultValue="1") Integer pageNum){
		Article article = new Article();
		PageHelper.startPage(pageNum,3);
		List<Article> list =	articleService.queryArticleAll(article);
		m.addAttribute("articleList", list);
		PageInfo<Article> page = new PageInfo<>(list);
		m.addAttribute("page", page);
		
		
		return "admin/article-manage";
		
	}
	
	//文章审核
	@RequestMapping("/article/updateArticleStatus")
	@ResponseBody
	public boolean updateArticleStatus(Integer aid,Integer status){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("aid", aid);
		map.put("status", status);
		articleService.updateArticleStatus(map);
		return status > 0;
		
	}
}
