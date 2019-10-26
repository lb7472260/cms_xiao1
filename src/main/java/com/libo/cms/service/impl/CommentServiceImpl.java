package com.libo.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libo.cms.dao.CommentMapper;
import com.libo.cms.domain.Comment;
import com.libo.cms.service.CommentService;
import com.libo.cms.utils.ResultUtils;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	CommentMapper commentMapper;
	
	@Override
	public ResultUtils insertComment(Comment comment) {
		Integer num = commentMapper.insertComment(comment);
		
		ResultUtils result = new ResultUtils();
		if(num>0){
			result.setStatus(true);
			result.setMessage("评论发布成功");
			return result;
		}else{
			result.setStatus(false);
			result.setMessage("评论发布失败");
			return result;
		}
		
		
	
	}

	@Override
	public List<Comment> queryCommentById(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.queryCommentById(id);
	}

}
