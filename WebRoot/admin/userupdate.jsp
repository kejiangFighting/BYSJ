<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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

  </head>
  
  <body>
    <%String school_num=request.getParameter("school_num");
      	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
      	 String company=null;
      	  String name =null;
      	  String sex =null;
      	  String school =null;
      	   String major =null;
      	  String password=null;
      	  String phone =null;
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
           	String sql="select* from  user where school_num='"+school_num+"'";
            rs= stmt.executeQuery(sql);
			while(rs.next()){	
			name=rs.getString("name");
			sex=rs.getString("sex");
			school=rs.getString("school");
			major=rs.getString("major");
			password=rs.getString("password");
			phone=rs.getString("phone");
			company=rs.getString("company");
			}
            
            }catch(Exception e){e.printStackTrace();
            }finally{
            
            }
 		%> 
 
 	<div class="container">
    <h5><b>当前位置</b>：用户管理 > 修改用户信息</h5>
    
 		
            <form  action="userupdate" method="post">
                <div>
                    <label style="padding-left: 28px">名字</label>
                    <input type="text" placeholder="Title" name="name" size="26px"id="name" value='<%=name%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">性别</label>
                    <input type="text" placeholder="如：男、女" name="sex" id="sex" value='<%=sex%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">学院</label>
                    <input type="datetime" placeholder="如：2015-01-01" name="school" id="school" value='<%=school%>'/>
                </div>
     			<div>
                   <label>专业</label>
                    <input type="text" placeholder="" name="major" id="major" value='<%=major%>'/>
                </div>
                <div>
                   <label>电话</label>
                    <input type="text" placeholder="" name="phone" id="phone" value='<%=phone%>'/>
                </div>
                <div>
                   <label>密码</label>
                    <input type="text" placeholder="" name="password" id="password" value='<%=password%>'/>
                </div>
                <div>
                   <label>实习公司</label>
                    <input type="text" placeholder="" name="company" id="company" value='<%=company%>'/>
                </div>
                 <div>
                   <label>学号</label>
                    <input type="text" placeholder="" name="school_num" id="school_num" value='<%=school_num%>'/>
                </div>
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">修改</button>
                 </div>
                  
 		</form>
 
 		</div>
       
  </body>
</html>
