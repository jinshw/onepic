define(function (require, exports, module) {
    BaseObject.DrawMarker = BaseHelper.Class.create();
    BaseObject.DrawMarker.prototype = BaseHelper.Class.inherit(BaseObject.Component, {

        initialize: function (globalMap, configData) {
            if (globalMap) {
                configData == null ? {} : configData;
                this.init(globalMap, configData);
            }
        },

        init: function (globalMap, configData) {
            this.configData = configData;
            this.globalMap = globalMap;
            this.drawHandler = new L.PM.Draw.Marker(this);
        },

        //初始化信息类
        getHtml: function () {
            var div = '<li id="drawMarkerTool_' + this.ID + '" >标注</li>';
            return div;
        },

        initializeCallBack: function () {
            var thisCallBack = this;
            this.elementHandler = $("#drawMarkerTool_" + this.ID);
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
                    this.drawHandler.enable();
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
        CLASS_NAME: "BaseObject.DrawMarker"
    });
    module.exports = BaseObject.DrawMarker;
});
L.PM.Draw.Marker = L.PM.Draw.extend({
    initialize: function (t) {
        this._parent = t,
        this._map = t.globalMap.mapObject,
        this._shape = "Marker",
        this.toolbarButtonName = "drawMarker"
    },
    enable: function (t) {
        L.Util.setOptions(this, t),
        this._enabled = !0,
        this._map.on("click", this._createMarker, this),
        //this._map.pm.Toolbar.toggleButton(this.toolbarButtonName, !0),
        this._hintMarker = L.marker([0, 0]),
        this._hintMarker._pmTempLayer = !0,
        this._hintMarker.addTo(this._map),
        this._layer = this._hintMarker,
        this._map.on("mousemove", this._syncHintMarker, this),
        this._map.eachLayer(function (t) {
            t instanceof L.Marker && t.pm.enable()
        })
    },
    disable: function () {
        this._enabled && (this._map.off("click", this._createMarker, this), this._hintMarker.remove(), this._map.off("mousemove", this._syncHintMarker, this), this._map.eachLayer(function (t) {
            t instanceof L.Marker && !t._pmTempLayer && t.pm.disable()
        }), this._enabled = !1)
    },
    enabled: function () {
        return this._enabled
    },
    toggle: function (t) {
        this.enabled() ? this.disable() : this.enable(t)
    },
    _createMarker: function (t) {
        if (t.latlng) {
            this._hintMarker._snapped || this._hintMarker.setLatLng(t.latlng);
            var e = this._hintMarker.getLatLng(),
            i = new L.Marker(e, this.options.markerStyle);
            i.addTo(this._map),
            i.pm.enable(),
            this._map.fire("pm:create", {
                shape: this._shape,
                marker: i,
                layer: i
            }),
            this._cleanupSnapping(),
            this._parent.globalMap.dispathEvent("drawCompleted", { target: e })
        }
    },
    _syncHintMarker: function (t) {
        if (this._hintMarker.setLatLng(t.latlng), this.options.snappable) {
            var e = t;
            e.target = this._hintMarker,
            this._handleSnapping(e)
        }
    }
});