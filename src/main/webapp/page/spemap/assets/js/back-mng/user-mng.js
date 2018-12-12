$(function () {
	//初始化区域统计-地区下拉框
	initSelectProvice("province-select","140000");
	initSelectCity("city-select",true,"140000","");
	initSelectArea("area-select",false,"","");
	
	
	//初始化表格数据
	getUserListByCon();
});
var dtable = null;

/**************************
 * 查询用户
 *************************/
function getUserListByCon() {
    if(isNoBlank(dtable)){  
        dtable.clear(); //清空数据.fnClearTable();//清空数据  
        //dtable.destroy(); //从当前上下文销毁掉Datatables对象
        dtable.draw(); //重绘表格
    }
    
	//dtable = $("#datatable").dataTable({  
    //初始化表格
    dtable = $("#datatable").dataTable({
        language:cnLanguageData,  //提示信息
        lengthChange: false,
        //lengthMenu: [10, 25, 50],
        autoWidth: false,  //禁用自动调整列宽
        stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
        //processing: true,  //隐藏加载提示,自行处理
        serverSide: true,  //启用服务器端分页
        searching: false,  //禁用原生搜索
        //"info": false,   //去掉底部文字
        destroy: true,  
    	retrieve: true,//保证只有一个table实例  
        orderMulti: true,  //启用多列排序
        ordering:false,//关闭表格的排序功能
        order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
        renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
        pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
        //列表表头字段
        columns: [
//          { "name": "id","data": "id"
//              	"render" : function(data,type, row, meta) {
//                      return (data == 1? "可以查发":data == 2?"可以链接":data == 3?"仅供查询":"不可用");  
//                  } 
//          },
            { "name": "index","data": null },
            { "name": "acc","data": "account" },
            { "name": "pwd","data": "password" },
            { "name": "area","data": "emArea.name" },
            { "name": "name","data": "name" },
            { "name": "mob","data": "mobile" },
          	{ "name": "act","data": "","defaultContent" : ""}
        ],
        columnDefs: [
//      	{
//      		"name": "id", //列的样式名
//              "targets": 0,  
//              "visible":false
//      	},
        	{
        		"name": "index", //列的样式名
                "targets": 0 
        	},
        	{
        		"name": "acc", //列的样式名
                "targets": 1 
        	},
        	{
        		"name": "pwd", //列的样式名
                "targets": 2 ,
                "visible":false
        	},
        	{
        		"name": "area", //列的样式名
                "targets": 3 
        	},
        	{
        		"name": "name",//列的样式名
        		"targets": 4,  
                "orderable": false    //包含上样式名‘nosort’的禁止排序
        	},
        	{
        		"name": "mob", //列的样式名
                "targets": 5 
        	}
			,{
                // 定义操作列,######以下是重点########
                "name": "act", //列的样式名
                "targets" : 6,//操作按钮目标列
                "data" : null
//              "render" : function(data,type, row) {
//                  var id = '"' + row.id + '"';
//                  //<a href='javascript:void(0);'  class='delete btn btn-default btn-xs'  ><i class='fa fa-times'></i> 查看</a>
//                  var html = "<button class='btn btn-xs btn-success' onclick='add()'><i class='icon-ok'></i> </button>"
//                  html += "<button class='btn btn-xs btn-warning' onclick='edit("
//                          + id
//                          + ")'><i class='icon-pencil'></i> </button>"
//                  html += "<button class='btn btn-xs btn-danger' onclick='del("
//                          + id
//                          + ")'><i class='icon-remove'></i> </button>"
//                  return html;
//              }
            }
        ],
         createdRow: function ( row, data, index ) {  
         	//	alert(data.id);
            //不使用render，改用jquery文档操作呈现单元格  
            var $btnEdit = $('<button type="button" class="btn btn-info btn-edit" onclick="javascript:goEditUser(\''+data.id+'\');">修改</button>'); 
            var $btnDel = $('<button type="button" class="btn btn-info btn-del" onclick="javascript:goDelUser(\''+data.id+'\');">删除</button>');  
            $('td', row).eq(5).append($btnEdit).append($btnDel);  

        },  
        drawCallback: function( settings ) {  //表格重绘的时候回调函数
            //渲染完毕后的回调  
            //默认选中第一行  
            //$("tbody tr",$table).eq(0).click();  
            
            //给添加序号
            var api = this.api();
            //var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
		　　api.column(0).nodes().each(function(cell, i) {
			  //cell.innerHTML = startIndex + i + 1;//此处 startIndex + i + 1;会出现翻页序号不连续，主要是因为startIndex 的原因,去掉即可。
		　　　　cell.innerHTML =  i + 1;
			});
        },  
        ajax: function (data, callback, settings) {
            //封装请求参数
            var param = {};
            param.provinceCode = $("#province-select").val();
            param.cityCode = $("#city-select").val();
            param.areaCode = $("#area-select").val();
            param.account = $("#con-user-acc").val();//查询条件  
            param.name = $("#con-user-name").val();//查询条件  
            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.start = data.start;//开始的记录序号
            param.pageNumber = (data.start / data.length)+1;//当前页码
//          param.sortBy = "";
//          param.orderBy = "";
            param.draw = data.draw;//访问计数器
            
            //console.log(param);
            //ajax请求数据
            $.ajax({
                type: "post",
                url: baseUrl + 'web/user/findPriUsers',
                cache: false,  //禁用缓存
                data: param,  //传入组装的参数
                dataType: "json",
                success:function(responseData){
					//alert(responseData.state);
					if(responseData.state=='failure'){
						//alert(responseData.result);
						//console.log(responseData.result);
						//$("#joinBtn").show();
						dtable.clear(); //清空数据.fnClearTable();//清空数据
						dtable.destroy(); //清空数据.fnClearTable();//清空数据
					}else if(responseData.state=='success'){
                    //console.log(result);
                    //setTimeout仅为测试延迟效果
                    //setTimeout(function () {
                    	
                        //封装返回数据
                        var returnData = {};
                        //returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.draw = responseData.draw;//访问计数器
                        returnData.recordsTotal = responseData.result.totalElements;//总记录数,返回数据全部记录
                        returnData.recordsFiltered = responseData.result.totalElements;//过滤后的总记录数,后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = responseData.result.content;//返回的数据列表
                        //console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    //}, 200);
                    }
                },
                error : function(XMLHttpRequest,textStatus,errorThrown) {
                    alert("查询失败");

                }
            });
        }
    }).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象	   
    
}


