$(function(){
		FastClick.attach(document.body);
		//rem适配
		/*var _cssText = document.querySelector("html").style.cssText;
		document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";
*/
		//域名变量 (后台更改)
		var able="core.com";
		//数据渲染

		$.ajax({  
	        url: "http://"+able+"/core/app/getDepartAndhospList",
	        type: "post",
	        data:{pageIndex:1,pageSize:25},
	        async:false,
	        dataType:"json", 
	        success: function(e){  
	        	var ele=e.list;
	        	var str="";
	        	for(var i=0; i<ele.length;i++){
	        		str+="<dl title="+ele[i].departId+"><dt><img src="+ele[i].logo+"></dt><dd><h3 class='objName'>"+ele[i].departName+"</h3><p class='hospName'>"+ele[i].hospName+"</p><p class='intro'>"+ele[i].introduce+"</p></dd></dl>";
	        	}
	        	$("section").html(str);
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});

		//页面跳转
		$("section dl").on("click",function(){
			var depId=$(this).attr("title");
			location.href="intro-hospt.html?id="+depId+"";
		})
		//返回按钮
		$(".back").on("click",function(){
			window.jsobj.back(1);
		})

})