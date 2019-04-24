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
	<%
		String teano=new String(request.getParameter("teano").getBytes());		
  		TeaDaoImpl teacher=new TeaDaoImpl();
  		Teacher t=teacher.findById(teano);
	 %>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <a class="layui-btn" href="jsp/common/TeamMsg.jsp?teano=<%= teano %>">发送队伍消息</a>
		</div>
		<div class="layui-inline">
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
		     <colgroup>
				<col>
				<col>
				<col>
				<col>
		    </colgroup>
		    <thead>
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>专业</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">		   		
						<%
							if(t.getComNo().isEmpty() || t.getComNo().equals(""))
							{
						%>
							<tr>
								<td>暂无数据</td>
								<td>暂无数据</td>
								<td>暂无数据</td>
							</tr>
						<%
							}
							else
							{							
						  		StuDaoImpl student=new StuDaoImpl();
						  		List<Student> studentlist=student.findByComId(t.getComNo());
								if(studentlist.size()>0){
									for(Student s:studentlist){
						 %>
									<tr>
									<%
										out.println("<td>"+ s.getStuNo() +"</td>");
										out.println("<td>"+ s.getName() +"</td>");
										out.println("<td>"+ s.getMajor() +"</td>");		
									%>
										<td>
											<a class="layui-btn layui-btn-mini " href="jsp/common/autoSendMsg.jsp?userno=<%= s.getStuNo() %>&fromno=<%=teano %>">
												<i class="iconfont icon-edit"></i> 回复
										</td>
									</tr>
						<%		
									}
								}
							} 
						%>
		    </tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>
	
</body>
</html>