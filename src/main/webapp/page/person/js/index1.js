$(function(){
	FastClick.attach(document.body);
	//域名变量（后台更改）
	var able="core.com";
	var ceshi="www.ucom365.cn";
	
//tab切换
	$(".body-nav-one").on("click",function(){
		$(".person").show();
		$(".body-nav-list").hide();
		$(this).addClass("bg").siblings().removeClass("bg");
	})
	$(".body-nav-two").on("click",function(){
		$(".body-nav-list").show();
		$(".person").hide();
		$(this).addClass("bg").siblings().removeClass("bg");
		$.ajax({  
	        url: "http://"+able+"/core/guide/getBodyPartsList",
	        type: "post",
	        async:false,
	        dataType:"json", 
	        success: function(e){  
	        	var ele=e.list;
	        	var str="<ul>";
	        	for(var i=0;i<ele.length;i++){
					str+="<li title="+ele[i].partId+">"+ele[i].partName+"<span></span></li>";
				}
				str+="</ul>";
				$(".body-nav-list").html(str);
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});
	})
	

//列表页li点击事件
	$(".body-nav-list").on("click","li",function(){
		animat();
		var id=$(this).attr("title");
		$.ajax({  
	        url: "http://"+able+"/core/guide/getSymptomByPart",
	        type: "post",
	        async:false,
	        dataType:"json", 
	        data:{"partId":id},
	        success: function(e){  
    	        	var str="<p>"+e.bodyPart.partName+"</p><ul>";
    				for(var i=0;i<e.syList.length;i++){
    					var str=str+"<li title="+e.syList[i].symptomId+">"+e.syList[i].symptomName+"<span></span></li>";
    				}
    				str+="</ul>";
    				$(".info").html(str);
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});
		     
	})
//动画	
	function animat(){
		$(".mark").show();
		$(".info").css({
			"-webkit-transform":"translate3d(0,0,0)",
			"-webkit-transition":"transform 1s",
			"-ms-transform":"translate3d(0,0,0)",
			"-ms-transition":"transform 1s",
			"-moz-transform":"translate3d(0,0,0)",
			"-moz-transition":"transform 1s",
			"-o-transform":"translate3d(0,0,0)",
			"-o-transition":"transform 1s"
		})
	}
	
	//遮罩显示
	$(".mark").on("click",function(){
		$(".info").css({
			"-webkit-transform":"translate3d(100%,0,0)",
			"-webkit-transition":"transform 1s",
			"-moz-transform":"translate3d(100%,0,0)",
			"-moz-transition":"transform 1s",
			"-o-transform":"translate3d(100%,0,0)",
			"-o-transition":"transform 1s",
			"-ms-transform":"translate3d(100%,0,0)",
			"-ms-transition":"transform 1s"
		})
		function hide(){
			$(".mark").hide();
		}
		timer=setTimeout(hide,1000);
	})

	
	//男女 切换
	$(".sex").on("click",function(){
		$(".sex label").toggleClass("bg");
		if ($("#sex-change").is(":checked")) {
			if ($("#age-change").is(":checked")) {
				$(".big-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			}else{
				$(".small-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			};
		}
		else{
			if ($("#age-change").is(":checked")) {
				$(".big-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			}else{
				$(".small-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			};
		}
		

	})

	//成人小孩 切换
	$(".age").on("click",function(){
		$(".age label").toggleClass("bg");
		if ($("#age-change").is(":checked")) {
			
			if ($("#sex-change").is(":checked")) {
				$(".big-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			}else{
				$(".big-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			};

		}
		else{
			if ($("#sex-change").is(":checked")) {
				$(".small-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			}else{
				$(".small-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			};
			
		}


	})

	//点击身体（图片）各部位
	$("section").on("click","img",function(){
		var num=$(".on").attr("data-num"); 
		animat();
		var id=$(this).attr("title");
		$.ajax({  
	        url: "http://"+able+"/core/guide/getSymptomByPart",
	        type: "post",
	        async:false,
	        dataType:"json", 
	        data:{"partId":id,"symptomRange":num},
	        success: function(e){  
    	        	var str="<p>"+e.bodyPart.partName+"</p><ul>";
    				for(var i=0;i<e.syList.length;i++){
    					var str=str+"<li title="+e.syList[i].symptomId+">"+e.syList[i].symptomName+"<span></span></li>";
    				}
    				str+="</ul>";
    				$(".info").html(str);
	        },  
	        error: function(){  
	            alert("失败");  
	        }
	    });
	     
	})
	//点击病症
	$('.info').on('click','li',function(){
		var id=$(this).attr("title");
		$(".info").hide();
		$(".mark").hide();
		$(".person").hide();
		$(".body-nav").hide();
		location.href="question1.html?id="+id+"";


	}); 
	        

    


    

	//点击转身
	turn();
	function turn(){
		$(".turn").on("click",function(){
			var size=$(".on").attr("data-size");
			if (size==1) {
				$(".big-boy-backside").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==2){
				$(".big-girl-backside").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==3){
				$(".small-boy-backside").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==4){
				$(".small-girl-backside").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==11){
				$(".big-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==22){
				$(".big-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==33){
				$(".small-boy-front").show().addClass("on").siblings().hide().removeClass("on");
			}else if(size==44){
				$(".small-girl-front").show().addClass("on").siblings().hide().removeClass("on");
			}
		})
	}




})




















