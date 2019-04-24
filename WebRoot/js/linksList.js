layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//鍔犺浇椤甸潰鏁版嵁
	var linksData = '';
	$.ajax({
		url : "../../json/linksList.json",
		type : "get",
		dataType : "json",
		success : function(data){
			linksData = data;
			if(window.sessionStorage.getItem("addLinks")){
				var addLinks = window.sessionStorage.getItem("addLinks");
				linksData = JSON.parse(addLinks).concat(linksData);
			}
			//鎵ц鍔犺浇鏁版嵁鐨勬柟娉�			linksList();
		}
	})

	//鏌ヨ
	$(".search_btn").click(function(){
		var newArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('鏌ヨ涓紝璇风◢鍊�,{icon: 16,time:false,shade:0.8});
      
		}else{
			layer.msg("璇疯緭鍏ラ渶瑕佹煡璇㈢殑鍐呭");
		}
	})

	//娣诲姞鍙嬫儏閾炬帴
	$(".linksAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "娣诲姞鍏憡",
			type : 2,
			content : "linksAdd.html",
			success : function(layero, index){
				layui.layer.tips('鐐瑰嚮姝ゅ杩斿洖鏂囩珷鍒楄〃', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		//鏀瑰彉绐楀彛澶у皬鏃讹紝閲嶇疆寮圭獥鐨勯珮搴︼紝闃叉瓒呭嚭鍙鍖哄煙锛堝F12璋冨嚭debug鐨勬搷浣滐級
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})
	
		//查看公告
	$(".readNotice_btn").click(function(){
		var index = layui.layer.open({
			title : "公告查看",
			type : 2,
			content : "jsp/page/Notice.jsp",
			success : function(layero, index){
				layui.layer.tips('点击此处返回公告列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})

	//鎵归噺鍒犻櫎
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('纭畾鍒犻櫎閫変腑鐨勪俊鎭紵',{icon:3, title:'鎻愮ず淇℃伅'},function(index){
				var index = layer.msg('鍒犻櫎涓紝璇风◢鍊�,{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//鍒犻櫎鏁版嵁
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].linksId == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								linksData.splice(i,1);
								linksList(linksData);
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("鍒犻櫎鎴愬姛");
	            },2000);
	        })
		}else{
			layer.msg("璇烽�鎷╅渶瑕佸垹闄ょ殑鏂囩珷");
		}
	})

	//鍏ㄩ�
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//閫氳繃鍒ゆ柇鏂囩珷鏄惁鍏ㄩ儴閫変腑鏉ョ‘瀹氬叏閫夋寜閽槸鍚﹂�涓�	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		data.elem.checked;
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})
 
	//鎿嶄綔
	$("body").on("click",".links_edit",function(){  //缂栬緫
		layer.alert('鎮ㄧ偣鍑讳簡鍙嬫儏閾炬帴缂栬緫鎸夐挳锛岀敱浜庢槸绾潤鎬侀〉闈紝鎵�互鏆傛椂涓嶅瓨鍦ㄧ紪杈戝唴瀹癸紝鍚庢湡浼氭坊鍔狅紝鏁璋呰В銆傘�銆�,{icon:6, title:'鍙嬮摼缂栬緫'});
	})

	$("body").on("click",".links_del",function(){  //鍒犻櫎
		var _this = $(this);
		layer.confirm('纭畾鍒犻櫎姝や俊鎭紵',{icon:3, title:'鎻愮ず淇℃伅'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<linksData.length;i++){
				if(linksData[i].linksId == _this.attr("data-id")){
					linksData.splice(i,1);
					linksList(linksData);
				}
			}
			layer.close(index);
		});
	})

	function linksList(that){
		//娓叉煋鏁版嵁
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td align="left">'+currData[i].linksName+'</td>'
			    	+'<td><a style="color:#1E9FFF;" target="_blank" href="'+currData[i].linksUrl+'">'+currData[i].linksUrl+'</a></td>'
			    	+'<td>'+currData[i].masterEmail+'</td>'
			    	+'<td>'+currData[i].linksTime+'</td>'
			    	+'<td>'+currData[i].showAddress+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit"><i class="iconfont icon-edit"></i> 缂栬緫</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+data[i].linksId+'"><i class="layui-icon">&#xe640;</i> 鍒犻櫎</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="7">鏆傛棤鏁版嵁</td></tr>';
			}
		    return dataHtml;
		}

		//鍒嗛〉
		var nums = 13; //姣忛〉鍑虹幇鐨勬暟鎹噺
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
