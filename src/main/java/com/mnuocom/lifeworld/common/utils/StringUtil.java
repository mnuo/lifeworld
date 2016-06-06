package com.mnuocom.lifeworld.common.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringUtil {
	
	public static String htmlToText(String in){
		return in;
	}
	
    public static String  textToHtml(String in){
    	if (in == null || in.length() == 0) {
            return in;
        }
    	int strlen;
    	StringBuffer reStr = new StringBuffer();
    	String deStr = "";
    	strlen = in.length();
    	for(int i=0;i<strlen;i++){
    		char ch=in.charAt(i);
    		switch(ch){
    			case '<': 
    				deStr = "&lt;";
    				break;
    			case '>':         
    				deStr = "&gt;";         
    	    	    break;
    			case '\"':         
    				deStr = "&quot;";         
    	    	    break;
    			case '&':         
    				deStr = "&amp;";         
    	    	    break;
    			case 13:         
    				deStr = "<br>";
    				break;
    			case 32:         
    				deStr = "&nbsp;";         
    	    	    break;
    			default :         
    				deStr = "" + ch;         
    	    	    break;
    		}
    		reStr.append(deStr);
    	}
    	return reStr.toString();
    }
    
    public static String  textToHtml2(String in){
    	if (in == null || in.length() == 0) {
    		return in;
    	}
    	int strlen;
    	StringBuffer reStr = new StringBuffer();
    	String deStr = "";
    	strlen = in.length();
    	for(int i=0;i<strlen;i++){
    		char ch=in.charAt(i);
    		switch(ch){
    		case '<': 
    			deStr = "&lt;";
    			break;
    		case '>':         
    			deStr = "&gt;";         
    			break;
    		case '\"':         
    			deStr = "&quot;";         
    			break;
    		case '&':         
    			deStr = "&amp;";         
    			break;
    		case '\t':
    			deStr = "&nbsp;&nbsp;&nbsp;&nbsp;";
    			break;
    		case '\n':
    			deStr = "<br>";
    			break;
//    		case 13:         
//    			deStr = "<br>";
//    			break;
    		case 32:         
    			deStr = "&nbsp;";         
    			break;
    		default :         
    			deStr = "" + ch;
    			break;
    		}
    		reStr.append(deStr);
    	}
    	return reStr.toString();
    }
    
    public static long[] convert2long(String[] ids) throws NumberFormatException {
    	if (ids == null || ids.length == 0)
    		return null;
    	
    	long[] arr = new long[ids.length];
    	for (int i = 0; i < ids.length; i++) {
			arr[i] = Long.parseLong(ids[i]);
		}
    	
    	return arr;
    }
    public static String replaceImg(String content){
    	return content.replaceAll("<[img,IMG][^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", "");
    }
    public static List<String> getImgStr(String content) {
    	List<String> list = new ArrayList<String>();
    	Pattern p = Pattern.compile("<[img,IMG][^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
        Matcher m = p.matcher(content);
//        System.out.println();
//        System.out.println(m.groupCount());
        while(m.find()){
           // System.out.println(m.group()+"-------------↓↓↓↓↓↓");
            list.add(m.group(1));
        }
        return list;
	} 
    public static Set<String> getImgStrToSet(String content) {
    	Set<String> list = new HashSet<String>();
    	Pattern p = Pattern.compile("<[img,IMG][^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
    	Matcher m = p.matcher(content);
    	while(m.find()){
    		list.add(m.group(1));
    	}
    	return list;
    } 
//    public static void main(String[] args) {
//		getImgStr("<p align=\"center\"><img id=\"eWebEditor_TempElement_Img\" border=\"0\" src=\"/operate/UpLoadFolder/2014-01-21-16-38-18-2496.jpg\" alt=\"\" /></p><p>　　1月20日，受苏州市经济和信息化委员会的邀请，国家光伏质检中心（CPVT）王顺权博士参加了苏州市光伏工作布置会议，并为参会人员解读了《光伏制造行业规范》。<br />　　本次会议由苏州经信委组织召开，主题是对苏州市第二批光伏企业公告申报工作进行安排和布置，并邀请行业专家对申报工作事项进行指导和讲解。苏州市各市、区经信委、发改委等相关部门负责人、企业人员代表和CPVT相关专家参加了会议。<br />　　会上，CPVT王顺权博士对行业规范的解读以及对行业状况的分析受到了与会人员的一致的好评。作为国家级光伏质检机构，CPVT一直以协助各企业更好的了解和贯彻执行相关的行业标准和条件规范为己任，以此促进光伏行业整体水平的提高和有序健康的发展。<br /></p>");
//	}
    
    public static boolean isEmpty(String in){
    	if(in == null)
    		return true;
    	if(in.trim().equals(""))
    		return true;
    	
    	return false;
    }
    
    public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
    
    public static String stripHtml(String content) { 
     	content = content.replaceAll("\\<.*?>", ""); 
    	content = content.replaceAll("&amp;", "&"); 
    	content = content.replaceAll("&nbsp;", ""); 
//    	content = content.replaceAll("&lt;", ""); 
    	content = content.replaceAll("&quot;", "\""); 
    	content = content.replaceAll("&lt;", "<"); 
    	content = content.replaceAll("&gt;", ">"); 
    	// <p>段落替换为换行 
//    	content = content.replaceAll("<p .*?>", "\r\n"); 
    	content = content.replaceAll("<p .*?>", ""); 
    	// <br><br/>替换为换行 
//    	content = content.replaceAll("<br\\s*/?>", "\r\n"); 
    	content = content.replaceAll("<br\\s*/?>", ""); 
    	// 去掉其它的<>之间的东西 
    	
    	content = content.replaceAll("\\<.*?>", ""); 
    	// 还原HTML 
    	return content; 
    }
}
