<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    
    <title>学生注册</title>
    
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
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                            		<p>请填写你的个人信息并进行注册:</p>
                        		</div>
                           		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="AddServlet" method="post" class="layui-form login-form">		           
			                    	<div class="form-group">
			                        	<input type="text" name="userno" placeholder="请输入你的学号" class="form-control"">
			                        </div>
			                        <div class="form-group">
			                        	<input type="text" name="name" placeholder="请输入你的姓名" class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
				                        <select name="major" lay-verify="required" lay-search="">
											<option value="">请选择你的专业信息</option>
											<option value="软件工程">软件工程</option>
											<option value="计算机科学与技术">计算机科学与技术</option>
											<option value="信息安全">信息安全</option>
											<option value="信息对抗技术">信息对抗技术</option>
											<option value="物联网工程">物联网工程</option>
											<option value="智能科学与技术">智能科学与技术</option>
											<option value="数字媒体技术">数字媒体技术</option>
											<option value="产品设计">产品设计</option>
											<option value="视觉传达设计">视觉传达设计</option>
											<option value="环境设计">环境设计</option>
											<option value="服装与服饰设计">服装与服饰设计</option>
											<option value="动画">动画</option>
											<option value="书法学">书法学</option>
											<option value="会计学">会计学</option>
											<option value="市场营销">市场营销</option>
											<option value="16">工业工程</option>
											<option value="工业工程">电子商务</option>
											<option value="财务管理">财务管理</option>
											<option value="人力资源管理">人力资源管理</option>
											<option value="金融工程">金融工程</option>
							        	</select>
							        </div>
						                        <div class="form-group">
			                        	<input type="password" name="psw" placeholder="请输入你的密码" class="form-password form-control" id="form-password">
			                        </div>
			                        <div class="form-group">
			                        	<input type="password" name="repsw" placeholder="请再次确认你的密码" class="form-password form-control">
			                        </div>
			                        <button type="submit" class="btn" name="StuRegister">注册</button>
			                        <div class="help">
			                        	<span><a href="jsp/Login.jsp">有账号，直接登录！</a></span>			                        	
			                        	<span><a href="jsp/common/TeaRegister.jsp">教师注册入口</a></span>
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
