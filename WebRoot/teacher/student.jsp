<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import= "java.sql.Connection"%>
<%@page import= "java.sql.Statement"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.DriverManager"%>
<%@include file="base.jsp"%>
<html>
	<head>
	<title></title>
	</head>
	
  <%String mycompany=null;
  response.setContentType("text/html;charset=utf-8");
 	request.setCharacterEncoding("utf-8");
 	ServletContext sc = getServletConfig().getServletContext(); 
	   String email=sc.getAttribute("email").toString();
	  TeacherDAO teacher = new TeacherDAO();
	 mycompany=teacher.getNewCompany(email);
   String url = "jdbc:mysql://localhost:3306/sc?"
            + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection connection=DriverManager.getConnection(url);
	Statement statement = connection.createStatement();
	//ÿҳ��ʾ��¼��
	int PageSize = 3;
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
	ResultSet rs = statement.executeQuery("select count(*) from user" ); 
	rs.next(); 
	RecordCount = rs.getInt(1); 
	rs = statement.executeQuery("SELECT user_id,school_num,name,sex,major,school,email,phone,password,adress,role,company FROM user where company='"+mycompany+"'and role=2 ORDER BY role DESC LIMIT "+StartRow+", "+PageSize);
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
      <h5><b>��ǰλ��</h5>
      <hr>
      <div>
	
	<table width="100%" border="0" class="InternalHeader">
	 <h5><b>��ǰλ��</b>�� �鿴ѧ����Ϣ</h5>
	</table>
	<br>
	<div>
	<form action="../teacher/studentquery.jsp" method="post">
     	 <label>�û�����</label>
          <input type="text" name="school_num" id="schol_num" placeholder=""/>
          <input type="submit" value="����">
          </form>
    </div>
	<br>

	<table class="table table-bordered" id="outside">
	    <tr>
	    <th>��¼���</th>
	    <th>ѧ��</th>
	    <th>����</th>
	    <th>�Ա�</th>
	    <th>ѧԺ</th>
	    <th>רҵ</th>	 
	 
	    <th>�绰</th>
	    <th>����</th>
	    <th>��ַ</th>
	    <th>��ɫ</th>
	    <th>ʵϰ��˾</th>
	    
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
	<td><%=rs.getString("sex")  %></td>
	<td><%=rs.getString("school") %></td>
	<td><%=rs.getString("major") %></td>	
	
	<td><%=rs.getString("phone") %></td>
	<td><%=rs.getString("email") %></td>
	<td><%=rs.getString("adress") %></td>
	<td><%=rs.getString("role")  %></td>
	<td><%=rs.getString("company") %></td>
	
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
	out.print("<a href=student.jsp?PageNo=1>��һҳ </a>: ");
	out.print("<a href=student.jsp?PageNo="+PrevStart+">ǰһҳ</a>");
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
	out.print("<a href=student.jsp?PageNo="+c+">"+c+"</a>");
	}else{
	out.print("<a href=student.jsp?PageNo="+c+">"+c+"</a> ,");
	}
	}else{
	if(PageNo == MaxPage){
	out.print(c);
	break;
	}else{
	out.print("<a href=student.jsp?PageNo="+c+">"+c+"</a>");
	break;

	}
	}
	}
	out.print("]");;
	if(PageNo < MaxPage){ //�����ǰҳ�������һҳ������ʾ��һҳ����
	NextPage = PageNo + 1;
	out.print("<a href=student.jsp?PageNo="+NextPage+">��һҳ</a>");
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
	out.print("<a href=student.jsp?PageNo="+MaxPage+">���һҳ</a>");
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
