package com.cn.prefile;
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
public class Test5 {
	private static BufferedWriter writer = null;
	public static void main(String[] args) {
		
	// TODO Auto-generated method stub
		createFile(" i love you  baby","http://yesBaby/a/b/c/123432oddj");
	}
		 public static void createFile(String content, String urlPath)  
		    {  
		        /* 分割url */ 
		        String[] elems = divUrl(urlPath);  
		        System.out.println(elems.length);
		        StringBuffer path = new StringBuffer();  
		 
		        File file = null;  
		        for (int i = 1; i < elems.length; i++)  
		        {  
		            if (i != elems.length - 1)  
		            {  
		 
		                path.append(elems[i]);
		                System.out.println(elems[i]);
		                path.append(File.separator);  
		                file = new File("D:" + File.separator +"abc"+File.separator + path.toString());  
		 
		            }  
		 
		            if (i == elems.length - 1)  
		            {  
		                Pattern pattern = Pattern.compile("\\w+");  
		                Matcher matcher = pattern.matcher(elems[i]);  
		                if ((matcher.matches()))  
		                {  
		                    if (!file.exists())  
		                    {  
		                        file.mkdirs();  
		                    }  
		                    String[] fileName = elems[i].split("\\.");  
		                    file = new File("D:" + File.separator +"abc"+File.separator+ path.toString()  
		                            + File.separator + fileName[0] + ".txt");  
		                    try 
		                    {  
		                        file.createNewFile();  
		                        writer = new BufferedWriter(new OutputStreamWriter(  
		                                new FileOutputStream(file)));  
		                        writer.write(content);  
		                        writer.flush();  
		                        writer.close();  
		                        System.out.println("创建文件成功");  
		                    } catch (IOException e)  
		                    {  
		                        e.printStackTrace();  
		                    }  
		 
		                }  
		            }  
		 
		        }  
		    } 
		 public static String[] divUrl(String url)  
		    {  
		        return url.split("/");  
		    }  

}
