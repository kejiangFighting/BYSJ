<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.TeacherDAO" %>


<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<% 	response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
 		String t=null;
 		ServletContext sc = getServletConfig().getServletContext(); 
	   String email=sc.getAttribute("email").toString();
	  TeacherDAO teacher = new TeacherDAO();
	%>
    <div class="container">      
    <div>xuan</div>
    <div>xuan</div>
        <h5><b>当前位置</b>：实习公司管理> 选择公司</h5>
        <hr>
        <div>当前选择的公司:<%=teacher.getNewCompany(email)%></div>
        <div> 

   		 	<%=teacher.getCompany()%>
       </div>
</div>


</body>
</html>
