package worm;
import java.text.*;
import java.util.*;
public class DateDemo {
	public static void main(String args[]){
		String strDate = "2014-11-08T19:38:00Z";
	
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
		System.out.println(sdf2.format(d));
		System.out.println(d);
	}

}