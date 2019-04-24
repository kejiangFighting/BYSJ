layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	
	//查询
	$(".search_btn").click(function(){
		if($(".search_input").val() != ''){
      
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})
	
//	//实习公司信息详情页
//	$(".readCompany_btn").click(function(){
//		var index = layui.layer.open({
//			title : "实习公司信息详情页",
//			type : 2,
//			content : "jsp/page/Notice.jsp",
//			success : function(layero, index){
//				layui.layer.tips('点击此处返回公告列表', '.layui-layer-setwin .layui-layer-close', {
//					tips: 3
//				});
//			}
//		})
//		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
//		$(window).resize(function(){
//			layui.layer.full(index);
//		})
//		layui.layer.full(index);
//	})
	
	//公告详情页
	$(".readNotice_btn").click(function(){
		var index = layui.layer.open({
			title : "公告详情页",
			type : 2,
			content : "",
			success : function(layero, index){
				layui.layer.tips('点击此处返回公告列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})
		

	
//	//添加公告
//	$(".noticeAdd_btn").click(function(){
//		var index = layui.layer.open({
//			title : "公告发布",
//			type : 2,
//			content : "jsp/page/noticeAdd.jsp",
//			success : function(layero, index){
//				layui.layer.tips('点击此处返回公告列表', '.layui-layer-setwin .layui-layer-close', {
//					tips: 3
//				});
//			}
//		})		
//		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
//		$(window).resize(function(){
//			layui.layer.full(index);
//		})
//		layui.layer.full(index);
//	})
		
		
	
//	
//	//添加实习公司信息
//	$(".comAdd_btn").click(function(){
//		var index = layui.layer.open({
//			title : "公司信息发布",
//			type : 2,
//			content : "jsp/page/ComAdd.jsp",
//			success : function(layero, index){
//				layui.layer.tips('点击此处返回公司列表', '.layui-layer-setwin .layui-layer-close', {
//					tips: 3
//				});
//			}
//		})
//		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
//		$(window).resize(function(){
//			layui.layer.full(index);
//		})
//		layui.layer.full(index);
//	})
//	
	
	

	function linksList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
		    return dataHtml;
		}

		//分页
		var nums = 13; //每页出现的数据量
		if(that){
			linksData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(linksData.length/nums),
			jump : function(obj){
				$(".links_content").html(renderDate(linksData,obj.curr));
				$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
