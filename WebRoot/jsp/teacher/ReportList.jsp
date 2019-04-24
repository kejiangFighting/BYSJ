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
	<title>教师实习报告列表</title>
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
		ReportDaoImpl report=new ReportDaoImpl();
  		String hasCom=teacher.hasCom(teano);  //返回公司编号
	 %>
	<div class="layui-form links_list">
		<table class="layui-table">
			<colgroup>
				<col width="120">
				<col width="100">
				<col width="120">
				<col>
				<col width="120">
				<col width="13%">
			</colgroup>
			<thead>
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>专业</th>
					<th>实习报告</th>
					<th>提交时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="links_content">
				<%
				if(hasCom!=null)
				{
					List<Student> studentlist=student.findByComId(hasCom);
					for(Student s:studentlist){
						Report r=report.findById(s.getStuNo());
						if(r!=null)
						{
				%>
							<tr>
								<td><%=s.getStuNo() %></td>
								<td><%=s.getName() %></td>
								<td><%=s.getMajor() %></td>
								<td><%=r.getContent() %></td>
								<td><%=r.getTime() %></td>
								<td><a class="layui-btn layui-btn-mini" href="cyy1500330201.service/DownloadServlet?stuno=<%= s.getStuNo() %>"> <i class="iconfont icon-edit"></i> 下载 </a>
								</td>
							</tr>
				<%
						}
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