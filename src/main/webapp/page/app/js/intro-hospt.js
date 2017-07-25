$(function(){
		FastClick.attach(document.body);

		//域名变量 (后台更改)
		var able="core.com";
		var chao="http://www.ucom365.cn";//上测试时直接为空

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
		//数据渲染
		$.ajax({  
	        url: "http://"+able+"/core/app/getDepartAndhospListDetailed",
	        type: "post",
	        data:{departId:v.id},
	        async:false,
	        dataType:"json", 
	        success: function(e){ 
	        	var ele=e.charaDepartment;
	        	var deptN=ele.departName;
	        	var str="";

	        		str+="<dl><dt><img src='"+ele.logo+"'></dt><dd><h3 title="+ele.hisDepartId+">"+ele.departName+"</h3><p class='hospName' title="+ele.hospId+">"+ele.hospName+"</p><p class='intro'></p></dd></dl>";
	        	$(".hosintro").html(str);
	        	$("header p").html(deptN);
			//显示隐藏
		   var content = ""+ele.introduce+"";
		  
			  function showAllInfo(){
			       $('.intro').html(content);
			       $('.intro').after('<p class="downarrow"><img src="img/uparrow.png" class="up"></p>');

			       $(".downarrow").on("click",function(){
			       		hideAnyInfo();
			       		$(".up").hide();
			       })
			   }

			   function hideAnyInfo(){
			       var pLength = content.length;
			       if (pLength > 50) {
			           $('.intro').html(content.substr(0,50) + '......');
			           $('.intro').after('<p class="downarrow"><img src="img/downarrow.png" class="down"></p>')
			       }
			       $(".downarrow").on("click",function(){
			       		showAllInfo();
			       		$(".down").hide();
			       })
			   }
			   hideAnyInfo();
	        	
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});

		//医生数据渲染
		$.ajax({  
	        url: "http://"+able+"/core/app/getDepartAndhospListDetailed",
	        type: "post",
	        data:{departId:v.id},
	        async:false,
	        dataType:"json", 
	        success: function(e){ 
    			//图片滑动 插件引用
    			var swiper = new Swiper('.swiper-container', {
    			       pagination: '.swiper-pagination',
    			        slidesPerView: 3.5,//窗口显示几个
    			        paginationClickable: true,
    			        preventClicksPropagation:true,//拖动Swiper时阻止click事件
    			        observer:true,//修改swiper自己或子元素时，自动初始化swiper
    	    			observeParents:true,//修改swiper的父元素时，自动初始化swiper
    			        spaceBetween: 0//slide之间的距离（单位px）calculateHeight
    			  });
	        	var sls=e.list;
	        	var str="";
	        	for(var i=0;i<sls.length;i++){
	        		str+="<div class='swiper-slide'><img src='"+sls[i].employeeLogo+"'><p class='dleader'>"+sls[i].employeeTitle+"</p><p class='dName' title="+sls[i].id+">"+sls[i].employeeName+"</p></div>";

	        	}
	        	$(".swiper-wrapper").html(str);
	        	$(".swiper-slide").on("click",function(){
	        		var doctId=$(this).children(".dName").attr("title");
	        		console.log(doctId)
					location.href="doct-home.html?ids="+doctId+"";
	        	})
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});
		


		//点击按钮
		$(".etcBtn").on("click",function(){
			$(this).css({"background":"#1bc4ae"});
			var deptId=$(".hosintro dl h3").attr("title"),
				deptName=$(".hosintro dl h3").html(),
				hospitalId=$(".hosintro dl .hospName").attr("title"),
				hospitalName=$(".hosintro dl .hospName").html();
				//console.log(deptId)
			// 创建Form
			var form = $('<form></form>');
			// 设置属性
			form.attr('action', ""+chao+"/core/appointApp/getDrRegScheduleInfo");
			form.attr('method', 'post');
	        // form的target属性决定form在哪个页面提交
	        // _self -> 当前页面 _blank -> 新页面
	        form.attr('target', '_self');
	        // 创建Input
	        var hospitalIdInput = $("<input type='text' name='hospitalId'>");
	        var hospitalNameInput = $("<input type='text' name='hospitalName'>");
	        var deptIdInput = $("<input type='text' name='deptId'>");
	        var deptNameInput = $("<input type='text' name='deptName'>");
	        hospitalIdInput.attr('value',hospitalId);
	        hospitalNameInput.attr('value',hospitalName);
	        deptIdInput.attr('value',deptId);
	        deptNameInput.attr('value',deptName);
	        // 附加到Form
	        form.append(hospitalIdInput);
	        form.append(hospitalNameInput);
	        form.append(deptIdInput);
	        form.append(deptNameInput);
	       
			// 提交表单
			form.submit();
		})  

		//点击返回
		$(".back").on("click",function(){
			if (window.history.length>1) {
				window.history.back();
			}else{
				window.jsobj.back(1);
			}
		})
})







