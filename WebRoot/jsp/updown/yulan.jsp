<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="com.jspsmart.upload.*" %>
<jsp:useBean id="reader" scope="page" class="db.WordReader"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>应用结构类信息</title>
    <LINK href="css.css" type=text/css rel=stylesheet>
    <script language="javascript" src="js/Calendar.js"></script>
    <script type="text/javascript" src="js/popup.js"></script>
	
	  <script type="text/javascript">
  		function yulan(urlname) 
           {
	
                    var url="<%=path%>/jsp/upload/"+urlname+"";
			        url=encodeURI(url); 
	                url=encodeURI(url); 
	                window.open(url,"_blank");
           }


	</script>
    
  </head>
  
  <body> 
      <% 
          try
          {
         	  String urlname="";
         	  System.out.println(System.getProperty("java.library.path"));
         	  System.getProperty("java.library.path");
              String fujianPath=request.getParameter("fujianPath");
	          String fujianYuashiMing=request.getParameter("fujianYuashiMing");
	          fujianYuashiMing=java.net.URLDecoder.decode(fujianYuashiMing,"UTF-8");
	          System.out.println(fujianPath);
	          System.out.println(fujianYuashiMing);
	          
        	  String filename= fujianYuashiMing.substring(0,fujianYuashiMing.lastIndexOf("."));
        	  filename=java.net.URLDecoder.decode(filename,"UTF-8");
        	  urlname=fujianYuashiMing.substring(0,fujianYuashiMing.lastIndexOf("."))+".html";
        	          	  urlname=java.net.URLDecoder.decode(urlname,"UTF-8");
        	  
        	  	          System.out.println(urlname);
        	  
	          reader.extractDoc(fujianPath, "/jsp/upload/"+filename+".html");
	          
	          
	         
          }
          catch(Exception e)
          {%>
              <script type="text/javascript">
                    alert("文件不存在。请联系管理人员");
                    window.history.back();
              </script>
     
      
   
 <%}
      %> 
      
  </body>
  <table>
  
  <tr>
	    
		<a href="javascript:void(0)" onclick="yulan('${urlname}')" style="font-size: 12px;color: red">开始预览</a>

  </tr>
  
  </table>

</html>
