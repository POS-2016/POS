<%--
  Created by IntelliJ IDEA.
  User: gssflyaway
  Date: 16/4/18
  Time: 下午1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title>停车位图表</title>

    <!-- Bootstrap Core CSS -->
    <%--<link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">--%>



    <!-- MetisMenu CSS -->
    <%--<link href="${ctx}/static/css/metisMenu.min.css" rel="stylesheet">--%>

    <!-- Timeline CSS -->
    <%--<link href="${ctx}/static/css/timeline.css" rel="stylesheet">--%>

    <!-- Custom CSS -->
    <%--<link href="${ctx}/static/css/sb-admin-2.css" rel="stylesheet">--%>

    <!-- ECharts单文件引入 -->
    <script src="${ctx}/static/js/echarts-all.js"></script>

    <!-- jQuery -->
    <script src="${ctx}/static/js/jquery.min.js"></script>


</head>
<body>
<div class="row">
    <div class="col-lg-12 col-xs-12 col-sm-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> 订单量分布
                <div class="pull-right">
                    <div class="btn-group">

                        <select class="btn btn-default btn-xs dropdown-toggle" id="companyChoose">
                            <option value ="1">京东白条</option>
                            <option value ="2">易宝支付</option>
                            <option value="3">联动优势</option>
                            <option value="4">财付通</option>
                        </select>
                    </div>
                </div>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div id="morris-area-chart1" style="height: 400px;"></div>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> 销售额分布图
                <div class="pull-right">
                    <div class="btn-group">
                        <select class="btn btn-default btn-xs dropdown-toggle" id="companyChoose1">
                            <option value ="1">京东白条</option>
                            <option value ="2">易宝支付</option>
                            <option value="3">联动优势</option>
                            <option value="4">财付通</option>
                        </select>
                    </div>
                </div>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div id="morris-area-chart2" style="height: 400px;"></div>

            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-clock-o fa-fw"></i> 时间分布
                <select class="btn btn-default btn-xs dropdown-toggle" style="float: right;" id="companyChoose2">
                    <option value ="1">京东白条</option>
                    <option value ="2">易宝支付</option>
                    <option value="3">联动优势</option>
                    <option value="4">财付通</option>
                </select>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body" style="height: 400px;" id="costcountDiv">

            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    <%--</div>--%>
    <!-- /.col-lg-8 -->
    <%--<div class="col-lg-4">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<i class="fa fa-bell fa-fw"></i> 排行榜--%>
            <%--</div>--%>
            <%--<!-- /.panel-heading -->--%>
            <%--<div class="panel-body">--%>
                <%--<div class="list-group" id="rankLists">--%>

                <%--</div>--%>
                <%--<!-- /.list-group -->--%>
                <%--<!--<a href="#" class="btn btn-default btn-block">View All Alerts</a>-->--%>
            <%--</div>--%>
            <%--<!-- /.panel-body -->--%>
        <%--</div>--%>

    <%--</div>--%>

    <%--<script type="text/css" src="${ctx}/static/css/bootbox.min.css"></script>--%>
    <%--<script type="text/css" src="${ctx}/static/css/metisMenu.min.css"></script>--%>
    <%--<script type="text/css" src="${ctx}/static/css/timeline.css"></script>--%>
    <script type="text/javascript" src="${ctx}/static/js/vdform2.js"></script>

    <script type="text/javascript" src="${ctx}/static/js/parkingSpaceStatus.js"></script>


</body>

</html>
