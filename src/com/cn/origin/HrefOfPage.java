package com.cn.origin;

public class HrefOfPage  
{  
    /**  
     * ���ҳ��Դ�����г�����  
     */ 
    public static void getHrefOfContent(String content)  
    {  
        System.out.println("��ʼ");  
        String[] contents = content.split("<a href=\"");  
        String[] contentpart = content.split("<li class=\"commit commits-list-item ");
        System.out.println(contentpart.length);
        System.out.println(contents.length);
       // System.out.println(contentpart[1]);
       
        for (int i = 1; i < contents.length; i++)  
        {  
            int endHref = contents[i].indexOf("\"");  
 
           String  aHref = FunctionUtils.getHrefOfInOut(contents[i].substring( 0,endHref));  
          // aHref = FunctionUtils.getHrefOfInOut(contents[i].substring( 0,endHref));  
            System.out.println(aHref);
            if (aHref != null)  
            {  
               // String href = FunctionUtils.getHrefOfInOut(aHref);  
                String href = FunctionUtils.getHrefOfInOut(aHref); 
 
                if (!UrlQueue.isContains(href)  
                       // && href.indexOf("/enaqx/awesome-react/commit") != -1 
                        && !VisitedUrlQueue.isContains(href))  
                {  
                    UrlQueue.addElem(href);  
                }  
            }  
        }  
 
        System.out.println(UrlQueue.size() + "--ץȡ����������");  
        System.out.println(VisitedUrlQueue.size() + "--�Ѵ����ҳ����");  
 
    }  
 
} 