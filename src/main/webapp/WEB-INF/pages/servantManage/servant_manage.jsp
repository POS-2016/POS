<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>账户管理</title>
</head>
<body>
<form:form modelAttribute="servant" action="${ctx}/w/servant/save" id="pageForm" method="post" autocomplete="off">
    <form:hidden path="id"/>
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
                    <h5 class="lighter">
                        <c:choose>
                            <c:when test="${servant.id == null}">
                                添加账户
                            </c:when>
                            <c:otherwise>
                                编辑账户
                            </c:otherwise>
                        </c:choose>
                    </h5>
                </div>

                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-search">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="username"> 用户名称 </label>
                                    <div class="col-sm-9">
                                        <span class="input-group-btn">
                                            <form:input id="username" path="username" type="text" value="${servant.username}" class="col-xs-10 col-sm-5"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="confirmPassword"> 用户名称 </label>
                                    <div class="col-sm-9">
                                        <span class="input-group-btn">
                                            <input id="confirmPassword" name="confirmPassword" type="password" validata-options="validType:'Require|Repeat',to:'password',msg:'不能为空|两次输入的密码不一致'" class="col-xs-10 col-sm-5"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="username"> 用户名称 </label>
                                    <div class="col-sm-9">
                                        <span class="input-group-btn">
                                            <input id="password" name="password" type="password" validata-options="validType:'Require|SafeString',msg:'不能为空|密码不符合安全规则(6-20位数字、字母或常用符号的组合密码)'" class="col-xs-10 col-sm-5"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row" style="margin-top: 20px">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="status">状态 </label>
                                    <div class="col-sm-9">
                                        <span class="input-group-btn">
                                            <select id="status" name="status" value="${parkingSpace.status}" class="col-xs-10 col-sm-5">
                                                <c:forEach items="${list}" var="myList">
                                                    <option value="${myList.get("status")}" <c:if test="${parkingSpace.status == myList.get('status')}">selected</c:if>>
                                                    ${myList.get("status")}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </span>
                                    </div>
                                </div>
                                <div class="space-4"></div>
                            </div>

                            <div class="row" style="margin-top: 20px">
                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="save" type="button" class="btn btn-info" type="button">
                                            <i class="icon-ok bigger-110"></i>提交
                                        </button>

                                        &nbsp; &nbsp; &nbsp;
                                        <button id="reset" type="button" class="btn" type="reset">
                                            <i class="icon-undo bigger-110"></i>重置
                                        </button>

                                        &nbsp; &nbsp; &nbsp;
                                        <button id="golist" type="button" class="btn btn-danger" onclick="location.href='${ctx}/w/parkingSpace/list'">
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

    jQuery(function ($) {
        $("#save").click(function () {
            $("#pageForm").submit();
        });

        $("#pageForm").checkForm();

        $("#reset").click(function () {
            $("select").val("可用");
        });
    })
</script>
</body>