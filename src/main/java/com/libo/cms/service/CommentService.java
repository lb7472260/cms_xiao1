package com.libo.cms.service;

import java.util.List;

import com.libo.cms.domain.Comment;
import com.libo.cms.utils.ResultUtils;

public interface CommentService {

	ResultUtils  insertComment(Comment comment);

	List<Comment> queryCommentById(Integer id);



}
