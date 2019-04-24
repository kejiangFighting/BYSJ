<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="base.jsp"%>

<html>
  <head>
   
  </head>
  
  <body>
<div class="container">
      <h5><b>当前位置</b>：用户管理 >查询用户</h5>
      <hr>
      <div>
        <% 
         response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
        String t=request.getParameter("school_num");
        AdminDAO adminDao = new AdminDAO();%>
   		<%=adminDao.getUser(t)%>
      </div>
      
  </div>

  </body>
</html>
