package com.cn.origin;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HrefOfPage1  
{  
    /**  
     * 获得局部页面源代码中超链接  
     */ 
    public static String getHrefOfContent(String content)  
    {  
       // System.out.println("\n下条记录为：");  
        String[] contents = content.split("<a href=\"");  
      
       // System.out.println(contents.length);
     
        String[] aHref = new String[10];
        try{
        for (int i = 1; i < contents.length; i++)  
        {  
            int endHref = contents[i].indexOf("\"");  
 
        
           aHref[i] = FunctionUtils.getHrefOfInOut(contents[i].substring( 0,endHref));  
           // System.out.println(aHref[i]);
            String pat1 = "https://github.com/[0-9a-zA-Z-]+/[0-9a-zA-Z-.]+/commit/[a-zA-Z0-9]+";
    		Pattern pattern0 = Pattern.compile(pat1);
    		Matcher matcher0 = pattern0.matcher(aHref[i]);
    		if(matcher0.matches()){
    			//System.out.println(aHref[i]+"是");
    			return aHref[i];
    			}
    	}
        }catch(NullPointerException e){
        	e.printStackTrace();
        	
        }
		 return "nothing";
    }
    public static String getTitle(String content){ //得到局部代码的commit备注
    	String pat1 = " title=\"";
    	String title[] = content.split(pat1);
    	if(title.length >= 2){
    	int start = title[1].indexOf(";\">");
    	  int end = title[1].indexOf("</a>");
    	  
    	return title[1].substring(start+3, end);
    	}else{
    		return "Sorry ,No title can be catched!";
    	}
    	
    }
    public static String getTime(String content){   //得到局部代码的commit时间
    	String pat1 = " authored <time datetime=\"";
    	String title[] = content.split(pat1);
    	if(title.length >= 2){
    	  int end = title[1].indexOf("\"");
    	  
    	return DateDemo.switchTimeType(title[1].substring(0, end));
    	}else{
    		return "Sorry ,No time can be catched!";
    	}    	
    }
    public static String getAuthor(String content){       //得到局部代码的commit作者
    	String pat1 = " ?author=";
    	String title[] = content.split(pat1);
    	if(title.length ==2){
    	  int end = title[1].indexOf("\"");
    	  
    	return (title[1].substring(0, end));
    	}else{
    		return "Sorry ,no author  can be catched";
    	}
    	
    }
    public static String getNumber(String content){       //得到局部代码的commit快照号
    	
    	  
    	return content.substring(content.indexOf(":commit:")+8,content.indexOf(":commit:")+48);
    	    	
    }
    
    
 
} 