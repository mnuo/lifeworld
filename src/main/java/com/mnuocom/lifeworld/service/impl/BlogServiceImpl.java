/**
 * BlogServiceImpl.java created at May 13, 2016 8:59:02 PM
 */
package com.mnuocom.lifeworld.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnuocom.lifeworld.dao.BlogDao;
import com.mnuocom.lifeworld.entity.Blog;
import com.mnuocom.lifeworld.service.BlogService;

/**
 * @author saxon
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	public BlogDao blogDao;
	
	@Override
	public boolean saveOrUpdate(Blog blog) {
		if(blog.getCreatedAt() == null){
			blog.setCreatedAt(new Date());
			blog.setCreatedBy("admin");
		}
		blog.setUpdatedAt(new Date());
		return this.blogDao.insert(blog) > 0 ? true : false;
	}

	@Override
	public Blog getOne(Integer id) {
		return this.blogDao.selectByPrimaryKey(id);
	}

}
