package com.cn.origin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ResultShowOfHomePage {               //�Ӿֲ���ҳ�г�ȡ������Ϣ
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
			System.out.println("\n������¼Ϊ\n������Ϊ��"+HrefOfHomePage.getName(contentPart[i]));
			System.out.println("��ľ�������Ϊ����"+HrefOfHomePage.getHrefOfContent(contentPart[i]));
			System.out.println("�˿�ı�עΪ��"+HrefOfHomePage.getTitle(contentPart[i]));
			System.out.println("�˿������Ϊ��"+HrefOfHomePage.getType(contentPart[i]));
			System.out.println("�˿������"+HrefOfHomePage.getAuthor(contentPart[i]));
		}
		
	}
	

}
