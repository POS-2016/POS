<%--
  Created by IntelliJ IDEA.
  User: XinLian
  Date: 2016/3/10
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>sdahsdsa</h1>
  <form:form  id="pageForm">
<table class="table table-bordered table-striped">
  <thead>
  <tr>
    <th>账号</th>
    <th>密码</th>
    <th>状态</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach items="${list}" var="servant">
      <tr>
        <td>${servant.username}</td>
        <td>${servant.password}</td>
        <td>${servant.status}</td>
      </tr>
    </c:forEach>
    </tbody>
  </form:form>
</body>
</html>
