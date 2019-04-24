<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.StudentDAO" %>


<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<% 	response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
 		
 		 StudentDAO studentDAO = new StudentDAO();
    String email=((User)session.getAttribute("currentUser")).getEmail() ; 
	  StudentDAO student = new StudentDAO();
	%>
    <div class="container">      

        <h5><b>当前位置</b>：实习公司管理> 选择公司</h5>
        <hr>
        <div>当前选择的公司:<%=student.getNewCompany(email)%></div>
        <div> 

   		 	<%=student.getCompany()%>
       </div>
</div>


</body>
</html>
