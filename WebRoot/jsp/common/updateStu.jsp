<%@ page language="java"
	import="java.util.*,Model.*,util.*"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>学生信息修改</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
</head>

<body class="childrenBody">
	<%
 		String stuid=new String(request.getParameter("stuid").getBytes()); 
 		StuDaoImpl student=new StuDaoImpl();
 		Student s=student.findById(stuid);
 	%>
	<form class="layui-form" method="post"
		action="update?stuno=<%=s.getStuNo()  %>">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">学生编号</label>
				<div class="layui-input-inline">
					<input type="text" disabled="true" class="layui-input newsAuthor "
						value="<%=s.getStuNo() %>">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" class="layui-input "
						value="<%=s.getName() %>" lay-verify="required">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">专业</label>
				<div class="layui-input-inline">
					<select name="major" lay-verify="required" lay-search="">
						<option value=""><%=s.getMajor() %></option>
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
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">研究团队</label>
				<div class="layui-input-inline">
					<input type="text" name="comno" class="layui-input "
						value="<%=s.getComNo() %>" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="text" name="stupsw" class="layui-input "
						value="<%=s.getPassword() %>" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="addNews"
						type="submit" name="updateStu">更改提交</button>
				</div>
			</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript">
		layui.config({
		base : "../../js/"
	}).use(['form','layer','jquery','layedit','laydate'],function(){
		var form = layui.form(),
			layer = parent.layer === undefined ? layui.layer : parent.layer,
			laypage = layui.laypage,
			layedit = layui.layedit,
			laydate = layui.laydate,
			$ = layui.jquery;
	
		
		var editIndex = layedit.build('news_content');
	
})
	</script>
</body>
</html>