define(function (require, exports, module) {
    BaseObject.DrawPolygon = BaseHelper.Class.create();
    BaseObject.DrawPolygon.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

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
            var thisCallBack = this;
            this.drawHandler = new L.PM.Draw.Poly(this, function (e) {
                thisCallBack.drawCompleted(e)
            });
        },

        //初始化信息类
        getHtml: function () {
            var div = '<li id="drawPolygonTool_' + this.ID + '" style=" float:left; text-align:center;"><span class="cj-hm"></span>绘制面</li>';
            return div;
        },

        initializeCallBack: function () {
            var thisCallBack = this;
            this.elementHandler = $("#drawPolygonTool_" + this.ID);
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
                    this.drawHandler.enable();
                } else {
                    this.drawHandler.enabled();
                }
            }
        },

        active: function () {
            this.globalMap.clearFeatures();
            this.drawHandler.clear();
            if (this.drawHandler) this.drawHandler.toggle();
        },
        clear: function () {
            if (this.drawHandler) {
                this.drawHandler.clear();
                
                if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
            }
        },

        drawCompleted: function (e) {
        
            var thisCallBack = this;
            this.configData.geometry = e;
            //var e=L.polygon([[0, 0], [-30, 0], [-10, 30], [0, 0]], { color: 'red' });
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

        setDraw: function () {
            this.active();
            if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
        },
        //初始化位置
        initPosition: function () { },
        CLASS_NAME: "BaseObject.DrawPolygon"
    });
    module.exports = BaseObject.DrawPolygon;
});

L.PM.Draw.Poly = L.PM.Draw.extend({
    initialize: function (t, callback) {
        this._parent = t,
        this.callback = callback;
        this._map = t.globalMap.mapHandler.mapObject,
        this._enabledEdit = t._enabledEdit;
        this._shape = "Poly",
        this.toolbarButtonName = "drawPolygon"
    },
    _finishShape: function () {
        var t = this._layer.getLatLngs(),
        e = L.polygon(t, this.options.pathOptions).addTo(this._map);
        this.disable(),
        this._map.fire("pm:create", {
            shape: this._shape,
            layer: e
        }),
        this.polygonShape = e;
        this._cleanupSnapping(),
        this._otherSnapLayers.splice(this._tempSnapLayerIndex, 1),
        delete this._tempSnapLayerIndex,
        this._enabledEdit&&this._parent.globalMap.dispathEvent("drawCompleted", { target: e });
        if (this.callback) this.callback(e);
    },
    _createMarker: function (t, e) {
        var i = new L.Marker(t, {
            draggable: !1,
            icon: L.divIcon({
                className: "marker-icon"
            })
        });
        i._pmTempLayer = !0,
        this._layerGroup.addLayer(i),
        e && (i.on("click", this._finishShape, this), this._tempSnapLayerIndex = this._otherSnapLayers.push(i) - 1, this.options.snappable && this._cleanupSnapping())
    },
    enable: function (t) {
        L.Util.setOptions(this, t),
        this._enabled = !0,
        this._layerGroup = new L.LayerGroup,
        this._layerGroup.addTo(this._map),
        this._layer = L.polyline([], this.options.templineStyle),
        this._layer._pmTempLayer = !0,
        this._layerGroup.addLayer(this._layer),
        this._hintline = L.polyline([], this.options.hintlineStyle),
        this._hintline._pmTempLayer = !0,
        this._layerGroup.addLayer(this._hintline),
        this._hintMarker = L.marker([0, 0], {
            icon: L.divIcon({
                className: "marker-icon cursor-marker"
            })
        }),
        this._hintMarker._pmTempLayer = !0,
        this._layerGroup.addLayer(this._hintMarker),
        this.options.cursorMarker && L.DomUtil.addClass(this._hintMarker._icon, "visible"),
        this._map._container.style.cursor = "crosshair",
        this._map.on("click", this._createVertex, this),
        this.options.finishOnDoubleClick && this._map.on("dblclick", this._finishShape, this),
        this._map.on("mousemove", this._syncHintMarker, this),
        this._hintMarker.on("move", this._syncHintLine, this),
        this._map.fire("pm:drawstart", {
            shape: this._shape
        }),
        //this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !0),
        this._otherSnapLayers = []
    },
    disable: function () {
        this._enabled && (this._enabled = !1, this._map._container.style.cursor = "default", this._map.off("click", this._createVertex, this), this._map.off("mousemove", this._syncHintMarker, this), this._map.off("dblclick", this._finishShape, this), this._map.removeLayer(this._layerGroup), this._map.fire("pm:drawend", {
            shape: this._shape
        }), this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !1), this.options.snappable && this._cleanupSnapping())
    },
    enabled: function () {
        return this._enabled
    },
    toggle: function (t) {
        this.enabled() ? this.disable() : this.enable(t)
    },
    _syncHintLine: function () {
        var t = this._layer.getLatLngs();
        if (t.length > 0) {
            var e = t[t.length - 1];
            this._hintline.setLatLngs([e, this._hintMarker.getLatLng()])
        }
    },
    _syncHintMarker: function (t) {
        if (this._hintMarker.setLatLng(t.latlng), this.options.snappable) {
            var e = t;
            e.target = this._hintMarker,
            this._handleSnapping(e)
        }
    },
    _createVertex: function (t) {
        this._hintMarker._snapped || this._hintMarker.setLatLng(t.latlng);
        var e = this._hintMarker.getLatLng();
        if (e.equals(this._layer.getLatLngs()[0])) return void this._finishShape();
        var i = 0 === this._layer.getLatLngs().length;
        this._layer.addLatLng(e),
        this._createMarker(e, i),
        this._hintline.setLatLngs([e, e])
    },

    clear: function () {
        this._map.pm.toggleGlobalRemovalMode()
        if (this.polygonShape) {
            this._map.removeLayer(this.polygonShape);
        }
        if (this._layerGroup) {
            this._map.removeLayer(this._layerGroup);
        }
        this.disable();
    },
});