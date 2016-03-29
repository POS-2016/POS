<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>停车位管理</title>
    <link rel="stylesheet" href="${ctx}/static/css/daterangepicker.css" />
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
                                        <form:input id="startTime" path="startTime" name="startTime" type="hidden"/>
                                        <form:input id="endTime" path="endTime" name="endTime" type="hidden"/>
                                        <input class="form-control" type="text" name="date-range-picker" id="date-range-picker" value="${parkingSpaceManagePageSearcher.date}"/>
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-1"></div>

                                <div class="col-xs-12 col-sm-3">
                                    <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                                    <label class="control-label no-padding-right" for="cost"> 消费查询 </label>
                                    </div>
                                    <div class="col-sm-9 no-padding-left">
                                        <form:input id="cost" path="cost" class="form-control search-query" placeholder="请输入数值" value="${parkingSpaceManagePageSearcher.cost}"/>
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-1"></div>

                                <div class="col-xs-12 col-sm-3">
                                    <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                                        <label class="control-label no-padding-right" for="status">状态查询</label>
                                    </div>
                                    <div class="col-sm-9 no-padding-left">
                                        <form:input id="status" path="status" class="form-control search-query" placeholder="请输入空或满" value="${parkingSpaceManagePageSearcher.status}"/>
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
                    <div class="table-responsive">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>车位号</th>
                                <th>车牌号</th>
                                <th>状态</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>应付金额</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageObj.result}" var="parkingSpace">
                                <tr>
                                    <td>${parkingSpace.id}</td>
                                    <td>${parkingSpace.spaceNumber}</td>
                                    <td>${parkingSpace.carNumber}</td>
                                    <td>${parkingSpace.status}</td>
                                    <td>${parkingSpace.startTime}</td>
                                    <td>${parkingSpace.endTime}</td>
                                    <td>${parkingSpace.cost}</td>
                                    <td>
                                        <a href="${ctx}/parkingSpaceManage/parkingSpace/manage?servantRoleID=${parkingSpace.id}">编辑</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                    <!--分页 begin-->
                    <div class="row">
                        <div class="col-lg-6">
                            <%@ include file="/common/page_bar.jsp" %>
                        </div>
                    </div>
                    <!--分页 end-->
                </div>
                <!-- /span -->
            </div>
            <!-- /row -->

        </div>
        <!-- /.page-content -->
    </div>
</form:form>
<script src="${ctx}/static/js/date-time/moment.min.js"></script>
<script src="${ctx}/static/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
    
    jQuery(function ($) {
        $("#query").click(function () {
            var date = $('#date-range-picker').val();
            $('#startTime').val(date.split("~")[0]);
            $('#endTime').val(date.split("~")[1]);
            $("#pageNo").val(1);
            $("#pageForm").submit();
        });

        $('#date-range-picker').daterangepicker().prev().on(ace.click_event, function(){
            $(this).next().focus();
        });

    })
</script>
</body>