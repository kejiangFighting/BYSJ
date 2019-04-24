
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.AdminDAO" %>
<%@ page import="Model.User" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container">
  <h5><b>当前位置</b>：消息管理 > 查看消息</h5>
  <hr>
  <div>
    <div><b>未读消息</b></div>
    <%String receiver=((User)session.getAttribute("currentUser")).getSchool_num();  %>
    <% AdminDAO adminDao = new AdminDAO();%>
    <%=adminDao.getMessages(receiver)%>
  </div>
  <div>
  <div><b>已读消息</b></div>
  <%=adminDao.getReadMessages(receiver) %>
  </div>
  <div><b>已发消息</b></div>
  <%=adminDao.AlreadySendMessages(receiver) %>
</div>


</body>
</html>
