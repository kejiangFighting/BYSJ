<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/signin.css" rel="stylesheet">
    <link href="/static/css/index.css" rel="stylesheet">
    <link href="/static/css/admin.css" rel="stylesheet">
  </head>
  
  <body>
  <h2>高校生产实习管理系统注册</h2>
     <div class="container"> 
        <div class="useradd">
            <form action="register" method="post" class="useraddf">
                <div>
                    <label>学号</label>
                    <input type="text" name="school_num"/>
                </div>
                <div>
                    <label>姓名</label>
                    <input type="text" name="name"/>
                </div>
                <div>
                    <label>学院</label>
                    <input type="text" name="school"/>
                </div>
                <div>
                    <label>专业</label>
                    <input type="text" name="major"/>
                </div>
       
                <div>
                    <label>邮箱</label>
                    <input type="text" name="email"/>
                </div>
                <div>
                    <label>密码</label>
                    <input type="password" name="password"/>
                </div>
                <div>
                    <label>角色</label>
               <input type="text" name="role" placeholder="如： 管理员：0;老师：1;学生：2"/>
                                                                        
                </div>
               
                <div>
                    <label>性别</label>
                    <input type="text" name="sex"/>
                </div>
                <div>
                    <label style="padding-left: 6px">QQ</label>
                    <input type="text" name="qq"/>
                </div>
                <div>
                    <label>电话</label>
                    <input type="text" name="phone"/>
                </div>
                <div>
                    <label>住址</label>
                    <input type="text" name="adress"/>
                </div>
                <div style="padding-top: 15px">
                    <button type="submit" class="btn btn-primary">添加</button>
                    <button type="reset" class="btn btn-warning">重置</button>
                </div>
            </form>
        </div>
    </div> <
  </body>
</html>
