package com.cn.prefile;
import com.cn.origin.*;

import java.io.File ;
import java.io.InputStream ;
import java.io.FileInputStream ;
public class Test3{
	public static void main(String args[]) throws Exception{	// �쳣�׳���������
		// ��1����ʹ��File���ҵ�һ���ļ�
		File f= new File("d:" + File.separator + "test3.txt") ;	// ����File����
		// ��2����ͨ������ʵ�����������
		InputStream input = null ;	// ׼����һ������Ķ���
		input = new FileInputStream(f)  ;	// ͨ�������̬�ԣ�����ʵ����
		// ��3�������ж�����
		byte b[] = new byte[3000] ;		// �����С���ļ�����
		int len = 0 ; 
		int temp = 0 ;			// ����ÿһ����ȡ����������
		
		while((temp=input.read())!=-1){
			// ��ʾ�������ݣ��ļ�û�ж���
			b[len] = (byte)temp ;
			len++ ;
		}
		// ��4�����ر������
		input.close() ;	// �ر������\
		String content0 = new String(b,0,len);
		//System.out.println("����Ϊ��" + content) ;	// ��byte�����Ϊ�ַ������
		System.out.println(len) ;
		String title0 = null;
		title0 = content0.substring(content0.indexOf(":commit:")+8,content0.indexOf(":commit:")+48);
		System.out.println(title0);
		
		
	}
};