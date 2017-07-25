import $ from 'jquery'

var dataScroll = function(){
	var url = window.location.href.split('#')[0]

	//rem适配
	var _cssText = document.querySelector("html").style.cssText;
	document.querySelector("html").style.cssText = _cssText + "font-size:" + 100 * ($(window).width()) / 750 + "px !important";

	// var top = $('a[href="#姓名"]').offset().top;
	console.log(url)
}


export default  dataScroll
