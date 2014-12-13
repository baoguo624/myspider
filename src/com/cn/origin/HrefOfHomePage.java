package com.cn.origin;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class HrefOfHomePage {
	  /**  
     * 获得 shouye 局部页面源代码中超链接  
     */ 
    public static String getHrefOfContent(String content)  
    {  
       // System.out.println("\n下条记录为：");  
        String[] contents = content.split("<a href=\"");  
      
       // System.out.println(contents.length);
     
        String[] aHref = new String[10];
        for (int i = 1; i < contents.length; i++)  
        {  
            int endHref = contents[i].indexOf("\"");  
 
        
           aHref[i] = FunctionUtils.getHrefOfInOut(contents[i].substring( 0,endHref));  
           // System.out.println(aHref[i]);
            String pat1 = "https://github.com/[0-9a-zA-Z-]+/[0-9a-zA-Z-.]+";
    		Pattern pattern0 = Pattern.compile(pat1);
    		Matcher matcher0 = pattern0.matcher(aHref[i]);
    		if(matcher0.matches()){
    			//System.out.println(aHref[i]+"是");
    			return aHref[i];
    			}
    	}
		 return "nothing";
    }
    public static String getTitle(String content){ //得到局部代码中的库介绍
    	String pat1 = "<p class=\"repo-list-description\">[ ]*";
    	String title[] = content.split(pat1);
    	//int start = title[1].indexOf(";\">");
    	  int end = title[1].indexOf("</p>");
    	  
    	return title[1].substring(0, end);
    	
    	
    }
    public static String getType(String content){ //得到局部代码中的库类型
    	String pat1 = "<p class=\"repo-list-meta\">[ ]*";
    	String title[] = content.split(pat1);
    	//int start = title[1].indexOf(";\">");
    	  int end = title[1].indexOf("&#8226");
    	  
    	return title[1].substring(0, end);
    	
    	
    }
    public static String getTime(String content){   //得到局部代码的此库的时间
    	String pat1 = " authored <time datetime=\"";
    	String title[] = content.split(pat1);
    	  int end = title[1].indexOf("\"");
    	  
    	return DateDemo.switchTimeType(title[1].substring(0, end));
    	    	
    }
    public static String getAuthor(String content){       //得到局部代码的commit作者
    	String pat1 = "<img alt=\"";
    	String title[] = content.split(pat1);
    	 StringBuffer stf = new StringBuffer();
    	//System.out.println(title[1]+title.length);
    	for(int i=1;i<title.length;i++){
    	  int end = title[i].indexOf("\"");
    	  
    	stf.append(title[i].substring(0,end)+"  and  ");
    	
    	}
    	return stf.toString();
    }
    public static String getName(String content){       //得到局部代码的库名称
    	String name = null;
    	name = getHrefOfContent( content).substring(19); 
    	  
    	return name;
    	    	
    }
    
    
 
}