/**************************
 * 修改用户
 *************************/
function goEditUser(id) {
	//alert(id);
	$("#edit-id").val(id);
	$("#edit-acc-tip").val("");
	$("#edit-pwd-tip").val("");
	$("#edit-mobile-tip").val("");
	$("#edit-mail-tip").val("");
	selUserForEdit(id);
	
}
/**************************
 * 删除用户
 *************************/
function goDelUser(id) {
	//alert(id);
	$("#info-id").val(id);
	selUserForDel(id);
	
}
/**************************
 * 新增用户
 *************************/
function goAddUser() {
	//初始化菜单项
	$("#add-acc").val("");
	$("#add-pwd").val("");
	$("#add-name").val("");
	$("#add-mobile").val("");
	$("#add-mail").val("");
	
	$("#add-acc-tip").val("");
	$("#add-pwd-tip").val("");
	$("#add-mobile-tip").val("");
	$("#add-mail-tip").val("");
	
	$("input[name='add-sex']:eq('0')").attr("checked",'checked');
	//初始化区域统计-地区下拉框
	initSelectProvice("add-province-select","140000");
	initSelectCity("add-city-select",true,"140000","");
	initSelectArea("add-area-select",false,"","");
	initUserType("add-type");
	initUserLevel("add-level");
	$("#modal-add").modal('show');
	
}
/**************************
 * 修改用户
 *************************/
