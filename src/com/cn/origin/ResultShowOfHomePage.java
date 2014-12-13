package com.cn.origin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ResultShowOfHomePage {               //从局部网页中抽取有用信息
	public static void main(String args[])throws Exception{
		String url = "https://github.com/trending";
		DownloadPage  down1 = new DownloadPage();
		//System.out.println(down1.getContentFormUrl(url));
		File f = new File("d:"+File.separator+"testhomepage.txt");
		OutputStream ops = new FileOutputStream(f);
		String contentPage  = down1.getContentFormUrl(url);
		byte b[] = contentPage.getBytes();
		ops.write(b);
		ops.close();
		//HrefOfPage.getHrefOfContent( contentPage);
		String[] contentPart =  contentPage.split(" <li class=\"repo-list-item\" ");
		//System.out.println(contentPart[15]);
		for(int i=1;i<contentPart.length;i++){
			System.out.println("\n下条记录为\n库名称为："+HrefOfHomePage.getName(contentPart[i]));
			System.out.println("库的具体链接为：："+HrefOfHomePage.getHrefOfContent(contentPart[i]));
			System.out.println("此库的备注为："+HrefOfHomePage.getTitle(contentPart[i]));
			System.out.println("此库的类型为："+HrefOfHomePage.getType(contentPart[i]));
			System.out.println("此库的作者"+HrefOfHomePage.getAuthor(contentPart[i]));
		}
		
	}
	

}
