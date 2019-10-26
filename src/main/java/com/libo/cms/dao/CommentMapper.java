package com.libo.cms.dao;

import java.util.List;

import com.libo.cms.domain.Comment;

public interface CommentMapper {
	public Integer insertComment(Comment comment);

	public List<Comment> queryCommentById(Integer id);
}
