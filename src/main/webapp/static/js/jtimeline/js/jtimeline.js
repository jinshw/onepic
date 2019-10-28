(function($, window, document, undefined) {
  var clickFlag = true;
  //定义TimeLine的构造函数
  var TimeLine = function(ele, opt) {
    (this.$element = ele),
      (this.defaults = {
        times: [
          "2016.03.05",
          "2016.05.06",
          "2016.06.26",
          "2016.09.04",
          "2016.10.01",
          "2017.01.01",
          "2017.03.15"
        ],
        activeIndex: 0
      }),
      (this.options = $.extend({}, this.defaults, opt));
  };
  //定义TimeLine的方法
  TimeLine.prototype = {
    createDOM: function() {
      var _domStr =
        '<div class="event_box">' +
        '<div class="parHd clearfix">' +
        '   <div class="tempWrap" style="">' +
        '       <ul style="           ' +
        '           ">';
      for (var i = 0; i < this.options.times.length; i++) {
        if (i == this.options.activeIndex) {
          _domStr =
            _domStr +
            '<li class="act"><span></span>' +
            this.options.times[i] +
            "</li>";
        } else {
          _domStr =
            _domStr + "<li><span></span>" + this.options.times[i] + "</li>";
        }
      }

      _domStr =
        _domStr +
        "       </ul>" +
        "   </div>" +
        '   <a class="sPrev"></a>          ' +
        '   <a class="sNext"></a>         ' +
        "</div></div>";

      return this.$element.html(_domStr);
    },
    preAndNext: function(callback) {
      // 上一个时间点
      $(".sPrev").click(function() {
        if (clickFlag) {
          clickFlag = false;
          var _left = $(".tempWrap>ul")
            .css("left")
            .slice(0, -2);
          $(".tempWrap>ul").css("left", Number(_left) + 160 + "px");
          setTimeout(function(){
            clickFlag = true;
          },500)
        }
      });
      // 下一个时间点
      $(".sNext").click(function() {
        if (clickFlag) {
          clickFlag = false;
          var _left = $(".tempWrap>ul")
            .css("left")
            .slice(0, -2);
          $(".tempWrap>ul").css("left", Number(_left) - 160 + "px");
          setTimeout(function(){
            clickFlag = true;
          },500)
        }
      });
      // 时间点击事件
      $(".tempWrap>ul>li").click(function() {
        $(".tempWrap>ul>li").removeClass("act");
        $(this).addClass("act");
        if (typeof callback === "function") {
          callback(this);
        }
      });
    },
    initActiveLocation: function() {
      // 如果初始化高亮时间点位置大于时间轴上显示的数量（6个），高亮点显示位置为最后一个
      var curNumber = this.options.activeIndex + 1;
      var diffVal = 0;
      if (curNumber > 6) {
        diffVal = curNumber - 6;
      }
      var _left = $(".tempWrap>ul")
        .css("left")
        .slice(0, -2);
      $(".tempWrap>ul").css("left", Number(_left) - 160 * diffVal + "px");
    }
  };
  //在插件中使用TimeLine对象
  $.fn.initTimeLine = function(options, callback) {
    //创建Beautifier的实体
    var timeLine = new TimeLine(this, options);
    timeLine.createDOM();
    timeLine.initActiveLocation();
    timeLine.preAndNext(callback);
  };
})(jQuery, window, document);
