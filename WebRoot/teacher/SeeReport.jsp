<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@include file="base.jsp"%>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.DriverManager"%>
<%@page import="Dao.Dbutil"%>

<html>
  <body>
  <% response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
  	String school_num=request.getParameter("school_num"); 
  		Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
      	 String gradeK=null;
      	  String name =null;
     		String summary =null;
      	  String tel =null;
      	   String major =null;
      	  String department=null;
      	  String time =null;
      	  String teacher =null;
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
           	String sql="select* from  report where school_num='"+school_num+"'";
            rs= stmt.executeQuery(sql);
			while(rs.next()){	
			name=rs.getString("name");
			gradeK=rs.getString("gradeK");
			department=rs.getString("department");
			major=rs.getString("major");
			tel=rs.getString("tel");
			time=rs.getString("time");
			teacher=rs.getString("teacher");
			summary=rs.getString("summary");
			}
            }catch(Exception e){e.printStackTrace();
            }finally{
            
            }
 		%> 
                
  <div class="container">
  <br>
  <br>
    <h5><b>��ǰλ��</b>������鿴</h5>
    <form action="../saveDocServlet" method="post">  
    <div id="file" align="center">     

            <table id="report" width="1130" height="700"  cellspacing="0"  border="1" borderColor="#74787c">
              <caption><h2 align="center" style="color: #2a5caa;">ʵϰ����</h2></caption>
                <tbody>
                  <tr>
                    <td align="center" class="key"  style="color: #1296db; width: 120px; height: 40px;">ѧ��</td>
                    <td align="center" width="230" style="font-size: 18px;">
                      <input type="text" name="school_num" style="width: 220px; height: 35px; font-size: 18px;"value="<%=school_num %>">
                    </td>
                    <td align="center" class="key" style="color: #1296db; width: 120px;">����</td>
                    <td align="center" width="200" style="font-size: 18px;">
                      <input type="text" name="name" style="width: 220px; height: 35px; font-size: 18px;"value="<%=name%>">
                    </td>  
                    <td align="center" class="key"  style="color: #1296db;">�÷�</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="gradeK"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=gradeK%>">
                    </td>              
                  </tr>
                  <tr>
                    <td align="center"class="key"  style="color: #1296db;">רҵ</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="major"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=major%>">
                    </td>
                    <td align="center" class="key" style="color: #1296db;">��ϵ�绰</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="tel"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=tel%>">
                    </td>
                     <td align="center"class="key"  style="color: #1296db; height: 40px;">ʵϰ��λ</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="department"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=department %>" >
                    </td>
                  </tr>
                  <tr>
                    <td align="center" class="key" style="color: #1296db; height: 40px;">ʵϰ��λ</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="department"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=department%>">
                    </td>
                    <td align="center"class="key"  style="color: #1296db;">ָ����ʦ</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="teacher"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=teacher%>">
                    </td>
                    <td align="center" class="key" style="color: #1296db;">ʵϰʱ��</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="time"  style="width: 220px; height: 35px; font-size: 18px;"value="<%=time%>">
                    </td>
                  </tr>
                  <tr>
                    <td align="center" class="key" style="color: #1296db;">ʵϰ�ܽ�</td>
                    <td colspan="5" align="center" style="font-size: 20px;">
                      <textarea  name="summary" style="width: 1000px; height: 125px; font-size: 20px;"value=""><%=summary%></textarea>
                    </td>
                  </tr>     
                </tbody>
               
            </table>
    </div>  
    <div align="center" style="margin-top:15px;">  
        <input type="submit" value="���ر���" />  
    </div>  
    </form>  
  </body>
</html>
