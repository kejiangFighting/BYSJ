<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <!-- CSS -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/form-elements.css">
        <link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="layui/css/layui.css">
        
    
    <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
        
    <!-- Javascript -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>
  </head>
  
  <body>
    <!-- Top content -->
        <div class="top-content">        	
            <div class="inner-bg">
                <div class="container">
                	<div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <p style="font-size:2em;">研究室资源管理系统</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                            		<p>请选择你的身份并输入账号密码进行登录:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="Login" method="post" class="layui-form login-form">
			                    	<div class="layui-form-item">
									    <div class="layui-input-block">
									      <input type="radio" name="roles" value="学生" title="学生" checked>
									      <input type="radio" name="roles" value="教师" title="教师">
									      <input type="radio" name="roles" value="管理员" title="管理员">
									    </div>
									</div>
			                    	<div class="form-group">
			                        	<input type="text" name="userNo" placeholder="UserNo..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="submit" class="btn">Sign in!</button>
			                        <div class="help">
			                        	<span><a href="jsp/common/TeaRegister.jsp">教师注 册</a></span>
			                        	<span><a href="jsp/common/StuRegister.jsp">学生注 册</a></span>
			                        </div>
			                    </form>
		                    </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
		<script src="layui/layui.js"></script>
		<script>
		//Demo
		layui.use('form', function(){
		  var form = layui.form;
		  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		</script>
    
  </body>
</html>
