<template>
    <div class="table-top" id="jdjdTable" style="display: block;">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th></th>
                    <th>路基</th>
                    <th>路面</th>
                    <th>桥梁、涵洞工程</th>
                    <th>交叉工程</th>
                    <th>隧道</th>
                    <th class="danger">交通工程</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">计划投资(万元)</th>
                    <td>351</td>
                    <td>362</td>
                    <td>453</td>
                    <td>454</td>
                    <td>355</td>
                    <td class="danger">436</td>
                </tr>
                <tr>
                    <th scope="row">实际投资(万元)</th>
                    <td>351</td>
                    <td>362</td>
                    <td>453</td>
                    <td>454</td>
                    <td>355</td>
                    <td class="danger">420</td>
                </tr>
                <tr>
                    <th scope="row">完成百分比(%)</th>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td class="danger">96.33%</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    import Vue from 'Vue'
    var ImageTable = Vue.extend({
        name: "ImageTable",
        data: function() {
            return {};
        }
    });
    export default ImageTable;
</script>
