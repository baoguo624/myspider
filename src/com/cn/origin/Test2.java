package com.cn.origin;

import java.io.File ;
import java.io.InputStream ;
import java.io.FileInputStream ;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
public class Test2{
	public static void main(String args[]) throws Exception{	// 异常抛出，不处理
		// 第1步、使用File类找到一个文件
		File f= new File("d:" + File.separator + "test3.txt") ;	// 声明File对象
		// 第2步、通过子类实例化父类对象
		InputStream input = null ;	// 准备好一个输入的对象
		input = new FileInputStream(f)  ;	// 通过对象多态性，进行实例化
		// 第3步、进行读操作
		byte b[] = new byte[3000] ;		// 数组大小由文件决定
		int len = 0 ; 
		int temp = 0 ;			// 接收每一个读取进来的数据
		
		while((temp=input.read())!=-1){
			// 表示还有内容，文件没有读完
			b[len] = (byte)temp ;
			len++ ;
		}
		// 第4步、关闭输出流
		input.close() ;	// 关闭输出流\
		String content0 = new String(b,0,len);
		System.out.println("内容为：" + content0) ;	// 把byte数组变为字符串输出
		System.out.println(len) ;
		
		System.out.println(HrefOfPage1.getNumber(content0));
		System.out.println(HrefOfPage1.getHrefOfContent(content0));
		System.out.println(HrefOfPage1.getTitle(content0));
		System.out.println(HrefOfPage1.getTime(content0));
		System.out.println(HrefOfPage1.getAuthor(content0));
		
		
}
}