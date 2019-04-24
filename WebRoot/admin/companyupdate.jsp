<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.AdminDAO" %>
<%@page import="Dao.Dbutil"%>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.PreparedStatement"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
       <%String id=request.getParameter("company_id");
      	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
      	 String company_name=null;
      	  String address =null;
      	  String tel =null;
      	  String description =null;
      	  String capacity =null;
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
           	String sql="select* from  company where company_id='"+id+"'";
            rs= stmt.executeQuery(sql);
			while(rs.next()){	
			company_name=rs.getString("company_name");
			address=rs.getString("address");
			tel=rs.getString("tel");
			description=rs.getString("introduce");
			capacity=rs.getString("capacity");
			}
            
            }catch(Exception e){e.printStackTrace();
            }finally{
            
            }
 		
 		
 		
 		%> 
 
 	<div class="container">
    <h5><b>当前位置</b>：公司管理 > 修改公司</h5>
 		
            <form  action="companyupdate" method="post">
                <div>
                    <label style="padding-left: 28px">公司名</label>
                    <input type="text" placeholder="Title" name="company_name" size="26px"id="company_name" value='<%=company_name%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">地址</label>
                    <input type="datetime" placeholder="" name="address" id="address" value='<%=address%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">联系方式</label>
                    <input type="datetime" placeholder="" name="tel" id="tel" value='<%=tel%>'/>
                </div>
                <div>
                    <label>公司介绍</label>
                    <textarea rows="15" cols="75" name="introduce" id="introduce" ><%=description%></textarea>
               
                </div>
                <div>
                    <label style="padding-top: 6px">容量</label>
                    <input type="datetime" placeholder="" name="capacity" id="capacity" value='<%=capacity%>'/>
                </div>
                 <div>
                   <label>公司编号</label>
                    <input type="text" placeholder="如：2015-01-01" name="company_id" id="company_id" value='<%=id%>'/>
                </div>
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">修改</button>
                 </div>
                  
 		</form>
 
 		</div>
       
   </body>
</html>
