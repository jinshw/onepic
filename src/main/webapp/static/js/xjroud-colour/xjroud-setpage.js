/**
 * 模块：设置页面
 */
$(function () {
    $("#configBT").click(function () {
        $(".config-page-container").css("display", "block")
    })
    $(".config-page-container").mouseleave(function () {
        $(".config-page-container").css("display", "none")
    })
    $("#projectInfoBt").change(function () {
        if ($(this).prop("checked")) {
            $("#projectInfoAreaId").css("display", "block")
        } else {
            $("#projectInfoAreaId").css("display", "none")
        }
    })
    $("#yxhcInfoBt").change(function () {
        if ($(this).prop("checked")) {
            $("#yxhcInfoArea").css("display", "block")
        } else {
            $("#yxhcInfoArea").css("display", "none")
        }
    })
})