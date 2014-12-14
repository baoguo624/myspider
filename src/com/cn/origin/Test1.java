package com.cn.origin;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
public class Test1 {
	public static void main(String args[]) throws Exception{
		String url = "https://github.com/mewwts/addict/commit/dbc9e7a71867e615372d7822c4a477e4b85793d7";
		DownloadPage  down1 = new DownloadPage();
		//System.out.println(down1.getContentFormUrl(url));
		File f = new File("d:"+File.separator+"test2.html");
		OutputStream ops = new FileOutputStream(f);
		byte b[] = down1.getContentFormUrl(url).getBytes();
		ops.write(b);
		ops.close();
		HrefOfPage.getHrefOfContent( down1.getContentFormUrl(url));
		
	}

}
