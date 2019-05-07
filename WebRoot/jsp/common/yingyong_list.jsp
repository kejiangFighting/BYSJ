
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

  function down1(fujianPath,fujianYuashiMing,id,dianjilv)
           {
	
                    var url="<%=path %>/jsp/updown/updown.jsp?id="+id+"&dianjilv="+dianjilv+"&fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
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
 <%String user=null;
 if(session.getAttribute("student")==null){
 	if(session.getAttribute("teacher")==null){
 	user="root";
 	}else{
 	user=session.getAttribute("teacher").toString();
 	}
 	}
 else{
 	user=session.getAttribute("student").toString();
 }
 %>
  <body >
  
<blockquote class="layui-elem-quote news_search">
		
	<form class="layui-form" action="jsp/common/yingyong_list.jsp" method="post">
		 <div class="layui-inline">
        <input class="layui-input" name="name" id="demoReload" autocomplete="off" placeholder="文件名搜索">
    	</div>
    	 <div class="layui-inline">
        <input class="layui-input" name="type" id="demoReload" autocomplete="off" placeholder="文件类型">
    	</div>
    	<button class="layui-btn" name="searchEbook" data-type="reload">搜索</button>
		</div>
          </form>
    </div>
	</blockquote>

 <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>

    <td bgcolor='#CCFFFF'>资料名称</td>
    <td bgcolor='#CCFFFF'>资料类别</td>
    <td bgcolor='#CCFFFF'>资料介绍</td>
    <td bgcolor='#CCFFFF'align="center">上传时间</td>
    <td width="120" align="center" bgcolor="CCFFFF">上传者</td>
    
    <td bgcolor='#CCFFFF'>资料内容</td>
    <td width="40" align="center" bgcolor='#CCFFFF'>下载次数</td>
    <td width="100" align="center" bgcolor="CCFFFF">操作</td>
  </tr>
  <%
  int curpage=1;//当前页
				int page_record=10;//每页显示的记录数
				int zgs=0;
				int zys=0;
				//用下面的方法（sql查询完成，速度快）
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
				curpage=Integer.parseInt(request.getParameter("page"));//获取传递的值，需要显示的页
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
  
  
//if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{sql=sql+" and bianhao like '%"+new String(request.getParameter("bianhao").getBytes("8859_1"))+"%'";}
//if(request.getParameter("biaoti")=="" ||request.getParameter("biaoti")==null ){}else{sql=sql+" and biaoti like '%"+new String(request.getParameter("biaoti").getBytes("8859_1"))+"%'";}
if(request.getParameter("name")=="" ||request.getParameter("name")==null ){}else{sql=sql+" and name like '%"+new String(request.getParameter("name").getBytes("8859_1"))+"%'";}
if(request.getParameter("type")=="" ||request.getParameter("type")==null ){}else{sql=sql+" and type like '%"+new String(request.getParameter("type").getBytes("8859_1"))+"%'";}

  sql=sql+" order by id desc  limit 0,"+page_record+"";
  
 
  RS_result=connDbBean.executeQuery(sql);
  String id="";
  String biaoti="";
 
 // String neirong="";
  String tianjiaren="";
  int dianjilv=0;
  String bianhao="";//编号
  String name="";//名称
  String miaoshu="";//描述
  String type="";//类别
  String createname="";//创建人
  String addtime="";//时间
  String value1="";
  String value2="";
 int i=0;
 //difengysfiqfgieuheze 
 while(RS_result.next()){
 i=i+1;
  id=RS_result.getString("id");
  tianjiaren=RS_result.getString("addname");
  dianjilv=RS_result.getInt("dianjilv");
 
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
    <td width="100" align="center"><%=tianjiaren %></td>
   
     <td ><%=value2 %>
       <a  href="javascript:void(0)" onclick="down1('<%=value1%>','<%=value2%>','<%=id%>','<%=dianjilv+1%>')" style="font-size: 12px;color: red">下载</a>
      <td align="center"><%=dianjilv%></td>

	<td align="center">
											<a class="layui-btn layui-btn-danger layui-btn-mini links_del" href='jsp/common/del.jsp?id=<%=id %>&userno=<%=user%>&addname=<%=tianjiaren%>' onclick="return confirm('真的要删除？')">
									           <i class="layui-icon">&#xe640;</i> 删除
											</a>
										</td>
  </tr>
  	<%
  }
   %></table>
<br>
以上数据共<%=i %>条,<a style="cursor:hand" onclick="javascript:window.print();">打印本页</a>
<p align="center">&nbsp;共<%=zgs%>条记录&nbsp;&nbsp;<%=page_record %>条/页　<a href="jsp/common/yingyong_list.jsp?page=1">首页</a>　<a href="jsp/common/yingyong_list.jsp?page=<%= curpage-1%>">上一页</a>　<A href="jsp/common/yingyong_list.jsp?page=<%= curpage+1%>">下一页</A>　<a href="jsp/common/yingyong_list.jsp?page=<%=zys %>">尾页</A>　当前第<FONT color=red><%=curpage %></FONT>页/共<FONT color=red><%=zys %></FONT>页</p>

  </body>

</html>

