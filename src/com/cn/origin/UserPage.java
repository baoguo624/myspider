package com.cn.origin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class UserPage {
	public static String getcontent(String url)throws Exception{ //commits页面的调用方法
		
		DownloadPage  down1 = new DownloadPage();
	
		String contentPage  = down1.getContentFormUrl(url);
		StringBuffer stf = new StringBuffer();
		String[] contentPart =  contentPage.split("<li class=\"commit commits-list-item ");
		//System.out.println(contentPart[1]);
		for(int i=1;i<contentPart.length;i++){
			stf.append("\n下条记录为：\n");
			stf.append("\n此次提交的快照号："+HrefOfPage1.getNumber(contentPart[i]));
			String urlTemp = HrefOfPage1.getHrefOfContent(contentPart[i]);
			stf.append("\n此次提交的具体信息链接："+urlTemp);
			//System.out.println(HrefOfPage1.getHrefOfContent(contentPart[i]));
			{
				StringBuffer stf1 = new StringBuffer();
				String temp = getcontentCode(urlTemp);         //调用得到code页面的具体内容
				FunctionUtils.createFile(temp, urlTemp);       //创建文件
			}
			stf.append("\n此次提交的备注为："+HrefOfPage1.getTitle(contentPart[i]));
			stf.append("\n此次提交的时间为："+HrefOfPage1.getTime(contentPart[i]));
			stf.append("\n此次提交的作者"+HrefOfPage1.getAuthor(contentPart[i]));
		}
		return stf.toString();
		
	}
	public static String getcontentCode(String url)throws Exception{    //codepage页面的方法调用
		
		DownloadPage  down1 = new DownloadPage();
	
		String content  = down1.getContentFormUrl(url);
		StringBuffer stf2 = new StringBuffer();
		String contentpart[] = content.split("<div id=\"diff-[0-9]+\"");
		for(int i = 0;i<contentpart.length;i++){
		stf2.append(HrefOfCodePage.getTitle(contentpart[i]));
		stf2.append(HrefOfCodePage.getLineInfo(contentpart[i])+"\n");
		}
		return stf2.toString();
		
	}
	
}
