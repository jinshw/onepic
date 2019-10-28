var host = window.isLocal ? window.server : "http://localhost:8090";
var map, url = host + "/iserver/services/map-zhdt/rest/maps/综合地图";
map = L.map('map', {
    crs: L.CRS.EPSG4326,
    center: [42.5463, 86.0553],
    maxZoom: 18,
    zoom: 5
});
L.supermap.tiledMapLayer(url).addTo(map);

$(function(){
    getRain()
})


function getSignature(obj){
    var signature = obj.passwrod +"\n"+obj.date+"\n"+obj.nonce+"\n"+obj.suburl
    console.log("signature str ==",signature)
    return md5(signature)
}

function getRain(){
    console.log("getRain...............")
    var token = "6072fd75f85c5632df9830c956d791b5"
    var passwrod = "e346ef0472828e1182dafe8d0835e749"
    var date = new Date().getTime()
    var nonce = "41f46b99497d46d4910baaa0e9b120d2"
    var suburl = "/v1/radar/rain/full/json"
    var signature = getSignature({passwrod:passwrod,date:date,nonce:nonce,suburl:suburl})

    var initPoints = [[43.6440258477,89.1650390625],[44.0875850282,94.5703125000]]

    $.ajax({
        // url: "http://hydrometeo.mojicb.com/v1/radar/rain/full/json?startLat=43.8899640000&startLon=87.7927930000&endLat=43.8777160000&endLon=87.9234280000",
        url: "http://hydrometeo.mojicb.com/v1/radar/rain/full/json?startLat="+initPoints[0][0] +"&startLon="+initPoints[0][1]+"&endLat="+ initPoints[1][0] +"&endLon="+initPoints[1][1],
        data: {
        },
        type: 'get',
        dataType: 'json',
        headers:{
            "X-AC-Token":token,
            "X-Date":date,
            "X-AC-Nonce":nonce,
            "X-AC-Signature":signature
        },
        success: function (data) {
            console.log("success...", data);
            // var latlngs = [[43.89055,87.78935],[43.88086,87.78935],[43.88086,87.9198],[43.89055,87.9198]]
            if(data.code != 200){
                console.log("server response data error...")
                return
            }
           var latlngs = getRectVertices(data.data)


            // var line =new L.polygon(latlngs,{color:'red',opacity:'0.4',weight:'5'})
            //     .addTo(map);
            var grids = getGridPoint({latlngs:latlngs,rows:data.data.rows,cols:data.data.cols})
            console.log("grids===",grids)
            // var layerGroup = new L.layerGroup()
            // var myRenderer = L.canvas({ padding: 0.5 })
            // for(var i=0;i<grids.length;i++){
            //     for(var j=0; j<grids[0].length;j++){
            //         // new L.polygon(latlngs,{color:'green',opacity:'0.1',weight:'1',fillColor:"green",fillOpacity:"0.1"}).addTo(map);
            //         layerGroup.addLayer(L.polygon(latlngs,{
            //             color:'green',opacity:'0.1',weight:'1',
            //             fillColor:"green",fillOpacity:"0.1",
            //             renderer: myRenderer 
            //         }));
            //     }
            // }
            // layerGroup.addTo(map)


            var heatDatas = new Array()
            for(var i=0;i<grids.length;i++){
                for(var j=0; j<grids[0].length;j++){
                    for(var k=0;k<grids[0][0].length;k++){
                        grids[i][j][k].push( Math.random() * 100)
                        heatDatas.push([].concat(grids[i][j][k]))
                    }
                    // layerGroup.addLayer(L.polygon(latlngs,{
                    //     color:'green',opacity:'0.1',weight:'1',
                    //     fillColor:"green",fillOpacity:"0.1",
                    //     renderer: myRenderer 
                    // }));
                }
            }
            console.log("heatDatas....",heatDatas)

            var heatPoints = [];
            for (var i = 0; i < 200; i++) {
                heatPoints[i] = [Math.random() * 0.28 + 39.78, Math.random() * 0.5 + 116.12, Math.random() * 80];
            }
            console.log("heatPoints....",heatPoints)
            // var resultLayer = L.heatLayer(heatDatas, {
            //     radius: 5,
            //     minOpacity: 0.5
            // }).addTo(map);

            option = {

                visualMap: {
                    show: true,
                    top: 'bottom',
                    min: 0,
                    max: 100,
                    seriesIndex: 0,
                    calculable: true,
                    pieces: [
                        {min: 0, max: 20},
                        {min: 21, max: 50},
                        {min: 51, max: 80},
                        {min: 81, max:90},
                        {min: 91, max:100},
                    ],
                    inRange: {
                        color: ['blue', 'blue', 'green', 'yellow', 'red']
                    }
                },
                series: [{
                    type: 'heatmap',
                    coordinateSystem: 'leaflet',
                    data: heatDatas,
                    pointSize: 2,
                    blurSize: 2
                }]
            };
            L.supermap.echartsLayer(option).addTo(map);


        },
        error: function (e) {
            console.log(e)
        }
    });
}

function getRectVertices(obj){
    var aPointLat = obj.startLat
    var aPointLon = obj.startLon
    var cPointLat = obj.endLat
    var cPointLon = obj.endLon
    var bPointLon = cPointLon
    var bPointLat = aPointLat
    var dPointLon = aPointLon
    var dPointLat = cPointLat
    // 返回的点应为需要用leaflet渲染，格式为[纬度,经度]
    return [[aPointLat,aPointLon],[bPointLat,bPointLon],[cPointLat,cPointLon],[dPointLat,dPointLon]]
}

function getGridPoint(obj){
    var latlngs = obj.latlngs
    var rows = obj.rows
    var cols = obj.cols
    var xItem = 0
    var yItem = 0
    xItem = (latlngs[1][1] - latlngs[0][1])/cols
    yItem = (latlngs[2][0]-latlngs[1][0])/rows

    var grids = new Array()
    for(var i=0;i<rows;i++){
        grids[i] = new Array()
        for(var j=0;j<cols;j++){
            grids[i][j] = getPointItems({row:i,col:j,xItem:xItem,yItem:yItem,startLon:latlngs[0][0],startLat:latlngs[0][1]})
        }
    }
    return grids
}

function getPointItems(obj){
    var row = obj.row
    var col = obj.col
    var xItem = obj.xItem
    var yItem = obj.yItem
    var startPoint = [obj.startLat,obj.startLon]
    var aPointLon = startPoint[0] + xItem*col
    var aPointLat = startPoint[1] + yItem*row
    var bPointLon = startPoint[0] + xItem*(col+1)
    var bPointLat = startPoint[1] + yItem*row
    var cPointLon = startPoint[0] + xItem*(col+1)
    var cPointLat = startPoint[1] + yItem*(row+1)
    var dPointLon = startPoint[0] + xItem*col
    var dPointLat = startPoint[1] + yItem*(row+1)
    return [[aPointLon,aPointLat],[bPointLon,bPointLat],[cPointLon,cPointLat],[dPointLon,dPointLat]]
    // return [[aPointLat,aPointLon],[bPointLat,bPointLon],[cPointLat,cPointLon],[dPointLat,dPointLon]]
}




