<%@ page language="java"  pageEncoding="gb2312" import="java.sql.*,java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(    
     "yyyy-MM-dd HH:mm:ss");    
   java.util.Date currentTime = new java.util.Date();    
   String time = simpleDateFormat.format(currentTime).toString(); 
%>
<%
request.setCharacterEncoding("gb2312"); 
response.setCharacterEncoding("gb2312"); 
%>
<jsp:useBean id="connDbBean" scope="page" class="db.db"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
    

  </head>
  
  <body>
  <%
 


String bianhao=request.getParameter("bianhao");
String name=request.getParameter("name");
String miaoshu=request.getParameter("miaoshu");	
String type=request.getParameter("type");
String addname=request.getParameter("userno");
String createname=request.getParameter("createname");
String fujian=request.getParameter("fujian");
String fujianYuanshiming=request.getParameter("fujianYuanshiming");

 ResultSet RS_result=connDbBean.executeQuery("select * from Ebook_tb where bianhao='"+bianhao+"'");

 if(RS_result.next())
{
out.print("<script>alert('该编号已经存在,请换其他编号!');window.history.go(-1);</script>");
	}
else{

	
  	  	String sql="insert into Ebook_tb(bianhao,addname,name,miaoshu,type,createname,addtime,fujian,fujianYuanshiming) values('"+bianhao+"','"+addname+"','"+name+"','"+miaoshu+"','"+type+"','"+createname+"','"+time+"','"+fujian+"','"+fujianYuanshiming+"') ";
  	  	
  	  	connDbBean.executeUpdate(sql);
  	  	out.print("<script>alert('添加成功!!');location.href='jsp/common/yingyong_add.jsp';</script>");
  	  
	}
 RS_result.close();


 %>
  </body>
</html>

