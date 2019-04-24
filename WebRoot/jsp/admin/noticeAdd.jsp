<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>添加公告</title>
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
	<form class="layui-form"  action="AddServlet" method="post" >
		<div class="layui-form-item">
			<label class="layui-form-label">公告编号</label>
			<div class="layui-input-block">
				<input type="text" name="noticeNo" class="layui-input " lay-verify="required" placeholder="请输入公告编号">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">公告标题</label>
			<div class="layui-input-block">
				<input type="text" name="title" class="layui-input newsName " lay-verify="required" placeholder="请输入公告标题">
			</div>
		</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">文章作者</label>
				<div class="layui-input-inline">
					<input type="text" name="name"  class="layui-input newsAuthor "placeholder="请输入发布人姓名">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">发布部门</label>
				<div class="layui-input-inline">
					<input type="text" name="department"  class="layui-input " lay-verify="required" placeholder="请输入发布部门">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">发布时间</label>
				<div class="layui-input-inline">
					<input type="text" name="time" class="layui-input newsTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">公告内容</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide content" name="content" lay-verify="content" id="news_content"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddNotice">立即提交</button>
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
	
		//鍒涘缓涓�釜缂栬緫鍣� 	
		var editIndex = layedit.build('news_content');
	
})
	</script>
</body>
</html>