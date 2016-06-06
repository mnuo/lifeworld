/**
 * Testss.java created at Apr 20, 2016 9:01:45 PM
 */
package com.mnuocom.lifeworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
