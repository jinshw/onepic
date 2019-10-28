var BaseHelper = {};
var DFastUI = {};
DFastUI.Remote = {};
BaseHelper.Class = {
	isPrototype: function() {},
	create: function() {
		return function() {
			if(arguments && arguments[0] != BaseHelper.Class.isPrototype) this.initialize.apply(this, arguments)
		}
	},
	inherit: function() {
		var superClass = arguments[0];
		var proto = new superClass(BaseHelper.Class.isPrototype);
		for(var i = 1; i < arguments.length; i++) {
			if(typeof arguments[i] == "function") {
				var mixin = arguments[i];
				arguments[i] = new mixin(BaseHelper.Class.isPrototype)
			}
			extend(proto, arguments[i]);
			if(arguments[i].hasOwnProperty('toString')) {
				proto.toString = arguments[i].toString
			}
		}
		return proto
	}
};
extend = function(destination, source) {
	for(property in source) {
		destination[property] = source[property];
		if(property === "initialize") {
			destination[property]()
		}
	}
	return destination
};
var AppEvent = {};
BaseHelper.EventBus = BaseHelper.Class.create();
BaseHelper.EventListener = BaseHelper.EventBus;
BaseHelper.EventBus.prototype = {
	initialize: function() {
		this.ID = "BaseHelper.EventBus"
	},
	dispathEvent: function(eventName, data) {
		if(!this.eventMethods) this.eventMethods = [];
		for(var index = 0; index < this.eventMethods.length; index++) {
			var item = this.eventMethods[index];
			if(item.eventName == eventName) {
				item.method(data)
			}
		}
	},
	dispathEventAll: function(eventName, data) {
		if(!this.eventMethods) this.eventMethods = [];
		for(var index = 0; index < this.eventMethods.length; index++) {
			var item = this.eventMethods[index];
			if(item.eventName == eventName) {
				item.method(data)
			}
		}
	},
	addEventListener: function(eventName, listener, id) {
		if(!this.eventMethods) this.eventMethods = [];
		if(!id) id = this.ID;
		this.eventMethods.push({
			identifier: id,
			eventName: eventName,
			method: listener
		})
	},
	removeEventListener: function(eventName, id) {
		if(!id) id = this.ID;
		for(var index = 0; index < this.eventMethods.length; index++) {
			var item = this.eventMethods[index];
			if(item.eventName == eventName && item.identifier == id) {
				this.eventMethods.splice(index, 1)
			}
		}
	},
	remove: function() {
		this.eventMethods = []
	},
	destroy: function() {
		this.eventMethods = []
	},
	init: function() {},
	CLASS_NAME: "BaseHelper.EventListener"
};
BaseHelper.GUID = BaseHelper.Class.create();
BaseHelper.GUID.prototype = {
	ID: null,
	initialize: function() {
		this.ID = "SuperMap.GUID"
	},
	getGUID: function() {
		var guid = "";
		for(var i = 1; i <= 32; i++) {
			var n = Math.floor(Math.random() * 16.0).toString(16);
			guid += n;
			if((i == 8) || (i == 12) || (i == 16) || (i == 20)) guid += ""
		}
		return guid
	},
	CLASS_NAME: "BaseHelper.GUID"
};
BaseHelper.Clone = BaseHelper.Class.create();
BaseHelper.Clone.prototype = {
	ID: null,
	initialize: function() {
		this.ID = "BaseHelper.Clone"
	},
	clone: function(data) {
		for(var key in data) {
			if(data.hasOwnProperty(key)) {
				this[key] = data[key]
			}
		}
	},
	CLASS_NAME: "BaseHelper.Clone"
};
var EventBus = new BaseHelper.EventBus();