/**
 * LoginController.java created at Apr 17, 2016 10:25:37 AM
 */
package com.mnuocom.lifeworld.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnuocom.lifeworld.common.HttpServletWebHelper;
import com.mnuocom.lifeworld.common.utils.StringUtil;
import com.mnuocom.lifeworld.entity.User;
import com.mnuocom.lifeworld.service.UserService;

/**
 * @author saxon
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(User user){
		if(StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword())){
			return false;
		}
		User entity = userService.getUserByInfo(user);
		if(entity == null || entity.getId() == null)
			return false;
		HttpServletWebHelper.getSession().setAttribute("user", entity);
		return true;
	}
}
