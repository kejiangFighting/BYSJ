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
	  
	//ÿҳ��ʾ��¼��
	int PageSize = 5;
	int StartRow = 0; //��ʼ��ʾ��¼�ı�� 
	int PageNo=0;//��Ҫ��ʾ��ҳ��
	int CounterStart=0;//ÿҳҳ��ĳ�ʼֵ
	int CounterEnd=0;//��ʾҳ������ֵ
	int RecordCount=0;//�ܼ�¼��;
	int MaxPage=0;//��ҳ��
	int PrevStart=0;//ǰһҳ
	int NextPage=0;//��һҳ
	int LastRec=0; 
	int LastStartRecord=0;
	String company=teacher.getNewCompany(email);//��ȡ��ǰ��ʦѡ��ʵϰ��˾
	
	
	if(request.getParameter("PageNo")==null){ //���Ϊ�գ����ʾ��1ҳ
	if(StartRow == 0){
		PageNo = StartRow + 1; //�趨Ϊ1
	}
	}else{
		PageNo = Integer.parseInt(request.getParameter("PageNo")); //����û��ύ��ҳ��
		StartRow = (PageNo - 1) * PageSize; //��ÿ�ʼ��ʾ�ļ�¼���
		}
	//������ʾҳ��ĳ�ʼֵ!!
	if(PageNo % PageSize == 0){
		CounterStart = PageNo - (PageSize - 1);
	}else{
			CounterStart = PageNo - (PageNo % PageSize) + 1;
			}
	CounterEnd = CounterStart + (PageSize - 1);
	%>
	
	<%
	//��ȡ�ܼ�¼��
	ResultSet rs = statement.executeQuery("select count(*) from report" ); 
	rs.next(); 
	RecordCount = rs.getInt(1); 
	rs = statement.executeQuery("SELECT school_num,name,major,gradeP,gradeK FROM report where gradeP is null and department='"+company+"' ORDER BY id DESC LIMIT "+StartRow+", "+PageSize);
	//��ȡ��ҳ��
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
  
		 <h5><b>��ǰλ��</b>���ɼ�����>¼��ɼ�</h5>
		 
      </td>
      <br>
    
     <div><form action="../inputscore" method="post">
     <label style="padding-left: 28px">������ƽʱ�ɼ�ռ��</label>
        <input type="text" placeholder="�磺0.4" name="proportion" size="26px" value=""/>
      
	
	<table class="table table-bordered" id="outside">
	    <tr>
	    <th>��¼���</th>
	    <th>ѧ��</th>
	    <th>����</th>
	    <th>רҵ</th>	 
	    <th>ƽʱ�ɼ�</th>
	    <th>���Գɼ�</th>

	 	<th>����</th>
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
	
	<td><input type="text" placeholder="�磺80" name="gradeP" size="10px" value=""/></td>
	<td><input type="text" placeholder="�磺80" name="gradeK" size="10px" value=""/></td>
	<td>
	
	<input name="school_num" type="hidden" value="<%= rs.getString("school_num")%>"/>
	<input type="submit" value="¼��"></form>
	
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
	//��ʾ��һҳ����ǰһҳ������
	//�����ǰҳ���ǵ�1ҳ������ʾ��һҳ��ǰһҳ������
	if(PageNo != 1){
	PrevStart = PageNo - 1;
	out.print("<a href=inputscore.jsp?PageNo=1>��һҳ </a>: ");
	out.print("<a href=inputscore.jsp?PageNo="+PrevStart+">ǰһҳ</a>");
	}
	out.print("[");
	//��ӡ��Ҫ��ʾ��ҳ��
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
	if(PageNo < MaxPage){ //�����ǰҳ�������һҳ������ʾ��һҳ����
	NextPage = PageNo + 1;
	out.print("<a href=inputscore.jsp?PageNo="+NextPage+">��һҳ</a>");
	}
	//ͬʱ�����ǰҳ�������һҳ��Ҫ��ʾ���һҳ������
	if(PageNo < MaxPage){
	LastRec = RecordCount % PageSize;
	if(LastRec == 0){
	LastStartRecord = RecordCount - PageSize;
	}
	else{
	LastStartRecord = RecordCount - LastRec;
	}
	out.print(":");
	out.print("<a href=inputscore.jsp?PageNo="+MaxPage+">���һҳ</a>");
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
	