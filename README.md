# 新疆公路建设指挥平台

## 20171205-新增黑色底图
* 修改的主要内容：
   替换底图、在建道路地址；修改左侧项目树初始化查询和点击查询
* 修改底图地址：
URL: host + "/iserver/services/map-XinJiangYiZhangTu/rest/maps/JSGIST-GL（黑）",
URL_DATA: host + "/iserver/services/data-XinJiangYiZhangTu/rest/data",
ROAD_URL: host + "/iserver/services/map-XinJiangYiZhangTu/rest/maps/JSGIST-GS",// 没用到
ZJ_ROAD: host + "/iserver/services/map-zaijiandaoluxin2/rest/maps/GLZJ",

* 修改文件：
xjroud-config.js
xjroud-echarts.js
xjroud-main.js
xjroud-ztree.js



## 20171013-新增
* 影像核查：     
1. 添加核查影像图层
2. 在进入模块提示框核查信息
3. 点击每个核查面积区域显示不同信息

---------------------------------------
## 遇到的问题
### spring quartz配置：
1.XML配置方式
* quartz.xml 配置
```aidl
    <bean id="getDatas" class="com.ykkj.weiyi.quartz.HdTask"></bean>
    <task:scheduled-tasks>
        <task:scheduled ref="getDatas" method="getDatas" cron="0/5 * * * * *"/>
    </task:scheduled-tasks>
    <context:component-scan base-package="com.ykkj.weiyi.quartz"/>
```
2.注解方式：
* 在Java事例方法上添加
```aidl
    @Scheduled(cron = "0/5 * *  * * ? ")
    public void getDatas(){
    
    }
```
* 在类上添加@Lazy(false) 注解标签（如果不添加，不能执行定时器方法）

3.注意点：
* spring的@Scheduled注解  需要写在实现上
* 类上添加@Component 注解标签
* 定时器的方法没有返回值

---------------------------------------
实时路况用到jar包
fastjson-1.2.4.jar

多数据源配置用到jar包
commons-pool-1.3.jar
c3p0-0.9.1.2.jar
ojdbc14-10.2.0.2.jar

* maven3 手动安装oracle本地驱动jar到仓库，
进入jar包所在文件夹执行：
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.2 -Dpackaging=jar -Dfile=ojdbc14-10.2.0.2.jar


