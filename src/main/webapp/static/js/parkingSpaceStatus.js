/**
 * Created by gssflyaway on 16/1/12.
 */
// 基于准备好的dom，初始化echarts图表

$(document).ready(function () {
    $.getJSON("/w/parkingSpace/status" , function (result) {
        var myChart1 = echarts.init(document.getElementById('morris-area-chart1'));

        var provinces1 = new Array();
        var data1 = new Array();
        var ddd1 = new Array();
        //alert(result);
        $.each(result, function(i, field){
            //$("#testp").append(field.pName + " ");
            provinces1[i] = field.status;
            data1[i] = field.number;
            var d= new Object();
            d.name=field.status;
            d.value=field.number;
            ddd1[i]=d;
        });
        option1 = {
            title : {
                text: '车位状态分布图',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:provinces1
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'left',
                                max: 10
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'访问来源',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:ddd1
                }
            ]
        };



// 为echarts对象加载数据
        myChart1.setOption(option1);
    });


});

