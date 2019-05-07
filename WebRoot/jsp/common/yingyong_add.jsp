
<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="db.db"/>
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="layui/css/layui.css" media="all" />
    <title></title><LINK href="css.css" type=text/css rel=stylesheet>
    <script language="javascript" src="js/Calendar.js"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	    <script type="text/javascript">
	    function up()
		    {
		    	
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path%>/jsp/upload/upload.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	           
		    }
	</script>
  </head>
<script language="javascript">
function check()
{
	if(document.form1.name.value=="")
	{alert("请输入资料名称");
	document.form1.name.focus();
	return false;
	}if(document.form1.miaoshu.value=="")
	{alert("请输入资料描述");
	document.form1.miaoshu.focus();
	return false;
	}if(document.form1.neirong.value=="")
	{alert("请输入资料类别");
	document.form1.neirong.focus();
	return false;}
}

</script>
  <body >
  <%
  String sql;
  ResultSet RS_result;
 //islbdq String id=request.getParameter("id");
 //islbdq sql="select * from melieibaoduqubiaoiguo where id="+id;
 //islbdq gogogogogo
 //islbdq RS_result=connDbBean.executeQuery(sql);
 //islbdq while(RS_result.next()){
 //islbdq lelelelelele
 //islbdq }
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
 <blockquote class="layui-elem-quote">请勿上传非相关资料！！</blockquote>
<form name="form1" id="form1" method="post"action="jsp/common/yingyong_add_post.jsp?userno=<%=user%>">
<div style="text-align: center;">
  <div class="layui-inline">
			 <table class="layui-table" lay-skin="line">
		<colgroup>
          <col width="150">
          <col width="200">
          <col>
        </colgroup>
				<tr>
					<td>
						资料编号
					</td>
					<td>
						<input name='bianhao' type='text' id='bianhao' value=''
					/>&nbsp;*

					</td>
				</tr>
					<tr>
					<td>
						资料名称
					</td>
					<td>
						<input name='name' type='text' id='name' value=''
							style='border: solid 1px #000000; color: #666666' />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td>
						资料简述
					</td>
					<td>
						<input name='miaoshu' type='text' id='miaoshu' value=''
							style='border: solid 1px #000000; color: #666666' />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td>
						资料类别
					</td>
					<td>
						<input name='type' type='text' id='type' value=''
							style='border: solid 1px #000000; color: #666666' />
						&nbsp;*
					</td>
				</tr>
	
				<tr>
					<td>
						资料作者
					</td>
					<td>
						<input name='createname' type='text' id='createname' value=''
							style='border: solid 1px #000000; color: #666666' />
						&nbsp;*
					</td>
				</tr>
					<tr>
					<td>
						资料内容
					</td>
						   <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="fujian" id="fujian" style="width: 150px;" readonly="readonly"/>
						        <input type="button" value="上传" onclick="up()"/>
						        <input type="hidden" name="fujianYuanshiming" id="fujianYuanshiming"/>
						    </td>
				</tr>
			</table>
			<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddMeeting"onclick="return check();">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
		</form>
	</body>
	<script type="text/javascript" src="layui/layui.js"></script>
</html>

