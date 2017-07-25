define([],function(){
    if(location.href.indexOf('question.html')== -1) return;
     
	//域名变量（后台更改）
	var able="core.com";
	var ceshi="www.ucom365.cn";

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
	var  res= parseUrl();//解析所有参数


	$.ajax({  
        url: "http://"+able+"/core/guide/getProblemBySymptom",
        type: "post",
        async:false,
        dataType:"json", 
        data:{"symptomId":res.id},
        success: function(e){  
        		var str="";
				for(var i=0;i<e.problemList.length;i++){
					
					 if (i==e.problemList.length-1) {
					 	str+="<div class='question'><p>"+e.problemList[i].problemContent+"</P><ul class='aff'><li class='yes yyes' title="+e.problemList[i].problemId+">是</li></ul></div>";
					 }else{
					 	str+="<div class='question'><p>"+e.problemList[i].problemContent+"</P><ul class='aff'><li class='yes' title="+e.problemList[i].problemId+">是</li><li class='no'>否</li></ul></div>";
					 }
	
				}
				$(".ask").html(str);
				
        },  
        error: function(){  
            alert("失败");  
        }  
    }); 

    //点击按钮（是）   科室的页面显示

    $(".yes").on("click",function(){
    	$(this).addClass("bgr");
		var Id=$(this).attr("title");
		location.href="chobj.html?id="+Id+"";
	});

    //点击否 问题切换
    $(".no").on("click",function(){
    		$(this).addClass("bgr");
    		$($(this).parent().parent()).next().css({
    			"-webkit-transform":"translate3d(0,0,0)",
    			"-webkit-transition":"transform 1s",
    			"-ms-transform":"translate3d(0,0,0)",
    			"-ms-transition":"transform 1s",
    			"-moz-transform":"translate3d(0,0,0)",
    			"-moz-transition":"transform 1s",
    			"-o-transform":"translate3d(0,0,0)",
    			"-o-transition":"transform 1s"
    		}).siblings().css({
    			"-webkit-transform":"translate3d(100%,0,0)",
    			"-webkit-transition":"transform 0.3s",
    			"-ms-transform":"translate3d(100%,0,0)",
    			"-ms-transition":"transform 0.3s",
    			"-moz-transform":"translate3d(100%,0,0)",
    			"-moz-transition":"transform 0.3s",
    			"-o-transform":"translate3d(100%,0,0)",
    			"-o-transition":"transform 0.3s"
    		})
    });








})