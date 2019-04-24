<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Dao.TeacherDAO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实习管理系统</title>
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../static/css/index.css" rel="stylesheet">
    <link href="../static/css/teacher.css" rel="stylesheet">
</head>
<body style="background:url('../image/3.jpg') no-repeat center;background-size:cover;">

    <%
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("../index.jsp");
        }
    %>

    <c:if test="${currentUser.role == 0}">
        <% response.sendRedirect("../admin/index.jsp"); %>
    </c:if>
    <c:if test="${currentUser.role == 2}">
        <% response.sendRedirect("../student/index.jsp"); %>
    </c:if>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">MANAGE-teacher</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="snotes.jsp">查看公告</a></li>
                    <li><a href="student.jsp">查看学生信息</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">实习公司管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Scompany.jsp">选择实习公司</a></li>
                            <li><a href="cancelcompany.jsp">取消公司选择</a></li>
                        </ul>
                         <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">实习报告管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Report.jsp">查看/下载报告</a></li>
                        </ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">消息管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Sendmessage.jsp">发送消息</a></li>
                            <li><a href="querrymessage.jsp">查看消息</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="changepasswd.jsp">密码修改</a></li>
                            <li><a href="changeinfo.jsp">个人信息修改</a></li>
                        </ul>
                    </li>
                         <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">成绩管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="score.jsp">查看成绩</a></li>
                             <li><a href="inputscore.jsp">录入成绩</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a>欢迎您，${currentUser.name}老师！</a></li>
                    <li><a href="../signout.jsp">【注销】</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
 
</body>
</html>
