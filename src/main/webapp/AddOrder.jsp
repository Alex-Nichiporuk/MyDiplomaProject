<%--
  Created by IntelliJ IDEA.
  User: Cj444
  Date: 23.10.2016
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<head>
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
    <link href="Bootstrap/css/login.css" rel="stylesheet">
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>

</head>
<body style="background-color: #456">
<script>
function f(param) {

user  = $('#userName');
var cargoName =$('#cargoname');
var cargoStatus=$('#cargostatus');
    var cargoWeight=$('#cargoweight');
    var cityName = $('#cityName');
$.ajax(
{
method: "POST",
url: "http://localhost:8080/AddOrderServlet",
data: {
userName: user.val(),
ajax: param,
    cargoN: cargoName.val(),
    cargoS: cargoStatus.val(),
    cargoW: cargoWeight.val(),
    cityname: cityName.val()

},
success: function (msg) {
$('#tableFor').empty();
$('#tableFor').append(msg);
}

}
)


}
</script>
<jsp:include page="test.jsp"/>
<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Add order</h2>
            <div id="tableFor" style="margin-top: 1%">
            <form method="post" class="login-container"  action="AddDriverServlet">


                <input type="button"  onclick="f('point')"  class="btn btn-primary btn-lg btn-block login-button"  value="Create path" style=" margin: auto; font-size: 20px; width: 20% "> </input>



            </form>
</div>

        </div>
    </div>
</div>
</body>
</html>