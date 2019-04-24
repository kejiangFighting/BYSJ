<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="base.jsp"%>

<html>
  <head>
   
  </head>
  
  <body>
<div class="container">
      <h5><b>当前位置</b>：公告管理 > 查看公告>查看结果</h5>
      <hr>
      <div>
        <% 
         response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
        String t=request.getParameter("notes_name");
        AdminDAO adminDao = new AdminDAO();%>
   			 <%=adminDao.getNotes(t)%>
      </div>
      
  </div>

  </body>
</html>