function editUser() {
	var id = $("#edit-id").val();
	var account = $("#edit-acc").val();
	
	var password = $("#edit-pwd").val();
	var passwordMd5 = password;
	//密码没有改动
	if(isNoBlank(password) && password.length>20  && isNoBlank(id)){
		var pwdFlag = validatePassword(id,password);
		//密码和md5密码不一致
		if(!pwdFlag){
			$("#edit-pwd").html("");
			$("#edit-pwd-tip").html("密码已改动,和原密码不符,请输入新密码");
			$("#edit-pwd-tip").css("display","block");
			$("#edit-pwd-tip").css("color","red");
			return;
		}
		
	//密码新设
	}else if(isNoBlank(password) && password.length<=20){
		var passwordRegexp = /^\w{6,20}$/;
		if(!passwordRegexp.test(password)){
			$("#edit-pwd-tip").html("");
			$("#edit-pwd-tip").append("密码只能由6~20位的字母、数字或下划线组成");
			$("#edit-pwd-tip").css("display","block");
			$("#edit-pwd-tip").css("color","red");
			return;
		}else{
			passwordMd5 = hex_md5(password);
		}
	}else{
		$("#edit-pwd-tip").html("");
		$("#edit-pwd-tip").append("密码不能为空");
		$("#edit-pwd-tip").css("display","block");
		$("#edit-pwd-tip").css("color","red");
		return;
	}
	var type = $("#edit-type").val();
	var level = $("#edit-level").val();
	var name = $("#edit-name").val();
	var sex = $('input[name="edit-sex"]:checked').val();
	var areaCode = getAreaCode("edit-province-select","edit-city-select","edit-area-select");
	var mobile = $("#edit-mobile").val();
	var mobileRegexp = /^0?1[3|4|5|8][0-9]\d{8}$/;
	if(isNoBlank(mobile) && !mobileRegexp.test(mobile)){
		$("#edit-mobile-tip").html("");
		$("#edit-mobile-tip").append("请输入正确的手机号码");
		$("#edit-mobile-tip").css("display","block");
		return;
	}
	var mail = $("#edit-mail").val();
	var mailRegexp = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(isNoBlank(mail) && !mailRegexp.test(mail)){
		$("#edit-mail-tip").html("");
		$("#edit-mail-tip").append("请输入正确的邮箱");
		$("#edit-mail-tip").css("display","block");
		return;
	}
	var priUser = {
		id:id,
		account:account,
		password:passwordMd5,
		type: type,
		level: level,
		name: name,
		sex: sex,
		areaCode: areaCode,
		mobile: mobile,
		mail: mail
	};
	$.ajax({
		url: baseUrl + 'web/user/updPriUser', //controller方法选择
		headers: {
			'Content-type': 'application/json;charset=UTF-8'
		}, //传entity对象参数时，规划格式
		type: 'post', //提交方式
		data: JSON.stringify(priUser),
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		//async: false,//设置才ajax同步加载，即后台执行完成后再执行前台				
		//成功执行方法 
		dataType:'json',//返回数据的类型
		//成功执行方法 
		success:function(responseData){
			//alert(responseData.state);
			if(responseData.state=='failure'){
				//alert(responseData.result);
				//console.log(responseData.result);

			}else if(responseData.state=='success'){
				$("#modal-edit").modal('hide');
				dtable.draw();
				
			}
		}
	})
}
/**************************
 * 修改用户
 *************************/
function addUser() {
	var account = $("#add-acc").val();

	if(isBlank(account)){
		$("#add-acc-tip").html("").append("账号不能为空");
		$("#add-acc-tip").css("display","block");
		$("#add-acc-tip").css("color","red");
		return;
	}else{
		var accFlag = validateAccount(account);
		//账号已经存在
		if(!accFlag){
			$("#add-acc-tip").html("").append("该账号已经存在");
			$("#add-acc-tip").css("display","block");
			$("#add-acc-tip").css("color","red");
			return;
		}
	}
	
	var password = $("#add-pwd").val();
	var passwordMd5 = password;
	//密码没有改动
	if(isNoBlank(password)){
		var passwordRegexp = /^\w{6,20}$/;
		if(!passwordRegexp.test(password)){
			$("#add-pwd-tip").html("").append("密码只能由6~20位的字母、数字或下划线组成");
			$("#add-pwd-tip").css("display","block");
			$("#add-pwd-tip").css("color","red");
			return;
		}else{
			passwordMd5 = hex_md5(password);
		}
	}else{
		$("#add-pwd-tip").html("").append("密码不能为空");
		$("#add-pwd-tip").css("display","block");
		$("#add-pwd-tip").css("color","red");
		return;
	}
	
	var type = $("#add-type").val();
	var level = $("#add-level").val();
	var name = $("#add-name").val();
	var sex = $('input[name="add-sex"]:checked').val();
	var areaCode = getAreaCode("add-province-select","add-city-select","add-area-select");
	var mobile = $("#add-mobile").val();
	var mobileRegexp = /^0?1[3|4|5|8][0-9]\d{8}$/;
	if(isNoBlank(mobile) && !mobileRegexp.test(mobile)){
		$("#add-mobile-tip").html("");
		$("#add-mobile-tip").append("请输入正确的手机号码");
		$("#add-mobile-tip").css("display","block");
		return;
	}
	var mail = $("#add-mail").val();
	var mailRegexp = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(isNoBlank(mail) && !mailRegexp.test(mail)){
		$("#add-mail-tip").html("");
		$("#add-mail-tip").append("请输入正确的邮箱");
		$("#add-mail-tip").css("display","block");
		return;
	}
	var priUser = {
		account:account,
		password:passwordMd5,
		type: type,
		level: level,
		name: name,
		sex: sex,
		areaCode: areaCode,
		mobile: mobile,
		mail: mail
	};
	$.ajax({
		url: baseUrl + 'web/user/addPriUser', //controller方法选择
		headers: {
			'Content-type': 'application/json;charset=UTF-8'
		}, //传entity对象参数时，规划格式
		type: 'post', //提交方式
		data: JSON.stringify(priUser),
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		//async: false,//设置才ajax同步加载，即后台执行完成后再执行前台				
		//成功执行方法 
		dataType:'json',//返回数据的类型
		//成功执行方法 
		success:function(responseData){
			//alert(responseData.state);
			if(responseData.state=='failure'){
				//alert(responseData.result);
				//console.log(responseData.result);

			}else if(responseData.state=='success'){
				$("#modal-add").modal('hide');
				dtable.draw();
				
			}
		}
	})
}

