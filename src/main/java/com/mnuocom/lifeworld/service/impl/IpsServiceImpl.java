/**
 * IpsServiceImpl.java created at Apr 17, 2016 10:17:35 PM
 */
package com.mnuocom.lifeworld.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnuocom.lifeworld.dao.IpsDao;
import com.mnuocom.lifeworld.entity.Ips;
import com.mnuocom.lifeworld.service.IpsService;

/**
 * @author saxon
 */
@Service
public class IpsServiceImpl implements IpsService {
	@Autowired
	private IpsDao ipsDao;
	@Override
	public void create(Ips ips) {
		ips.setCreatedAt(new Date());
		ipsDao.insert(ips);
	}

}
