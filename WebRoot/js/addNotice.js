layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	

	//��ѯ
	$(".search_btn").click(function(){
		if($(".search_input").val() != ''){
      
		}else{
			layer.msg("��������Ҫ��ѯ������");
		}
	})
	
	//��ӹ���
	$(".noticeAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "���淢��",
			type : 2,
			content : "jsp/page/noticeAdd.jsp",
			success : function(layero, index){
				layui.layer.tips('����˴����ع����б�', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})

		//�ı䴰�ڴ�Сʱ�����õ����ĸ߶ȣ���ֹ��������������F12����debug�Ĳ�����
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})