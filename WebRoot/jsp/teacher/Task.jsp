<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>团队学生列表</title>
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
 		String ComNo="";
 		String teano=session.getAttribute("teacher").toString();
 		//获取团队编号
 		TeaDaoImpl teacher=new TeaDaoImpl();
 		Teacher tea=teacher.findById(teano);
 		ComNo=tea.getComNo();
 		//查询团队队员
 		StuDaoImpl student=new StuDaoImpl();
 		List<Student> stulist=student.findAll(ComNo);
 	 %>
 	 <blockquote class="layui-elem-quote">给研究团队成员分配任务！</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
	  	  <colgroup>
				<col width="120">
				<col width="200">
				<col width="220">
				<col width="220">
		
				<col width="20%">
		    </colgroup>
		    <thead>
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>团队编号</th>
					<th>带队导师</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
		    	<%
							if(stulist.size()>0){
								for(Student c:stulist){
									%>
									<tr>
									<%
										out.println("<td>"+ c.getStuNo() +"</td>");
										out.println("<td>"+ c.getName() +"</td>");
										out.println("<td>"+ c.getComNo() +"</td>");	
										out.println("<td>"+ tea.getName() +"</td>");
									%>
										<td>
											<a class="layui-btn layui-btn-mini " href="jsp/teacher/giveTask.jsp?teano=<%=teano%>&stuno=<%=c.getStuNo() %>">
												<i class="iconfont icon-edit"></i> 分配任务
											</a>
											
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='jsp/teacher/seeTask.jsp?stuno=<%=c.getStuNo() %>'>
												<i class="layui-icon">&#xe642;</i> 历史任务
											</a>
										</td>
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