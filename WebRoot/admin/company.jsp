
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.AdminDAO" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container">
  <h5><b>当前位置</b>：实习公司管理 > 公司查看</h5>
  <hr>
  <div>
  <div>
	<form action="../admin/companyquery.jsp" method="post">
     	 <label>公司搜索</label>
          <input type="text" name="company_name" id="company_name" placeholder=""/>
          <input type="submit" value="搜索">
          </form>
    </div>
    <% AdminDAO adminDao = new AdminDAO();%>
    <%=adminDao.getCompany()%>
    
  </div>
</div>


</body>
</html>
