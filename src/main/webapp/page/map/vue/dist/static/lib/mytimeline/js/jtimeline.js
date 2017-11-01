;
(function($, window, document, undefined) {
    //定义TimeLine的构造函数
    var TimeLine = function(ele, opt) {
        this.$element = ele,
            this.defaults = {
                times:[
                    '2016.03.05',
                    '2016.05.06',
                    '2016.06.26',
                    '2016.09.04',
                    '2016.10.01',
                    '2017.01.01',
                    '2017.03.15'
                ]
            },
            this.options = $.extend({}, this.defaults, opt)
    }
    //定义TimeLine的方法
    TimeLine.prototype = {
        createDOM: function() {
            var _domStr = '<div class="event_box">' +
                '<div class="parHd clearfix">' +
                '   <div class="tempWrap" style="">' +
                '       <ul style="           ' +
                '           ">' ;
                for(var i=0;i<this.options.times.length;i++){
                    if(typeof this.options.active != 'undefined'){
                        if(this.options.times[i] == this.options.active){
                            _domStr = _domStr + '<li class="act"><span></span>'+this.options.times[i]+'</li>';
                        }else{
                            _domStr = _domStr + '<li><span></span>'+this.options.times[i]+'</li>';
                        }
                    }else{
                        if(i==0){
                            _domStr = _domStr + '<li class="act"><span></span>'+this.options.times[i]+'</li>';
                        }else{
                            _domStr = _domStr + '<li><span></span>'+this.options.times[i]+'</li>';
                        }
                        
                    }
                }

                // '           <li class="act"><span></span>2016.03.05</li>     ' +
                // '           <li><span></span>2016.05.06</li>                 ' +
                // '           <li><span></span>2016.06.26</li>                 ' +
                // '           <li><span></span>2016.09.04</li>                 ' +
                // '           <li><span></span>2016.11.05</li>                 ' +
                // '           <li><span></span>2016.12.18</li>                 ' +
                // '           <li><span></span>2017.01.13</li>                 ' +
                // '           <li><span></span>2017.02.18</li>                 ' +
                _domStr = _domStr +
                '       </ul>' +
                '   </div>' +
                '   <a class="sPrev"></a>          ' +
                '   <a class="sNext"></a>         ' +
                '</div></div>';

            return this.$element.html(_domStr)
        },
        preAndNext: function(callback) {
            // 上一个时间点
            $('.sPrev').click(function() {
                var _left = $(".tempWrap>ul").css("left").slice(0, -2)
                $(".tempWrap>ul").css("left", (Number(_left) + 160) + "px")
            })
            // 下一个时间点
            $('.sNext').click(function() {
                var _left = $(".tempWrap>ul").css("left").slice(0, -2)
                $(".tempWrap>ul").css("left", (Number(_left) - 160) + "px")
            })
            // 时间点击事件
            $(".tempWrap>ul>li").click(function() {
                $(".tempWrap>ul>li").removeClass("act")
                $(this).addClass("act")
                if (typeof callback === 'function') {
                    callback(this)
                }
            })
        }
    }
    //在插件中使用TimeLine对象
    $.fn.initTimeLine = function(options, callback) {
        //创建Beautifier的实体
        var timeLine = new TimeLine(this, options);
        timeLine.createDOM();
        timeLine.preAndNext(callback);


        //调用其方法
        // return timeLine.preAndNext();
    }
})(jQuery, window, document);