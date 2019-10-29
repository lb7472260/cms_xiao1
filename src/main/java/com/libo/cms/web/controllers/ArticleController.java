package com.libo.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libo.cms.domain.Article;
import com.libo.cms.domain.Comment;

import com.libo.cms.service.ArticleService;
import com.libo.cms.service.CommentService;
import com.libo.cms.service.SpecialService;

@Controller
public class ArticleController {
	@Resource
	ArticleService articleService;
	
	@Resource
	CommentService commentService;
	
	@Resource
	SpecialService specialService;
	
	//根据Id查文章
	@RequestMapping("/article/{id}")
	public String queryArticleById(@PathVariable Integer id,Model m){
		Article article =articleService.queryArticleById(id);
		m.addAttribute("blog", article);
		
		//查看评论 comments
		List<Comment> list = commentService.queryCommentById(id);
		m.addAttribute("comments", list);				
		return "blog";
	}
	
	
	
	


}
