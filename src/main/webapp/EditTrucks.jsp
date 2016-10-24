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
                    url: "http://localhost:8080/EditTruckServlet",
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
        var numb =  $(id).find('td:eq(0)').text();

        $.ajax(
                {
                    method: "POST",
                    url: "http://localhost:8080/EditTruckServlet",
                    data: {
                        truckNum: numb,
                        ajax: "edit",


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
<div class="container" style="margin:  10% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Edit truck</h2>

            <form  action="/EditTruckServlet" method="post">
                <div class="form-group" style=" min-height: 5%">
                    <label for="truckNum" class="cols-sm-2 control-label" style="margin: auto">Truck id</label>


                    <input type="text"  class="form-control" name="truckNum" id="truckNum"  placeholder="truck" onkeyup="f()" style="width: 20% ; margin: auto "/>

                    <div id="tableFor" style="margin-top: 1%">
     <span>
<c:if test="${not empty error}">
    <c:out value="${error}"> </c:out>
</c:if>
         </span>
                    </div>



                </div>




            </form>

        </div>
    </div>
</div>
</body>
</html>