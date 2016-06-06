/**
 * IpsController.java created at Apr 17, 2016 10:12:40 PM
 */
package com.mnuocom.lifeworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnuocom.lifeworld.entity.Ips;
import com.mnuocom.lifeworld.service.IpsService;

/**
 * @author saxon
 */
@Controller
@RequestMapping("/ip")
public class IpsController {
	@Autowired
	private IpsService ipsService;
	
	@RequestMapping("/create")
	@ResponseBody
	public String createIp(String ip,String ipAddress){
		Ips ips = new Ips();
		ips.setIp(ip);
		ips.setIpAddress(ipAddress);
		ipsService.create(ips);
		return "ok";
	}
}
