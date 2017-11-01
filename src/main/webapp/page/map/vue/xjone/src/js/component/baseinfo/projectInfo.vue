<template>
    <!--项目基本信息-->
    <div class="project-info" id="projectInfoAreaId">
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="#commandList" data-toggle="tab">指挥部</a>
            </li>
            <li>
                <a href="#constructionList" data-toggle="tab">施工单位</a>
            </li>
            <li>
                <a href="#supervisoryList" data-toggle="tab">监管单位</a>
            </li>
            <li>
                <a href="#agreementList" data-toggle="tab">合同信息</a>
            </li>
            <li>
                <a href="#jlbgList" data-toggle="tab">计量变更</a>
            </li>
            <li>
                <a href="#preWorkList" data-toggle="tab">前期工作</a>
            </li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fad in active" id="commandList">
                <div class="container-fluid">
                    <div class="accordion" id="zhihuiCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#zhihuiCollapse" href="#zhXMJL">
                                                        项目计量软件使用人员
                                                    </a>
                            </div>
                            <div id="zhXMJL" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <!--<img src="../../static/images/onepic-home-img/zh-xmjl.png"-->
                                    <!--alt="" style="width: 100%;">-->
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>姓名</th>
                                                <th>单位</th>
                                                <th>备注</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>杨明</td>
                                                <td>驻办地</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>李玉英</td>
                                                <td>施工单位</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>韩军</td>
                                                <td>施工单位</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>纪超</td>
                                                <td>总监</td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#zhihuiCollapse" href="#zhXMXX">
                                                        项目基本信息
                                                    </a>
                            </div>
                            <div id="zhXMXX" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <!--<img src="../../static/images/onepic-home-img/zh-xm-xinxi.png"-->
                                    <!--alt="" style="width: 100%;">-->
                                    <div class="container-fluid" style="margin: 0 5px;">
                                        <div class="row show-row-line">
                                            <div class="col-md-3 show-item">
                                                项目编号：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                S19-G575
                                            </div>
                                            <div class="col-md-3 show-item">
                                                项目名称：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                老爷庙口岸-巴里坤
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 show-item">
                                                项目负责人：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                热普凯提·卡哈尔
                                            </div>
                                            <div class="col-md-3 show-item">
                                                全长（KM）：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                2000
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 show-item">
                                                批准概算（万元）：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                371300
                                            </div>
                                            <div class="col-md-3 show-item">
                                                开工日期：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                2017-01
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 show-item">
                                                交工日期：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                2019-04
                                            </div>
                                            <div class="col-md-3 show-item">
                                                竣工日期：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                2019-5
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 show-item">
                                                计划工期（月）：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                30
                                            </div>
                                            <div class="col-md-3 show-item">
                                                项目联系电话：
                                            </div>
                                            <div class="col-md-3 show-item">
                                                13899359424
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#zhihuiCollapse" href="#zhXinXi">
                                                        指挥部信息
                                                    </a>
                            </div>
                            <div id="zhXinXi" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/zh-zhb-xinxi.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#zhihuiCollapse" href="#zhXMZZJG">
                                                        指挥部信息
                                                    </a>
                            </div>
                            <div id="zhXMZZJG" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/zh-xm-zzjg.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fad" id="constructionList">
                <div class="container-fluid">
                    <div class="accordion" id="shigongCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#shigongCollapse" href="#sgBiaoDuan">
                                                        标段基本信息
                                                    </a>
                            </div>
                            <div id="sgBiaoDuan" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/sg-biaoduan.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#shigongCollapse" href="#sgRen">
                                                        人员到位信息
                                                    </a>
                            </div>
                            <div id="sgRen" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/sg-ren.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#shigongCollapse" href="#sgSheBei">
                                                        设备在场统计信息
                                                    </a>
                            </div>
                            <div id="sgSheBei" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/sg-shebei.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fad" id="supervisoryList">
                <div class="container-fluid">
                    <div class="accordion" id="jianguanCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jianguanCollapse" href="#jgHeTong">
                                                        合同信息
                                                    </a>
                            </div>
                            <div id="jgHeTong" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/p-info-1.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jianguanCollapse" href="#jgJianGuan">
                                                        监理单位基本信息
                                                    </a>
                            </div>
                            <div id="jgJianGuan" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/p-info-jianguan.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jianguanCollapse" href="#jgJianGuanRen">
                                                        监理单位人员到位信息
                                                    </a>
                            </div>
                            <div id="jgJianGuanRen" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/p-info-jgren.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fad" id="agreementList">
                <div class="container-fluid">
                    <div class="accordion" id="agreementCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#agreementCollapse" href="#htRen">
                                                        人员到位计划信息
                                                    </a>
                            </div>
                            <div id="htRen" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/ht-ren.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#agreementCollapse" href="#htSB">
                                                        设备管理列表
                                                    </a>
                            </div>
                            <div id="htSB" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/ht-sb.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fad" id="jlbgList">
                <div class="container-fluid">
                    <div class="accordion" id="jlbgCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="#jlbgYLB">
                                                        变更令一览表
                                                    </a>
                            </div>
                            <div id="jlbgYLB" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/jlbg-ylb.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="#bgtz">
                                                        变更台账
                                                    </a>
                            </div>
                            <div id="bgtz" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/jlbg-bgtz.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="#sgjd">
                                                        施工进度
                                                    </a>
                            </div>
                            <div id="sgjd" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/jlbg-sgjd.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        合同价格调整表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        回扣动员预付款一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        计量支付数量汇总表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        价格调整汇总表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        扣回材料垫付款一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        扣回及退还农民工工资保证金一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        扣回质量保证金一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        清单单价变更一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        清单工程量变更一览表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        清单信息
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        清单中期支付报表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        永久性工程材料到达现场计量表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        支付申请表
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        支付证书
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        中间计量单
                                                    </a>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#jlbgCollapse" href="">
                                                        中期财务支付证书
                                                    </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fad" id="preWorkList">
                <div class="container-fluid">
                    <div class="accordion" id="preWorkCollapse">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#preAQZR">
                                                        安全责任体系
                                                    </a>
                            </div>
                            <div id="preAQZR" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-anquanzenren.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#prework">
                                                        前期工作一栏表
                                                    </a>
                            </div>
                            <div id="prework" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-work.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#preTZ">
                                                        项目投资完成情况表
                                                    </a>
                            </div>
                            <div id="preTZ" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-tz.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#preYK">
                                                        用款计划
                                                    </a>
                            </div>
                            <div id="preYK" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-yk.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#preYKSQ">
                                                        用款申请
                                                    </a>
                            </div>
                            <div id="preYKSQ" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-yksq.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#preWorkCollapse" href="#preZLTX">
                                                        质量责任体系
                                                    </a>
                            </div>
                            <div id="preZLTX" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <img src="../../static/images/onepic-home-img/pre-zltx.png" alt="" style="width: 100%;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Vue from 'Vue'
    var ProjectInfo = Vue.extend({
        name: 'ProjectInfo',
        data: function() {
            return {
            }
        },
    });
    export default {};
</script>