/**************************
 * 删除用户
 *************************/
function delUser() {
	var userId = $("#info-id").val();
	$.ajax({
		url: baseUrl + 'web/user/delPriUser', //controller方法选择
		type: 'post', //提交方式
		data: {'userId':userId},
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		//async: false,//设置才ajax同步加载，即后台执行完成后再执行前台				
		//成功执行方法 
		dataType:'json',//返回数据的类型
		//成功执行方法 
		success:function(responseData){
			//alert(responseData.state);
			if(responseData.state=='failure'){
				//alert(responseData.result);
				//console.log(responseData.result);

			}else if(responseData.state=='success'){
				$("#modal-info").modal('hide');
				dtable.draw();
				
			}
		}
	})
}

/**************************
 * 查询用户-服务删除
 *************************/
function selUserForDel(id) {
	//alert(id);
	$.ajax({
		url: baseUrl + 'web/user/findPriUserById', //controller方法选择
		type: 'post', //提交方式
		data: {'userId':id},
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		//async: false,//设置才ajax同步加载，即后台执行完成后再执行前台				
		//成功执行方法 
		dataType:'json',//返回数据的类型
		//成功执行方法 
		success:function(responseData){
			//alert(responseData.state);
			if(responseData.state=='failure'){
				//alert(responseData.result);
				//console.log(responseData.result);

			}else if(responseData.state=='success'){
				var data = responseData.result;
				$("#info-acc").html("").append(data.account);
				$("#info-pwd").html("").append("******");
				if(isNoBlank(data.type)){
					var typeName = userTypeToName(data.type);
					$("#info-type").html("").append(typeName);
				}else{
					$("#info-type").html("");
				};
				if(isNoBlank(data.level)){
					var levelName = userLevelToName(data.level);
					$("#info-level").html("").append(levelName);
				}else{
					$("#info-level").html("");
				};

				if(isNoBlank(data.emArea)){
					$("#info-area").html("").append(data.emArea.name);
				}else{
					$("#info-area").html("");
				}
				if(isNoBlank(data.sex)){
					var sexName = sexToName(data.sex);
					$("#info-sex").html("").append(sexName);
				}else{
					$("#info-sex").html("");
				}
				
				$("#info-name").html("").append(data.name);
				$("#info-mobile").html("").append(data.mobile);
				$("#info-mail").html("").append(data.mail);
				
				$("#modal-info").modal('show');
				
			}
		}
	})
}

/**************************
 * 查询用户-服务编辑
 *************************/
function selUserForEdit(id) {
	//alert(id);

	$.ajax({
		url: baseUrl + 'web/user/findPriUserById', //controller方法选择
		type: 'post', //提交方式
		data: {'userId':id},
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		async: false,//设置才ajax同步加载，即后台执行完成后再执行前台				
		//成功执行方法 
		dataType:'json',//返回数据的类型
		//成功执行方法 
		success:function(responseData){
			//alert(responseData.state);
			if(responseData.state=='failure'){
				//alert(responseData.result);
				//console.log(responseData.result);

			}else if(responseData.state=='success'){
				var data = responseData.result;
				$("#edit-acc").val(data.account);
				$("#edit-pwd").val(data.password);

				initUserType("edit-type",data.type);
				initUserLevel("edit-level",data.level);
				if(isNoBlank(data.emArea)){
					initUserArea(data.areaCode,data.emArea.parentCode);
				}
				
				
				$("input[name='edit-sex']:eq("+data.sex+")").attr("checked",'checked'); 
				$("#edit-name").val(data.name);
				$("#edit-mobile").val(data.mobile);
				$("#edit-mail").val(data.mail);
				$("#modal-edit").modal('show');
			}
		}
	})
}
/**************************
 * 初始化-用户类别
 *************************/
