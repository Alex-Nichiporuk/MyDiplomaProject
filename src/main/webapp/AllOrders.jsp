
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

            <h2 class="login-header">Drivers</h2>
            <table  class="table table-striped" style="width: 100%" >
                <thead>
                <tr>
                    <td>Number</td>
                    <td>Status</td>
                    <td>Begin time</td>
                    <td>End time</td>



                </tr>
                </thead>

                <c:forEach var="order" items="${order}">
                    <tr>
                        <td>${order.id}</td>
                        <td>
                            <c:if test="${order.status==false}">
                                broken
                            </c:if>
                            <c:if test="${order.status==true}">
                                ok
                            </c:if>

                        </td>
                        <td>${order.begin}</td>
                        <td>${order.end}</td>


                    </tr>
                    <div  id='PopUp'  style='display: none; position: absolute; left: 50px; top: 50px; border: solid black 1px; padding: 10px; background-color: white; text-align: justify; font-size: 14px; width: 20%;' onclick="document.getElementById('PopUp').style.display = 'none'">Это текст во всплывающем окне

                    </div>
                </c:forEach>



            </table>

        </div>
    </div>
</div>




</body>
</html>
