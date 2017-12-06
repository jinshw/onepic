/**
 * 模块：前后台值得交互
 */

var app = new Vue({
    el : '#alldiv',
    data : {
	projectInfo : {},
    },
    methods : {
	checkall : function(_id) {
	    ajaxRequest.checkall(_id).then(function(data) {
		if (data.status == 200) {
		    app.projectInfo = data.returnData[0];
		    console.log(app.projectInfo)
		}
	    });

	}

    },
    created : function() {
	if (true) {
	}
    },

})
