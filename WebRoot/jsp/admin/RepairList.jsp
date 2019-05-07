<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>报修情况</title>
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
		    	<input type="text" value=""  class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn">查询</a>
		</div>
		
		<div class="layui-inline">
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
	  	  <colgroup>
				<col width="100">
				<col width="100">
				<col>
				<col width="150">
				<col width="150">
				<col width="200">
		    </colgroup>
		    <thead>
				<tr>
					
					<th>报修人员</th>
					<th>报修设备</th>
					<th>报修描述</th>	
					<th>报修时间</th>
					<th>报修状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
		    			<%	
		    				EquipDaoImpl equ=new EquipDaoImpl();
		    				List<Repair> reList=equ.findRepairAll();
						
							if(reList.size()>0){
								for(Repair c:reList){
						%>
									<tr>
										
									<%
										out.println("<td>"+ c.getUserID()+"</td>");
										out.println("<td>"+ c.getEquipID() +"</td>");
										out.println("<td>"+ c.getDescribe() +"</td>");	
										out.println("<td>"+ c.getTime() +"</td>");
										out.println("<td>"+ c.getStatus() +"</td>");	
									%>
										<td>
											<a class="layui-btn layui-btn-mini links_edit"  href='update?repairID=<%=c.getEquipID() %>'>
												<i class="iconfont icon-edit"></i> 设备修复
											</a>
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='DeleteUserServlet?repairID=<%=c.getEquipID() %>'>
												<i class="layui-icon">&#xe640;</i> 删除记录
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