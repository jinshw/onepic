define(function (require, exports, module) {
    BaseObject.DrawPolyline = BaseHelper.Class.create();
    BaseObject.DrawPolyline.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },

        init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
            this.drawHandler = new L.PM.Draw.Line(this);
        },

        getHtml: function () {
            var div = '<li id="drawLineTool_' + this.ID + '">绘制线</li>';
            return div;
        },

        initializeCallBack: function () {
            var thisCallBack = this;
            this.elementHandler = $("#drawLineTool_" + this.ID);
            this.elementHandler.bind('click',
            function () {
                thisCallBack.setDraw();
            });
            this.setDisabled(true);
            this.globalMap.addTool(this);
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
            if (this.drawHandler) this.drawHandler.toggle();
        },
        clear: function () {
            if (this.drawHandler) {
                this.drawHandler.deactivate();
                if (this.globalMap.mapObject.getControl(this.drawHandler.id)) this.globalMap.mapObject.removeControl(this.drawHandler);
                if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
            }
        },

        setDraw: function () {
            this.active();
            if (this.globalMap.editManage) this.globalMap.editManage.deactivate();
        },
        //初始化位置
        initPosition: function () { },
        CLASS_NAME: "BaseObject.DrawPolyline"
    });
    module.exports = BaseObject.DrawPolyline;
});

L.PM.Draw.Line = L.PM.Draw.extend({
    initialize: function (t) {
        this._parent = t,
        this._map = t.globalMap.mapObject,
        this._shape = "Line",
        this.toolbarButtonName = "drawPolyline"
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
        this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !0),
        this._otherSnapLayers = []
    },
    disable: function () {
        this._enabled && (this._enabled = !1, this._map._container.style.cursor = "default", this._map.off("click", this._createVertex, this), this._map.off("mousemove", this._syncHintMarker, this), this._map.off("dblclick", this._finishShape, this), this._map.removeLayer(this._layerGroup), this._map.fire("pm:drawend", {
            shape: this._shape
        }),
        this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !1), this.options.snappable && this._cleanupSnapping())
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
    _finishShape: function () {

        var t = this._layer.getLatLngs(),
        e = L.polyline(t, this.options.pathOptions).addTo(this._map);
        this.disable(),
        this._map.fire("pm:create", {
            shape: this._shape,
            layer: e
        }),
        this.options.snappable && this._cleanupSnapping(),
        this._parent.globalMap.dispathEvent("drawCompleted", { target: e });
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
        e.on("click", this._finishShape, this),
        e
    }
});