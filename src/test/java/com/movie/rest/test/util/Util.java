package com.movie.rest.test.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;



public class Util {
	private static final Logger logger =LoggerFactory.getLogger(Util.class);
	
	
	public static boolean isStoryNull(String s){
		return (s != null && s.trim().equalsIgnoreCase("<null>")) ? true : false;
	}

	public static void waitForSpecifiedTime(long time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private static boolean isNotNullAndEmpty(String s){
		return (s != null & s.trim().length() !=0) ? true : false;
	}
	public static Integer stringToInteger(String s){
		if(isNotNullAndEmpty(s)){
			try{
				return Integer.valueOf(s.trim());
			}catch(NumberFormatException nfe){}
		}
		return null;
	}
	
	public static boolean stringToBoolean(String s){
		if(isNotNullAndEmpty(s)){
			if(s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")){
				try{
					System.out.println("inner return: "+Boolean.parseBoolean(s));
					return Boolean.parseBoolean(s);
				}catch(NumberFormatException nfe){}
			}
		}
		System.out.println("outer return: "+(Boolean) null);
		return (Boolean) null;
	}
}
