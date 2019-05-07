<%@ page language="java" import="java.util.*,Model.*,util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>预约详情</title>
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
 String userid=request.getParameter("userid");
 AdmDaoImpl ad=new AdmDaoImpl();
 Meeting meet=new Meeting();
 meet=ad.findMeeting(userid);
 %>
 <blockquote class="layui-elem-quote">本会议室仅用于学术上的研讨、学习交流，请不要用于自习及玩闹休息场所，谢谢配合！</blockquote>
 <form class="layui-form"  action="" method="post" >
		<div class="layui-inline">		
				<label class="layui-form-label">预约日期</label>
				<div class="layui-input-inline">
					<input type="text" name="time" value="<%=meet.getTime() %>" class="layui-input newsTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="time" class="layui-input newsTime"  value="<%=meet.getStartTime() %>" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
			
			<div class="layui-inline">		
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-inline">
					<input type="text" name="num"  class="layui-input " lay-verify="required" value="<%=meet.getEndTime() %>">
				</div>
			</div>
				
		<div class="layui-form-item">
			<label class="layui-form-label">会议主题</label>
			<div class="layui-input-block">
				<input type="text" name="title" class="layui-input newsName " lay-verify="required" value="<%=meet.getTitle()%>">
			</div>
		</div>
		
   <div class="layui-form-item">
    <label class="layui-form-label">使用设备</label>
     <div class="layui-input-block">
      <input type="text" name=""  autocomplete="off" class="layui-input"value="<%=meet.getEquip()%>">
    </div>
  </div>
		<div class="layui-form-item">			
			<div class="layui-inline">		
				<label class="layui-form-label">参与人数</label>
				<div class="layui-input-inline">
					<input type="text" name="num" value="<%=meet.getNum() %>" class="layui-input newsAuthor "placeholder="">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">参与人员</label>
				<div class="layui-input-inline">
					<input type="text" name="names"  value="<%=meet.getNames()%>"class="layui-input " lay-verify="required" >
				</div>
			</div>
			<div class="layui-form-item">
			<div class="layui-inline">		
				<label class="layui-form-label">您的手机号</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" value="<%=meet.getPhone() %>" class="layui-input " lay-verify="required" >
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