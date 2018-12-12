	
$(function () {
	/**********************************营业收入-地图-初始化**********************************************/
	//营业收入-地图-时间插件初始化生成
	$('#dtp-yysr-map-yyyymm').datetimepicker({
	    viewMode: 'years',
    	format: 'YYYY年MM月'
	});
	//营业收入-地图-柱状图-表格-时间初始化生成
	dtpYysrMapYyyymmChange();
	/**********************************营业收入-行业统计-初始化**********************************************/
	//营业收入-行业统计-时间插件初始化生成
	$('#dtp-yysr-industry-yyyy').datetimepicker({
	    viewMode: 'years',
    	format: 'YYYY年'
	});
	$('#dtp-sjsj-industry-yyyy').datetimepicker({
	    viewMode: 'years',
    	format: 'YYYY年'
	});
	//营业收入-行业统计-柱状图时间初始化生成
	dtpYysrIndustryYyyyChange();
	dtpSjsjIndustryYyyyChange();

});			
//时间插件选择触发
function dtpYysrMapYyyymmChange(){
	var yearMonth = $("#dtp-yysr-map-yyyymm-val").val();
	//alert(yearMonth.substr(0,4)+yearMonth.substr(5,2));
	
	var titleName = yearMonth+"山西中小微营业收入柱状图统计";
	var subtitleName = "";
	var tableRowDataVal = [];
	var tableDataVal = [];
	var seriesDataVal = [];
	var mapOnlyDataVal = null;
	var mapAllDataVal = [];
	var maxValue = 0;
	$.getJSON("../data/yysrAreaData.json",function(data){
		$.each(data.data,function(index,item){
			if(item.year==yearMonth.substr(0,4) && item.month==yearMonth.substr(5,2)){
				//组织表格数据
				var mapOnlyData = "{name:'"+item.areaTaxName+"',value:"+item.sum+"}";

				mapAllDataVal.push(eval("("+mapOnlyData+")"));
				mapOnlyData = null;//再次初始化
				
				if(maxValue<parseFloat(item.sum)){
					maxValue = parseFloat(item.sum);
				}
				//组织表格数据
				tableRowDataVal.push(item.areaTaxName);
				tableRowDataVal.push(item.companySum);
				tableRowDataVal.push(item.sum);
				tableRowDataVal.push(item.zb);
				tableRowDataVal.push(item.tb);
				tableRowDataVal.push(item.hb);
				tableDataVal.push(tableRowDataVal);
				tableRowDataVal = [];//再次初始化
				//组织柱状图数据
				seriesDataVal.push(parseFloat(item.sum));
			}
		});
		if(isNoBlank(seriesDataVal)){
		//加载地图
		initMapProvince('chart-column-yysr-map','山西',mapAllDataVal,maxValue); 
		//加载table
		initYysrMapTable("yysr-table",tableDataVal);
		//加载柱状图
		var xAxisVal = ['太原','大同','朔州','忻州','晋中','吕梁','阳泉','长治','晋城','临汾','运城'];
		initEchartBar("echart-bar-yysr",titleName,xAxisVal,seriesDataVal);
		
		}else{
			$("#echart-bar-yysr").html("<b><br />暂无数据</b>");
		}
	});

}
//时间插件选择触发
function dtpYysrIndustryYyyyChange(){
	var yearMonth = $("#dtp-yysr-industry-yyyy-val").val();
	//alert(yearMonth.substr(0,4)+yearMonth.substr(5,2));
	
	var titleName = yearMonth+"山西中小微营业收入行业统计";
	var subtitleName = "";
	var seriesDataVal = [];

	$.getJSON("../data/yysrIndustryYearData.json",function(data){
		$.each(data.data,function(index,item){
			if(item.year==yearMonth.substr(0,4)){

				//组织柱状图数据
				seriesDataVal.push(parseFloat(item.sum));
			}
		});
		if(isNoBlank(seriesDataVal)){

			//加载柱状图
			var xAxisVal = ['农、林、牧、渔业','采矿业','制造业','电力、热力、燃气及水生产和供应业','建筑业','批发和零售业','交通运输、仓储和邮政业','住宿和餐饮业','信息传输、软件和信息技术服务业','房地产业','租赁和商务服务业','科学研究和技术服务业','水利、环境和公共设施管理业','居民服务、修理和其他服务业','卫生和社会工作','文化、体育和娱乐业'];
			initEchartBar("echart-bar-yysr-industry",titleName,xAxisVal,seriesDataVal);
		
		}else{
			$("#echart-bar-yysr-industry").html("<b><br />暂无数据</b>");
		}
	});

}
//时间插件选择触发
function dtpSjsjIndustryYyyyChange(){
	var yearMonth = $("#dtp-sjsj-industry-yyyy-val").val();
	//alert(yearMonth.substr(0,4)+yearMonth.substr(5,2));
	
	var titleName = yearMonth+"山西中小微营业收入行业统计";
	var subtitleName = "";
	var seriesDataVal = [];

	$.getJSON("../data/sjsjIndustryYearData.json",function(data){
		$.each(data.data,function(index,item){
			if(item.year==yearMonth.substr(0,4)){

				//组织柱状图数据
				seriesDataVal.push(parseFloat(item.sum));
			}
		});
		if(isNoBlank(seriesDataVal)){

			//加载柱状图
			var xAxisVal = ['农、林、牧、渔业','采矿业','制造业','电力、热力、燃气及水生产和供应业','建筑业','批发和零售业','交通运输、仓储和邮政业','住宿和餐饮业','信息传输、软件和信息技术服务业','房地产业','租赁和商务服务业','科学研究和技术服务业','水利、环境和公共设施管理业','居民服务、修理和其他服务业','卫生和社会工作','文化、体育和娱乐业'];

			initEchartBar("echart-bar-sjsj-industry",titleName,xAxisVal,seriesDataVal);
		
		}else{
			$("#echart-bar-sjsj-industry").html("<b><br />暂无数据</b>");
		}
	});

}	

