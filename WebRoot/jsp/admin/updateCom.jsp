<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
	<title>修改团队信息--研究室助手</title>
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
 		String comid=new String(request.getParameter("comid").getBytes()); 
 		ComDaoImpl company=new ComDaoImpl();
 		Company c=company.findById(comid);
 	%>
	<form class="layui-form" method="post"  action="update?comNo=<%=c.getComNo() %>" >
		<div class="layui-form-item">
			<label class="layui-form-label">团队编号</label>
			<div class="layui-input-block">
				<input type="text"  class="layui-input " disable lay-verify="required" value="<%=c.getComNo() %>">
			</div>
		</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">团队名称</label>
				<div class="layui-input-inline">
					<input type="text" name="name"  class="layui-input newsAuthor "placeholder="请输入公司名称" lay-verify="required" value="<%=c.getName() %>">
				</div>
			</div>
			
		<div class="layui-form-item">
			<label class="layui-form-label">研究计划</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入实习计划" name="plan" class="layui-textarea" lay-verify="required"><%=c.getPlan() %></textarea>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">团队简介</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide content" name="intro" lay-verify="content" id="news_content" lay-verify="required"><%=c.getIntroduction() %></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="updateCom">更新提交</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript">
		layui.config({
		base : "js/"
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