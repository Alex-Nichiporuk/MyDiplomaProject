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
    <link href="Bootstrap/css/login.css" rel="stylesheet">
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
</head>
<body style="background-color: #456">
<script>
    var user;
    var driv ;
    function f() {

        user  = $('#userName');



        $.ajax(
                {
                    method: "POST",
                    url: "http://localhost:8080/DelUserServlet",
                    data: {
                        userName: user.val(),
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
        driv = $('#userName');
         driv.val($(id).find('td:eq(0)').text());
f();
    }

</script>


<jsp:include page="test.jsp"/>
<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Delete driver</h2>

    <form  action="/DelUserServlet" method="post">
        <div class="form-group">
            <label for="userName" class="cols-sm-2 control-label" style="margin: auto">Driver last name, name or id</label>


                    <input type="text" class="form-control" name="userName" id="userName"  placeholder="driver" onkeyup="f()" style="width: 20% ; margin: auto"/>

 <div id="tableFor">
     <span>
<c:if test="${not empty driver}">
    <c:out value="${driver}"></c:out>
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
