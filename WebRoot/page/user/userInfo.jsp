<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<meta charset="utf-8">
	<title>个人资料</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/user.css" media="all" />
</head>
<body class="childrenBody">

    
	<form class="layui-form" action="../../userupdate" method="post">
		<div class="user_left">
			<div class="layui-form-item">
			    <label class="layui-form-label">用户名</label>
			    <div class="layui-input-block">
			    	<input type="text" name="name" value="${currentUser.name}" disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">编号</label>
			    <div class="layui-input-block">
			    	<input type="text" name="userID"value="${currentUser.userID}" disabled class="layui-input layui-disabled">
			    </div>
			    <div class="layui-input-block">
			    	<p hidden><input type="tel" name="userID" value="${currentUser.userID}" placeholder="" lay-verify="required|text" class="layui-input">
			    	</p>
			    </div>
			</div>	
			<div class="layui-form-item">
			    <label class="layui-form-label">手机号码</label>
			    <div class="layui-input-block">
			    	<input type="tel" name="phone" value="${currentUser.phone}" placeholder="请输入手机号码" lay-verify="required|phone" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">学院</label>
			    <div class="layui-input-block">
			    	<input type="text" name="college"value="${currentUser.college}" placeholder="请输入学院" lay-verify="required|text" class="layui-input">
			    </div>
			</div>
				<div class="layui-form-item">
			    <label class="layui-form-label">研究团队</label>
			    <div class="layui-input-block">
			    	<input type="tel" name="team"value="${currentUser.team}" placeholder="请输入加入的研究团队" lay-verify="required|text" class="layui-input">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">专业</label>
			    <div class="layui-input-block">
			    	<input type="tel"name="major" value="${currentUser.major}" placeholder="请输入专业" lay-verify="required|text" class="layui-input">
			    </div>
			</div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">邮箱</label>
			    <div class="layui-input-block">
			    	<input type="text" name="email"value="${currentUser.email}" placeholder="请输入邮箱" lay-verify="required|email" class="layui-input">
			    </div>
			</div>
			
		</div>
		
		<div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="address.js"></script>
	
</body>
</html>