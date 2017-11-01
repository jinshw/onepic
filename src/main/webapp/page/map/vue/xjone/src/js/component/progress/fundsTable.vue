<template>
    <div class="table-top" id="zjjdTable" style="display: block;">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th></th>
                    <th>1月</th>
                    <th>2月</th>
                    <th>3月</th>
                    <th>4月</th>
                    <th>5月</th>
                    <th class="danger">6月</th>
                    <th>7月</th>
                    <th>8月</th>
                    <th>9月</th>
                    <th>10月</th>
                    <th>11月</th>
                    <th class="danger">12月</th>
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
                    <td>357</td>
                    <td>448</td>
                    <td>369</td>
                    <td>510</td>
                    <td>311</td>
                    <td class="danger">412</td>
                </tr>
                <tr>
                    <th scope="row">实际投资(万元)</th>
                    <td>351</td>
                    <td>362</td>
                    <td>453</td>
                    <td>454</td>
                    <td>355</td>
                    <td class="danger">420</td>
                    <td>357</td>
                    <td>448</td>
                    <td>369</td>
                    <td>510</td>
                    <td>311</td>
                    <td class="danger">414</td>
                </tr>
                <tr>
                    <th scope="row">完成百分比(%)</th>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td class="danger">96.33%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td>100%</td>
                    <td class="danger">100.49%</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    import Vue from 'Vue'
    var FundsTable = Vue.extend({
        name: "FundsTable",
        data: function() {
            return {
            }
        }
    })
    export default FundsTable;
</script>
