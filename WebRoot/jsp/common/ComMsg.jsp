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
  		String comno=new String(request.getParameter("comno").getBytes());
  		ComDaoImpl company=new ComDaoImpl();
  		TeaDaoImpl teacher=new TeaDaoImpl();
  		StuDaoImpl student=new StuDaoImpl();
  		Company c=company.findById(comno);
  		List<Student> studentlist=student.findByComId(comno);
  	 %>
    <div class="row">
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">研究团队信息</blockquote>
			<div class="layui-elem-quote layui-quote-nm">
				<h3>团队名称:<%=c.getName() %></h3>
				<p>团队编号:<%=c.getComNo() %></p>
				<p>研究计划:<%=c.getPlan() %></p>
				<p>团队简介:<%=c.getIntroduction() %></p>
			</div>
		</div>
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">带队导师信息</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
					<%
						if(c.getTeaNo().isEmpty())
						{
						
					%>
						<tr>
							<td>教工号</td>
							<td class="version"></td>
						</tr>
						<tr>
							<td>导师姓名</td>
							<td class="author"></td>
						</tr>
					<%
						}
						else
						{							
  							Teacher t=teacher.findById(c.getTeaNo());
  					%>
  							<tr>
								<td>教工号</td>
								<td class="version"><%=t.getTeaNo() %></td>
							</tr>
							<tr>
								<td>导师姓名</td>
								<td class="author"><%=t.getName() %></td>
							</tr>
					<%
						}
					 %>
				</tbody>
			</table>
			<blockquote class="layui-elem-quote title">学生队伍信息</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
			    <thead>
					<tr>
						<th>学号</th>
						<th>学生姓名</th>
						<th>专业信息</th>	
					</tr> 
			    </thead>
				<tbody>
				<%
					if(studentlist.size()>0){
					
						for(Student s:studentlist){
								
				%>
					<tr>
					<%
						out.println("<td>"+ s.getStuNo() +"</td>");
						out.println("<td>"+ s.getName() +"</td>");
						out.println("<td>"+ s.getMajor() +"</td>");
					 %>
					</tr>
				<%
						}
					}						
				 %>
				</tbody>
			</table>
		</div>
	<script type="text/javascript" src="../layui/layui.js"></script>
  </body>
</html>
