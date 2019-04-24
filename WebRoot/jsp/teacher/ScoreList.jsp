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
	<title>教师成绩管理</title>
	<base href="<%=basePath%>">
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
		ScoreDaoImpl score=new ScoreDaoImpl();
  		String hasCom=teacher.hasCom(teano);  //返回公司编号
	 %>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<a class="layui-btn " href="jsp/teacher/EnteringScore.jsp?teano=<%= teano %>">录入成绩</a>
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
					<th>总评成绩</th>
					<th>操作</th>
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
						<td><%=s.getStuNo() %></td>
						<td><%=s.getName() %></td>
						<td><%=s.getMajor() %></td>
				<%
						Score r=score.findById(s.getStuNo());
						if(r!=null)
						{
				%>
							
								<td><%=r.getPscore() %></td>
								<td><%=r.getTscore() %></td>
								<td><%=r.getScore() %></td>
				<%
						}
						else
						{
				%>
								<td></td>
								<td></td>
								<td></td>
				<%
						}
				%>
				
								<td>
									<a class="layui-btn layui-btn-mini " href="jsp/teacher/SingleEnteringScore.jsp?stuno=<%=s.getStuNo()  %>&teano=<%= teano %>">
										<i class="iconfont icon-edit"></i> 修改
									</a>
								</td>
								
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
					<td>暂无数据</td>
				</tr>
				<%	   
				}
				%>
			</tbody>
		</table>
	</div>
	</form>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>

</body>
</html>