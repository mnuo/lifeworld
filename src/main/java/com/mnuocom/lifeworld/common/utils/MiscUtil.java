/**
 * MiscUtil.java created at Oct 14, 2015 7:52:56 AM
 */
package com.mnuocom.lifeworld.common.utils;

import java.util.List;

/**
 * @author saxon
 * MiscUtil.java
 */
public class MiscUtil {

	public static boolean take(String videoLocation, String imageLocation, String toolString){
		// 低精度
		List<String> commend = new java.util.ArrayList<String>();
		commend.add(toolString);//视频提取工具的位置
		commend.add("-i");
		commend.add(videoLocation);
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		commend.add("08.010");
		commend.add("-t");
		commend.add("0.001");
		commend.add("-s");
		commend.add("352x240");
		commend.add(imageLocation);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		//需要提取截图的视频地址
		String s1 = "E:\\Media/肢体を洗う THE ANIMATION CASE.2「性魔」.rmvb";
		//将生成的截图存放在什么位置
		String s2 = "D://myVideo.jpg";
		if (take(s1, s2,"d:/"))
		System.out.println("截图提取成功");
		else
		System.out.println("截图提取失败");
		}

}
