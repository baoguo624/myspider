package com.cn.origin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefOfCodePage {
	  public static String getHrefOfContent(String content)  //
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
	    public static String getTitle(String content){ //�õ��ֲ��������ļ�����
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
	    public static String getLineInfoBak(String content) {  //�������������кŲ�ͬ������ȡ��������룬tops�� ʧ�ܡ� ��Ϊ����
	    	
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
	    
	    public static String getLineInfo(String content) {                // ��ȡ����ɾ��������
	    	
	    	String linecode[] = content.split("<tr>");
	    	StringBuffer stf = new StringBuffer();
	    	for(int i =1;i<linecode.length;i++){
	    		//�ֲ������
	    			{																
	    				String entity[] = linecode[i].split("<td class=\"blob-code blob-code-[a-z]+\">[+]");
	    				if(entity.length ==2){
	    					int  entityEnd = entity[1].indexOf("</td>");
	    					stf.append("+"+entity[1].substring(0, entityEnd)+"\n");
	    				}
	    			}
	    			//�ֲ������
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
	    
	    
	 
	}


