/**
 * UserService.java created at Apr 17, 2016 1:35:55 AM
 */
package com.mnuocom.lifeworld.service;

import java.util.List;

import com.mnuocom.lifeworld.entity.Babytimeline;

/**
 * @author saxon
 */
public interface BabytimelineService {

	public boolean saveOrUpdate(Babytimeline entity);
	public List<Babytimeline> getList(Babytimeline entity);
	public List<Babytimeline> getOneDayList(Babytimeline babytimeline);
}
