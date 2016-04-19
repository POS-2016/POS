<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!--left start-->
<div style="width: 190px;">
<a class="menu-toggler" id="menu-toggler" href="#">
  <span class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
  <script type="text/javascript">
    try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
  </script>

  <div class="sidebar-shortcuts" id="sidebar-shortcuts">
    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
      <button class="btn btn-success">
        <i class="icon-signal"></i>
      </button>

      <button class="btn btn-info">
        <i class="icon-pencil"></i>
      </button>

      <button class="btn btn-warning">
        <i class="icon-group"></i>
      </button>

      <button class="btn btn-danger">
        <i class="icon-cogs"></i>
      </button>

    </div>

    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
      <span class="btn btn-success"></span>
      <span class="btn btn-info"></span>
      <span class="btn btn-warning"></span>
      <span class="btn btn-danger"></span>
    </div>
  </div>
  <!-- #sidebar-shortcuts -->
  <ul class="nav nav-list">
    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 停车位管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="/w/parkingSpace/list"> <i class="icon-double-angle-right"></i> 停车位查询 </a> </li>
        <li> <a href="/w/parkingSpace/manage"> <i class="icon-double-angle-right"></i> 停车位新增 </a> </li>
      </ul>
    </li>

    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 订单管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="/w/reserve/list"> <i class="icon-double-angle-right"></i> 订单查询 </a> </li>
        <li> <a href="/w/reserve/chart"> <i class="icon-double-angle-right"></i> 订单统计 </a> </li>
      </ul>
    </li>

    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 用户管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="/w/personInfo/list"> <i class="icon-double-angle-right"></i> 用户查询 </a> </li>
      </ul>
    </li>

    <c:choose>
      <c:when test="${user.username != 'admin'}">
    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 账号管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="${ctx}/w/servant/list"> <i class="icon-double-angle-right"></i> 账号查询</a> </li>
        <li> <a href="${ctx}/w/servant/manage"> <i class="icon-double-angle-right"></i> 账号新增 </a> </li>
      </ul>
    </li>
      </c:when>
    </c:choose>
  </ul>

  <div class="sidebar-collapse" id="sidebar-collapse">
    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
  </div>

  <script type="text/javascript">
    try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
  </script>
</div>

<script src="${ctx}/static/js/ace.min.js"></script>
  </div>
<!--left end-->