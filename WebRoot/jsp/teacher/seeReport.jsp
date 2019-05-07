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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="css/notice.css" media="all" />

  </head>
  
  <body>
  
  	<%	
  	String pingyu=null;
  		String reportID=new String(request.getParameter("ID").getBytes());
  		StuDaoImpl stuDaoImpl=new StuDaoImpl();
  		Report n=stuDaoImpl.findReport(reportID);
  		  	 %>
    <div class="row">
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">任务标题：<%=n.getName()%></blockquote>
			<div class="layui-elem-quote layui-quote-nm">
				<p>编写人编号:<%=n.getStuNo()%>  接收者编号:<%=n.getTeaNO()%> 时间:<%=n.getTime() %></p>
				<p style="text-align:left;"><%=n.getNeirong() %></p>
				
			</div>
			
			<%if(n.getPingyu()==null){%>
	<form class="layui-form" action="update" methon="post">
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">点评</label>
    <div class="layui-input-block">
      <textarea name="pingyu" placeholder="请输入点评内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <input type="hidden" name="name" value="<%=n.getNeirong()%>"/>
  <button class="layui-btn"name="updatePingyu">提交</button>
  	<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</form>	
			
			<%}else{%>
			<div style="text-align:left;color:red">导师评语：
			<%=n.getPingyu() %>
		<% 	}%>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../layui/layui.js"></script>
  </body>
</html>
