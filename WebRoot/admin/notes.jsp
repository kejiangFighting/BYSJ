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
  <%   String url = "jdbc:mysql://localhost:3306/sc?"
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
	ResultSet rs = statement.executeQuery("select count(*) from notes" ); 
	rs.next(); 
	RecordCount = rs.getInt(1); 
	rs = statement.executeQuery("SELECT notes_id,title,start_time,stop_time,description,Writer,bumen FROM notes ORDER BY notes_id DESC LIMIT "+StartRow+", "+PageSize);
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
      <h5><b>��ǰλ��</b>��������� > �鿴����</h5>
      <hr>
      <div>
	
	<table width="100%" border="0" class="InternalHeader">
	<tr>
	
	<td width="76%">
	<font size=4><%="�ܹ�"+RecordCount+"����¼ - ��ǰҳ��"+PageNo+"/"+MaxPage %></font>
	</td>
	
	</tr>
	<tr>
	</tr>
	</table>
	<br>
	<div>
	<form action="../admin/notesquery.jsp" method="post">
     	 <label>֪ͨ����</label>
          <input type="text" name="notes_name" id="naotes_name" placeholder=""/>
      
          <input type="submit" value="����">
          </form>
    </div>
	<table width="100%" border="0" class="table-bordered">
	<tr> 
	<td class="InternalHeader" >��¼���</td>
	<td class="InternalHeader">֪ͨ����</td>
	<td class="InternalHeader" >��ʼʱ��</td>
	<td class="InternalHeader" >����ʱ��</td>
	<td class="InternalHeader" >����</td>
	<td class="InternalHeader" >������</td>
	<td class="InternalHeader" >��������</td>
	<td class="InternalHeader" >ɾ��</td>
	<td class="InternalHeader" >�޸�</td>
	</tr>
	<%
	int i = 1;
	while (rs.next()) {
	int bil = i + (PageNo-1)*PageSize;
	%>
	<tr>
	<td class="NormalFieldTwo" ><%=bil %></td>
	<td class="NormalFieldTwo" ><%=rs.getString(2)%></td>
	<td class="NormalFieldTwo" ><%=rs.getString(3)%></td>
	<td class="NormalFieldTwo" ><%=rs.getString(4)%></td>
	<td class="NormalFieldTwo" ><%=rs.getString(5)%></td>
	<td class="NormalFieldTwo" ><%=rs.getString(6)%></td>
	<td class="NormalFieldTwo" ><%=rs.getString(7)%></td>
	<td>
	<form action="../notesdelete" method="post">
	<input name="notes_id" type="hidden" value="<%=rs.getString("notes_id")%>"/>
	<input type="submit" value="ɾ��"> </form>
	</td>
	<td>
	<form action="../admin/notesupdate.jsp" method="post">
	<input name="notes_id" type="hidden" value="<%=rs.getString("notes_id")%>"/>
	<input type="submit" value="�޸�"> </form>
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
	out.print("<a href=notes.jsp?PageNo=1>��һҳ </a>: ");
	out.print("<a href=notes.jsp?PageNo="+PrevStart+">ǰһҳ</a>");
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
	out.print("<a href=notes.jsp?PageNo="+c+">"+c+"</a>");
	}else{
	out.print("<a href=notes.jsp?PageNo="+c+">"+c+"</a> ,");
	}
	}else{
	if(PageNo == MaxPage){
	out.print(c);
	break;
	}else{
	out.print("<a href=notes.jsp?PageNo="+c+">"+c+"</a>");
	break;

	}
	}
	}
	out.print("]");;
	if(PageNo < MaxPage){ //�����ǰҳ�������һҳ������ʾ��һҳ����
	NextPage = PageNo + 1;
	out.print("<a href=notes.jsp?PageNo="+NextPage+">��һҳ</a>");
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
	out.print("<a href=notes.jsp?PageNo="+MaxPage+">���һҳ</a>");
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
