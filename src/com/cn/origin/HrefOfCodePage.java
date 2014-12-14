package com.cn.origin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefOfCodePage {
	  public static String getHrefOfContent(String content)  //
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
	    public static String getTitle(String content){ //得到局部代码中文件名称
	    	String pat1 = " <span class=\"js-selectable-text\" title=\"";
	    	String title[] = content.split(pat1);
	    	//int start = title[1].indexOf(";\">");
	    	if(title.length>1){
	    	  int end = title[1].indexOf("\">");
	    	  
	    	return title[1].substring(0, end);
	    	}else{
	    		return "";
	    	}
	    	
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
	    public static String getLineInfoBak(String content) {  //根据左右两个行号不同，来抽取出变更代码，tops： 失败。 作为备份
	    	
	    	String linecode[] = content.split("<tr>");
	    	StringBuffer stf = new StringBuffer();
	    	System.out.println(linecode[1]);
	    	for(int i =1;i<linecode.length;i++){
	    		
	    		String inlinecode[] = linecode[i].split("data-line-number=\"");
	    		String codenumber[]  = new String[3]; 
	    		if(inlinecode.length>1){
	    		for(int j = 1;j<inlinecode.length;j++){
	    			int end = inlinecode[j].indexOf("\"");
	    			codenumber[j-1] = inlinecode[j].substring(0,end);
	    			}
	    	}
	    		
	    		if(codenumber[0].equalsIgnoreCase(codenumber[1])){
	    			continue;
	    		}else{
	    			System.out.println("234");
	    			System.out.println(linecode[1]);
	    			
	    			String entity[] = linecode[i].split("<td class=\"blob-code blob-code-[a-z]+\">");
	    			
	    			if(entity.length ==2){
	    			int  entityEnd = entity[1].indexOf("</td>");
	    			stf.append(entity[1].substring(0, entityEnd)+"\n");
	    				
	    			}else{
	    				stf.append("false");
	    			}
	    		}
	    	}
	    	
	    	
	    	return stf.toString();
	    }	 
	    
	    public static String getLineInfo(String content) {                // 获取增加删除的内容
	    	
	    	String linecode[] = content.split("<tr>");
	    	StringBuffer stf = new StringBuffer();
	    	for(int i =1;i<linecode.length;i++){
	    		//局部代码块
	    			{																
	    				String entity[] = linecode[i].split("<td class=\"blob-code blob-code-[a-z]+\">[+]");
	    				if(entity.length ==2){
	    					int  entityEnd = entity[1].indexOf("</td>");
	    					stf.append("+"+entity[1].substring(0, entityEnd)+"\n");
	    				}
	    			}
	    			//局部代码块
	    			{
	    				String entity[] = linecode[i].split("<td class=\"blob-code blob-code-[a-z]+\">[-]");
	    				if(entity.length ==2){
	    					int  entityEnd = entity[1].indexOf("</td>");
	    					stf.append("-"+entity[1].substring(0, entityEnd)+"\n");
	    				}
	    			}
	    	
	    	}
	    	
	    	return stf.toString();
	    }
	    
	    public static String getChangeFile(String content){       //得到局部代码的change file
	    	String pat1 = "<button type=\"button\" class=\"button-link js-details-target\">";
	    	String title[] = content.split(pat1);
	    	 StringBuffer stf = new StringBuffer();
	    	//System.out.println(title[1]+title.length);
	    	 if(title.length !=1){
	    	  int end = title[1].indexOf("</button>");
	    	  
	    	stf.append(title[1].substring(0,end));
	    	 }
	    	
	    	return stf.toString();
	    }
	    public static String getAddMete(String content){       //得到局部代码的change file add 量
	    	String pat1 = "<span class=\"diffstat-icon\">+</span>";
	    	String title[] = content.split(pat1);
	    	 StringBuffer stf = new StringBuffer();
	    	System.out.println("title[].length"+title.length);
	    	 if(title.length !=1){
	    		 System.out.print(title[1]);
	    	  int end = title[1].indexOf("</span>");
	    	  
	    	stf.append(title[1].substring(0,end)+"additions ");
	    	 }
	    	
	    	return stf.toString();
	    }
	    public static String getDelMete(String content){       //得到局部代码的change file delete 量
	    	String pat1 = "<span class=\"diffstat-icon\">−</span>";
	    	String title[] = content.split(pat1);
	    	 StringBuffer stf = new StringBuffer();
	    	//System.out.println(title[1]+title.length);
	    	 if(title.length !=1){
	    	  int end = title[1].indexOf("</span>");
	    	  
	    	stf.append(title[1].substring(0,end)+"deletes ");
	    	
	    	 }
	    	return stf.toString();
	    }
	    
	 
	}


