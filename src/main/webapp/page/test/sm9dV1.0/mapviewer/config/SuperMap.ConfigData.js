//定义地图初始化配置数据结构
BaseObject.GlobalMap.ConfigData = {
    baseMaps: null,
    layers: null,
    tools: null,
    controls: null,
    widgets: null
}

BaseObject.GlobalMap.DefaultConfigData = {
    bounds: "80.1121790515151,17.9253423753938,134.296006725842,51.3507932270128",
    level: 4,
    controls: [ 
    ],
    
    maps: [
    	{
	        "ICON": "mapTool/theme/images/tabMap-2.png;ico_09",
	        "NAME": "矢量",
	        "DEFAULT": "1",
	        "ID": "20EAC71493A54ADC811BE8012DBB6733",
	        "NOTE": {
	            "projection": "EPSG:4326",
	            "label": "cta",
	            "type": "vec",
	            "isLabel": true,
	            "crs": "L.CRS.EPSG4326",
	            "northEast":{"x":"87.80423250656662","y":"43.879583553655259"},
	        	"southWest":{"x":"87.613345803144682","y":"43.776029041703033"},
	        	"minZoom":"13",
	        	"maxZoom":"",
	        	"initZoom":"5"
	        },
	        "URL":"http://127.0.0.1:8090/iserver/services/map-zhdt/rest/maps/综合地图",
	        "CENTER": {
	        	"x":"84.93789460755",
	        	"y":"41.756541686276"
	        },
	        "BOUNDS":"7980130.13925814,2518086.4813501,15376788.4923587,6959995.06905867",
	        "TYPE": "REST",
	        "CODE": "jc"
        },
		{
		    "ICON": "mapTool/theme/images/tabMap-83.png;ico_02",
		    "NAME": "影像",
		    "DEFAULT": "0",
		    "ID": "201ACA3FC5A74BB8A7F3C887FBCED5A9",
		    "NOTE": {
		        "projection": "EPSG:4326",
		        "label": "cta",
		        "type": "vec",
		        "isLabel": true,
		        "crs": "L.CRS.EPSG4326",
		        "northEast":{"x":"87.80423250656662","y":"43.879583553655259"},
	        	"southWest":{"x":"87.613345803144682","y":"43.776029041703033"},
	        	"minZoom":"13",
	        	"maxZoom":"",
	        	"initZoom":"5"
		    },
		    "URL":"http://127.0.0.1:8090/iserver/services/map-world/rest/maps/World",
	        "CENTER": {
	        	"x":"84.93789460755",
	        	"y":"41.756541686276"
	        },
	        "BOUNDS":"7980130.13925814,2518086.4813501,15376788.4923587,6959995.06905867",
		    "TYPE": "REST",
		    "CODE": "yx"
		}
    ],
    layers: [],
    tools: [],
    configIMaps: [{
        code: "LeafletMap",
        url: "/sm9dV1.0/mapviewer/SMap/SuperMap.LeafletMap.js",
        isDefault: false,
        params: {
            code: "DEFAULT"
        },
       
        configServices: [{
            code: "Location",
            url: "/sm9dV1.0/mapviewer/utils/SuperMap.Location.js",
            preload: true
        },
            {
                code: "ThematicLayer",
                url: "/sm9dV1.0/mapviewer/thematic/SuperMap.ThematicLayer.js",
                preload: true,
                configServices: [{
                        code: "JuHe",
                        url: "/sm9dV1.0/mapviewer/thematic/thematicmap/JuHe.Theme.js"
                    },
                    {
                        code: "DanZhiFuHao",
                        url: "/sm9dV1.0/mapviewer/thematic/thematicmap/DanZhiFuHao.Theme.js"
                    },
                    {
                        code: "DanZhi",
                        url: "/sm9dV1.0/mapviewer/thematic/thematicmap/DanZhi.Theme.js"
                    },
                    {
                        code: "EchartPulsePoint",
                        url: "/sm9dV1.0/mapviewer/thematic/thematicmap/EchartPulsePoint.Theme.js"
                    }
                ]
            }
        ]
       }
    ],
    configTools: [{
        code: "PointChoose",
        url: "/sm9dV1.0/mapviewer/tool/SuperMap.PointChoose.js"
    },
		{
		    code: "LineChoose",
		    url: "/sm9dV1.0/mapviewer/tool/SuperMap.LineChoose.js"
		},
		{
		    code: "CircleChoose",
		    url: "/sm9dV1.0/mapviewer/tool/SuperMap.CircleChoose.js"
		},
		{
		    code: "PolygonChoose",
		    url: "/sm9dV1.0/mapviewer/tool/SuperMap.PolygonChoose.js"
		},
		{
		    code: "RectangleChoose",
		    url: "/sm9dV1.0/mapviewer/tool/SuperMap.RectangleChoose.js"
		},
		{
		    code: "PathAnalys",
		    url: "/sm9dV1.0/mapviewer/tool/SuperMap.PathAnalys.js"
		},
		{
		    code: "DrawCircle",
		    url: "/sm9dV1.0/mapviewer/tool/leaflet/SuperMap.EditCircle.js"
		},
		{
		    code: "DrawPolygon",
		    url: "/sm9dV1.0/mapviewer/tool/leaflet/SuperMap.DrawPolygon.js"
		}

    ],
    configServices: [{
        code: "SqlQueryService",
        url: "/sm9dV1.0/mapviewer/service/SuperMap.SqlQueryService.js"
        },
		{
		    code: "BufferQueryService",
		    url: "/sm9dV1.0/mapviewer/service/SuperMap.BufferQueryService.js"
		},
		{
		    code: "GeometryChooseQuery",
		    url: "/sm9dV1.0/mapviewer/service/SuperMap.GeometryChooseQuery.js"
		},
		{
		    code: "TransferPathQueryService",
		    url: "/sm9dV1.0/mapviewer/service/SuperMap.TransferPathQueryService.js"
		},
		{
		    code: "MapService",
		    url: "/sm9dV1.0/mapviewer/service/SuperMap.MapService.js"
		},
		{
		    code: "AttrViewer",
		    url: "/sm9dV1.0/mapviewer/attrviewer/attrviewer-app.js"
		}
    ],
    configCommonComponets: [
    	{
		    code: "EditManage",
		    url: "sm9dV1.0/mapviewer/manage/SuperMap.EditManage.js",
		    sortIndex: "10"
		}
    ]
}