<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
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

<form:form modelAttribute="parkingSpaceManagePageSearcher" id="pageForm">
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
                                            <%--<input id="startTime"  name="startTime" type="hidden"/>--%>
                                            <%--<input id="endTime"  name="endTime" type="hidden"/>--%>
                                        <input path="date" class="form-control" type="text" name="date-range-picker"
                                               id="date-range-picker"  />
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-1"></div>

                                <div class="col-xs-12 col-sm-3">
                                    <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                                        <%--<label class="control-label no-padding-right" for="id"> 车位查询 </label>--%>
                                    </div>
                                    <div class="col-sm-9 no-padding-left">
                                        <%--<form:input id="id" path="id" class="form-control search-query"--%>
                                                    <%--placeholder="请输入数值" value="${parkingSpaceManagePageSearcher.ppName}"/>--%>
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-1"></div>

                                <div class="col-xs-12 col-sm-3">
                                    <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                                        <%--<label class="control-label no-padding-right" for="status">状态查询</label>--%>
                                    </div>
                                    <div class="col-sm-9 no-padding-left">
                                        <%--<select id="status" name="status">--%>
                                            <%--<option >全部</option>--%>
                                            <%--<c:forEach items="${statusList}" var="statusList">--%>
                                                <%--<option value="${statusList.get("status")}" <c:if test="${statusList.get('status') == parkingSpaceManagePageSearcher.status}"> selected </c:if> >${statusList.get("status")}</option>--%>
                                            <%--</c:forEach>--%>
                                        <%--</select>--%>
                                    </div>
                                </div>
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
</body>
<%--<div class="row">--%>
    <%--<div class="col-lg-12 col-xs-12 col-sm-3">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<i class="fa fa-bar-chart-o fa-fw"></i> 订单量分布--%>
                <%--<div class="pull-right">--%>
                    <%--<div class="btn-group">--%>

                        <%--<select class="btn btn-default btn-xs dropdown-toggle" id="companyChoose">--%>
                            <%--<option value ="1">京东白条</option>--%>
                            <%--<option value ="2">易宝支付</option>--%>
                            <%--<option value="3">联动优势</option>--%>
                            <%--<option value="4">财付通</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- /.panel-heading -->--%>
            <%--<div class="panel-body">--%>
                <%--<div id="morris-area-chart1" style="height: 400px;"></div>--%>
            <%--</div>--%>
            <%--<!-- /.panel-body -->--%>
        <%--</div>--%>
        <%--<!-- /.panel -->--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<i class="fa fa-bar-chart-o fa-fw"></i> 销售额分布图--%>
                <%--<div class="pull-right">--%>
                    <%--<div class="btn-group">--%>
                        <%--<select class="btn btn-default btn-xs dropdown-toggle" id="companyChoose1">--%>
                            <%--<option value ="1">京东白条</option>--%>
                            <%--<option value ="2">易宝支付</option>--%>
                            <%--<option value="3">联动优势</option>--%>
                            <%--<option value="4">财付通</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- /.panel-heading -->--%>
            <%--<div class="panel-body">--%>
                <%--<div id="morris-area-chart2" style="height: 400px;"></div>--%>

            <%--</div>--%>
            <%--<!-- /.panel-body -->--%>
        <%--</div>--%>
        <%--<!-- /.panel -->--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<i class="fa fa-clock-o fa-fw"></i> 时间分布--%>
                <%--<select class="btn btn-default btn-xs dropdown-toggle" style="float: right;" id="companyChoose2">--%>
                    <%--<option value ="1">京东白条</option>--%>
                    <%--<option value ="2">易宝支付</option>--%>
                    <%--<option value="3">联动优势</option>--%>
                    <%--<option value="4">财付通</option>--%>
                <%--</select>--%>
            <%--</div>--%>
            <%--<!-- /.panel-heading -->--%>
            <%--<div class="panel-body" style="height: 400px;" id="costcountDiv">--%>

            <%--</div>--%>
            <%--<!-- /.panel-body -->--%>
        <%--</div>--%>
        <%--<!-- /.panel -->--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<!-- /.col-lg-8 -->--%>
    <%--&lt;%&ndash;<div class="col-lg-4">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="panel panel-default">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="panel-heading">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<i class="fa fa-bell fa-fw"></i> 排行榜&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<!-- /.panel-heading -->&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="panel-body">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="list-group" id="rankLists">&ndash;%&gt;--%>

                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<!-- /.list-group -->&ndash;%&gt;--%>
                <%--&lt;%&ndash;<!--<a href="#" class="btn btn-default btn-block">View All Alerts</a>-->&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<!-- /.panel-body -->&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--<script type="text/css" src="${ctx}/static/css/bootbox.min.css"></script>--%>
    <%--<script type="text/css" src="${ctx}/static/css/metisMenu.min.css"></script>--%>
    <%--<script type="text/css" src="${ctx}/static/css/timeline.css"></script>--%>