function initUserType(obj,type) {
	$("#"+obj).select2(
	 	{
	 		theme: "classic",
	 		minimumResultsForSearch: Infinity,
	 		placeholder: '请选择'
	 	}
	 );
	 $("#"+obj).html("").append('<option value=""></option><option value="0">超级管理者</option><option value="1">中小企业局管理者</option><option value="2">中小企业局普通用户</option><option value="3">下级管理单位管理者</option><option value="4">下级管理单位普通用户</option><option value="5">公司管理者</option><option value="6">公司普通用户</option>');
	if(isNoBlank(type)){
		$("#"+obj).val(type);
	}else{
		$("#"+obj).val("");
	};
}
/**************************
 * 初始化-用户级别
 *************************/
function initUserLevel(obj,level) {
	$("#"+obj).select2(
	 	{
	 		theme: "classic",
	 		minimumResultsForSearch: Infinity,
	 		placeholder: '请选择'
	 	}
	 );
	$("#"+obj).html("").append('<option value=""></option><option value="1">高级</option><option value="2">中级</option><option value="3">低级</option>');

	if(isNoBlank(level)){
		$("#"+obj).val(level);
	}else{
		$("#"+obj).val("");
	};
}

/**************************
 * 初始化-用户地域
 *************************/
function initUserArea(areaCode,areaFatherCode) {
		
	//初始化区域统计-地区下拉框
//	initSelectProvice("edit-province-select","140000");
//	initSelectCity("edit-city-select",true,"140000","");
//	initSelectArea("edit-area-select",false,"","");
	
	if(isNoBlank(areaCode)){
		if(areaCode.substr(2,6) == "0000"){
			initSelectProvice("edit-province-select","140000");
			initSelectCity("edit-city-select",true,"140000","");
			initSelectArea("edit-area-select",false,"","");
		}else if(areaCode.substr(4,6) == "00"){
			initSelectProvice("edit-province-select","140000");
			initSelectCity('edit-city-select',true,areaFatherCode,areaCode);
			initSelectArea('edit-area-select',true,areaCode);
		}else if(areaCode.substr(4,6) != "00"){
			initSelectProvice("edit-province-select","140000");
			initSelectCity('edit-city-select',true,"140000",areaFatherCode);
			initSelectArea('edit-area-select',true,areaFatherCode,areaCode);
		}
	}else{
		
	}
}

/**
 * 验证账号是否已经存在
 * "true":账号不存在,没问题
 * "false":账号存在,有问题
 */
function validateAccount(accountReg) {
	var flag = false;

	//var mobileRegexp = /^0?1[3|4|5|8][0-9]\d{8}$/;
//	if(!mobileRegexp.test(accountReg)){
//		$("#"+objTip).html("");
//		$("#"+objTip).append("请输入正确的手机号码");
//		$("#"+objTip).css("display","block");
//		return;
//	}
	$.ajax({
		url: baseUrl + 'web/user/validateAccount', //controller方法选择
		type: 'post', //提交方式
		data: {'account':accountReg},
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		async: false,//设置才ajax同步加载，即后台执行完成后再执行前台	
		//成功执行方法 
		success:function(responseData){
			//console.log(responseData);
			//账号存在
			if(responseData){
				flag = false;
			//账号不存在
			}else{
				flag = true;
			}

		}
	});
	return flag;
}

/**
 * 验证密码是否一致
 * "true":一致,没问题
 * "false":不一致,有问题
 */
function validatePassword(userId,passwordReg) {
	var flag = false;

	$.ajax({
		url: baseUrl + 'web/user/validatePassword', //controller方法选择
		type: 'post', //提交方式
		data: {'password':passwordReg,'userId':userId},
		cache: false, //避免Ie，一次执行ajax，从缓存中读取错误信息
		async: false,//设置才ajax同步加载，即后台执行完成后再执行前台	
		//成功执行方法 
		success:function(responseData){
			//console.log(responseData);
			//密码一致
			if(responseData){
				//$("#"+objTip).html("");
				//$("#"+objTip).append("账号可用");
				//$("#"+objTip).css("display","block");
				//$("#"+objTip).css("color","green");
				flag = true;
			//密码不一致
			}else{
//				$("#"+objTip).html("");
//				$("#"+objTip).append("密码已改动,和原密码不符,请输入新密码");
//				$("#"+objTip).css("display","block");
//				$("#"+objTip).css("color","red");
				flag = false;
			}

		}
	});
	return flag;
}