$(function(){
	FastClick.attach(document.body);

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

	//判断是否为微信
	function isWeiXin(){
		var ua = window.navigator.userAgent.toLowerCase();
		if(ua.match(/MicroMessenger/i) == 'micromessenger'){
			return true;
		}else{
			return false;
		}
	}

	$.ajax({  
        url: "http://"+able+"/core/guide/getDepartmentByProble",
        type: "post",
        async:false,
        dataType:"json", 
        data:{"problemId":res.id},
        success: function(e){  
        		var str="<div class='off-list'>";
        		var ele=e.hospAnddepartList;
        		if (ele.length==0) {
        			$(".ask").html("很抱歉,暂且没数据");
        			$(".ask").css({
        				"text-align":"center",
        				"font-size":"0.3rem",
        				"padding-top":"2rem"
        			})
        		}else{
        			if(isWeiXin()){
    	        			for(var i=0;i<e.hospAnddepartList.length;i++){
    	        				if (ele[i].hisDepartmentId=="") {
    	        					str+="<p><a href='http://"+ceshi+"/core/appoint/getDrRegScheduleInfo?hospitalId="+e.hospAnddepartList[i].hospId+"&hospitalName="+e.hospAnddepartList[i].hospName+"&deptName="+e.hospAnddepartList[i].departName+"&deptId="+e.hospAnddepartList[i].departId+"'><span title="+e.hospAnddepartList[i].departId+">"+e.hospAnddepartList[i].departName+"</span></br><small title="+e.hospAnddepartList[i].hospId+">"+e.hospAnddepartList[i].hospName+"</small></a></p>";
    	        				}else{
    	        					str+="<p><a href='http://"+ceshi+"/core/appoint/getDrRegScheduleInfo?hospitalId="+e.hospAnddepartList[i].hospId+"&hospitalName="+e.hospAnddepartList[i].hospName+"&deptName="+e.hospAnddepartList[i].departName+"&deptId="+e.hospAnddepartList[i].hisDepartmentId+"'><span title="+e.hospAnddepartList[i].departId+">"+e.hospAnddepartList[i].departName+"</span></br><small title="+e.hospAnddepartList[i].hospId+">"+e.hospAnddepartList[i].hospName+"</small></a></p>";
    	        				}
    	        				
    	        			}
    	        			str+="</div>";
    	        		}else{
    	        			for(var i=0;i<e.hospAnddepartList.length;i++){
    	        				if(ele[i].hisDepartmentId==""){
    	        					str+="<p><a href='http://"+ceshi+"/core/appointApp/getDrRegScheduleInfo?hospitalId="+e.hospAnddepartList[i].hospId+"&hospitalName="+e.hospAnddepartList[i].hospName+"&deptName="+e.hospAnddepartList[i].departName+"&deptId="+e.hospAnddepartList[i].departId+"'><span title="+e.hospAnddepartList[i].departId+">"+e.hospAnddepartList[i].departName+"</span></br><small title="+e.hospAnddepartList[i].hospId+">"+e.hospAnddepartList[i].hospName+"</small></a></p>";
    	        				}else{
    	        					str+="<p><a href='http://"+ceshi+"/core/appointApp/getDrRegScheduleInfo?hospitalId="+e.hospAnddepartList[i].hospId+"&hospitalName="+e.hospAnddepartList[i].hospName+"&deptName="+e.hospAnddepartList[i].departName+"&deptId="+e.hospAnddepartList[i].hisDepartmentId+"'><span title="+e.hospAnddepartList[i].departId+">"+e.hospAnddepartList[i].departName+"</span></br><small title="+e.hospAnddepartList[i].hospId+">"+e.hospAnddepartList[i].hospName+"</small></a></p>";
    	        				}
    	        				
    	        			}
    	        			str+="</div>";
    	        		}
    	        		$(".ask").html(str);
	        	}
        		
        },  
        error: function(){  
            alert("失败");  
        }  
    }); 
    

	//点击科室
	$(".case").on("click",function(){
		$(this).addClass("bgcolor");
	})






})