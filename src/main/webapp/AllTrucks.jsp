<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
    <link href="Bootstrap/css/login.css" rel="stylesheet">
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
</head>
<body   style="background-color: #456 ">
<jsp:include page="test.jsp"/>

<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white">

            <h2 class="login-header">Trucks</h2>
            <table  class="table table-striped" style="width: 100%" >
                <thead>
                <tr>
                    <td>Number</td>
                    <td>Size</td>
                    <td>Status</td>
                    <td>Driver desc size</td>
                    <td>Current city</td>
                    <td>Busy status</td>


                </tr>
                </thead>

                <c:forEach var="truck" items="${truck}">
                    <tr>
                        <td>${truck.id}</td>
                        <td>${truck.size}</td>
                        <td>
                            <c:if test="${truck.status==false}">
                                broken
                            </c:if>
                            <c:if test="${truck.status==true}">
                                ok
                            </c:if>

                        </td>
                        <td>${truck.driverdesc}</td>
                        <td>${truck.city}</td>
                        <td>
                            <c:if test="${truck.busyStatus==false}">
                                free
                            </c:if>
                            <c:if test="${truck.busyStatus==true}">
                                busy
                            </c:if>

                  </td>

                    </tr>

                </c:forEach>



            </table>

        </div>
    </div>
</div>




</body>
</html>
