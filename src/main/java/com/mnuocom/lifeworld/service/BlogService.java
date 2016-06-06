/**
 * BlogService.java created at May 13, 2016 8:57:42 PM
 */
package com.mnuocom.lifeworld.service;

import com.mnuocom.lifeworld.entity.Blog;

/**
 * @author saxon
 */
public interface BlogService {

	boolean saveOrUpdate(Blog blog);

	Blog getOne(Integer id);

}
