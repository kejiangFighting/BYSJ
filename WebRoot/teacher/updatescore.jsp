<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Dao.Dbutil"%>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.PreparedStatement"%>

<%@include file="base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>

  <body>
       <% response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
       String id=request.getParameter("school_num");
      	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
      	 String gradeP=null;
      	 String gradeK =null;
    	
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
           	String sql="select* from report where school_num='"+id+"'";
            rs= stmt.executeQuery(sql);
			while(rs.next()){	
			gradeP=rs.getString("gradeP");
			gradeK=rs.getString("gradeK");
			
			}
            
            }catch(Exception e){e.printStackTrace();
            }finally{
            
            }	
 		%> 
<div class="container">
<br>
<br>
<h5><b>当前位置</b>：成绩管理> 修改成绩</h5>

<form  action="../inputscore" method="post">

 <div>
      <label style="padding-left: 300px;padding-top: 50px">学号</label>
       <input type="text"  name="school_num"  value='<%=id%>'/>
</div>
   <div>
    <label style="padding-left: 300px;padding-top: 50px">请输入平时成绩占比</label>
    <input type="text" placeholder="如：0.4" name="proportion"  value=""/>
   </div>
  <div>
	<label style="padding-left: 300px;padding-top: 50px">平时成绩</label>
	<input type="text" placeholder="如：80" name="gradeP" size="10px" value="<%=gradeP%>"/>
</div>
<div>
	<label style="padding-left: 300px;padding-top: 50px">考试成绩</label>
	 <input type="text" placeholder="如：80" name="gradeK" size="10px" value="<%=gradeK%>"/>
</div>
 <div style="padding-left: 300px;padding-top: 50px">
 <button type="submit" class="btn btn-primary">修改</button>
</div>           
</form>
</div>
       
   </body>
</html>
