<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="db.db"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
    

  </head>
  
  <body>
  <%
 

String id=request.getParameter("id");
String addname=request.getParameter("addname");
String userno=request.getParameter("userno");
System.out.println(id+addname+userno);
if(addname.equals(userno)){
String sql="delete from Ebook_tb where ID="+id+"";
  	  	
connDbBean.executeUpdate(sql);
out.print("<script>alert('删除成功!!');location.href='"+request.getHeader("Referer")+"';</script>");
}else{

  out.print("<script>alert('只能删除自己上传的文件!!');location.href='"+request.getHeader("Referer")+"';</script>");
  	}  


 %>
  </body>
</html>

