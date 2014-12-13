package com.cn.origin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class ResultShowCodePage {

	/**
	 * 对https://github.com/binux/pyspider/commit/88c94e66dc29300c87fbabd281c0393fda62a5d0?diff=unified
	 * 代码分步分析
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "https://github.com/botherder/detekt/commit/63d2bcd7ab84ad09327aec6daec292c99c263534";
		DownloadPage down1 =  new DownloadPage();
		String content = down1.getContentFormUrl(url);
		File file = new File("d:"+File.separator+"testCodePage.html");
		OutputStream ops = new FileOutputStream(file);
		byte b[] = content.getBytes();
		ops.write(b);
		ops.close();
		String contentpart[] = content.split("<div id=\"diff-[0-9]+\"");
		for(int i = 0;i<contentpart.length;i++){
		System.out.println(HrefOfCodePage.getTitle(contentpart[i]));
		System.out.println(HrefOfCodePage.getLineInfo(contentpart[i])+"\n");
		}
	}

}
