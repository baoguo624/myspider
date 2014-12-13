package com.cn.origin;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HrefOfPage1  
{  
    /**  
     * ��þֲ�ҳ��Դ�����г�����  
     */ 
    public static String getHrefOfContent(String content)  
    {  
       // System.out.println("\n������¼Ϊ��");  
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
    			//System.out.println(aHref[i]+"��");
    			return aHref[i];
    			}
    	}
        }catch(NullPointerException e){
        	e.printStackTrace();
        	
        }
		 return "nothing";
    }
    public static String getTitle(String content){ //�õ��ֲ������commit��ע
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
    public static String getTime(String content){   //�õ��ֲ������commitʱ��
    	String pat1 = " authored <time datetime=\"";
    	String title[] = content.split(pat1);
    	if(title.length >= 2){
    	  int end = title[1].indexOf("\"");
    	  
    	return DateDemo.switchTimeType(title[1].substring(0, end));
    	}else{
    		return "Sorry ,No time can be catched!";
    	}    	
    }
    public static String getAuthor(String content){       //�õ��ֲ������commit����
    	String pat1 = " ?author=";
    	String title[] = content.split(pat1);
    	if(title.length ==2){
    	  int end = title[1].indexOf("\"");
    	  
    	return (title[1].substring(0, end));
    	}else{
    		return "Sorry ,no author  can be catched";
    	}
    	
    }
    public static String getNumber(String content){       //�õ��ֲ������commit���պ�
    	
    	  
    	return content.substring(content.indexOf(":commit:")+8,content.indexOf(":commit:")+48);
    	    	
    }
    
    
 
} 