<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="Dao.TeacherDAO" %>
<%@include file="base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
 

  </head>
  
  <body>
  
  <% response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
 		String t=null;
 		ServletContext sc = getServletConfig().getServletContext(); 
	   String email=sc.getAttribute("email").toString();
	  TeacherDAO teacher = new TeacherDAO();
	 t=teacher.getNewCompany(email);%>
	   
	
         
   <div class="container">
   <div>1</div>
   <div>2</div>
  
  	 当前选择的公司:<%=teacher.getNewCompany(email)%>
    <h5><b>当前位置</b>：实习公司管理> 取消公司选择</h5>
 		    <div class="companysel">
            <form  action="../companysel" method="post">
            <table>
              <div>
                    <label style="padding-left: 28px">当前用户为：</label>
                    <input type="text" placeholder="" name="user_email" size="26px"id="user_email" value='${currentUser.email}'/>
                </div>
              <div>
                    <label style="padding-left: 28px">当前选择的公司为：</label>
                    <input type="text"  name="lcompany" size="26px"id="lcompany" value="<%=t%>"/>
                </div>
                <div>
                    
                    <input type="hidden" name="company" size="26px"id="company" value='null'/>
                </div>
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">确认取消</button>
                 </div>
                  
 		</table></form>
 
 		</div>
    
  </body>
</html>
