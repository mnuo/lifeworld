/**
 * UserServiceImpl.java created at Apr 17, 2016 1:36:43 AM
 */
package com.mnuocom.lifeworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnuocom.lifeworld.dao.UserDao;
import com.mnuocom.lifeworld.entity.User;
import com.mnuocom.lifeworld.service.UserService;

/**
 * @author saxon
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(int userId) {
		 return this.userDao.selectByPrimaryKey(userId);  
	}
	@Override
	public User getUserByInfo(User user) {
		return this.userDao.selectByInfo(user);
	}

}
