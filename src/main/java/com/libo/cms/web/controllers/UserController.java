/**
 * 
 */
package com.libo.cms.web.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.libo.cms.domain.Article;
import com.libo.cms.domain.Channel;
import com.libo.cms.domain.User;
import com.libo.cms.service.ArticleService;
import com.libo.cms.service.ChannelCategoryService;
import com.libo.cms.utils.FileUtils;
import com.libo.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */

@Controller
@RequestMapping("/my")
public class UserController {
	
	@Resource
	ChannelCategoryService ser;
	
	@Resource
	ArticleService articleService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(HttpSession session ,Model m){
		//查询文章列表
		Article article = new Article();
		User author = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(author );
		List<Article> list = articleService.queryArticleAll(article);
		m.addAttribute("articleList", list);
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	
	@RequestMapping("/blog/edit")
	public String article(Model model){
		model.addAttribute("article", new Article());
		
		//查询所有栏目信息
		List<Channel> channels = ser.getChannels();
		System.out.println(channels);
		model.addAttribute("channels", channels);
		
		return "user-space/blog_edit";
		
	}
	
	/**
	 * 说明:
	 * 
	 * @param session  会话,获取用户登录信息
	 * @param article	添加文章的信息,并使用303验证
	 * @param file		图片上传
	 * @param br		验证
	 *
	 * 2018年1月10日 下午2:40:38
	 */
	
	@RequestMapping("/blog/save")
	public String save(HttpSession session ,@Valid @ModelAttribute("article") Article article,MultipartFile file ,BindingResult br) throws Exception{
		
		if(br.hasErrors()){
			return "user-space/blog_edit";
		}
		//发布文章需要 用户id
		
		//封面图片
		//通过工具类上传图片返回图片路径
		String upload = FileUtils.upload(file);
		//将图片路径保存到实体中
		article.setPicture(upload);
		//当前用户登录信息
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		
		//设置删除状态  0
		article.setDeleted(false);
		
		//设置浏览量默认为 0
		article.setHits(0);
		
		//设置发布时间为当前时间
		article.setCreated(new Date());
		article.setUpdated(new Date());
		
		System.out.println(article.getCreated());
		articleService.save(article);
		return "redirect:/my/home";
		
	}
	
	@RequestMapping("/blog/lookImg")
	public void lookImg(String url,HttpServletRequest request,HttpServletResponse response){
		
		FileUtils.lookImg(url, request, response);
	
	}
	
}
