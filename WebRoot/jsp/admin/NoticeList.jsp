<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员公告管理</title>
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
		    <div class="layui-input-inline">
		    	<input type="text" value=""class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn noticeAdd_btn" style="background-color:#5FB878" href="jsp/admin/noticeAdd.jsp">添加公告</a>
		</div>
		<div class="layui-inline">
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
		     <colgroup>
				<col width="50">
				<col width="100">
				<col>
				<col width="300">
				<col>
				<col>
				<col>
				<col width="13%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>公告编号</th>
					<th>公告标题</th>
					<th>公告内容</th>
					<th>发布人</th>
					<th>发布部门</th>
					<th>发布时间</th>		
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">		   		
						<%
							NoticeDaoImpl notice=new NoticeDaoImpl();
							
							List<Notice> noticelist=notice.findAll();
							if(noticelist.size()>0){
								for(Notice n:noticelist){
									%>
									<tr>
										<td>
											<input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose">
										</td>
									<%
										out.println("<td>"+ n.getNoticeNo() +"</td>");
										out.println("<td>"+ n.getTitle() +"</td>");
										out.println("<td>"+ n.getContent() +"</td>");
										out.println("<td>"+ n.getName() +"</td>");
										out.println("<td>"+ n.getDepartment() +"</td>");
										out.println("<td>"+ n.getTime() +"</td>");		
									%>
										<td>
											<a class="layui-btn layui-btn-mini links_edit" href='jsp/admin/updateNotice.jsp?noticeid=<%=n.getNoticeNo() %>'>
												<i class="iconfont icon-edit"></i> 编辑
											</a>
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='DeleteUserServlet?noticeid=<%=n.getNoticeNo() %>'>
												<i class="layui-icon">&#xe640;</i> 删除
											</a>
										</td>
									</tr>
								<% }} %>
		    </tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	
</body>
</html>