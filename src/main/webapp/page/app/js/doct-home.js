$(function(){
	FastClick.attach(document.body);
	//域名变量（后台更改）
	var able="core.com";//更改
	var chao="http://www.ucom365.cn";//上测试时直接为空

	//切换关注
	$(".atten").on("click",function(){
		var txt=$(this).html();
		if (txt=="关注") {
			$(this).html("取消关注");
		}else{
			$(this).html("关注");
		}
	})
	//数据渲染
		//解析地址栏
		function parseUrl(){
		                var url=location.href;
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
		 var v = parseUrl();//解析所有参数

		 if (v.ids) {
		 		$.ajax({  
		 	        url: "http://"+able+"/core/app/getAllListByIdDetailed",
		 	        type: "post",
		 	        data:{employeeId:v.ids},
		 	        async:false,
		 	        dataType:"json", 
		 	        success: function(e){ 
		 	        	var ele=e.list;
		 	        	var str="",str1="";
		 	        	console.log(ele.hisDepartId)
		 	        		str+="<dl data-docname="+ele.employeeName+" data-hospname="+ele.hospName+" data-hospId="+ele.hospId+" data-docId="+v.ids+" data-docTitle="+ele.positionalTitles+"><dt data-departId="+ele.hisDepartId+"><img src="+ele.logo+"></dt><dd><p class='doc-name' title="+ele.id+">"+ele.employeeName+"<span title="+ele.hospId+">"+ele.hospName+"</span></p><p class='doc-info'><span class='doc-level'>"+ele.positionalTitles+"</span><span class='doc-obj' title="+ele.departId+">"+ele.departName+"</span></p><p class='doc-eval'>好评度<span class='star'></span></p></dd></dl>";
		 	        	$(".doct-info").html(str);

		 	        	//好评度星星
		 	        			var number=ele.praiseCount;
		 	        			if (number==1) {
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -0.01rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}else if(number==2){
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -0.25rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}else if(number==3){
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -0.5rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}else if(number==4){
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -0.75rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}else if(number==5){
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -1rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}else{
		 	        				$("section .doct-info dl dd p span.star").css({
		 	        					"background":"url(img/star.png) no-repeat 0 -1rem",
		 	        					"background-size":"cover"
		 	        				})
		 	        			}  
		 	        			str1+="<p class='favarite'>擅长<small>"+ele.goods+"</small></p>";
		 	        			$(".doct-info dl").after(str1);

		 	        },  
		 	        error: function(){  
		 	            console.log("科室详情跳转失败") 
		 	        }
		 		});
		 }else if(v.id){
		 	 //医生信息渲染
		 			$.ajax({  
		 		        url: "http://"+able+"/core/app/getEmployeeDepartAndhospDetailed",
		 		        type: "post",
		 		        data:{id:v.id},
		 		        async:false,
		 		        dataType:"json", 
		 		        success: function(e){ 
		 		        	var ele=e.list;
		 		        	var str="",str1="";
		 		        	console.log(ele.hisDepartId)
		 		        		str+="<dl data-docname="+ele.employeeName+" data-hospname="+ele.hospName+" data-hospId="+ele.hospId+" data-docId="+v.id+" data-docTitle="+ele.positionalTitles+"><dt data-departId="+ele.hisDepartId+"><img src="+ele.logo+"></dt><dd><p class='doc-name' title="+ele.id+">"+ele.employeeName+"<span title="+ele.hospId+">"+ele.hospName+"</span></p><p class='doc-info'><span class='doc-level'>"+ele.positionalTitles+"</span><span class='doc-obj' title="+ele.departId+">"+ele.departName+"</span></p><p class='doc-eval'>好评度<span class='star'></span></p></dd></dl>";
		 		        	$(".doct-info").html(str);
		 		        	
		 	  				//好评度星星
		 	  						var number=ele.praiseCount;
		 	  						if (number==1) {
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -0.01rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}else if(number==2){
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -0.25rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}else if(number==3){
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -0.5rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}else if(number==4){
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -0.75rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}else if(number==5){
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -1rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}else{
		 	  							$("section .doct-info dl dd p span.star").css({
		 	  								"background":"url(img/star.png) no-repeat 0 -1rem",
		 	  								"background-size":"cover"
		 	  							})
		 	  						}  
		 	  				
		 		        	str1+="<p class='favarite'>擅长<small>"+ele.goods+"</small></p>";
		 		        	$(".doct-info dl").after(str1);
		 		        },  
		 		        error: function(){  
		 		            console.log("名医推荐跳转失败")
		 		        }
		 			});
		 }

		 //截取字符串
		 /*var Img=$(".doct-info dl dt img").attr("src");
		 console.log(Img)
		 var newImg=Img.slice(29);*/
		
	//点击现在预约
	$(".now-order").on("click",function(){
		var doctorId=$(".doct-info dl").attr("data-docId"),
			doctorName=$(".doct-info dl").attr("data-docname"),
			departIdss=$(".doct-info dl dt").attr("data-departId"),
			departId="",
			hospId=$(".doct-info dl").attr("data-hospId"),
			hospName=$(".doct-info dl").attr("data-hospName"),
			doctorTitle=$(".doct-info dl").attr("data-docTitle"),
			betterFor=$(".favarite small").html(),
			urlPic=$(".doct-info dl dt img").attr("src"),
			departName=$(".doc-obj").html();

			 if (departIdss=="") {
				  departId=$(".doc-obj").attr("title");
			}else{
				   departId=departIdss;
			}
			console.log(departId)
			// 创建Form
			var form = $('<form></form>');
			// 设置属性
			form.attr('action', ""+chao+"/core/findMoreApp/doctorsRecommend");
			form.attr('method', 'post');
	        // form的target属性决定form在哪个页面提交
	        // _self -> 当前页面 _blank -> 新页面
	        form.attr('target', '_self');
	        // 创建Input
	        var hospitalIdInput = $("<input type='text' name='hospId'>");
	        var hospitalNameInput = $("<input type='text' name='hospName'>");
	        var deptIdInput = $("<input type='text' name='departId'>");
	        var doctorIdInput = $("<input type='text' name='doctorId'>");
	        var doctorNameInput = $("<input type='text' name='doctorName'>");
	        var doctorTitleInput = $("<input type='text' name='doctorTitle'>");
	        var betterForInput = $("<input type='text' name='betterFor'>");
	        var urlPicInput = $("<input type='text' name='urlPic'>");
	        var departNameInput = $("<input type='text' name='departName'>");
	        hospitalIdInput.attr('value',hospId);
	        hospitalNameInput.attr('value',hospName);
	        deptIdInput.attr('value',departId);
	        doctorIdInput.attr('value',doctorId);
	        doctorNameInput.attr('value',doctorName);
	        doctorTitleInput.attr('value',doctorTitle);
	        betterForInput.attr('value',betterFor);
	        urlPicInput.attr('value',urlPic);
	        departNameInput.attr('value',departName);
	        // 附加到Form
	        form.append(hospitalIdInput);
	        form.append(hospitalNameInput);
	        form.append(deptIdInput);
	        form.append(doctorIdInput);
	        form.append(doctorNameInput);
	        form.append(doctorTitleInput);
	        form.append(betterForInput);
	        form.append(urlPicInput);
	        form.append(departNameInput);
			// 提交表单
			form.submit();
				
	})

	//点击返回
	$(".back").on("click",function(){
		if (window.history.length>=2) {
			window.history.back();
		}else{
			window.jsobj.back(0);
		}
	})
})