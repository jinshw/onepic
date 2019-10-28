# jtimeline 时间轴
* 基于jQuery实现的时间轴插件
* 横向和纵向展示
* 时间节点点击时间，鼠标滑动可以展示信息
* 时间轴超出长度可以左右滑动

# 事例

1. 在HTML页面中定义DOM节点
```
<div id="timeLine">/div>
```
2. 在js中，使用如下
```
$("#timeLine").initTimeLine({
            times: [
                '2016-03-08',
                '05-19',
                '2016.06.28',
                '2016.09.04',
                '2016.10.01',
                '2017.01.01'            ],
            activeIndex: 8
        },function(item){
            console.log($(item).text())
        });
```
3. API 说明：

   $("#id").initTimeLine({times[],activeIndex:number},function(){})

|    关键字    |  类型  |     备注      |
| :----------: | :----: | :-----------: |
| initTimeLine | object |    关键字     |
|    times     | array  |   时间列表    |
| activeIndex  | number | times数组下标 |
|   回调函数   |        |               |

