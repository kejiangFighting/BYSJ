
<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="db.db"/>
<jsp:useBean id="reader" scope="page" class="db.WordReader"/>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all" />
    <LINK href="css.css" type=text/css rel=stylesheet>
    <script language="javascript" src="js/Calendar.js"></script>
    <script type="text/javascript" src="js/popup.js"></script>
    
	  <script type="text/javascript" src="layui/layui.js"></script>
	  <script type="text/javascript">

  function down1(fujianPath,fujianYuashiMing)
           {
	
                    var url="<%=path %>/jsp/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
			        url=encodeURI(url); 
	                url=encodeURI(url); 
	                window.open(url,"_self");
           }

function yulan(fujianPath,fujianYuashiMing) 
           {
	
                    var url="<%=path %>/jsp/updown/yulan.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
			        url=encodeURI(url); 
	                url=encodeURI(url); 
	                window.open(url,"_self");
           }
	</script>
    
  </head>
<%
String sql;
ResultSet RS_result;

%>
  <body >
  
<blockquote class="layui-elem-quote news_search">
		
	<form class="layui-form" action="jsp/common/searchEbook.jsp" method="post">
		 <div class="layui-inline">
        <input class="layui-input" name="search" id="demoReload" autocomplete="off">
    	</div>
    	<button class="layui-btn" name="searchEbook" data-type="reload">����</button>
		</div>
          </form>
    </div>
	</blockquote>

 <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>

    <td bgcolor='#CCFFFF'>��������</td>
    <td bgcolor='#CCFFFF'>�������</td>
    <td bgcolor='#CCFFFF'>���Ͻ���</td>
    <td bgcolor='#CCFFFF'>�ϴ�ʱ��</td>
    <td width="120" align="center" bgcolor="CCFFFF">�ϴ���</td>
    
    <td bgcolor='#CCFFFF'>��������</td>
    <td width="120" align="center" bgcolor="CCFFFF">����</td>
  </tr>
  <%
  int curpage=1;//��ǰҳ
				int page_record=10;//ÿҳ��ʾ�ļ�¼��
				int zgs=0;
				int zys=0;
				//������ķ�����sql��ѯ��ɣ��ٶȿ죩
				String hsgnpage=request.getParameter("page");
				String fysql="select count(id) as ss from Ebook_tb ";
				ResultSet RS_resultfy=connDbBean.executeQuery(fysql);
  while(RS_resultfy.next()){
  zgs=Integer.parseInt(RS_resultfy.getString("ss"));
  if((zgs % page_record)==0)
  {
  zys=zgs/page_record;
  }
  else
  {
  	zys=zgs/page_record+1;
  }
  }
				if (hsgnpage!=null)
				{
				curpage=Integer.parseInt(request.getParameter("page"));//��ȡ���ݵ�ֵ����Ҫ��ʾ��ҳ
				}
				else
				{
				curpage=1;
				}
				if (curpage==0)
				{
					curpage=1;
				}
				if(curpage>zys)
				{
					curpage=zys;
				}
if(((curpage-1)*page_record)==0 || curpage==0)
   {
  sql="select  * from Ebook_tb where 1=1 ";
   }
   else
   {
   String tempsql="select  id from Ebook_tb  order by id desc limit 0,"+(curpage-1)*page_record+"";
   ResultSet tempRS_result=connDbBean.executeQuery(tempsql);
   int tempid=0;
   String tempidstring="";
   while(tempRS_result.next())
   {
   		tempidstring=tempidstring+tempRS_result.getString("id")+",";
   }
   tempidstring=tempidstring.substring(0,tempidstring.length()-1);
  sql="select  * from Ebook_tb where  id not in ("+tempidstring+")  ";
  }
  
  
if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{sql=sql+" and bianhao like '%"+new String(request.getParameter("bianhao").getBytes("8859_1"))+"%'";}
//if(request.getParameter("biaoti")=="" ||request.getParameter("biaoti")==null ){}else{sql=sql+" and biaoti like '%"+new String(request.getParameter("biaoti").getBytes("8859_1"))+"%'";}
if(request.getParameter("miaoshu")=="" ||request.getParameter("miaoshu")==null ){}else{sql=sql+" and miaoshu like '%"+new String(request.getParameter("miaoshu").getBytes("8859_1"))+"%'";}
//if(request.getParameter("leibie")=="" ||request.getParameter("leibie")==null ){}else{sql=sql+" and leibie like '%"+new String(request.getParameter("leibie").getBytes("8859_1"))+"%'";}

  sql=sql+" order by id desc  limit 0,"+page_record+"";
  
 
  RS_result=connDbBean.executeQuery(sql);
  String id="";
  String biaoti="";
 
 // String neirong="";
  String tianjiaren="";
  String dianjilv="";
  String bianhao="";//���
  String name="";//����
  String miaoshu="";//����
  String type="";//���
  String createname="";//������
  String addtime="";//ʱ��
  String value1="";
  String value2="";
 int i=0;
 //difengysfiqfgieuheze 
 while(RS_result.next()){
 i=i+1;
  id=RS_result.getString("id");
  tianjiaren=RS_result.getString("addname");
  dianjilv=RS_result.getString("dianjilv");
 
  bianhao=RS_result.getString("bianhao");
  name=RS_result.getString("name");
  miaoshu=RS_result.getString("miaoshu");
   type=RS_result.getString("type");
   createname=RS_result.getString("createname");
   addtime=RS_result.getString("addtime");
   	value1 = RS_result.getString("fujian");
	value2 = RS_result.getString("fujianYuanshiming");
 //zoxngxetxoxngjxvi 
%>
  <tr>
    <td width="30" align="center"><%=id %></td>
    <td align="center"><%=name %></td>
    <td align="center"><%=type %></td>
    <td align="center"><%=miaoshu %></td>
    <td align="center"><%=addtime %></td>
    <td width="120" align="center"><%=tianjiaren %></td>
   
     <td ><%=value2 %>
       <a  href="javascript:void(0)" onclick="down1('<%=value1%>','<%=value2%>')" style="font-size: 12px;color: red">����</a>
     

	<td align="center">
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='jsp/common/del.jsp?id=<%=id %>' onclick="return confirm('���Ҫɾ����')">
									           <i class="layui-icon">&#xe640;</i> ɾ��
											</a>
										</td>
  </tr>
  	<%
  }
   %></table>
<br>
�������ݹ�<%=i %>��,<a style="cursor:hand" onclick="javascript:window.print();">��ӡ��ҳ</a>
<p align="center">&nbsp;��<%=zgs%>����¼&nbsp;&nbsp;<%=page_record %>��/ҳ��<a href="jsp/common/yingyong_list.jsp?page=1">��ҳ</a>��<a href="jsp/common/yingyong_list.jsp?page=<%= curpage-1%>">��һҳ</a>��<A href="jsp/common/yingyong_list.jsp?page=<%= curpage+1%>">��һҳ</A>��<a href="jsp/common/yingyong_list.jsp?page=<%=zys %>">βҳ</A>����ǰ��<FONT color=red><%=curpage %></FONT>ҳ/��<FONT color=red><%=zys %></FONT>ҳ</p>

  </body>

</html>

