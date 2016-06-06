/**
 * created in 2015年4月4日 下午3:01:44
 */
package com.mnuocom.lifeworld.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author saxonwade
 */
public class HttpServletWebHelper {
	public static HttpSession getSession(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	 }
	public static HttpServletRequest getHttpServletRequest(){
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		return servletRequestAttribute.getRequest();
	}
	public static String getBasePath(){
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		
		HttpServletRequest request = servletRequestAttribute.getRequest();
		return request.getScheme() + "://" + request.getServerName()
		+":" + request.getServerPort()+ request.getContextPath() + "/";
	}
}
