package com.cn.origin;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class HrefOfHomePage {
	  /**  
     * ��� shouye �ֲ�ҳ��Դ�����г�����  
     */ 
    public static String getHrefOfContent(String content)  
    {  
       // System.out.println("\n������¼Ϊ��");  
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
    			//System.out.println(aHref[i]+"��");
    			return aHref[i];
    			}
    	}
		 return "nothing";
    }
    public static String getTitle(String content){ //�õ��ֲ������еĿ����
    	String pat1 = "<p class=\"repo-list-description\">[ ]*";
    	String title[] = content.split(pat1);
    	//int start = title[1].indexOf(";\">");
    	  int end = title[1].indexOf("</p>");
    	  
    	return title[1].substring(0, end);
    	
    	
    }
    public static String getType(String content){ //�õ��ֲ������еĿ�����
    	String pat1 = "<p class=\"repo-list-meta\">[ ]*";
    	String title[] = content.split(pat1);
    	//int start = title[1].indexOf(";\">");
    	  int end = title[1].indexOf("&#8226");
    	  
    	return title[1].substring(0, end);
    	
    	
    }
    public static String getTime(String content){   //�õ��ֲ�����Ĵ˿��ʱ��
    	String pat1 = " authored <time datetime=\"";
    	String title[] = content.split(pat1);
    	  int end = title[1].indexOf("\"");
    	  
    	return DateDemo.switchTimeType(title[1].substring(0, end));
    	    	
    }
    public static String getAuthor(String content){       //�õ��ֲ������commit����
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
    public static String getName(String content){       //�õ��ֲ�����Ŀ�����
    	String name = null;
    	name = getHrefOfContent( content).substring(19); 
    	  
    	return name;
    	    	
    }
    
    
 
}
