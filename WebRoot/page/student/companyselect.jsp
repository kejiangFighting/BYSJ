<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@include file="base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
 

  </head>
  
  <body>
  <% response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
  String company_name=request.getParameter("company_name"); 
 
  %>
                
   <div class="container">
 
   
    <h5><b>��ǰλ��</b>��ʵϰ��˾����> ʵϰ��˾�޸�</h5>
 		    <div class="companysel">
            <form  action="../companysel" method="post">
            <table>
              <div>
                    <label style="padding-left: 28px">��ǰ�û�Ϊ��</label>
                    <input type="text" placeholder="Title" name="user_email" size="26px"id="user_email" value='${currentUser.email}'/>
                </div>
              <div>
                    <label style="padding-left: 28px">ѡ��Ĺ�˾Ϊ��</label>
                    <input type="text" placeholder="Title" name="company" size="26px"id="company" value="<%=company_name%>"/>
                </div>
                
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">ȷ��</button>
                 </div>
                  
 		</table></form>
 
 		</div>
    
  </body>
</html>
