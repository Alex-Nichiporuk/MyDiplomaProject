<%--
  Created by IntelliJ IDEA.
  User: Cj444
  Date: 19.10.2016
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script src="Bootstrap/js/DropDown.js"></script>
</head>
<body>
<script>
    var user;
    var span;
    function f() {
        span =$('#span');
        user  = $('#userName');



        $.ajax(
                {
                    method: "POST",
                    url: "http://localhost:8080/DelUserServlet",
                    data: {
                        username: user.val()

                    },
                    success: function (msg) {

                        span.text("Do you real want to delete "+msg+"?");
                    }

                }
        )


    }





</script>


<jsp:include page="ManagerBar.jsp"/>
<div style="margin: 0px">
    <jsp:include page="ManDrivBar.jsp"/>
    <form >
        <div class="form-group">
            <label for="userName" class="cols-sm-2 control-label">Driver number</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="userName" id="userName"  placeholder="number" onkeyup="f()" style="width: 10%;"/>

                </div>

            </div>

            <span id="span"> </span>

            <input type="submit"   class="btn btn-primary btn-lg btn-block login-button"  value="ok" style="width: 5% ; height: 25px; font-size: 16px "> </input>

        </div>




    </form>
    </div>

</body>
</html>
