$(function(){

	//解析地址栏
	function parseUrl(){
	                var url=decodeURI(location.href);
	                var i=url.indexOf('?');
	                if(i==-1)return;
	                var querystr=url.substr(i+1);
	                var arr1=querystr.split('&');
	                var arr2=new Object();
	                for  (i in arr1){
	                    var ta=arr1[i].split('=');
	                    arr2[ta[0]]=ta[1];
	                }
	                return arr2;
	            }
	var urls = parseUrl();//解析所有参数
	console.log("urls = "+urls)

    //退款类型
    $("#tradeType").select({
        title: "请选择退款类型",
        items: [
        {
          title : "微信",
          value : 0
        },
        {
          title : "app",
          value : 1
        }
        ],
        onChange: function(data) {
        	if(data.values == 0) {
        		//公众号
        	    $("#appidType").select({
    	            title: "请选择退款类型",
    	            items: [
    	            {
    	              title : "鹿城健康365",
    	              value : 0
    	            },
    	            {
    	              title : "中心医院",
    	              value : 1
    	            }
    	            ],
    	            onChange: function(data) {

    	            }
        	    });
        	}
        }
    });

    //点击提交
	$(".cconBtn").on("click",function(){
        $(this).css({"background":"#1bc4ae"});
        inexe();
	})

	function inexe(){
		var appointOrderId=$("#appointOrderId").val(),
			tradeType=$("#tradeType").val();
			appidType=$("#appidType").val();
			tradeTypeValue=$("#tradeType").attr("data-values");
			appidTypeValue=$("#appidType").attr("data-values");
			alert("appointOrderId = "+appointOrderId)
			alert("tradeType = "+tradeType)
		if(appointOrderId==""){
			layer.open({
				content: '请填写订单号',
				skin: 'msg',
				time: 3 //秒后自动关闭
			});
			return false;
        }else if (tradeType=="") {
        	layer.open({
				content: '请选择挂号类型',
				skin: 'msg',
				time: 3 //秒后自动关闭
        	});
        	return false;
        } else if(tradeTypeValue == 0 && appidType=="") {
        	layer.open({
				content: '请选择挂号类型',
				skin: 'msg',
				time: 3 //秒后自动关闭
        	});
        	return false;
        } else {
        	// 确定退款 单体医院(中心医院)
        	if(tradeTypeValue == 0 && appidTypeValue == 1) {
        		alert("单体医院提交")
            	ajaxRequest.adminRefundSingle({"appointOrderId" : appointOrderId, "tradeType" : tradeTypeValue}).then(function(data){})
        	} else {
        		alert("鹿城健康365提交")
            	ajaxRequest.adminRefund({"appointOrderId" : appointOrderId, "tradeType" : tradeTypeValue}).then(function(data){})
        	}
        }
	}
})