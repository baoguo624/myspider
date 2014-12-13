package com.cn.origin;
import java.text.*;
import java.util.*;
public class DateDemo {
	public static String switchTimeType(String strDate){
		
	
		String t=strDate.replace("T", " ");
		String s=t.replace("Z","");	
		
	
		
  	    String pat1 = "yyyy-MM-dd HH:mm:ss";
		String pat2 = "yyyy年MM月dd日  HH时mm分ss秒";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pat1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pat2);
		Date d = null;
		try{
			d = sdf1.parse(s);
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println(sdf2.format(d));
		//System.out.println(d);
		return sdf2.format(d);
	}

}