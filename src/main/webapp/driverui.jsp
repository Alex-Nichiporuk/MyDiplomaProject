<%--
  Created by IntelliJ IDEA.
  User: Cj444
  Date: 16.10.2016
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<jsp:include page="DriverBar.jsp"/>

<div class="container">
    <h2>Hello <c:out value="${driver.name}"> </c:out>! Your current order: </h2>
<table  class="table table-striped">
    <thead>
    <tr>
        <td>Order number</td>
        <td>Truck number</td>
        <td>Path length</td>

    </tr>
    </thead>

        <tr>
            <td><c:out value="${driver.orderId}"> </c:out></td>
            <td><c:out value="${driver.truckId}"> </c:out></td>
            <td><c:out value="${driver.pathLength}"> км</c:out></td>

        </tr>

</table>
    </div>

<div class="container">
    <h2>Drivers on this order: </h2>
    <table  class="table table-striped">
        <thead>
        <tr>
            <td>Driver number</td>
            <td>Driver</td>

        </tr>
        </thead>


            <c:forEach var="coworker" items="${driver.coDriver}">
        <tr>
            <td>${coworker.key}</td>
               <td>${coworker.value}</td>
        </tr>

        </c:forEach>

        </tr>

    </table>
</div>

<div class="container">
    <h2>Your path: </h2>
    <table  class="table table-striped">
        <thead>
        <tr>
            <td>City</td>
            <td>Cargo</td>
            <td>Weight</td>
            <td>Out/In</td>

        </tr>
        </thead>


        <c:forEach var="points" items="${driver.pointViews}">
            <tr>
                <td>${points.city}</td>
                <td>${points.cargo}</td>
                <td>${points.weight}</td>
                <td>
                    <c:if test="${points.status==true}"> out</c:if>
                    <c:if test="${points.status==false}"> in</c:if>
                </td>
            </tr>

        </c:forEach>

        </tr>

    </table>
</div>




</body>
</html>
