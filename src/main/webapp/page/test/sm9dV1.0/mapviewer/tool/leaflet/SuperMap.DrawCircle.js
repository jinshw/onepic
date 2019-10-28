define(function (require, exports, module) {
    BaseObject.DrawCircle = BaseHelper.Class.create();
    BaseObject.DrawCircle.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },

        init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
            this.globalMap.addTool(this);
            this.enabledEdit = false;
            var thisCallBack = this;
            this.drawHandler = new L.PM.Draw.Circle(this, function (e) { thisCallBack.drawCompleted(e) });
        },

        //初始化信息类
        getHtml: function () {
            var div = '<li id="tool_' + this.ID + '"></span>绘制圆</li>';
            return div;
        },

        initializeCallBack: function () {
            var thisCallBack = this;
            this.elementHandler = $("#tool_" + this.ID);
            this.elementHandler.bind('click',
            function () {
                thisCallBack.setDraw();
            });
            this.setDisabled(true);
        },

        setDisabled: function (value) {
            var thisCallBack = this;
            if (this.elementHandler) {
                if (value) {

                } else {
                    this.drawHandler.enabled();
                }
            }
        },

        active: function () {
            this.drawHandler.clear();
            this.globalMap.clearFeatures();
            if (this.drawHandler) this.drawHandler.toggle();
        },

        drawCompleted:function(e)
        {
            var Latlngs = this._convertCircleTo360Latlngs(e.getLatLng(), e.getRadius());
            var geometry = L.polygon(Latlngs, {
                color: 'green',
                fillColor: '#f03',
                fillOpacity: 0.5
            });

            var thisCallBack = this;
            this.configData.geometry = geometry;
            if (!thisCallBack.bufferQueryService) {
                    this.globalMap.useService(["GeometryChooseQuery"], function (a) {
                    thisCallBack.bufferQueryService = new a(thisCallBack.globalMap);
                    thisCallBack.bufferQueryService.addEventListener("processCompleted", function (result) {
                        thisCallBack.processCompleted(result)
                    });
                    thisCallBack.bufferQueryService.execute(thisCallBack.configData);
                });
            }
            else {
                thisCallBack.bufferQueryService.execute(this.configData);
            }
        },

        processCompleted: function (serviceResult) {
            //this.globalMap.showFeatures(serviceResult.result.features.features, { labelField: "NAME" })
            this.dispathEvent("queryCompleted", serviceResult.result);
            this.globalMap.dispathEvent("queryCompleted", serviceResult.result);
        },

        
        _convertCircleTo360Latlngs: function (origin, radius) {
            var EARTH_RADIUS = 6378.140*1000;
            //圆心纬度   
            var lat = (origin.lat * Math.PI) / 180;
            //圆心经度   
            var lon = (origin.lng * Math.PI) / 180;
            var d = parseFloat(radius) / EARTH_RADIUS;
            var Latlngs = new Array();
            for (i = 0; i <= 360; i++) {
                var loc = [];
                var bearing = i * Math.PI / 180;
                loc[0] = Math.asin(Math.sin(lat) * Math.cos(d) + Math.cos(lat) * Math.sin(d) * Math.cos(bearing));
                loc[1] = ((lon + Math.atan2(Math.sin(bearing) * Math.sin(d) * Math.cos(lat), Math.cos(d) - Math.sin(lat) * Math.sin(loc[0]))) * 180) / Math.PI;
                loc[0] = (loc[0] * 180) / Math.PI;
                Latlngs.push(loc);
            }
            return Latlngs;
        },

        clear: function () {
            if (this.drawHandler) {
                this.drawHandler.clear();
              
                if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
            }
        },

        setDraw: function () {
            this.active();
            if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
        },
        //初始化位置
        initPosition: function () { },
        CLASS_NAME: "BaseObject.DrawCircle"
    });
    module.exports = BaseObject.DrawCircle;
});
L.PM.Draw.Circle = L.PM.Draw.extend({

    initialize: function (t, callback) {
        this._parent = t,
        this._map = t.globalMap.mapHandler.mapObject,
        this._enabledEdit = t._enabledEdit;
        this.callback = callback;
        this._shape = "Circle",
        this.toolbarButtonName = "drawCircle"
    },
    enable: function (t) {
        L.Util.setOptions(this, t),
        this.options.radius = 0,
        this._enabled = !0,
        this._layerGroup = new L.LayerGroup,
        this._layerGroup.addTo(this._map),
        this._layer = L.circle([0, 0], this.options.templineStyle),
        this._layer._pmTempLayer = !0,
        this._layerGroup.addLayer(this._layer),
        this._centerMarker = L.marker([0, 0], {
            icon: L.divIcon({
                className: "marker-icon"
            }),
            draggable: !0,
            zIndexOffset: 100
        }),
        this._centerMarker._pmTempLayer = !0,
        this._layerGroup.addLayer(this._centerMarker),
        this._hintMarker = L.marker([0, 0], {
            icon: L.divIcon({
                className: "marker-icon cursor-marker"
            })
        }),
        this._hintMarker._pmTempLayer = !0,
        this._layerGroup.addLayer(this._hintMarker),
        this.options.cursorMarker && L.DomUtil.addClass(this._hintMarker._icon, "visible"),
        this._hintline = L.polyline([], this.options.hintlineStyle),
        this._hintline._pmTempLayer = !0,
        this._layerGroup.addLayer(this._hintline),
        this._map._container.style.cursor = "crosshair",
        this._map.on("click", this._placeCenterMarker, this),
        this._map.on("mousemove", this._syncHintMarker, this),
        this._map.fire("pm:drawstart", {
            shape: this._shape
        }),
        this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !0),
        this._otherSnapLayers = []
    },


    disable: function () {
        this._enabled && (this._enabled = !1, this._map._container.style.cursor = "default", this._map.off("click", this._finishShape, this), this._map.off("click", this._placeCenterMarker, this), this._map.off("mousemove", this._syncHintMarker, this), this._map.removeLayer(this._layerGroup), this._map.fire("pm:drawend", {
            shape: this._shape
        }), this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !1), this.options.snappable && this._cleanupSnapping())
    },
    enabled: function () {
        return this._enabled
    },
    toggle: function (t) {
        this.enabled() ? this.disable() : this.enable(t)
    },
    clear:function()
    {
        this._map.pm.toggleGlobalRemovalMode()
        if (this.circleShape) {
            this._map.removeLayer(this.circleShape);
        }
        if (this._layerGroup)
        {
            this._map.removeLayer(this._layerGroup);
        }
        this.disable();
    },
    _syncHintLine: function () {
        var t = this._centerMarker.getLatLng();
        this._hintline.setLatLngs([t, this._hintMarker.getLatLng()])
    },
    _syncCircleRadius: function () {
        var t = this._centerMarker.getLatLng(),
        e = this._hintMarker.getLatLng(),
        i = t.distanceTo(e);
        this._layer.setRadius(i)
    },
    _syncHintMarker: function (t) {
        if (this._hintMarker.setLatLng(t.latlng), this.options.snappable) {
            var e = t;
            e.target = this._hintMarker,
            this._handleSnapping(e)
        }
    },
    _placeCenterMarker: function (t) {
        this._hintMarker._snapped || this._hintMarker.setLatLng(t.latlng);
        var e = this._hintMarker.getLatLng();
        this._centerMarker.setLatLng(e),
        this._map.off("click", this._placeCenterMarker, this),
        this._map.on("click", this._finishShape, this),
        this._placeCircleCenter()
    },
    _placeCircleCenter: function () {
        var t = this._centerMarker.getLatLng();
        t && (this._layer.setLatLng(t), this._hintMarker.on("move", this._syncHintLine, this), this._hintMarker.on("move", this._syncCircleRadius, this))
    },
    _finishShape: function () {
        var t = this._centerMarker.getLatLng(),
        e = this._hintMarker.getLatLng(),
        i = t.distanceTo(e),
        a = L.circle(t, {
            radius: i
        }).addTo(this._map);
        this.circleShape = a;
        this.disable(),
        this._map.fire("pm:create", {
                shape: this._shape,
                layer: a
        }) ,
        this._enabledEdit && this._parent.globalMap.dispathEvent("activeEditFeature", { target: e });
        if (this.callback) this.callback(a);
    },
    _createMarker: function (t) {
        var e = new L.Marker(t, {
            draggable: !1,
            icon: L.divIcon({
                className: "marker-icon"
            })
        });
        return e._pmTempLayer = !0,
        this._layerGroup.addLayer(e),
        e
    }
});