$(function(){
		FastClick.attach(document.body);
		//域名变量（后台更改）
		var able="core.com";


		$.ajax({  
	        url: "http://"+able+"/core/app/getEmployeeDepartAndhospList",
	        type: "post",
	        data:{pageIndex:1,pageSize:10},
	        async:false,
	        dataType:"json", 
	        success: function(e){  
	        	var ele=e.list;
	        	var str="";
	        	console.log(ele)
	        	for(var i=0; i<ele.length;i++){
	        		str+="<dl title="+ele[i].id+"><dt><img src="+ele[i].logo+"></dt><dd><p class='doc-name'>"+ele[i].employeeName+"</p><p class='doc-info'><span class='doc-level'>"+ele[i].positionalTitles+"</span><span class='doc-obj' title="+ele[i].departId+">"+ele[i].departName+"</span></p><p class='doc-hospt' title="+ele[i].hospId+">"+ele[i]. hospName+"</p></dd></dl>";
	        	}
	        	$("section").html(str);
	        },  
	        error: function(){  
	            alert("失败");  
	        }
		});



		//点击跳转
		$("section dl").on("click",function(){
			
			var doctId=$(this).attr("title");
			location.href="doct-home.html?id="+doctId+"";
		})


		//点击返回
		$(".back").on("click",function(){
			window.jsobj.back(0);
		})







})