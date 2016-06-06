/**
 * 
 */
package com.mnuocom;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author mnuo
 *
 */
public class LigntTest {
	//定义枚举类型
	public enum Light{
		//利用构造函数传参
		 RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
		//定义私有变量
		private int nCode;
		private String name;
		
		private Light(String name,int nCode){
			this.nCode = nCode;
			this.name = name;
		}
		@Override
		public String toString() {
			return String.valueOf(this.nCode);
		}
		public int getnCode() {
			return nCode;
		}
		public void setnCode(int nCode) {
			this.nCode = nCode;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	public static void main(String[] args) {
		//遍历枚举类型
		System.out.println("演示枚举类型的遍历==================================");
		testTraversalEnum();
		System.out.println("演示EnumMap的使用================================");
		testEnumMap();
		System.out.println("演示EnumSet的使用================================");
		testEnumSet();
	}
	/**
	 * 演示枚举循环
	 */
	public static void testTraversalEnum(){
		Light[] allLight = Light.values();
		for(Light aLight : allLight){
			System.out.println("当前灯name:" + aLight.name());
			System.out.println("当前灯ordinal:" + aLight.ordinal());
			System.out.println("当前灯:" + aLight);
			System.out.println("=="+ aLight.getName());
		}
	}
	/**
	 * 演示EnumMap的使用,EnumMap跟HashMap的使用差不多,只不过key要是枚举类型
	 */
	private static void testEnumMap(){
		//1.演示定义EnumMap对象,EnumMap对象的构造函数需要参数传入,默认是key的类的类型
		EnumMap<Light, String> currentEnumMap = new EnumMap<Light,String>(Light.class);
		currentEnumMap.put(Light.RED, "红灯");
		currentEnumMap.put(Light.GREEN, "绿灯");
		currentEnumMap.put(Light.BLANK, "黄灯");
		for(Light aLight : Light.values()){
			System.out.println("[key="+	aLight.name() + ",当前灯="+aLight+",value="+ currentEnumMap.get(aLight)+"]");
		}
	}
	/**
	 * 演示EnumSet
	 */
	private static void testEnumSet(){
		EnumSet<Light> currenEnumSet = EnumSet.allOf(Light.class);
		for(Light aLightSetElement: currenEnumSet){
			System.out.println("当前EnumSet中的数据为:" + aLightSetElement);
		}
	}
}
