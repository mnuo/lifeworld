/**
 * Testss.java created at Apr 20, 2016 9:01:45 PM
 */
package com.mnuocom.lifeworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.mnuocom.lifeworld.common.utils.ImageHelper;

/**
 * @author saxon
 */
public class Testss {
	public static void main(String[] args) {
		Testss.statisticNum();
		//Testss.statistic();
		/*String str = "伟大的中国伟大的人民万岁!";
		char[] arr = str.toCharArray();
		String temp= "";//临时
		for(int i = 0; i < arr.length; i ++) {
			if(temp.contains(arr[i]+"")){//如果之前统计过的,就进行洗一次循环
				continue;
			}
			temp  += arr[i];//之前没统计过加入temp变量中
			int count = 0;//初始化
			for(int j = 0; j < arr.length; j ++){
				if((arr[i]+"").equals(arr[j] + "")){
					count ++;
				}
			}
			System.out.println("\"" + arr[i] + "\"出现:" + count + "次");
		}*/
	}
	
	public static void statisticNum(){
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		try {
			System.out.print("请输入字符串:");
			String tx = br.readLine();
			System.out.println("您输入的字符串是:" + tx);
	    	Pattern p = Pattern.compile("\\d{1,}");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
	        Matcher m = p.matcher(tx);
	        int i = 0;
	        while(m.find()){
	        	i ++;
	            System.out.println("数字串" + i + "\""+ m.group());
	        }
	        System.out.println("总数是:" + i);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}

	public static void statistic(){
		String str = "伟大的中国伟大的人民万岁!";
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		String temp = new String(arr);
		for(int i = 0; i < arr.length; i ++){
			char c = temp.charAt(i);
			int lastIndex = temp.lastIndexOf(c);
			if(i ==0){//第一次输出个数
				System.out.println(c + " 出现的次数:" + (lastIndex +1 -i));
			}else if(!(arr[i]+"").equals(arr[i-1]+"")){//当循环到第一不同的时候,输出个数
				System.out.println(c + " 出现的次数:" + (lastIndex +1 -i));
			}
		}
	}
	@Test
	public void genericPictureCompress() throws Exception{
		String sourceStr = "D:/data/resource/resource/image/";
		File file = new File(sourceStr);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if(file2.isDirectory()){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse("2017-09-11");
				long dateAssert = date.getTime();
				long createTime = file2.lastModified();
				if(dateAssert > createTime) continue;
				
				String name = file2.getName();
				File[] file3 = file2.listFiles();
				for(File file4 : file3){
					ImageHelper.scaleImage(sourceStr+"/"+name+"/" + file4.getName(), sourceStr+"/"+name+"/" + file4.getName()+"_", 0.1, "jpg");
				}
			}
		}
	}
	@Test
	public void genericPicture(){
		String insertHader = " INSERT INTO `lw_baby_images` VALUES (";
		File file = new File("D:/mnuo/Camera/qq");
        File[] files = file.listFiles();
        int i = 380;
        for (File file2 : files) {
             String fileName = file2.getName();
             String time = "";
             String diretime = "";
             String[] times = fileName.split("_");
             if(times.length > 2){
            	 diretime = times[1];
            	 time = formateDate1(times[1], "yyyyMMdd","yyyy-MM-dd");
             }else{
            	 String time1 = fileName.replaceAll("IMG", "").replaceAll(".jpg", "");
            	 time = formateDate1(time1, "yyyyMMddHHmmss","yyyy-MM-dd");
            	 diretime = formateDate1(time1, "yyyyMMddHHmmss","yyyyMMdd");
             }
//             copyFile("D:/data/resource/resource/image/" + diretime, fileName, "D:/mnuo/Camera/qq/" + fileName);
             System.out.println(insertHader + (i++) + ", '" + time + "', '/resource/image/" + diretime+"/"+fileName + "', '', '2017-9-8 11:57:53');");
         }
	}
	
	public static void copyFile(String path, String fileName, String resource){
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			// 建立父目录
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			in = new FileInputStream(resource);
			// 每次读的长度
			int readLength = 1024;
			int length = in.available();
			int len = (length % readLength == 0) ? (length / readLength)
					: (length / readLength + 1);
			byte[] data = new byte[readLength];

			// 建立文件并写文件
			out = new FileOutputStream(path + "/" + fileName);
			for (int i = 0; i < len; i++) {
				if (in.read(data) != -1) {
					out.write(data);
				}
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static String formateDate1(String str, String parse, String parse1) {
		DateFormat format1 = new SimpleDateFormat(parse);         
		DateFormat format2= new SimpleDateFormat(parse1);         
		Date date = null;    
		try {    
	       date = format1.parse(str);   
	       return format2.format(date); 
		} catch (ParseException e) {    
		   e.printStackTrace();    
		}   
		return null;
	}
	
}
