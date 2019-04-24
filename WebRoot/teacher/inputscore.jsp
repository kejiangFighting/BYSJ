<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.DriverManager"%>
<%@page import= "java.io.PrintWriter"%>
<%@include file="base.jsp"%>
<html>
	<head>
	<title></title>
	</head>
	
  <% 
    response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
  String url = "jdbc:mysql://localhost:3306/sc?"
            + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection connection=DriverManager.getConnection(url);
	Statement statement = connection.createStatement();
	ServletContext sc = getServletConfig().getServletContext(); 
	  String email=sc.getAttribute("email").toString();
	  TeacherDAO teacher = new TeacherDAO();
	  
	//每页显示记录数
	int PageSize = 5;
	int StartRow = 0; //开始显示记录的编号 
	int PageNo=0;//需要显示的页数
	int CounterStart=0;//每页页码的初始值
	int CounterEnd=0;//显示页码的最大值
	int RecordCount=0;//总记录数;
	int MaxPage=0;//总页数
	int PrevStart=0;//前一页
	int NextPage=0;//下一页
	int LastRec=0; 
	int LastStartRecord=0;
	String company=teacher.getNewCompany(email);//获取当前教师选的实习公司
	
	
	if(request.getParameter("PageNo")==null){ //如果为空，则表示第1页
	if(StartRow == 0){
		PageNo = StartRow + 1; //设定为1
	}
	}else{
		PageNo = Integer.parseInt(request.getParameter("PageNo")); //获得用户提交的页数
		StartRow = (PageNo - 1) * PageSize; //获得开始显示的记录编号
		}
	//设置显示页码的初始值!!
	if(PageNo % PageSize == 0){
		CounterStart = PageNo - (PageSize - 1);
	}else{
			CounterStart = PageNo - (PageNo % PageSize) + 1;
			}
	CounterEnd = CounterStart + (PageSize - 1);
	%>
	
	<%
	//获取总记录数
	ResultSet rs = statement.executeQuery("select count(*) from report" ); 
	rs.next(); 
	RecordCount = rs.getInt(1); 
	rs = statement.executeQuery("SELECT school_num,name,major,gradeP,gradeK FROM report where gradeP is null and department='"+company+"' ORDER BY id DESC LIMIT "+StartRow+", "+PageSize);
	//获取总页数
	MaxPage = RecordCount % PageSize;
	if(RecordCount % PageSize == 0){
		MaxPage = RecordCount/PageSize;
	}else{
		MaxPage = RecordCount/PageSize+1;
	}
	%>
	<body class="UsePageBg">
	 <div class="container">
	<hr>
	<br>
    <td>
  
		 <h5><b>当前位置</b>：成绩管理>录入成绩</h5>
		 
      </td>
      <br>
    
     <div><form action="../inputscore" method="post">
     <label style="padding-left: 28px">请输入平时成绩占比</label>
        <input type="text" placeholder="如：0.4" name="proportion" size="26px" value=""/>
      
	
	<table class="table table-bordered" id="outside">
	    <tr>
	    <th>记录序号</th>
	    <th>学号</th>
	    <th>姓名</th>
	    <th>专业</th>	 
	    <th>平时成绩</th>
	    <th>考试成绩</th>

	 	<th>操作</th>
	    </tr>
    
	<%
	int i = 1;
	while (rs.next()) {
	int bil = i + (PageNo-1)*PageSize;
	%>
	<tr>
	<td><%=bil %></td>
	<td><%=rs.getString("school_num")%></td>
	<td><%=rs.getString("name") %></td>
	<td><%=rs.getString("major") %></td>	
	
	<td><input type="text" placeholder="如：80" name="gradeP" size="10px" value=""/></td>
	<td><input type="text" placeholder="如：80" name="gradeK" size="10px" value=""/></td>
	<td>
	
	<input name="school_num" type="hidden" value="<%= rs.getString("school_num")%>"/>
	<input type="submit" value="录入"></form>
	
	</td>
  
    </tr>
	<%
	i++;
	}%>
	</table>
	    </div>
  </div>
	
	><br>
	<table width="100%" border="0" class="InternalHeader">
	<tr>
	<td><div align="center">
	<%
	out.print("<font size=4>");
	//显示第一页或者前一页的链接
	//如果当前页不是第1页，则显示第一页和前一页的链接
	if(PageNo != 1){
	PrevStart = PageNo - 1;
	out.print("<a href=inputscore.jsp?PageNo=1>第一页 </a>: ");
	out.print("<a href=inputscore.jsp?PageNo="+PrevStart+">前一页</a>");
	}
	out.print("[");
	//打印需要显示的页码
	for(int c=CounterStart;c<=CounterEnd;c++){
	if(c <MaxPage){
	if(c == PageNo){
	if(c %PageSize == 0){
	out.print(c);
	}else{
	out.print(c+" ,");
	}
	}else if(c % PageSize == 0){
	out.print("<a href=inputscore.jsp?PageNo="+c+">"+c+"</a>");
	}else{
	out.print("<a href=inputscore.jsp?PageNo="+c+">"+c+"</a> ,");
	}
	}else{
	if(PageNo == MaxPage){
	out.print(c);
	break;
	}else{
	out.print("<a href=inputscore.jsp?PageNo="+c+">"+c+"</a>");
	break;

	}
	}
	}
	out.print("]");;
	if(PageNo < MaxPage){ //如果当前页不是最后一页，则显示下一页链接
	NextPage = PageNo + 1;
	out.print("<a href=inputscore.jsp?PageNo="+NextPage+">下一页</a>");
	}
	//同时如果当前页不是最后一页，要显示最后一页的链接
	if(PageNo < MaxPage){
	LastRec = RecordCount % PageSize;
	if(LastRec == 0){
	LastStartRecord = RecordCount - PageSize;
	}
	else{
	LastStartRecord = RecordCount - LastRec;
	}
	out.print(":");
	out.print("<a href=inputscore.jsp?PageNo="+MaxPage+">最后一页</a>");
	}
	out.print("</font>");
	%>
	</div>
	</td>
	</tr>
	
	</table>
	<%
	rs.close();
	statement.close();
	connection.close();
	%>

  </body>
</html>
	