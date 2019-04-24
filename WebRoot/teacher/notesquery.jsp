<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="base.jsp"%>
<%@page import= "Dao.TeacherDAO"%>
<html>
  <head>
   
  </head>
  
  <body>
<div class="container">
      <h5><b>当前位置</b>：查看公告></h5>
      <hr>
      <div>
        <% 
         response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
 		String t=request.getParameter("notes_name");
        TeacherDAO teacher = new TeacherDAO();%>
   			 <%=teacher.getNotes(t)%>
      </div>
      
  </div>

  </body>
</html>
