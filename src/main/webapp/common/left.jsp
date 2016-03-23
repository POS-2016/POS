<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!--left start-->
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
        <li> <a href="/manage/parkingSpace/manage"> <i class="icon-double-angle-right"></i> 添加停车位 </a> </li>
        <li> <a href="/manage/parkingSpace/list"> <i class="icon-double-angle-right"></i> 停车位查询 </a> </li>
      </ul>
    </li>

    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 交易管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="/manage/parkingSpace/manage"> <i class="icon-double-angle-right"></i> 交易查询 </a> </li>
      </ul>
    </li>

    <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 用户管理 </span> <b class="arrow icon-angle-down"></b> </a>
      <ul class="submenu">
        <li> <a href="/manage/parkingSpace/manage"> <i class="icon-double-angle-right"></i> 编辑用户 </a> </li>
        <li> <a href="/manage/parkingSpace/list"> <i class="icon-double-angle-right"></i> 用户查询</a> </li>
      </ul>
    </li>

  </ul>
</div>

<script src="${ctx}/static/js/ace.min.js"></script>
<!--left end-->