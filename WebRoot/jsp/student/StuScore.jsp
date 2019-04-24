<%@ page language="java" import="java.util.*,cyy1500330201.entity.*,kj.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>学生查看成绩</title>
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
 		String stuno=new String(request.getParameter("stuno").getBytes());
		StuDaoImpl student=new StuDaoImpl();
		ScoreDaoImpl score=new ScoreDaoImpl();
 	 %>
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
					<th>平时成绩</th>	
					<th>考核成绩</th>
					<th>总评成绩</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
		    	<%
		    		Student stu=student.findById(stuno);
		    		Score s=score.findById(stuno);
						if(s!=null)
						{
				%>
							<tr>
								<td><%=stu.getStuNo() %></td>
								<td><%=stu.getName() %></td>
								<td><%=s.getPscore() %></td>
								<td><%=s.getTscore() %></td>
								<td><%=s.getScore() %></td>
							</tr>
				<%
						}
						else
						{
				%>
							<tr>
								<td><%=stu.getStuNo() %></td>
								<td><%=stu.getName() %></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
				<%
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