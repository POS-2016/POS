<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
  <title>账号管理</title>
</head>
<body>
<form:form modelAttribute="servantManagePageSearcher" id="pageForm">
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
                  <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                    <label class="control-label no-padding-right" for="username"> 账号查询 </label>
                  </div>
                  <div class="col-sm-9 no-padding-left">
                    <form:input id="username" path="username" class="form-control search-query"
                                placeholder="请输入用户" value="${servantManagePageSearcher.username}"/>
                  </div>
                </div>

                <div class="col-xs-12 col-sm-1"></div>

                <div class="col-xs-12 col-sm-3">
                  <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                    <label class="control-label no-padding-right" for="status">状态查询</label>
                  </div>
                  <div class="col-sm-9 no-padding-left">
                    <select id="status" name="status">
                      <option value="-1">全部</option>
                      <c:forEach items="${list}" var="statusList">
                        <option value="${statusList.get("key")}" <c:if test="${statusList.get('key') == servantManagePageSearcher.status}"> selected </c:if> >
                          <c:choose>
                            <c:when test="${statusList.get('key') == 0}">禁用</c:when>
                            <c:otherwise>启用</c:otherwise>
                          </c:choose>
                        </option>
                      </c:forEach>
                    </select>
                  </div>
                </div>

                <div class="col-xs-12 col-sm-1"></div>

                <div class="col-xs-12 col-sm-3">
                  <div class="col-sm-3 no-padding-right" style="height: 34px; padding-top: 5px;">
                    <label class="control-label no-padding-right" for="status">权限查询</label>
                  </div>
                  <div class="col-sm-9 no-padding-left">
                    <select id="authority" name="authority">
                      <option value="-1">全部</option>
                      <c:forEach items="${list}" var="authorityList">
                        <option value="${authorityList.get("key")}" <c:if test="${authorityList.get('key') == servantManagePageSearcher.authority}"> selected </c:if> >
                          <c:choose>
                            <c:when test="${authorityList.get('key') == 0}">Level 1</c:when>
                            <c:otherwise>Level 2</c:otherwise>
                        </c:choose>
                        </option>
                      </c:forEach>
                    </select>
                  </div>
                </div>

              </div>

              <div class="row" style="margin-top: 30px">
                <div class="col-xs-12 col-sm-8">
                  <div class="input-group">
                    <span class="input-group-btn">
                      <button id="query" type="button" class="btn btn-purple btn-sm" style="margin-left: 10px">查询
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
                <th>账号</th>
                <th>状态</th>
                <th>权限</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${pageObj.result}" var="servant">
                <tr>
                  <td>${servant.username}</td>
                  <td>
                    <c:choose>
                      <c:when test="${servant.status == 1}">启用</c:when>
                      <c:otherwise>禁用</c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${servant.authority == 0}">Level 1</c:when>
                      <c:otherwise>Level 2</c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <a href="${ctx}/w/servant/manage?id=${servant.id}">编辑</a>
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
<script type="text/javascript">

  jQuery(function ($) {
    $("#query").click(function () {
      $("#pageNo").val(1);
      $("#pageForm").submit();
    });

  })
</script>
</body>