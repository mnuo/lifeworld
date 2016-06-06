/**
 * UserService.java created at Apr 17, 2016 1:35:55 AM
 */
package com.mnuocom.lifeworld.service;

import com.mnuocom.lifeworld.entity.User;

/**
 * @author saxon
 */
public interface UserService {
	public User getUserById(int userId);

	public User getUserByInfo(User user);
}
