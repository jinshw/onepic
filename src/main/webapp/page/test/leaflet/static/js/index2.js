var host = window.isLocal ? window.server : "http://localhost:8090";
var map, url = host + "/iserver/services/map-zhdt/rest/maps/综合地图";
map = L.map('map', {
    crs: L.CRS.EPSG4326,
    center: [42.5463, 86.0553],
    maxZoom: 18,
    zoom: 5
});
L.supermap.tiledMapLayer(url).addTo(map);

// //将geoJson数据加入到map中
geojson = L.geoJson(xjall, {
    style: style,
    onEachFeature: onEachFeature
}).addTo(map).on('mouseover', function (e) {
    console.log(e.sourceTarget.feature.properties)

});
//将geoJson数据加入到map中
// geojson = L.geoJson(xjgeojson, {
//     style: style,
//     // onEachFeature: onEachFeature
// }).addTo(map);


function onEachFeature(feature, layer) {
    layer.on({
        mouseover: highlightFeature,
        mouseout: resetHighlight,
        click: zoomToFeature
    });
}
function highlightFeature(e) {
    var layer2 = e.target;

    layer2.setStyle({
        fillColor:"#700000",
        weight: 5,
        color: '#700000',
        dashArray: '',
        fillOpacity: 0.9
    });

    if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
        layer2.bringToFront();
    }

    // info.update(layer.feature.properties);
}


function resetHighlight(e) {
    geojson.resetStyle(e.target);
    // info.update();
}

function zoomToFeature(e) {
    map.fitBounds(e.target.getBounds());
}





// set marker
var icon = L.icon({
    iconUrl: './static/img/weather/W0.png',
    // shadowUrl: './static/img/weather/W0.png',
    iconSize: [48, 48], // size of the icon
    // shadowSize: [50, 64], // size of the shadow
    iconAnchor: [24, 24], // point of the icon which will correspond to marker's location
    // shadowAnchor: [4, 62],  // the same for the shadow
    // popupAnchor: [-3, -76] // point from which the popup should open relative to the 
})
L.marker([43.7585, 88.1653], { icon: icon }).addTo(map).on('click', function (e) {
    console.log(e)
}).bindPopup("<b>Hello world!</b><br />I am a popup.").openPopup()


//根据feature对象属性density提供对应的风格样式
function style(feature) {
    console.log(feature)
    var colorOpacity = getColor(feature.properties.name).split(",")
    var color = colorOpacity[0]
    var opacity = parseFloat(colorOpacity[1])
    return {
        fillColor: color,
        weight: 1,
        opacity: opacity,
        color: 'white',
        dashArray: '3',
        fillOpacity: opacity
    };
}
// //根据d大小返回相应颜色
function getColor(d) {
    // return "#800026"
    // return d > 1000 ? '#800026' :
    //     d > 500 ? '#BD0026' :
    //     d > 200 ? '#E31A1C' :
    //     d > 100 ? '#FC4E2A' :
    //     d > 50 ? '#FD8D3C' :
    //     d > 20 ? '#FEB24C' :
    //     d > 10 ? '#FED976' :
    //     '#FFEDA0';
    var result = ""
    if (d.indexOf("市") != -1) {
        result = "#700000" + ",0"
    } else if (d.indexOf("县") != -1) {
        result = "#EDEDED" + ",0"
    } else if (d.indexOf("区") != -1) {
        result = "#EDEDED" + ",0"
    } else {
        result = "#EDEDED" + ",0"
    }
    return result
}



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

    $.ajax({
        url: "http://hydrometeo.mojicb.com/v1/radar/rain/full/json?startLat=43.8899640000&startLon=87.7927930000&endLat=43.8777160000&endLon=87.9234280000",
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
            var latlngs = [[43.89055,87.78935],[43.88086,87.78935],[43.88086,87.9198],[43.89055,87.9198]]

            var line =new L.polygon(latlngs,{color:'red',opacity:'0.8',weight:'3'})
                .addTo(map);
            

        },
        error: function (e) {
            console.log(e)
        }
    });
}

$(function(){
    $("#rainBT").click(function(){
        getRain()
    })
})



