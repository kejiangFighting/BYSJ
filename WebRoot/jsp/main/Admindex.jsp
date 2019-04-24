<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<title>管理员</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="css/main.css" media="all" />
  </head>
  
<body class="main_body">
	<% String no=(String)session.getAttribute("admin"); %>
    <div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main">
				<a href="#" class="logo">研究室助手</a>			
			    <!-- 顶部右侧菜单 -->
			    <ul class="layui-nav top_menu">
			    	<li class="layui-nav-item showNotice" id="showNotice" pc>
						<a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
					</li>
					<li class="layui-nav-item" pc>
						<a href="javascript:;">
							<img src="images/face.jpg" class="layui-circle" width="35" height="35">
							<cite><%=session.getAttribute("admin") %></cite>
						</a>
						<dl class="layui-nav-child">
							<dd><a href="javascript:;" data-url="jsp/common/changePwd.jsp?adminno=<%=session.getAttribute("admin")%>"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd>
							<dd><a href="javascript:;"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="user-photo">
				<a class="img" title="我的头像" ><img src="images/face.jpg"></a>
				<p>你好！<span class="userName"><%=session.getAttribute("admin") %></span>, 欢迎登录</p>
			</div>
			<div class="navBar layui-side-scroll">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="jsp/main/AdmMain.jsp">
							<i class="iconfont icon-computer" data-icon="icon-computer"></i>
							<cite>首页</cite>
						</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="jsp/admin/NoticeList.jsp">
							<i class="iconfont icon-text" data-icon="icon-text"></i>
							<cite>公告信息管理</cite>
						</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="jsp/admin/ComList.jsp">
							<i class="iconfont icon-text" data-icon="icon-text"></i>
							<cite>研究团队信息管理</cite>
						</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="jsp/admin/ScoreList.jsp">
							<i class="layui-icon" data-icon=""></i>
							<cite>资源共享</cite>
						</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" data-url="">
							<i class="layui-icon" data-icon=""></i>
							<cite>消息管理</cite>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="jsp/admin/AdmSendMsg.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>群发消息</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/common/UserSendMsg.jsp?fromno=<%= session.getAttribute("admin") %>">
									<i class="layui-icon" data-icon=""></i>
									<cite>单发消息</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/common/NeverReadMsgList.jsp?userno=<%= session.getAttribute("admin") %>">
									<i class="layui-icon" data-icon=""></i>
									<cite>未读消息</cite>
								</a>								
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/common/ReadedMsgList.jsp?userno=<%= session.getAttribute("admin") %>">
									<i class="layui-icon" data-icon=""></i>
									<cite>已读消息</cite>
								</a>								
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/admin/MsgListSendFromAdm.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>已发消息</cite>
								</a>								
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">
							<i class="layui-icon" data-icon=""></i>
							<cite>研究室设备管理</cite>
							<span class="layui-nav-more"></span>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="jsp/admin/StuManage.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>报修处理</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/admin/TeaManage.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>设备管理</cite>
								</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">
							<i class="layui-icon" data-icon=""></i>
							<cite>用户信息管理</cite>
							<span class="layui-nav-more"></span>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="jsp/admin/StuManage.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>学生用户信息管理</cite>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="jsp/admin/TeaManage.jsp">
									<i class="layui-icon" data-icon=""></i>
									<cite>教师用户信息管理</cite>
								</a>
							</dd>
						</dl>
					</li>
					<span class="layui-nav-bar"></span>
				</ul>
			</div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab marg0" lay-filter="bodyTab">
				<ul class="layui-tab-title top_tab">
					<li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>后台首页</cite></li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="jsp/main/AdmMain.jsp"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部 -->
		<div class="layui-footer footer">
			<p>2019@1501030208BYSJ
		</div>
	</div>

	
	<!-- 移动导航 -->
	<div class="site-tree-mobile layui-hide"><i class="layui-icon">&#xe602;</i></div>
	<div class="site-mobile-shade"></div>

	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script type="text/javascript" src="js/leftNav.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
  </body>
</html>
