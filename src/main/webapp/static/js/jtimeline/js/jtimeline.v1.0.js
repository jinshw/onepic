(function ($, window, document, undefined) {
  var clickFlag = true;
  var liWidth = 100, liSpanLeft = 38;
  var options = null;
  var playerTimer = null;
  var timeLine = null;

  //定义TimeLine的构造函数
  var TimeLine = function (ele, opt) {
    (this.$element = ele),
      (this.defaults = {
        times: [
          "2011",
          "2012",
          "2013",
          "2014",
          "2015",
          "2016",
          "2017"
        ],
        activeIndex: 0,
        isPlay: true,
        step: 100,
        intervaltime: 2000 // 单位毫秒
      }),
      (this.options = $.extend({}, this.defaults, opt));
  };
  //定义TimeLine的方法
  TimeLine.prototype = {
    createDOM: function () {
      // 计算步长，默认 liWidth = 100,liSpanLeft = 38
      var liWidthDiff = liWidth - this.options.step;
      var liSpanLeft = 38 - liWidthDiff / 2;
      options = this.options

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
            '<li class="act" data-index="' + i + '" style="width:' + this.options.step + 'px"><span style="left:' + liSpanLeft + 'px"></span>' +
            "<p style='display:none;'>" + this.options.times[i] + "</p>" +
            "</li>";
        } else {
          _domStr =
            _domStr + "<li data-index='" + i + "' style='width:" + this.options.step + "px'><span style='left:" + liSpanLeft + "px'></span>" +
            "<p style='display:none;'>" + this.options.times[i] + "</p>" + "</li>";
        }
      }

      _domStr =
        _domStr +
        "   <div class='timeline'></div>    </ul>" +
        // "   <div class='timeline'></div>    </ul>" +
        "   </div>" +
        '   <a class="sPrev"></a>          ' +
        '   <a class="sNext"></a>         ' +
        '   <a class="sPause" id="playBT"></a>         ' +
        "</div></div>";

      return this.$element.html(_domStr);
    },
    preAndNext: function (callback) {
      // 上一个时间点
      $(".sPrev").click(function () {
        if (clickFlag) {
          clickFlag = false;
          var _left = $(".tempWrap>ul")
            .css("left")
            .slice(0, -2);
          $(".tempWrap>ul").css("left", Number(_left) + options.step + 160 + "px");
          setTimeout(function () {
            clickFlag = true;
          }, 500)
        }
      });
      // 下一个时间点
      $(".sNext").click(function () {
        if (clickFlag) {
          clickFlag = false;
          var _left = $(".tempWrap>ul")
            .css("left")
            .slice(0, -2);
          $(".tempWrap>ul").css("left", Number(_left) - options.step - 160 + "px");
          setTimeout(function () {
            clickFlag = true;
          }, 500)
        }
      });
      // 时间点击事件
      $(".tempWrap>ul>li").click(function () {
        $(".tempWrap>ul>li").removeClass("act");
        $(this).addClass("act");
        // 设置options.activeIndex值
        var textVal = $(this).text()
        var optionsVal = ""
        for (var i = 0; i < options.times.length; i++) {
          optionsVal = options.times[i]
          if (textVal === String(optionsVal)) {
            options.activeIndex = i
            break;
          }
        }

        if (typeof callback === "function") {
          callback(this);
        }
      });


    },
    initActiveLocation: function () {
      // 如果初始化高亮时间点位置大于时间轴上显示的数量（6个），高亮点显示位置为最后一个
      var curNumber = this.options.activeIndex + 1;
      var diffVal = 0;
      if (curNumber > 6) {
        diffVal = curNumber - 6;
      }
      var _left = $(".tempWrap>ul")
        .css("left")
        .slice(0, -2);
      $(".tempWrap>ul").css("left", Number(_left) - (160 + options.step) * diffVal + "px");
    },
    runPlay: function () {
      var that = this;
      $("#playBT").click(function () {
        var thisClass = $(this).attr("class")
        if (thisClass === "sPause") {// 当前样式显示暂停，即正在播放状态，点击后触发暂停事件
          that.clearTimer()
        } else if (thisClass === "sPlay") {// 当前样式显示播放，即正在暂停状态，点击后触发播放事件
          options.isPlay = true
          that.runTimer()
        }
        console.log(thisClass)
      })
      var thisClass = $("#playBT").attr("class")
      // 初始化当前事件
      if (thisClass === "sPause") {
        this.runTimer()
      }
    },
    runTimer: function () {
      var that = this
      var $lis = $(".tempWrap>ul>li")
      if (options.isPlay) {
        $("#playBT").removeClass("sPlay")
        $("#playBT").addClass("sPause")
        var wrapWith = $(".tempWrap").width()
        playerTimer = setInterval(function () {
          $lis.removeClass("act");
          // $($lis[options.activeIndex]).addClass("act")
          $($lis[options.activeIndex]).trigger("click")
          // $(".sNext").trigger("click")
          // 判断是否应该向左移动
          var actWidht = options.activeIndex * (options.step + 60)
          var ulLeft = Number($(".tempWrap>ul").css("left").replace("px", ""))
          var currWidth = actWidht - ulLeft
          var actLeft = currWidth - wrapWith
          // console.log(wrapWith,actWidht,ulLeft,currWidth,actLeft)
          if (actLeft >= 0) {
            $(".sNext").trigger("click")
          }

          options.activeIndex = options.activeIndex + 1

          if (options.activeIndex > options.times.length) {
            options.activeIndex = 0
            // $("#playBT").removeClass("sPause")
            // $("#playBT").addClass("sPlay")
            // 回到第一个时间点
            $lis.removeClass("act");
            $($lis[0]).addClass("act")
            $(".tempWrap>ul").css("left", "0")
            // that.clearTimer()
            $($lis[options.activeIndex]).trigger("click")

            // 停止在最后一个时间点
            // $lis.removeClass("act");
            // $($lis[options.times.length-1]).addClass("act")

          }
        }, options.intervaltime)

      } else {
        $("#playBT").removeClass("sPause")
        $("#playBT").addClass("sPlay")
      }

    },
    clearTimer: function () {
      window.clearInterval(playerTimer)
      $("#playBT").removeClass("sPause")
      $("#playBT").addClass("sPlay")
    }
  };
  //在插件中使用TimeLine对象
  $.fn.initTimeLine = function (options, callback) {
    //创建Beautifier的实体
    timeLine = new TimeLine(this, options);
    timeLine.createDOM();
    timeLine.initActiveLocation();
    timeLine.preAndNext(callback);
    timeLine.runPlay();
  };
  $.fn.clearTimer = function () {
    if (timeLine != null && timeLine !== undefined) {
      timeLine.clearTimer()
    }
  }
})(jQuery, window, document);
