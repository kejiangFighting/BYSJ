<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>

<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.DriverManager"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>设备管理</title>
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
  <%
  	response.setContentType("text/html;charset=utf-8");
 	request.setCharacterEncoding("utf-8");

   	String url = "jdbc:mysql://localhost:3306/sc?"
            + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection connection=DriverManager.getConnection(url);
	Statement statement = connection.createStatement();
	//每页显示记录数
	int PageSize = 8;
	int StartRow = 0; //开始显示记录的编号 
	int PageNo=0;//需要显示的页数
	int CounterStart=0;//每页页码的初始值
	int CounterEnd=0;//显示页码的最大值
	int RecordCount=0;//总记录数;
	int MaxPage=0;//总页数
	int PrevStart=0;//前一页
	int NextPage=0;//下一页
	int LastRec=0; 
	int LastStartRecord=0;
	
	if(request.getParameter("PageNo")==null){ //如果为空，则表示第1页
	if(StartRow == 0){
		PageNo = StartRow + 1; //设定为1
	}
	}else{
		PageNo = Integer.parseInt(request.getParameter("PageNo")); //获得用户提交的页数
		StartRow = (PageNo - 1) * PageSize; //获得开始显示的记录编号
		}
	//设置显示页码的初始值!!
	if(PageNo % PageSize == 0){
		CounterStart = PageNo - (PageSize - 1);
	}else{
			CounterStart = PageNo - (PageNo % PageSize) + 1;
			}
	CounterEnd = CounterStart + (PageSize - 1);
	%>
	
	<%
	//获取总记录数
	ResultSet rs = statement.executeQuery("select count(*) from equip_tb" ); 
	rs.next(); 
	RecordCount = rs.getInt(1); 
	rs = statement.executeQuery("SELECT* FROM equip_tb  ORDER BY EquipID DESC LIMIT "+StartRow+", "+PageSize);
	//获取总页数
	MaxPage = RecordCount % PageSize;
	if(RecordCount % PageSize == 0){
		MaxPage = RecordCount/PageSize;
	}else{
		MaxPage = RecordCount/PageSize+1;
	}
	%>
<body class="childrenBody">
<blockquote class="layui-elem-quote news_search">
		
	<form class="layui-form" action="Search" method="post">
		 <div class="layui-inline">
        <input class="layui-input" name="search" id="demoReload" autocomplete="off">
    	</div>
    	<button class="layui-btn" name="AdminsearchEquip" data-type="reload">搜索</button>
		</div>
		<div class="layui-inline">
			<a class="layui-btn noticeAdd_btn" style="background-color:#5FB878" href="jsp/admin/equipAdd.jsp">添加设备</a>
		</div>
		<div class="layui-inline">
          </form>
    </div>
   
	</blockquote>

	<div class="layui-form links_list">
	  	<table class="layui-table">
		     <colgroup>
				<col width="100">
				<col width="300">
				<col>
				<col>
				<col>
				<col width="13%">
		    </colgroup>
		    <thead>
				<tr>
					 <th>序号</th>
	    <th>设备编号</th>
	    <th>设备名称</th>
	    <th>生产厂商</th>
	    <th>设备类型</th>
	    <th>设备状态</th>
	    <th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="links_content">
		    <%
	int i = 1;
	while (rs.next()) {
	int bil = i + (PageNo-1)*PageSize;
	%>
	
	<tr>
	<td><%=bil %></td>
	<td><%=rs.getString("EquipID")%></td>
	<td><%=rs.getString("Name") %></td>	
	<td><%=rs.getString("Manufacturer")%></td>
	<td><%=rs.getString("Type") %></td>
	<td><%=rs.getString("Status") %></td>
	<td>
	<a class="layui-btn layui-btn-mini links_edit" href='jsp/admin/updateEquip.jsp?equipID=<%=rs.getString("EquipID")%>'>
												<i class="iconfont icon-edit"></i> 编辑
											</a> 
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='DeleteUserServlet?equipID=<%=rs.getString("EquipID")%>'>
												<i class="layui-icon">&#xe640;</i> 删除
											</a>
	</td>
   
						<%
	i++;
	}%>
	
	</tbody>
	</table>
	</div>
	<br>
	<table width="100%" border="0" class="InternalHeader">
	<tr>
	<td><div align="center">
	<%
	out.print("<font size=4>");
	//显示第一页或者前一页的链接
	//如果当前页不是第1页，则显示第一页和前一页的链接
	if(PageNo != 1){
	PrevStart = PageNo - 1;
	out.print("<a href=jsp/admin/Report.jsp?PageNo=1>第一页 </a>: ");
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+PrevStart+">前一页</a>");
	}
	out.print("[");
	//打印需要显示的页码
	for(int c=CounterStart;c<=CounterEnd;c++){
	if(c <MaxPage){
	if(c == PageNo){
	if(c %PageSize == 0){
	out.print(c);
	}else{
	out.print(c+" ,");
	}
	}else if(c % PageSize == 0){
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+c+">"+c+"</a>");
	}else{
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+c+">"+c+"</a> ,");
	}
	}else{
	if(PageNo == MaxPage){
	out.print(c);
	break;
	}else{
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+c+">"+c+"</a>");
	break;

	}
	}
	}
	out.print("]");;
	if(PageNo < MaxPage){ //如果当前页不是最后一页，则显示下一页链接
	NextPage = PageNo + 1;
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+NextPage+">下一页</a>");
	}
	//同时如果当前页不是最后一页，要显示最后一页的链接
	if(PageNo < MaxPage){
	LastRec = RecordCount % PageSize;
	if(LastRec == 0){
	LastStartRecord = RecordCount - PageSize;
	}
	else{
	LastStartRecord = RecordCount - LastRec;
	}
	out.print(":");
	out.print("<a href=jsp/admin/Report.jsp?PageNo="+MaxPage+">最后一页</a>");
	}
	out.print("</font>");
	%>
	</div>
	</td>
	</tr>
	
	</table>
	<%
	rs.close();
	statement.close();
	connection.close();
	%>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/NoticeList.js"></script>
	
</body>
</html>