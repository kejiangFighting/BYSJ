
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.TeacherDAO" %>
<%@ page import="Model.User" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container">
<br>
<br>
  <h5><b>当前位置</b>：消息管理 > 查看消息</h5>
  <hr>
  <div>
    <div><b>未读消息</b></div>
    <%String receiver=((User)session.getAttribute("currentUser")).getSchool_num();  %>
    <%String company=((User)session.getAttribute("currentUser")).getCompany();  %>
    <% TeacherDAO teacherDao = new TeacherDAO();%>
    <%=teacherDao.getMessages(receiver,company)%>
  </div>
  <div>
  <div><b>已读消息</b></div>
  <%=teacherDao.getReadMessages(receiver,company) %>
  </div>
  <div><b>已发消息</b></div>
  <%=teacherDao.AlreadySendMessages(receiver) %>
</div>


</body>
</html>
