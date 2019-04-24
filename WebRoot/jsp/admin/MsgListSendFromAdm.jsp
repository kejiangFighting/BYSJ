<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员已发消息</title>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="css/news.css" media="all" />
  </head>
  
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<a class="layui-btn" style="background-color:#5FB878" href="jsp/admin/AdmSendMsg.jsp">发送消息</a>
		</div>
		<div class="layui-inline">
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
	  	  <colgroup>
				<col width="80%">
				<col>
		    </colgroup>
		    <thead>
				<tr>
					<th>内容 </th>
					<th>接收者</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
		    			<%
							MsgDaoImpl message=new MsgDaoImpl();
							List<Message> msglist=message.findAllFromAdm();
							if(msglist.size()>0){
								for(Message m:msglist){
						 %>
									<tr>
									<%
										out.println("<td>"+ m.getContent() +"</td>");
										out.println("<td>"+ m.getUserNo() +"</td>");
									%>
									</tr>
								<% }} %>
		   			
		    </tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>
	
</body>
</html>