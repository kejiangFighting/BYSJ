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
  
  	 ��ǰѡ��Ĺ�˾:<%=teacher.getNewCompany(email)%>
    <h5><b>��ǰλ��</b>��ʵϰ��˾����> ȡ����˾ѡ��</h5>
 		    <div class="companysel">
            <form  action="../companysel" method="post">
            <table>
              <div>
                    <label style="padding-left: 28px">��ǰ�û�Ϊ��</label>
                    <input type="text" placeholder="" name="user_email" size="26px"id="user_email" value='${currentUser.email}'/>
                </div>
              <div>
                    <label style="padding-left: 28px">��ǰѡ��Ĺ�˾Ϊ��</label>
                    <input type="text"  name="lcompany" size="26px"id="lcompany" value="<%=t%>"/>
                </div>
                <div>
                    
                    <input type="hidden" name="company" size="26px"id="company" value='null'/>
                </div>
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">ȷ��ȡ��</button>
                 </div>
                  
 		</table></form>
 
 		</div>
    
  </body>
</html>
