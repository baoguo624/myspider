package com.cn.origin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class UserPage {
	public static String getcontent(String url)throws Exception{ //commitsҳ��ĵ��÷���
		
		DownloadPage  down1 = new DownloadPage();
	
		String contentPage  = down1.getContentFormUrl(url);
		StringBuffer stf = new StringBuffer();
		String[] contentPart =  contentPage.split("<li class=\"commit commits-list-item ");
		//System.out.println(contentPart[1]);
		for(int i=1;i<contentPart.length;i++){
			stf.append("\n������¼Ϊ��\n");
			stf.append("\n�˴��ύ�Ŀ��պţ�"+HrefOfPage1.getNumber(contentPart[i]));
			String urlTemp = HrefOfPage1.getHrefOfContent(contentPart[i]);
			stf.append("\n�˴��ύ�ľ�����Ϣ���ӣ�"+urlTemp);
			//System.out.println(HrefOfPage1.getHrefOfContent(contentPart[i]));
			{
				StringBuffer stf1 = new StringBuffer();
				String temp = getcontentCode(urlTemp);         //���õõ�codeҳ��ľ�������
				FunctionUtils.createFile(temp, urlTemp);       //�����ļ�
			}
			stf.append("\n�˴��ύ�ı�עΪ��"+HrefOfPage1.getTitle(contentPart[i]));
			stf.append("\n�˴��ύ��ʱ��Ϊ��"+HrefOfPage1.getTime(contentPart[i]));
			stf.append("\n�˴��ύ������"+HrefOfPage1.getAuthor(contentPart[i]));
		}
		return stf.toString();
		
	}
	public static String getcontentCode(String url)throws Exception{    //codepageҳ��ķ�������
		
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
