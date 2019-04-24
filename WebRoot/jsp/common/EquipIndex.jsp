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
  		String equipID=new String(request.getParameter("equipID").getBytes());
  		EquipDaoImpl equip=new EquipDaoImpl();
  		Equip n=equip.findById(equipID);
  	                                                                    
  	 %>
    <div class="row">
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title"><%=n.getEquipID() %></blockquote>
			<div class="layui-elem-quote layui-quote-nm">
				<p>设备名称:<%=n.getName()%>  设备厂商:<%=n.getManufacturer() %> 设备类型:<%=n.getType() %></p>
				<p style="text-align:left;"><%=n.getSpecification() %></p>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../layui/layui.js"></script>
  </body>
</html>
