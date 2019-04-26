<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>登记资料</title>
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
			<label class="layui-form-label">书刊号</label>
			<div class="layui-input-block">
				<input type="text" name="bookID" class="layui-input " lay-verify="required" placeholder="请输入设备编号">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">书刊名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" class="layui-input newsName " lay-verify="required" placeholder="请输入设备名称">
			</div>
		</div>
		 <div class="layui-form-item">
			<div class="layui-inline">		
				<label class="layui-form-label">书刊类型</label>
				 <div class="layui-input-block">
				 <select name="type" lay-verify="required">
        <option value=""></option>
        <option value="图书">图书</option>
        <option value="期刊">期刊</option>
        <option value="其它">其它</option>
      
      </select>
			</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">出版时间</label>
				<div class="layui-input-inline">
					<input type="text" name="time" class="layui-input newsTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
			
			<div class="layui-inline">		
				<label class="layui-form-label">书刊数量</label>
				<div class="layui-input-inline">
					<input type="text" name="num"  class="layui-input " lay-verify="required" placeholder="请输入书刊数量">
				</div>
			</div>

		<div class="layui-form-item">
			<label class="layui-form-label">书刊简介</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide content" name="introdu" lay-verify="content" id="news_content"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddBook">立即提交</button>
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