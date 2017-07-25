require.config({
    paths:{
        'fastclick':'lib/fastclick'
    }
});

require(['fastclick','js/index','js/chobj','js/question'],function(FastClick,index){
    FastClick.attach(document.body,{});
   
});