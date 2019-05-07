<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>添加公告</title>
	<!-- 引入样式 -->
	<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
	<!-- 引入组件库 -->
	 <script src="https://unpkg.com/vue/dist/vue.js"></script>
	<script src="https://unpkg.com/element-ui@2.8.2/lib/index.js"></script>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />	
  </head>
  <body>
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
 <script language="javascript">
function check()
{
	if(document.getElementById("Time").value=="")
	{alert("请输入预约日期");
	document.getElementById("Time").focus();
	return false;
	}if(document.getElementById("startTime").value=="")
	{alert("请输入开始时间");
	document.getElementById("startTime").focus();
	return false;
	}if(document.getElementById("endTime").value=="")
	{alert("请输入结束时间");
	document.getElementById("endTime").focus();
	return false;
	}
	
}
function check2()
{
	if(document.getElementById("Time").value=="")
	{alert("请输入预约日期");
	document.getElementById("Time").focus();
	return false;
	}if(document.getElementById("startTime").value=="")
	{alert("请输入开始时间");
	document.getElementById("startTime").focus();
	return false;
	}if(document.getElementById("endTime").value=="")
	{alert("请输入结束时间");
	document.getElementById("endTime").focus();
	return false;
	}if(document.getElementById("title").value=="")
	{alert("请输入会议主题");
	document.getElementById("title").focus();
	return false;
	}if(document.getElementById("num").value=="")
	{alert("请输入参与人数");
	document.getElementById("num").focus();
	return false;
	}if(document.getElementById("phone").value=="")
	{alert("请输入您的手机号");
	document.getElementById("phone").focus();
	return false;
	}
	
	
}

</script>
 <blockquote class="layui-elem-quote">本会议室仅用于学术上的研讨、学习交流，请不要用于自习及玩闹休息场所，谢谢配合！</blockquote>
 <form class="layui-form" id="layui-form" action="AddServlet?userno=<%=user%>" method="post" >
		<div class="layui-inline">		
				<label class="layui-form-label">预约日期</label>
				<div class="layui-input-inline">
					<input type="text" name="time" id="Time"class="layui-input newsTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
		<div class="layui-form-item">
			<label class="layui-form-label">预约时间</label>
			<div class="layui-input-block">
				<div id="app">
<template>
  <el-time-select placeholder="起始时间" name="startTime" id="startTime" v-model="startTime" :picker-options="{ start: '08:30',step: '00:15',end: '18:30'}"></el-time-select>
  <el-time-select placeholder="结束时间" name="endTime" id="endTime"v-model="endTime":picker-options="{start: '08:30', step: '00:15', end: '18:30',minTime: startTime}"> </el-time-select>
</template>
	<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="chekTime" onclick="return check()">闲置查询</button>
</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">会议主题</label>
			<div class="layui-input-block">
				<input type="text" name="title" id="title"class="layui-input newsName " placeholder="请描述会议主题">
			</div>
		</div>
		
   <div class="layui-form-item">
    <label class="layui-form-label">使用设备</label>
    <div class="layui-input-block">
      <input type="checkbox" name="equips" value="投影仪" title="投影仪">
      <input type="checkbox" name="equips" value="电脑"title="电脑" >
      <input type="checkbox" name="equips" value="液晶电视" title="液晶电视">
    </div>
  </div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">参与人数</label>
				<div class="layui-input-inline">
					<input type="text" name="num" id="num" class="layui-input newsAuthor " placeholder="">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">参与人员</label>
				<div class="layui-input-inline">
					<input type="text" name="names"  class="layui-input "  placeholder="请输入参与人员姓名！">
				</div>
			</div>
			<div class="layui-form-item">
			<div class="layui-inline">		
				<label class="layui-form-label">您的手机号</label>
				<div class="layui-input-inline">
					<input type="text" name="phone"  id="phone"class="layui-input "  placeholder="请输入您的号码">
				</div>
			</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews" type="submit" name="AddMeeting"onclick="return check2()">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>

<div id="app1">
<template><div><el-divider><i>当前会议室预约情况</i></el-divider></div></template>
</div>		
</form>
<div style="text-align: center;">
  <div class="layui-inline">
    <table class="layui-table" lay-skin="line">
	  	<div style="text-align: center;">
	<colgroup>
    <col width="100">
    <col width="150">
     <col width="200">
    <col>
  </colgroup>
		    <thead>
				<tr>
					
					<th>预约人员</th>
					<th>预约日期</th>
					<th>预约时间</th>
					<th>审批情况</th>													
				</tr> 
		    </thead>
		    <tbody class="links_content">		   		
						<%
							//NoticeDaoImpl notice=new NoticeDaoImpl();
							AdmDaoImpl ad=new AdmDaoImpl();
							List<Meeting>list=ad.getMeeting();
							if(list.size()>0){
								for(Meeting n:list){
									%>
									<tr>
										
									<%
										out.println("<td>"+ n.getUserID() +"</td>");
										out.println("<td>"+ n.getTime() +"</td>");
										out.println("<td>"+ n.getStartTime() +"~"+n.getEndTime()+"</td>");
										out.println("<td>"+ n.getStatus() +"</td>");
																					
									%>
									</tr>
								<% }} %>
		    </tbody>
		</table>
   </div>
</div>
	


<script>
 var Main = {
    data() {
      return {
        startTime: '',
        endTime: ''
      };
    }
  }
var Ctor = Vue.extend(Main)
new Ctor().$mount('#app')
new Vue().$mount('#app1')
</script>
<script type="text/javascript" src="layui/layui.js"></script>	
<script type="text/javascript">
		layui.config({
		base : "../../js/"
	}).use(['form','layer','jquery','layedit','laydate'],function(){
		var form = layui.form(),
			layer = parent.layer === undefined ? layui.layer : parent.layer,
			laypage = layui.laypage,
			layedit = layui.layedit,
			laydate = layui.laydate,
			$ = layui.jquery;
	
		
		var editIndex = layedit.build('news_content');
	
})
	</script>
</body>
</html>