/**********************************营业收入-统计图生成**********************************************/
/**
 * 营业收入-地图-柱状图生成
 */
function initEchartBar(objId,titleText,xAxisVal,yysrDataVal){
	
	var myChart = echarts.init(document.getElementById(objId));  
    //定义图表option  
    var option = {
	    title : {
	        text: titleText,
	        subtext: ''
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
//	    legend: {
//	        data:['营业收入']
//	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    xAxis : [ 
	    	{
	            type : 'category',
	            "axisLabel":{  
		             interval: 0,
	                 rotate:45,
	                 margin:2  
		        },  
	            data : xAxisVal
	        }
	    ],
	     grid: { // 控制图的大小，调整下面这些值就可以，
             x: 40,
             x2: 100,
             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
         },
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'营业收入',
	            type:'bar',
	            data:yysrDataVal,
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最高'},
	                    {type : 'min', name: '最低'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        }
	    ]
	};
    //为echarts对象加载数据     
     myChart.setOption(option); 

}

//定义成全局变量-营业收入-地图-table表
var yysrMapDataTable = null;
/**
 * 营业收入-地图-表格生成
 */
function initYysrMapTable(objId,ajaxData){
	if(isNoBlank(yysrMapDataTable)){
		yysrMapDataTable.fnClearTable();//清空数据.fnClearTable();//清空数据  
		yysrMapDataTable.fnDestroy(); //还原初始化了的datatable 
	}

	yysrMapDataTable = $("#"+objId).dataTable({
		"aLengthMenu": [ 15, 25, 50], 				
		"bSort": true, //排序功能
		"bLengthChange": false, //改变每页显示数据数量
		"bFilter": false, //过滤功能
		"info": false,   //去掉底部文字
		"oLanguage" : cnLanguageData,
        "bDestroy" : true,  
        "retrieve": true,//保证只有一个table实例  
		data: ajaxData
        
//      "ajax": "../data/abc.json",
//      "columns": [
//          { "data": "areaTaxName" },
//          { "data": "companySum" },
//          { "data": "sum" },
//          { "data": "zb" },
//          { "data": "tb" },
//          { "data": "hb" }
//      ]
		
	});
}
