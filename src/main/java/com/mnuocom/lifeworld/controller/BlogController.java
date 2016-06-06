/**
 * LoginController.java created at Apr 17, 2016 10:25:37 AM
 */
package com.mnuocom.lifeworld.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnuocom.lifeworld.common.utils.StringUtil;
import com.mnuocom.lifeworld.entity.Blog;
import com.mnuocom.lifeworld.service.BlogService;

/**
 * @author saxon
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	
	@RequestMapping("/create")
	@ResponseBody
	public boolean login(Blog blog){
		if(StringUtil.isEmpty(blog.getTitle()) || StringUtil.isEmpty(blog.getContent())){
			return false;
		}
		return blogService.saveOrUpdate(blog);
	}
	@RequestMapping("/blog")
	@ResponseBody
	public Blog blog(Integer id){
		if(id == null){
			return null;
		}
		return blogService.getOne(id);
	}
}
