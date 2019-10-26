package com.libo.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libo.cms.domain.Category;
import com.libo.cms.service.ChannelCategoryService;

@Controller
@RequestMapping("/channelCategory")
public class ChannelCategoryController {
	@Resource
	ChannelCategoryService ser;
	
	@RequestMapping("/channel/queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channelId){
		List<Category> list = ser.getCategories(channelId);
		
		return list;
		
	}
	
	
}
