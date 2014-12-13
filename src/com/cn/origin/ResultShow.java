package com.cn.origin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ResultShow {           //从网页局部中抽取有用信息
	public static void main(String args[])throws Exception{
		String url = "https://github.com/enaqx/awesome-react/commits/master";
		DownloadPage  down1 = new DownloadPage();
		//System.out.println(down1.getContentFormUrl(url));
		File f = new File("d:"+File.separator+"test2.txt");
		OutputStream ops = new FileOutputStream(f);
		String contentPage  = down1.getContentFormUrl(url);
		byte b[] = contentPage.getBytes();
		ops.write(b);
		ops.close();
		//HrefOfPage.getHrefOfContent( contentPage);
		String[] contentPart =  contentPage.split("<li class=\"commit commits-list-item ");
		//System.out.println(contentPart[1]);
		for(int i=1;i<contentPart.length;i++){
			System.out.println("下条记录为：\n此次提交的快照号："+HrefOfPage1.getNumber(contentPart[i]));
			System.out.println("此次提交的具体信息链接："+HrefOfPage1.getHrefOfContent(contentPart[i]));
			System.out.println("此次提交的备注为："+HrefOfPage1.getTitle(contentPart[i]));
			System.out.println("此次提交的时间为："+HrefOfPage1.getTime(contentPart[i]));
			System.out.println("此次提交的作者"+HrefOfPage1.getAuthor(contentPart[i]));
		}
		
	}
	
	
}
