<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>查看预约</title>
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
   <%String user=null;
 if(session.getAttribute("student")==null){
 	if(session.getAttribute("teacher")==null){
 	user="root";
 	}else{
 	user=session.getAttribute("teacher").toString();
 	}
 	}
 else{
 	user=session.getAttribute("student").toString();
 }
 %>
<body class="childrenBody">
	<blockquote class="layui-elem-quote">预约情况                       （ 注意：取消预约前需联系预约人，告知情况！）</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="110">
				<col>
				<col width="300">
				<col>
			
				<col width="15%">
		    </colgroup> 
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>日期</th>
					<th>学号</th>
					<th>主题</th>
					<th>时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">		   		
						<%	//先查出今日之后的链表显示，再查出今日之前的链表显示
							AdmDaoImpl ad=new AdmDaoImpl();
 							List<Meeting> meetingList=ad.getMeeting();

							if(meetingList.size()>0){
								for(Meeting n:meetingList){
									%>
									<tr>
										<td>
											<input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose">
										</td>
									<%	
										out.println("<td>"+ n.getTime() +"</td>");
										out.println("<td>"+ n.getUserID()+"</td>");
										out.println("<td>"+ n.getTitle()+"</td>");
										out.println("<td>"+n.getStartTime() +"~"+n.getEndTime() +"</td>");
									
										out.println("<td>"+ n.getStatus() +"</td>");												
									%>
										<td>
											<a class="layui-btn layui-btn-mini links_edit" href='jsp/common/seeMeeting.jsp?userid=<%=n.getUserID() %>'>
												<i class="iconfont icon-edit"></i> 查看
											</a> 
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='update?MeetingID=<%=n.getID() %>'>
												<i class="layui-icon">&#xe642;</i> 取消
											</a>
										</td>
									</tr>
								<% }} %>
				<%
				List<Meeting> List=ad.getOldMeeting();
				if(List.size()>0){
				for(Meeting n:List){
					%>
					<tr>
						<td>
							<input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose">
						</td>
					<%
						out.println("<td>"+ n.getTime() +"</td>");
						out.println("<td>"+ n.getUserID()+"</td>");
						out.println("<td>"+ n.getTitle()+"</td>");
						out.println("<td>"+n.getStartTime() +"~"+n.getEndTime() +"</td>");
					
						out.println("<td>"+ n.getStatus() +"</td>");												
					%>
						<td>
							<a class="layui-btn layui-btn-mini links_edit" href='jsp/common/seeMeeting.jsp?userid=<%=n.getUserID() %>'>
								<i class="iconfont icon-edit"></i> 查看
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