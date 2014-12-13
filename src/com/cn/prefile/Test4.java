package com.cn.prefile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 File file = new File ("D:" + File.separator+"GitHubDownload"+ File.separator + "aaa"+File.separator+"bb"); 
		// System.out.println(File.pathSeparator+File.pathSeparatorChar+File.separator+File.separator);
		 if (!file.exists())  
         {  
             file.mkdirs();  
         } 
		 File f = null;
		 f = new File("D:" + File.separator+"GitHubDownload"+ File.separator + "aaa"+File.separator+"bb"+File.separator+"test.txt");
	        f.createNewFile();
		 OutputStream ops = new FileOutputStream(f);
			String content = "ancddeeeee";
			byte b[] = content.getBytes();
			ops.write(b);
			ops.close();

	}

}
