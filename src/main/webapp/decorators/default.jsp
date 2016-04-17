<!DOCTYPE html>
<html>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<head>
    <%--防止firefox缓冲--%>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <%--防止http1.1缓冲--%>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <%--http1.0不缓存响应头--%>
    <meta http-equiv="Pragma" content="no-cache"/>
    <%--http1.0不缓存--%>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="后台管理系统" />
    <title><decorator:title/> | 后台管理系统</title>
    <link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/jquery-ui-1.10.3.full.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/datepicker.css" />
    <link rel="stylesheet" href="${ctx}/static/css/ui.jqgrid.css" />
    <link rel="stylesheet" href="${ctx}/static/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/pagebar.css" />

    <script src="${ctx}/static/js/jquery.min.js"></script>
    <script src="${ctx}/static/js/ace-extra.min.js"></script>
    <decorator:head/>
    <spring:htmlEscape defaultHtmlEscape="true" />

    <style type="text/css">
        .main-content {
            margin-left: 0px;
            margin-right: 0;
            margin-top: 0;
            min-height: 100%;
            padding: 0;
        }

    </style>
</head>
<body>
<!--header start-->
<%@ include file="/common/head.jsp" %>
<!--header end-->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <div class="main-container-inner">
    <%@ include file="/common/left.jsp" %>
       <div style="position: fixed; margin-left: 190px">
           <decorator:body/>
       </div>
    </div>
    <!--返回页面顶端-->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a>
</div>
</body>
</html>
