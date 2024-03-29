
/*!
 *     Copyright (c) 2015 Gregor MacLennan
 *     leaflet-side-by-side.(https://github.com/digidem/leaflet-side-by-side)
 *     license: MIT
 *     version: v2.0.0
 */
!
function e(t, n, i) {
    function r(s, o) {
        if (!n[s]) {
            if (!t[s]) {
                var d = "function" == typeof require && require;
                if (!o && d) return d(s, !0);
                if (a) return a(s, !0);
                var l = new Error("Cannot find module '" + s + "'");
                throw l.code = "MODULE_NOT_FOUND",
                l
            }
            var h = n[s] = {
                exports: {}
            };
            t[s][0].call(h.exports,
            function (e) {
                var n = t[s][1][e];
                return r(n ? n : e)
            },
            h, h.exports, e, t, n, i)
        }
        return n[s].exports
    }
    for (var a = "function" == typeof require && require,
    s = 0; s < i.length; s++) r(i[s]);
    return r
}({
    1: [function (e, t, n) {
        (function (n) {
            function i(e, t, n, i) {
                t.split(" ").forEach(function (t) {
                    h.DomEvent.on(e, t, n, i)
                })
            }
            function r(e, t, n, i) {
                t.split(" ").forEach(function (t) {
                    h.DomEvent.off(e, t, n, i)
                })
            }
            function a(e) {
                return "oninput" in e ? "input" : "change"
            }
            function s() {
                u = this._map.dragging.enabled(),
                p = this._map.tap && this._map.tap.enabled(),
                this._map.dragging.disable(),
                this._map.tap && this._map.tap.disable()
            }
            function o(e) {
                this._refocusOnMap(e),
                u && this._map.dragging.enable(),
                p && this._map.tap.enable()
            }
            function d(e) {
                return "undefined" === e ? [] : Array.isArray(e) ? e : [e]
            }
            function l() { }
            var h = "undefined" != typeof window ? window.L : "undefined" != typeof n ? n.L : null;
            e("./layout.css"),
            e("./range.css");
            var u, p;
            h.Control.SideBySide = h.Control.extend({
                options: {
                    thumbSize: 42,
                    padding: 0
                },
                initialize: function (e, t, n) {
                    this.setLeftLayers(e),
                    this.setRightLayers(t),
                    h.setOptions(this, n)
                },
                getPosition: function () {
                    var e = this._range.value,
                    t = (.5 - e) * (2 * this.options.padding + this.options.thumbSize);
                    return this._map.getSize().x * e + t
                },
                setPosition: l,
                includes: h.Mixin.Events,
                addTo: function (e) {
                    this.remove(),
                    this._layers = [];
                    this._map = e;
                    var t = this._container = h.DomUtil.create("div", "leaflet-sbs", e._controlContainer);
                    this._divider = h.DomUtil.create("div", "leaflet-sbs-divider", t);
                    var n = this._range = h.DomUtil.create("input", "leaflet-sbs-range", t);
                    return n.type = "range",
                    n.min = 0,
                    n.max = 1,
                    n.step = "any",
                    n.value = .5,
                    n.style.paddingLeft = n.style.paddingRight = this.options.padding + "px",
                    this._addEvents(),
                    this._updateLayers(),
                    this
                },
                remove: function () {
                    if (this._layers) {
                        this._layers.forEach(function (target) {
                            target.layer.getContainer().style.clip = '';
                        });
                        this._layers = [];
                    }
                    return this._map ? (this._leftLayer && (this._leftLayer.getContainer().style.clip = ""), this._rightLayer && (this._rightLayer.getContainer().style.clip = ""), this._removeEvents(), h.DomUtil.remove(this._container), this._map = null, this) : this
                },
                setLeftLayers: function (e) {
                    return this._leftLayers = d(e),
                    this._updateLayers(),
                    this
                },
                setRightLayers: function (e) {
                    return this._rightLayers = d(e),
                    this._updateLayers(),
                    this
                },
                _updateClip: function () {
                    var e = this._map,
                    t = e.containerPointToLayerPoint([0, 0]),
                    n = e.containerPointToLayerPoint(e.getSize()),
                    i = t.x + this.getPosition(),
                    r = this.getPosition();
                    this._divider.style.left = r + "px",
                    this.fire("dividermove", {
                        x: r
                    });
                    var a = "rect(" + [t.y, i, n.y, t.x].join("px,") + "px)",
                    s = "rect(" + [t.y, n.x, n.y, i].join("px,") + "px)";
                    this._leftLayer && (this._leftLayer.getContainer().style.clip = a),
                    this._rightLayer && (this._rightLayer.getContainer().style.clip = s);

                    this._layers.forEach(function (target) {
                      
                        if (target.layer.getContainer()) {
                            if (target.type == 'left')
                                target.layer.getContainer().style.clip = a;
                            else if (target.type == 'right') {
                                target.layer.getContainer().style.clip = s
                            }
                        }
                    });
                },
                _updateLayers: function () {
                    if (!this._map) return this;
                    var e = this._leftLayer,
                    t = this._rightLayer;
                    this._leftLayer = this._rightLayer = null,
                    this._leftLayers.forEach(function (e) {
                        this._map.hasLayer(e) && (this._leftLayer = e)
                    },
                    this),
                    this._rightLayers.forEach(function (e) {
                        this._map.hasLayer(e) && (this._rightLayer = e)
                    },
                    this),
                    e !== this._leftLayer && (e && this.fire("leftlayerremove", {
                        layer: e
                    }), this._leftLayer && this.fire("leftlayeradd", {
                        layer: this._leftLayer
                    })),
                    t !== this._rightLayer && (t && this.fire("rightlayerremove", {
                        layer: t
                    }), this._rightLayer && this.fire("rightlayeradd", {
                        layer: this._rightLayer
                    })),
                    this._updateClip()
                },

                addLayers: function (layers, type) {
                    var lays = d(layers);
                    lays.forEach(function (layer) {
                        if (this._map.hasLayer(layer)) {
                            this._layers.push({ layer: layer, type: type });

                            if (layer != null && type === 'left') {
                                this.fire('leftlayeradd', { layer: layer })
                            }
                            if (layer != null && type === 'right') {
                                this.fire('rightlayeradd', { layer: layer })
                            }
                        }
                    }, this);
                    this._updateClip();
                },

                removeLayers: function (layers, type) {
                    var lays = d(layers);
                    lays.forEach(function (layer) {
                        if (this._map.hasLayer(layer)) {
                            layer.remove();
                        }
                        this._removeLayer(layer);
                    }, this);
                    this._updateClip();
                },

                _removeLayer: function (layer) {
                    for (var i = 0; i < this._layers.length; i++) {
                        var target = this._layers[i];
                        if (target.layer && target.layer.id == layer.id)
                        { this._layers.splice(i, 1); break; }

                    }
                },
                _addEvents: function () {
                    var e = this._range,
                    t = this._map;
                    t && e && (t.on("move", this._updateClip, this), t.on("layeradd layerremove", this._updateLayers, this), i(e, a(e), this._updateClip, this), i(e, h.Browser.touch ? "touchstart" : "mousedown", s, this), i(e, h.Browser.touch ? "touchend" : "mouseup", o, this))
                },
                _removeEvents: function () {
                    var e = this._range,
                    t = this._map;
                    e && (r(e, a(e), this._updateClip, this), r(e, h.Browser.touch ? "touchstart" : "mousedown", s, this), r(e, h.Browser.touch ? "touchend" : "mouseup", o, this)),
                    t && (t.off("layeradd layerremove", this._updateLayers, this), t.off("move", this._updateClip, this))
                }
            }),
            h.control.sideBySide = function (e, t, n) {
                return new h.Control.SideBySide(e, t, n)
            },
            t.exports = h.Control.SideBySide
        }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
    },
    {
        "./layout.css": 2,
        "./range.css": 4
    }],
    2: [function (e, t, n) {
        var i = ".leaflet-sbs-range {\n    position: absolute;\n    top: 50%;\n    width: 100%;\n    z-index: 999;\n}\n.leaflet-sbs-divider {\n    position: absolute;\n    top: 0;\n    bottom: 0;\n    left: 50%;\n    margin-left: -2px;\n    width: 4px;\n    background-color: #fff;\n    pointer-events: none;\n    z-index: 999;\n}\n";
        e("./node_modules/cssify")(i, void 0, "/data/github/leaflet-side-by-side/layout.css"),
        t.exports = i
    },
    {
        "./node_modules/cssify": 3
    }],
    3: [function (e, t, n) {
        function i(e, t, n) {
            var i = e.getElementById(t);
            if (i) n(i);
            else {
                var r = e.getElementsByTagName("head")[0];
                i = e.createElement("style"),
                i.id = t,
                n(i),
                r.appendChild(i)
            }
            return i
        }
        t.exports = function (e, t, n) {
            var r = t || document;
            if (r.createStyleSheet) {
                var a = r.createStyleSheet();
                return a.cssText = e,
                a.ownerNode
            }
            return i(r, n,
            function (t) {
                t.styleSheet ? t.styleSheet.cssText = e : t.innerHTML = e
            })
        },
        t.exports.byUrl = function (e) {
            if (document.createStyleSheet) return document.createStyleSheet(e).ownerNode;
            var t = document.getElementsByTagName("head")[0],
            n = document.createElement("link");
            return n.rel = "stylesheet",
            n.href = e,
            t.appendChild(n),
            n
        }
    },
    {}],
    4: [function (e, t, n) {
        var i = '.leaflet-sbs-range {\n    -webkit-appearance: none;\n    display: inline-block!important;\n    vertical-align: middle;\n    height: 0;\n    padding: 0;\n    margin: 0;\n    border: 0;\n    background: rgba(0, 0, 0, 0.25);\n    min-width: 100px;\n    cursor: pointer;\n    pointer-events: none;\n    z-index: 999;\n}\n.leaflet-sbs-range::-ms-fill-upper {\n    background: transparent;\n}\n.leaflet-sbs-range::-ms-fill-lower {\n    background: rgba(255, 255, 255, 0.25);\n}\n/* Browser thingies */\n\n.leaflet-sbs-range::-moz-range-track {\n    opacity: 0;\n}\n.leaflet-sbs-range::-ms-track {\n    opacity: 0;\n}\n.leaflet-sbs-range::-ms-tooltip {\n    display: none;\n}\n/* For whatever reason, these need to be defined\n * on their own so dont group them */\n\n.leaflet-sbs-range::-webkit-slider-thumb {\n    -webkit-appearance: none;\n    margin: 0;\n    padding: 0;\n    background: #fff;\n    height: 40px;\n    width: 40px;\n    border-radius: 20px;\n    cursor: ew-resize;\n    pointer-events: auto;\n    border: 1px solid #ddd;\n    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABlBMVEV9fX3///+Kct39AAAAAnRSTlP/AOW3MEoAAAA9SURBVFjD7dehDQAwDANBZ/+l2wmKoiqR7pHRcaeaCxAIBAL/g7k9JxAIBAKBQCAQCAQC14H+MhAIBE4CD3fOFvGVBzhZAAAAAElFTkSuQmCC");\n    background-position: 50% 50%;\n    background-repeat: no-repeat;\n    background-size: 40px 40px;\n}\n.leaflet-sbs-range::-ms-thumb {\n    margin: 0;\n    padding: 0;\n    background: #fff;\n    height: 40px;\n    width: 40px;\n    border-radius: 20px;\n    cursor: ew-resize;\n    pointer-events: auto;\n    border: 1px solid #ddd;\n    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABlBMVEV9fX3///+Kct39AAAAAnRSTlP/AOW3MEoAAAA9SURBVFjD7dehDQAwDANBZ/+l2wmKoiqR7pHRcaeaCxAIBAL/g7k9JxAIBAKBQCAQCAQC14H+MhAIBE4CD3fOFvGVBzhZAAAAAElFTkSuQmCC");\n    background-position: 50% 50%;\n    background-repeat: no-repeat;\n    background-size: 40px 40px;\n}\n.leaflet-sbs-range::-moz-range-thumb {\n    padding: 0;\n    right: 0    ;\n    background: #fff;\n    height: 40px;\n    width: 40px;\n    border-radius: 20px;\n    cursor: ew-resize;\n    pointer-events: auto;\n    border: 1px solid #ddd;\n    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABlBMVEV9fX3///+Kct39AAAAAnRSTlP/AOW3MEoAAAA9SURBVFjD7dehDQAwDANBZ/+l2wmKoiqR7pHRcaeaCxAIBAL/g7k9JxAIBAKBQCAQCAQC14H+MhAIBE4CD3fOFvGVBzhZAAAAAElFTkSuQmCC");\n    background-position: 50% 50%;\n    background-repeat: no-repeat;\n    background-size: 40px 40px;\n}\n.leaflet-sbs-range:disabled::-moz-range-thumb {\n    cursor: default;\n}\n.leaflet-sbs-range:disabled::-ms-thumb {\n    cursor: default;\n}\n.leaflet-sbs-range:disabled::-webkit-slider-thumb {\n    cursor: default;\n}\n.leaflet-sbs-range:disabled {\n    cursor: default;\n}\n.leaflet-sbs-range:focus {\n    outline: none!important;\n}\n.leaflet-sbs-range::-moz-focus-outer {\n    border: 0;\n}\n\n';
        e("./node_modules/cssify")(i, void 0, "/data/github/leaflet-side-by-side/range.css"),
        t.exports = i
    },
    {
        "./node_modules/cssify": 3
    }]
},
{},
[1]);
