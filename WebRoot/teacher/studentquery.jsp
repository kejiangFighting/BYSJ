<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="base.jsp"%>

<html>
  <head>
   
  </head>
  
  <body>
<div class="container">
<br>
<br>
      <h5><b>当前位置</b>：查看学生信息 >学生搜查</h5>
      <hr>
      <div>
        <% 
         response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
        String t=request.getParameter("school_num");
        TeacherDAO teacherDao = new TeacherDAO();%>
   		<%=teacherDao.searchStudent(t)%>
      </div>
      
  </div>

  </body>
</html>
