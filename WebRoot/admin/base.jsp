<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Dao.AdminDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高校实习管理系统</title>
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../static/css/index.css" rel="stylesheet">
    <link href="../static/css/admin.css" rel="stylesheet">
</head>
<body style="background:url('../image/3.jpg') no-repeat center;background-size:cover;">

    <%
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("../index.jsp");
        }
    %>
    <c:if test="${currentUser.role == 1}">
        <% response.sendRedirect("../teacher/index.jsp"); %>
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
                <a class="navbar-brand" href="#">MANAGE-admin</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="useradd.jsp">添加用户（批量）</a></li>
                            <li><a href="users.jsp">查看用户（修改-公司）</a></li>

                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">公告管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="notesadd.jsp">添加公告</a></li>
                            <li><a href="notes.jsp">查看公告</a></li>
                            
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">实习公司管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="companyadd.jsp">添加实习公司</a></li>
                            <li><a href="company.jsp">实习公司（修改查找删除）</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">消息管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="sendmessage.jsp">发送消息</a></li>
                            <li><a href="querymessage.jsp">查看消息</a></li>
                        </ul>
                    </li>
                    <li><a href="changepasswd.jsp">修改密码</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">查看成绩 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="smajor.jsp">按专业查询</a></li>
                            <li><a href="score.jsp">所有学生</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a>欢迎您：${currentUser.name}！</a></li>
                    <li><a href="../signout.jsp">【注销】</a></li>
                </ul>
            </div>
        </div>
    </nav>


    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>
