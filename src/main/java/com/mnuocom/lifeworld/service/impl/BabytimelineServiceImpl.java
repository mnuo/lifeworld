/**
 * BlogServiceImpl.java created at May 13, 2016 8:59:02 PM
 */
package com.mnuocom.lifeworld.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnuocom.lifeworld.dao.BabytimelineDao;
import com.mnuocom.lifeworld.entity.Babytimeline;
import com.mnuocom.lifeworld.service.BabytimelineService;

/**
 * @author saxon
 */
@Service
@Transactional
public class BabytimelineServiceImpl implements BabytimelineService {
	@Autowired
	public BabytimelineDao babytimelineDao;
	
	@Override
	public boolean saveOrUpdate(Babytimeline entity) {
		if(entity.getCreatedTime() == null){
			entity.setCreatedTime(new Date());
		}
		return this.babytimelineDao.insert(entity) > 0 ? true : false;
	}

	@Override
	public List<Babytimeline> getList(Babytimeline entity) {
		return babytimelineDao.selectByTime(entity);
	}

	@Override
	public List<Babytimeline> getOneDayList(Babytimeline babytimeline) {
		return babytimelineDao.selectByOneTime(babytimeline);
	}
}
