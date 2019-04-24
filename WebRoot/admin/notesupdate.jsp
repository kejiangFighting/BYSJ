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
    
    <title>My JSP 'xiugai.jsp' starting page</title>
    
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
       <%String id=request.getParameter("notes_id");
      	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
      	 String title=null;
      	  String start_time =null;
      	  String stop_time =null;
      	  String description =null;
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
           	String sql="select* from  notes where notes_id='"+id+"'";
            rs= stmt.executeQuery(sql);
			while(rs.next()){	
			title=rs.getString("title");
			start_time=rs.getString("start_time");
			stop_time=rs.getString("stop_time");
			description=rs.getString("description");
			}
            
            }catch(Exception e){e.printStackTrace();
            }finally{
            
            }
 		
 		
 		
 		%> 
 
 	<div class="container">
    <h5><b>当前位置</b>：公告管理 > 修改公告</h5>
 		
            <form  action="notesupdate" method="post">
                <div>
                    <label style="padding-left: 28px">标题</label>
                    <input type="text" placeholder="Title" name="title" size="26px"id="title" value='<%=title%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">开始时间</label>
                    <input type="datetime" placeholder="如：2015-01-01" name="start_time" id="start_time" value='<%=start_time%>'/>
                </div>
                <div>
                    <label style="padding-top: 6px">结束时间</label>
                    <input type="datetime" placeholder="如：2015-01-01" name="stop_time" id="start_time" value='<%=stop_time%>'/>
                </div>
                <div>
                    <label>公告内容</label>
                    <textarea rows="15" cols="75" name="description" id="description" ><%=description%></textarea>
               
                </div>
                 <div>
                   <label>notes_id</label>
                    <input type="text" placeholder="如：2015-01-01" name="notes_id" id="notes_id" value='<%=id%>'/>
                </div>
                <div style="padding-top: 15px">
                 <button type="submit" class="btn btn-primary">修改</button>
                 </div>
                  
 		</form>
 
 		</div>
       
   </body>
</html>
