<%--
  Created by IntelliJ IDEA.
  User: Cj444
  Date: 18.10.2016
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="ManagerBar.jsp"/>




<div style="margin: 0px">
    <jsp:include page="ManDrivBar.jsp"/>

<h2 style="margin-top: 0px">Список всех доступных водителей </h2>
<table  class="table table-striped" style="width: 50%">
    <thead>
    <tr>
        <td>Number</td>
        <td>Name</td>
        <td>Last name</td>
        <td>Truck number</td>
        <td>Current city</td>
        <td>Status</td>
        <td>Work time</td>

    </tr>
    </thead>

        <c:forEach var="driver" items="${driver}">
    <tr>
        <td>${driver.id}</td>
        <td>${driver.name}</td>
        <td>${driver.lastname}</td>
    <td>${driver.truck}</td>
    <td>${driver.city}</td>
    <td>${driver.status}</td>
    <td>${driver.time}</td>
    </tr>

    </c:forEach>

    </tr>

</table>

</div>

</body>
</html>
