<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>添加设备</title>
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
			<label class="layui-form-label">设备编号</label>
			<div class="layui-input-block">
				<input type="text" name="equipID" class="layui-input " lay-verify="required" placeholder="请输入设备编号">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">设备名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" class="layui-input newsName " lay-verify="required" placeholder="请输入设备名称">
			</div>
		</div>
		 <div class="layui-form-item">
			<div class="layui-inline">		
				<label class="layui-form-label">设备类型</label>
				 <div class="layui-input-block">
				 <select name="type" lay-verify="required">
        <option value=""></option>
        <option value="重点设备">重点设备</option>
        <option value="主要设备">主要设备</option>
        <option value="一般设备">一般设备</option>
      
      </select>
			</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">生产厂商</label>
				<div class="layui-input-inline">
					<input type="text" name="manufacture"  class="layui-input newsAuthor "placeholder="请输入厂商">
				</div>
			</div>
			
			<div class="layui-inline">		
				<label class="layui-form-label">设备状态</label>
				<div class="layui-input-inline">
					<input type="text" name="status"  class="layui-input " lay-verify="required" placeholder="请输入设备状态">
				</div>
			</div>

		<div class="layui-form-item">
			<label class="layui-form-label">设备规格</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide content" name="specification" lay-verify="content" id="news_content"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddEquip">立即提交</button>
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