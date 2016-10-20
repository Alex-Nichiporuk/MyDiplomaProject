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
    <h2>Здравствуйте <c:out value="${driver.name}"> </c:out>! Ваш текущий заказ: </h2>
<table  class="table table-striped">
    <thead>
    <tr>
        <td>Номер заказа</td>
        <td>Номер фуры</td>
        <td>Длина маршрута</td>

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
    <h2>Водители, назначенные на этот заказ: </h2>
    <table  class="table table-striped">
        <thead>
        <tr>
            <td>Номер водителя</td>
            <td>Водитель</td>

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
    <h2>Ваш маршрут: </h2>
    <table  class="table table-striped">
        <thead>
        <tr>
            <td>Город</td>
            <td>Груз</td>
            <td>Вес</td>
            <td>Разгрузка/Погрузка</td>

        </tr>
        </thead>


        <c:forEach var="points" items="${driver.pointViews}">
            <tr>
                <td>${points.city}</td>
                <td>${points.cargo}</td>
                <td>${points.weight}</td>
                <td>
                    <c:if test="${points.status==true}"> разгрузка</c:if>
                    <c:if test="${points.status==false}"> погрузка</c:if>
                </td>
            </tr>

        </c:forEach>

        </tr>

    </table>
</div>




</body>
</html>
