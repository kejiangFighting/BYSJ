<%@ page import="Model.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <h5><b>当前位置</b>：成绩查询</h5>
    <hr>
    <div>
      <% StudentDAO studentDAO = new StudentDAO();%>
     <%String num=((User)session.getAttribute("currentUser")).getSchool_num() ;%>  
      <%=studentDAO.getScore(num)%>
    </div>
  </div>

</body>
</html>
