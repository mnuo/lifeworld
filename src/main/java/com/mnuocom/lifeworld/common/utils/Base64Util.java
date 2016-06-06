/**
 * Base64Util.java created at Nov 7, 2015 10:07:37 AM
 */
package com.mnuocom.lifeworld.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author saxon
 * Base64Util.java
 */
public class Base64Util {

	  //图片转化成base64字符串  
    public static String getImageStr(String path){//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = path;//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e){  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
      
    //base64字符串转化成图片  
    public static boolean generateImage(String imgStr,String path) {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i){  
                if(b[i]<0){//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = path;//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e) {  
            return false;  
        }  
    }  
    public static void main(String[] args) {
    	  String ing = getImageStr("D://myVideo.jpg");
    	  System.out.println(ing);
    	generateImage(ing, "D://1231232.jpg");
	}
}
