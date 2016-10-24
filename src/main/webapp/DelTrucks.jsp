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
    var truck;
    var driv ;
    function f() {

        truck  = $('#truckNum');



        $.ajax(
                {
                    method: "POST",
                    url: "http://localhost:8080/TruckDelServlet",
                    data: {
                        truckNum: truck.val(),
                        ajax: true

                    },
                    success: function (msg) {
                        $('#tableFor').empty();
                        $('#tableFor').append(msg);
                    }

                }
        )


    }


    function choiceOf(id) {
        driv = $('#truckNum');
        driv.val($(id).find('td:eq(0)').text());
        f();
    }

</script>


<jsp:include page="test.jsp"/>
<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Delete truck</h2>

            <form  action="/TruckDelServlet" method="post">
                <div class="form-group">
                    <label for="truckNum" class="cols-sm-2 control-label" style="margin: auto">Truck id</label>


                    <input type="text" class="form-control" id="truckNum" name="truckNum"  placeholder="driver" onkeyup="f()" style="width: 20% ; margin: auto"/>

                    <div id="tableFor">
     <span>
<c:if test="${not empty truck}">
    <c:out value="${truck}"></c:out>
</c:if>
         </span>
                    </div>

                    <input type="submit"   class="btn btn-primary btn-lg btn-block login-button"  value="ok" style=" margin: auto; font-size: 20px; width: 20% "> </input>

                </div>




            </form>

        </div>
    </div>
</div>
</body>
</html>
