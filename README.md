# 新疆公路建设指挥平台

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

