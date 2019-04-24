<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>教师信息修改--研究室助手</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
  </head>
  
 <body class="childrenBody">
 	<%
 		String teaid=new String(request.getParameter("teaid").getBytes()); 
 		TeaDaoImpl teacher=new TeaDaoImpl();
 		Teacher t=teacher.findById(teaid);
 	%>
	<form class="layui-form" method="post" action="updateServlet?teano=<%=t.getTeaNo()%>">
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">教工号</label>
				<div class="layui-input-inline">
					<input type="text"  disabled="true"   class="layui-input newsAuthor "  value="<%=t.getTeaNo() %>" placeholder="请输入发布人姓名">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">教师姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="name"  class="layui-input "  value="<%=t.getName() %>" lay-verify="required" placeholder="请输入发布部门">
				</div>
			</div>		
			<div class="layui-inline">		
				<label class="layui-form-label">研究团队</label>
				<div class="layui-input-inline">
					<input type="text" name="comno"  class="layui-input "  value="<%=t.getComNo() %>" placeholder="请输入实习公司编号">
				</div>
			</div>
			
			<div class="layui-inline">		
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="text" name="teapsw"  class="layui-input "  value="<%=t.getPassword() %>" lay-verify="required" placeholder="请输入发布部门">
				</div>
			</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="updateTea">更改提交</button>
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