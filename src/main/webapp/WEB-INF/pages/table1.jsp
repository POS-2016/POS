<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
  <title>停车位管理</title>
</head>
<body>
<form:form modelAttribute="parkingSpaceManagePageSearcher" id="pageForm">
  <div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
      <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
      </script>
      <ul class="breadcrumb">
        <li> <i class="icon-home home-icon"></i> <a href="#">Home</a> </li>
        <li> <a href="#">Tables</a> </li>
        <li class="active">Simple &amp; Dynamic</li>
      </ul>
      <!-- .breadcrumb -->
    </div>

    <div class="page-content">

      <div class="page-header">
        <h1> Tables <small> <i class="icon-double-angle-right">
        </i> Static &amp; Dynamic Tables </small> </h1>
      </div><!-- /.page-header -->

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
                  <td><a href="${ctx}/parkingSpaceManage/parkingSpace/manage?servantRoleID=${parkingSpace.id}">编辑</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div><!-- /.table-responsive -->
          <!--分页 begin-->
          <div class="row">
            <div class="col-lg-6">
              <%@ include file="/common/page_bar.jsp" %>
            </div>
          </div><!--分页 end-->
        </div><!-- /span -->
      </div><!-- /row -->

    </div><!-- /.page-content -->
  </div>
</form:form>
<script type="text/javascript">
  jQuery(function($) {
    $("#query").click(function() {
      $("#pageNo").val(1);
      $("#pageForm").submit();
    })

  })
</script>
</body>