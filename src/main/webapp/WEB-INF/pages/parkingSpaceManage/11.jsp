<%--<body>--%>
<%--<form:form modelAttribute="parkingSpace" id="pageForm" method="post" autocomplete="off">--%>
    <%--<div class="main-content">--%>
        <%--<div class="breadcrumbs" id="breadcrumbs">--%>
            <%--<script type="text/javascript">--%>
                <%--try {--%>
                    <%--ace.settings.check('breadcrumbs', 'fixed')--%>
                <%--} catch (e) {--%>
                <%--}--%>
            <%--</script>--%>
            <%--<ul class="breadcrumb">--%>
                <%--<li><i class="icon-home home-icon"></i> <a href="#">Home</a></li>--%>
                <%--<li><a href="#">Tables</a></li>--%>
                <%--<li class="active">Simple &amp; Dynamic</li>--%>
            <%--</ul>--%>
            <%--<!-- .breadcrumb -->--%>
        <%--</div>--%>

        <%--<div class="page-content">--%>

            <%--<div class="page-header"/>--%>
            <%--<!-- /.page-header -->--%>

            <%--<div class="row">--%>
                <%--<div class="col-xs-12">--%>
                    <%--<div class="form-horizontal">--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> TextField </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5" validata-options="validType:'Require',msg:'不能为空'"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="space-4"></div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="form-field-2">PasswordField </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<input type="password" id="form-field-2" placeholder="Password"--%>
                                       <%--class="col-xs-10 col-sm-5"/>--%>
                            <%--<span class="help-inline col-xs-12 col-sm-7">--%>
                                <%--<span class="middle">Inline help text</span>--%>
                            <%--</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="space-4"></div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label no-padding-right" for="form-field-2">Select </label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<select class="col-xs-10 col-sm-5" id="form-field-select-1">--%>
                                    <%--<c:forEach items="${list}" var="myList">--%>
                                        <%--<option>${myList.get("key")}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="space-4"></div>--%>

                        <%--<div class="clearfix form-actions">--%>
                            <%--<div class="col-md-offset-3 col-md-9">--%>
                                <%--<button id="save" name="save" class="btn btn-info" type="button">--%>
                                    <%--<i class="icon-ok bigger-110"></i>提交--%>
                                <%--</button>--%>

                                <%--&nbsp; &nbsp; &nbsp;--%>
                                <%--<button id="back" name="back" class="btn" type="reset">--%>
                                    <%--<i class="icon-undo bigger-110"></i>返回--%>
                                <%--</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<!-- /span -->--%>
            <%--</div>--%>
            <%--<!-- /row -->--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</form:form>--%>
<%--</body>--%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>停车位管理</title>
</head>
<body>
<form:form modelAttribute="parkingSpace" id="pageForm" method="post" autocomplete="off">
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
                    <h5 class="lighter">添加停车位</h5>
                </div>

                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-search">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> TextField </label>
                                    <div class="col-sm-9">
                                        <span class="input-group-btn">
                                        <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5" validata-options="validType:'Require',msg:'不能为空'"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row" style="margin-top: 20px">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-2">PasswordField </label>
                                    <div class="col-sm-9">
                                        <input type="password" id="form-field-2" placeholder="Password" class="col-xs-10 col-sm-5"/>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row" style="margin-top: 20px">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-2">Select </label>
                                    <div class="col-sm-9">
                                        <select class="col-xs-10 col-sm-5" id="form-field-select-1">
                                            <c:forEach items="${list}" var="myList">
                                                <option>${myList.get("key")}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row" style="margin-top: 20px">
                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="save" name="save" class="btn btn-info" type="button">
                                            <i class="icon-ok bigger-110"></i>提交
                                        </button>

                                        &nbsp; &nbsp; &nbsp;
                                        <button id="reset" name="reset" class="btn" type="reset">
                                            <i class="icon-undo bigger-110"></i>重置
                                        </button>

                                        &nbsp; &nbsp; &nbsp;
                                        <button id="golist" name="golist" class="btn btn-danger" onclick="location.href='${ctx}/w/parkingSpace/list'">
                                            <i class="icon-reply icon-only"></i> 前往列表
                                        </button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="page-header"/>
            <!-- /.page-header -->

        </div>
        <!-- /.page-content -->
    </div>
</form:form>
<script type="text/javascript">
    $("#save").click(function() {

        $("#pageForm").submit();

    });

    $("#pageForm").checkForm();

    $("#reset").click(function() {
        $("input").val('');
        $("select").val("-1");
    })
</script>
</body>