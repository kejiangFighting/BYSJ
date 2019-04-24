<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="base.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <head>
  </head>
  
  <body>
   <div class="container">
    <h5><b>当前位置</b>：公告</h5>
       <!--书写实习报告面板-->
          <div><form action="../wreport" method="post">
            <table id="report" width="1130" height="700"  cellspacing="0"  border="1" borderColor="#74787c">
              <caption><h2 align="center" style="color: #2a5caa;">实习报告</h2></caption>
                <tbody>
                  <tr>
                    <td align="center" style="color: #1296db; width: 120px; height: 40px;">学号</td>
                    <td align="center" width="230" style="font-size: 18px;">
                      <input type="text" name="school_num" style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                    <td align="center" style="color: #1296db; width: 120px;">姓名</td>
                    <td align="center" width="200" style="font-size: 18px;">
                      <input type="text" name="name" style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>  
                    <td align="center" style="color: #1296db;">得分</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="gradeK"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>              
                  </tr>
                  <tr>
                    <td align="center" style="color: #1296db;">专业</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="major"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                    <td align="center" style="color: #1296db;">联系电话</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="tel"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                     <td align="center" style="color: #1296db; height: 40px;">实习单位</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="department"  style="width: 220px; height: 35px; font-size: 18px;"value="" >
                    </td>
                  </tr>
                  <tr>
                    <td align="center" style="color: #1296db; height: 40px;">学院</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="school"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                    <td align="center" style="color: #1296db;">指导老师</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="teacher"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                    <td align="center" style="color: #1296db;">实习时间</td>
                    <td align="center" style="font-size: 18px;">
                      <input type="text" name="time"  style="width: 220px; height: 35px; font-size: 18px;"value="">
                    </td>
                  </tr>
                  <tr>
                    <td align="center" style="color: #1296db;">实习总结</td>
                    <td colspan="5" align="center" style="font-size: 20px;">
                      <textarea  name="summary" style="width: 1000px; height: 125px; font-size: 20px;"value=""></textarea>
                    </td>
                  </tr>     
                </tbody>
               
            </table>
           <input type="submit" value="提交"  /></form>
 
          </div>
        </div>



 
  </body>
</html>
