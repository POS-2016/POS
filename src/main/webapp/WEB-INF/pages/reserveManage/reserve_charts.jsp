<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<head>
    <title>订单统计</title>
    <!-- ECharts单文件引入 -->
    <script src="${ctx}/static/js/echarts-all.js"></script>
    <!-- jQuery -->
    <script src="${ctx}/static/js/jquery.min.js"></script>
</head>
<body>

<form:form modelAttribute="reserve" action="${ctx}/w/reserve/count" method="post" id="pageForm">
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li><i class="icon-home home-icon"></i> <a href="#">Home</a></li>
                <li><a href="#">Tables</a></li>
                <li class="active">Simple &amp; Dynamic</li>
            </ul>
            <!-- .breadcrumb -->
        </div>

        <div class="page-content">
            <div class="widget-box">
                <div class="widget-header widget-header-small">
                    <h5 class="lighter">搜索框</h5>
                </div>

                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-search">
                            <div class="row">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="icon-calendar bigger-110"></i>
                                        </span>
                                        <input class="form-control date-picker" id="date" name="date" type="text" data-date-format="yyyy-mm-dd" />
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-1"></div>

                            </div>

                            <div class="row" style="margin-top: 10px">
                                <div class="col-xs-12 col-sm-8">
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <button id="query" type="button" class="btn btn-purple btn-sm">查询
                                                <i class="icon-search icon-on-right bigger-110"></i>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="page-header"/>
            <!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
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

                </div>
                <!-- /span -->
            </div>
            <!-- /row -->

            <div class="row">
                <div class="col-xs-12">

                </div>
                <!-- /span -->
            </div>
            <!-- /row -->

        </div>
        <!-- /.page-content -->
    </div>
</form:form>
<script type="text/javascript" src="${ctx}/static/js/vdform2.js"></script>
<script type="text/javascript" src="${ctx}/static/js/parkingSpaceStatus.js"></script>
<script type="text/javascript" src="${ctx}/static/js/date-time/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/date-time/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/date-time/moment.min.js"></script>
<script type="text/javascript">

    jQuery(function ($) {

        $("#query").click(function () {
            $("#pageForm").submit();
        });

        $('#date').datepicker({autoclose:true}).next().on(ace.click_event, function(){
            $(this).prev().focus();
        });
    })
</script>
</body>


