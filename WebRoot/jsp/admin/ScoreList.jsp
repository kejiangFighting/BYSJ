<%@ page language="java" import="java.util.*,cyy1500330201.entity.*,kj.util.*"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员学生成绩查看</title>
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
		StuDaoImpl student=new StuDaoImpl();
		ScoreDaoImpl score=new ScoreDaoImpl();
	 %>
	 <form class="layui-form"  action="cyy1500330201.service/SelectServlet" method="post" >
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">			
		    <div class="layui-input-inline">
		    	<input type="text" value="" name="major" class="layui-input search_input">
		    </div>
			<button class="layui-btn"  type="submit" name="SelectScoreByMajor">按专业查询</button>
		</div>
	</blockquote>
	</form>
		<div class="layui-form links_list">
			<table class="layui-table">
				<colgroup>
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
					</tr>
				</thead>
				<tbody class="links_content">
					<%
					List<Student> studentlist=student.findAll();
					for (Student stu:studentlist){
					%>
					<tr>
						<td><%=stu.getStuNo() %></td>
						<td><%=stu.getName() %></td>
						<td><%=stu.getMajor() %></td>
					<%
						Score s=score.findById(stu.getStuNo());
						if(s!=null)
						{
					%>
							<td><%=s.getPscore() %></td>
							<td><%=s.getTscore() %></td>
							<td><%=s.getScore() %></td>
						</tr>
					<%
						}
						else
						{
					%>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					<%
						}
					}
				%>
				</tbody>
			</table>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>

</body>
</html>