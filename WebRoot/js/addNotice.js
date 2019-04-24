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
	
	//添加公告
	$(".noticeAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "公告发布",
			type : 2,
			content : "jsp/page/noticeAdd.jsp",
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