/**
 * 模块：前后台值得交互
 */

var app = new Vue({
    el : '#alldiv',
    data : {
	projectInfo : {},
	directInfo : {},
	supervisionInfo : {},
	sectInfo : {},
    },
    methods : {
	checkall : function(_id) {
	    ajaxRequest.checkall(_id).then(
		    function(data) {

			if (data.status == 200) {
			    $("#table_jldwjbxx  tr:not(:first)").empty()
			    $("#table_bdjbxx  tr:not(:first)").empty()
			    app.projectInfo = data.projectInfo[0];
			    app.directInfo = data.directInfo[0];
			    app.supervisionInfo = data.supervisionInfo;
			    app.sectInfo = data.sectInfo;

			    // 删除原有的内容
			    $("#table tbody_jldwjbxx tr").remove();
			    $("#table tbody_bdjbxx tr").remove();
			    var obj_jldw = app.supervisionInfo;// 监理单位列表
			    var obj_bd = app.sectInfo; // 标段列表
			    // 循环遍历表格

			    for (var i = 0; i < obj_jldw.length; i++) {

				var supervisionNo = obj_jldw[i].supervisionNo;
				var directorName = obj_jldw[i].directorName;
				var $tr = $("<tr>" + "<td>" + supervisionNo
					+ "</td>" + "<td>" + directorName
					+ "</td>" + "<td><a onclick='details("
					+ i + ")'>详情</a></td>" + "</tr>");
				var $table = $("#table_jldwjbxx");
				$table.append($tr);
			    }

			    for (var i = 0; i < obj_bd.length; i++) {

				var sectShortName = obj_bd[i].sectShortName;
				var shortName = app.directInfo.shortName;
				var sectNo = obj_bd[i].sectNo;
				var $tr = $("<tr>" + "<td>" + sectShortName
					+ "</td>" + "<td>" + shortName
					+ "</td>" + "<td>" + sectNo + "</td>"
					+ "<td><a onclick='bddetails(" + i
					+ ")'>详情</a></td>" + "</tr>");
				var $table = $("#table_bdjbxx");
				$table.append($tr);
			    }

			}
		    });

	}

    },
    created : function() {
	if (true) {
	}
    },

});
function details(i) {

    layer
	    .open({
		type : 1,
		title : false,
		closeBtn : 2,
		area : [ '920px', '340px' ], // 宽高
		skin : 'yourclass',
		content : "<div id='zhXMXX' class='panel-collapse collapse in'>"
			+ "<div class='panel-body'>"
			+ "<div class='container-fluid' style='margin: 0 5px;'>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>标段编号：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].supervisionNo
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>单位名称：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].sysDeptId
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>标段简称：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].supervisionShortName
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>单位地址：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].supervisionAdd
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>起始桩号：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].sectBeginPoint
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>结束桩号：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].sectEndPoint
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>监理工程师电话：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].directorTel
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>单位电话：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].supervisionTel
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>资质等级：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].zzhdj
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>证书号码：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].zhshhm
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>营业执照：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].yyzhzh
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>传真号码：</div><div class='col-md-3 show-item-show'>"
			+ app.supervisionInfo[i].chzhhm
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>单位业绩概况：</div><div class='col-md-9 show-item-show'>"
			+ app.supervisionInfo[i].dwyjgk
			+ "</div>"
			+ "</div>"
			+ "</div></div></div>"
	    })

}

function bddetails(i) {

    layer
	    .open({
		type : 1,
		title : false,
		closeBtn : 2,
		area : [ '920px', '340px' ], // 宽高
		skin : 'yourclass',
		content : "<div id='zhXMXX' class='panel-collapse collapse in'>"
			+ "<div class='panel-body'>"
			+ "<div class='container-fluid' style='margin: 0 5px;'>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>标段简称：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectShortName
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>标段编号：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectNo
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>单位名称：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sysDeptId
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>监理单位名称：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].superDeptName
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>单位地址：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].compAdd
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>单位电话：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].compTel
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>起点桩号：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectBeginPoint
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>结束桩号：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectEndPoint
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>计划开工日期：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].beginDay
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>计划完工日期：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].planEndDay
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>延长工期 ：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].lagDay
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>开工令日期：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].beginTokenDay
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='col-md-3 show-item-show'>项目经理：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectLeader
			+ "</div>"
			+ "<div class='col-md-3 show-item-show'>项目经理电话：</div><div class='col-md-3 show-item-show'>"
			+ app.sectInfo[i].sectLeaderTel
			+ "</div>"
			+ "</div>"
			+ "</div></div></div>"
	    })
}
