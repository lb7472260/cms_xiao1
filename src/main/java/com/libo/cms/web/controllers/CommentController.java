package com.libo.cms.web.controllers;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libo.cms.domain.Article;
import com.libo.cms.domain.Comment;
import com.libo.cms.domain.User;
import com.libo.cms.service.CommentService;
import com.libo.cms.utils.ResultUtils;
import com.libo.cms.web.Constant;


@Controller
@RequestMapping("/my")
public class CommentController {
	@Resource
	CommentService commentService;
	
	//文章评论
	@RequestMapping("/comment/{id}")
	@ResponseBody
	public ResultUtils insertComment(HttpSession session ,@PathVariable Integer id,Comment comment,Model m){
		
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		Integer id2 = user.getId();
		comment.setAuthor(user);
		//设置创建时间
		comment.setCreated(new Date());
		//
		Article article = new Article(id);
		comment.setArticle(article);
		System.out.println("commentController : userID = "+id2);
		
		ResultUtils result = commentService.insertComment(comment);
		
		
		return result;
	}


}
