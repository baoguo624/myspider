package com.cn.origin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class HomePageToUserPage {
	public static void main(String args[])throws Exception{
		String url = "https://github.com/trending";
		DownloadPage  down1 = new DownloadPage();
		File f = new File("d:"+File.separator+"testhomepage.txt");
		OutputStream ops = new FileOutputStream(f);
		String contentPage  = down1.getContentFormUrl(url);
		byte b[] = contentPage.getBytes();
		ops.write(b);
		ops.close();
		String[] contentPart =  contentPage.split(" <li class=\"repo-list-item\" ");  //对trending中源代码进行分割
		for(int i = 1;i<contentPart.length;i++){
			 UrlQueue.addElem(HrefOfHomePage.getHrefOfContent(contentPart[i]));  
		}
		int urlqueueSize = UrlQueue.size();
		System.out.println(urlqueueSize);
		while(UrlQueue.size()!=0){
			System.out.println("\n第"+(urlqueueSize-UrlQueue.size()+1)+"个库：\n");
			String userurl = UrlQueue.outElem()+"/commits/master";
			String temp = UserPage.getcontent(userurl);
		FunctionUtils.createFile(temp,userurl );
		}
	}		
}
