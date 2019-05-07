<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="utf-8">
	<title>报告填写--研究助手</title>
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
 	<blockquote class="layui-elem-quote news_search">
	填写报告
	</blockquote>
	<form class="layui-form"  action="AddServlet?stuno=<%=session.getAttribute("student")%> " method="post" >
		
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">主题</label>
				<div class="layui-input-inline">
					<input type="text" name="name" value=""class="layui-input "">
				</div>
			</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">接收者编号</label>
				<div class="layui-input-inline">
					<input type="text" name="teano" value=""class="layui-input "">
				</div>
			</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">时间</label>
				<div class="layui-input-inline">
					<input type="text" name="time" class="layui-input newsTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">报告内容</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide content" name="neirong" lay-verify="content" id="news_content"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddReport">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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