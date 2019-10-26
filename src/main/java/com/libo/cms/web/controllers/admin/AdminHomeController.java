/**
 * 
 */
package com.libo.cms.web.controllers.admin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libo.cms.service.ArticleService;
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
	ArticleService articleService;
	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	
}
