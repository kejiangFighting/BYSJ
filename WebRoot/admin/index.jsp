<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body style="background:url('../image/2.jpg') no-repeat center;background-size:cover;">
<br>
  <div class="container">
    <div class="page-header">
   
  
  
<%  response.setContentType("text/html;charset=utf-8");
 	request.setCharacterEncoding("utf-8");
	int n=0; 
	String count=(String)application.getAttribute("counter");%>
	
	<% 
	 if(count!=null) 
	 n=Integer.parseInt(count); 
	 if(session.isNew()) ++n; 
	 out.print("<h5 id='master' >"+"您是第" +(n+1)+"位访客!"+"</h3>");
	 count=String.valueOf(n); 
	 application.setAttribute("counter",count); %>
<style type="text/css" >
 #master {
      position:absolute;
      left:50%;
      bottom:0;
      text-align :center;
      color: red;
        }
 </style>
</body>
</html>
