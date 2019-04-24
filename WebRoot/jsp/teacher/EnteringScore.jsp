<%@ page language="java"
	import="java.util.*,cyy1500330201.entity.*,kj.util.*"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>教师录入成绩</title>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="css/news.css" media="all" />

</head>

<body class="childrenBody">
	<%
		String teano=new String(request.getParameter("teano"));		
  		TeaDaoImpl teacher=new TeaDaoImpl();
		StuDaoImpl student=new StuDaoImpl();
		ReportDaoImpl report=new ReportDaoImpl();
  		String hasCom=teacher.hasCom(teano);  //返回公司编号
	 %>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<a class="layui-btn" href="jsp/teacher/ScoreList.jsp?teano=<%= teano %>">查看成绩单</a>
		</div>
		<div class="layui-inline">
	</blockquote>
	<form class="layui-form"  action="cyy1500330201.service/updateServlet" method="post" >
	<div class="layui-form links_list">
		<table class="layui-table">
			<colgroup>
				<col>
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
					<th>平时成绩</th>
					<th>考核成绩</th>
				</tr>
			</thead>
			<tbody class="links_content">
				<%
				if(hasCom!=null)
				{
					List<Student> studentlist=student.findByComId(hasCom);
					for(Student s:studentlist){
				%>
							<tr>
								<td><input type="text" readonly="readonly" name="StuNo" class="layui-input " lay-verify="required" value="<%=s.getStuNo() %>"></td>
								<td><%=s.getName() %></td>
								<td><%=s.getMajor() %></td>
								<td><input type="text" name="pscore" class="layui-input " lay-verify="required"></td>
								<td><input type="text" name="tscore" class="layui-input " lay-verify="required"></td>
							</tr>
				<%
					}
				}
				else
				{
				%>
				<tr>
					<td>暂无数据</td>
					<td>暂无数据</td>
					<td>暂无数据</td>
					<td>暂无数据</td>
					<td>暂无数据</td>
				</tr>
				<%	   
				}
				%>
			</tbody>
		</table>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="EnterScore">立即提交</button>
		    </div>
		</div>
	</div>
	</form>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>

</body>
</html>