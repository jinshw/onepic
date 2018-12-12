	
			
	/**
	 * 获取图表属性
	 * @param name select的名称
	 */
	function initMapProvince(objId,mapName,dataVal,dataRangeMaxVal){
		var myChart = echarts.init(document.getElementById(objId));  
        //定义图表option  
        var option = {  
            //标题，每个图表最多仅有一个标题控件，每个标题控件可设主副标题  
            title: {  
                //主标题文本，'\n'指定换行  
                text: '',  
                //副标题文本，'\n'指定换行  
                subtext: '',  
                //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'center',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top'  
            },  
            //图例，每个图表最多仅有一个图例  
            tooltip : {  
                //触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'  
                trigger: 'item'  
            },  
            dataRange: {
            	orient: 'vertical', 
		        min: 0,
		        max: dataRangeMaxVal,
		        //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top',
		        text:['高','低'],
		        realtime: false,
		        calculable : true,
//		        color: ['orangered','yellow','lightskyblue']
				color: ['dodgerblue','lightskyblue','gainsboro']
		    },
            //工具箱，每个图表最多仅有一个工具箱  
            toolbox: {  
                //显示策略，可选为：true（显示） | false（隐藏），默认值为false  
                show: true,  
                //布局方式，默认为水平布局('horizontal')，可选为：'horizontal' | 'vertical'  
                orient: 'vertical',  
                //水平安放位置，默认为全图右对齐('right')，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'bottom',  
                //启用功能，目前支持feature，工具箱自定义功能回调处理  
                feature: {  
                    //辅助线标志  
                    mark: {show: true},  
                    //数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能  
                    dataView: {show: true, readOnly: false},  
                    //restore，还原，复位原始图表  
                    restore: {show: true},  
                    //saveAsImage，保存图片（IE8-不支持）,图片类型默认为'png'  
                    saveAsImage: {show: true}  
                }  
            },  
            //缩放漫游组件，仅对地图有效  
            /*roamController: {  
                //显示策略，默认为显示(true),可选为：true（显示） | false（隐藏）。  
                show: true,  
                //水平安放位置，默认为左侧('letf')，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top',  
                //必须，默认无(null),指定漫游组件可控地图类型，如：{ china: true }  
                mapTypeControl: {  
                    //指定地图类型  
                    'china': true  
                }  
            },*/  
            //series(地图),驱动图表生成的数据内容数组，数组中每一项为一个系列的选项及数据  
            series : [  
                {  
                    //系列名称，如果启用legend，该值将被legend.data索引相关  
                    name: '营业收入',  
                    //图表类型，必要参数！如为空或不支持类型，则该系列数据不被显示  
                    type: 'map',  
                    //地图类型，支持world，china及全国34个省市自治区。省市自治区的mapType直接使用简体中文：如'广东'  
                    mapType: mapName,  
                    //是否开启滚轮缩放和拖拽漫游，默认为false（关闭），其他有效输入为true（开启），'scale'（仅开启滚轮缩放），'move'（仅开启拖拽漫游）  
                    roam: 'scale',  
                    //图形样式，可设置图表内图形的默认样式和强调样式（悬浮时样式）  
                    itemStyle:{  
                        //正常时的样式  
                        normal:{  
                            //边框线宽，单位px  
                            borderWidth: 1,  
                            //边框颜色  
                            borderColor: 'gray',  
                            //标签，饼图默认显示在外部，离饼图距离由labelLine.length决定，地图标签不可指定位置   
                            label: {show:true}
                        },  
                        //鼠标经过时的样式  
                         emphasis: {  
                            //边框线宽，单位px  
                            borderWidth:2,  
                            //边框颜色  
                            borderColor:'#fff',  
                            //鼠标经过时区域的颜色  
			                color: '#32cd32', 
                            //标签  
                            label: {  
                                show: true,  
                                //文本样式  
                                textStyle: {  
                                    //文本字体颜色  
                                    color: '#fff'  
                                }  
                            }  
                        }  
                    },  
                    //当图表类型为地图时，需要说明每部分数据对应的省份，可设置选中状态，如 :{name: '北京',value: 1234,selected: true},  
                    data:dataVal  
                }
            ]  
        };  
        //为echarts对象加载数据     
         myChart.setOption(option); 
         //通过该事件进行底图的变换
	     myChart.on('click', function (result) {//回调函数，点击时触发，参数params格式参加官方API
	        var selectCity = result.name;
	        /*$.get('../assets/js/echarts/mapData/geoJson/'+selectCity+'.json', function (Citymap) {
            echarts.registerMap(selectCity, Citymap);*/
            
	        //alert(selectCity);
	        var dataValNext = null;
	        if(selectCity=="山西"){
	        	dataValNext = yysrData2016Shanxi;
	        }
	        myChart.setOption(getChartOptions(selectCity,dataValNext,99999999));
	        
	        
	    });
	}
	/**
	 * 获取图表属性
	 * @param name select的名称
	 */
	function getChartOptions(name,dataVal,dataRangeMaxVal){
		//alert("ss:"+name);
		return 	{
			//标题，每个图表最多仅有一个标题控件，每个标题控件可设主副标题  
            title: {  
                //主标题文本，'\n'指定换行  
                text: '',  
                //副标题文本，'\n'指定换行  
                subtext: '',  
                //水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'center',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top'  
            },  
            //图例，每个图表最多仅有一个图例  
            tooltip : {  
                //触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'  
                trigger: 'item'  
            },  
            dataRange: {
            	orient: 'vertical', 
		        min: 0,
		        max: dataRangeMaxVal,
		        //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top',
		        text:['高','低'],
		        realtime: false,
		        calculable : true,
//		        color: ['orangered','yellow','lightskyblue']
				color: ['dodgerblue','lightskyblue','gainsboro']
		    },
            //工具箱，每个图表最多仅有一个工具箱  
            toolbox: {  
                //显示策略，可选为：true（显示） | false（隐藏），默认值为false  
                show: true,  
                //布局方式，默认为水平布局('horizontal')，可选为：'horizontal' | 'vertical'  
                orient: 'vertical',  
                //水平安放位置，默认为全图右对齐('right')，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'bottom',  
                //启用功能，目前支持feature，工具箱自定义功能回调处理  
                feature: {  
                    //辅助线标志  
                    mark: {show: true},  
                    //数据视图，打开数据视图，可设置更多属性,readOnly 默认数据视图为只读(即值为true)，可指定readOnly为false打开编辑功能  
                    dataView: {show: true, readOnly: false},  
                    //restore，还原，复位原始图表  
                    restore: {show: true},  
                    //saveAsImage，保存图片（IE8-不支持）,图片类型默认为'png'  
                    saveAsImage: {show: true}  
                }  
            },  
            //缩放漫游组件，仅对地图有效  
            /*roamController: {  
                //显示策略，默认为显示(true),可选为：true（显示） | false（隐藏）。  
                show: true,  
                //水平安放位置，默认为左侧('letf')，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）  
                x: 'left',  
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）  
                y: 'top',  
                //必须，默认无(null),指定漫游组件可控地图类型，如：{ china: true }  
                mapTypeControl: {  
                    //指定地图类型  
                    'china': true  
                }  
            }, */ 
            //series(地图),驱动图表生成的数据内容数组，数组中每一项为一个系列的选项及数据  
            series : [  
                {  
                    //系列名称，如果启用legend，该值将被legend.data索引相关  
                    name: '营业收入',  
                    //图表类型，必要参数！如为空或不支持类型，则该系列数据不被显示  
                    type: 'map',  
                    //地图类型，支持world，china及全国34个省市自治区。省市自治区的mapType直接使用简体中文：如'广东'  
                    mapType: name,  
                    //是否开启滚轮缩放和拖拽漫游，默认为false（关闭），其他有效输入为true（开启），'scale'（仅开启滚轮缩放），'move'（仅开启拖拽漫游）  
                    roam: 'scale',  
                    //图形样式，可设置图表内图形的默认样式和强调样式（悬浮时样式）  
                    itemStyle:{  
                        //正常时的样式  
                        normal:{  
                            //边框线宽，单位px  
                            borderWidth: 1,  
                            //边框颜色  
                            borderColor: 'gray', 
                            //标签，饼图默认显示在外部，离饼图距离由labelLine.length决定，地图标签不可指定位置   
                            label: {show:true}  
                        },  
                        //鼠标经过时的样式  
                         emphasis: {  
                            //边框线宽，单位px  
                            borderWidth:2,  
                            //边框颜色  
                            borderColor:'#fff',  
                            //鼠标经过时区域的颜色  
                            color: '#32cd32',  
                            //标签  
                            label: {  
                                show: true,  
                                //文本样式  
                                textStyle: {  
                                    //文本字体颜色  
                                    color: '#fff'  
                                }  
                            }  
                        }  
                    },  
                    //当图表类型为地图时，需要说明每部分数据对应的省份，可设置选中状态，如 :{name: '北京',value: 1234,selected: true},  
                    data:dataVal 
                }
            ] 
	    };
	}