/**
 * BabytimelineController.java created at 2017年2月19日 下午7:57:46
 */
package com.mnuocom.lifeworld.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnuocom.lifeworld.entity.Babytimeline;
import com.mnuocom.lifeworld.service.BabytimelineService;

/**
 * @author saxon
 */
@Controller
@RequestMapping("/babytimeline")
public class BabytimelineController {
	@Resource
	private BabytimelineService babytimelineService;
	
	@RequestMapping("/create")
	@ResponseBody
	public boolean create(Babytimeline babytimeline){
		try{
			String imageUrls = babytimeline.getImageUrl();
			if(imageUrls != null && !"".equals(imageUrls)){
				String[] arr = imageUrls.split(",");
				for(String str : arr){
					Babytimeline entity = new Babytimeline();
					entity.setCreatedTime(new Date());
					entity.setDescript(babytimeline.getDescript());
					entity.setImageUrl(str);
					entity.setTime(babytimeline.getTime());
					babytimelineService.saveOrUpdate(entity);
				}
			}else{
				babytimelineService.saveOrUpdate(babytimeline);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<Babytimeline> getList(Babytimeline babytimeline){
		List<Babytimeline> list = null;
		try{
			list = babytimelineService.getList(babytimeline);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping("/list/{time}")
	@ResponseBody
	public List<Babytimeline> getListTime(@PathVariable("time") String time){
		List<Babytimeline> list = null;
		try{
			Babytimeline babytimeline = new Babytimeline();
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			babytimeline.setTime(formatter.parse(time));
			list = babytimelineService.getOneDayList(babytimeline);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
