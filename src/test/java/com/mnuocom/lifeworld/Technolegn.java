/**
 * Technolegn.java created at Mar 27, 2016 9:48:13 PM
 */
package com.mnuocom.lifeworld;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mnuocom.lifeworld.entity.User;
import com.mnuocom.lifeworld.service.UserService;

/**
 * @author saxon
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class Technolegn {

	 private static Logger logger = Logger.getLogger(Technolegn.class);  
	//  private ApplicationContext ac = null;  
	    @Resource  
	    private UserService userService = null;  
	  
	//  @Before  
	//  public void before() {  
//	      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	      userService = (IUserService) ac.getBean("userService");  
	//  }  
	  
	    @Test  
	    public void test1() {  
	    	User entity = new User();
	    	entity.setUserName("admin");
	    	entity.setPassword("123");
	        User user = userService.getUserByInfo(entity);  
	        
	        System.out.println(user.getId());
	    }
}
