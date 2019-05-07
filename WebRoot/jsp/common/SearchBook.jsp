<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
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
			<form class="layui-form" action="Search" method="post">
		 <div class="layui-inline">
        <input class="layui-input" name="search" id="demoReload" autocomplete="off">
    	</div>
    	<button class="layui-btn" name="minsearchBook" data-type="reload">搜索</button>
		</div>
		
		<div class="layui-inline">
          </form>
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
		     <colgroup>
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="100">
				
				<col width="13%">
		    </colgroup>
		    <thead>
				<tr>					
					<th>书刊名</th>
					<th>出版日期</th>
					<th>书刊类型</th>
					
					<th>数量</th>
						
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">		   		
						<%	
						response.setContentType("text/html;charset=utf-8");
 						request.setCharacterEncoding("utf-8");
						String seach =request.getParameter("search");
							//NoticeDaoImpl notice=new NoticeDaoImpl();
							AdmDaoImpl ad=new AdmDaoImpl();								
							List<Book>	books=	ad.findAll(seach);
							if(books.size()>0){
								for(Book n:books){
									%>
									<tr>
									<%
										
										out.println("<td>"+ n.getName() +"</td>");
										out.println("<td>"+ n.getTime()+"</td>");
										out.println("<td>"+ n.getType()+"</td>");
										
										out.println("<td>"+ n.getNum()+"</td>");
											
									%>
										<td>
											<a class="layui-btn layui-btn-mini links_edit" href='jsp/common/seeBook.jsp?bookID=<%=n.getBookID()%>'>
												<i class="iconfont icon-edit"></i> 查看详情
											</a> 
	
										</td>
									</tr>
								<% }} %>				
								
									<tr>

		    </tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	
</body>
</html>