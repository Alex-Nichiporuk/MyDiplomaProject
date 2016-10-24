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
<jsp:include page="test.jsp"/>
<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Add truck</h2>

            <form method="post" class="login-container"  action="AddTruckServlet">
                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Truck number</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-road fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="Number" id="email"  placeholder="Number"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">Truck size</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-star fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="Size" id="username"  placeholder="Size"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">City</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-building-o fa-lg" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="City" id="password"  placeholder="City"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Driver desc</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa-lg" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="Desc" id="confirm"  placeholder="desc"/>
                        </div>
                    </div>
                </div>

                <span style="color: red">
     <c:if test="${not empty error}">
         <c:out value="${error}"> </c:out>
     </c:if>
</span>
                <span style="color: green">
<c:if test="${not empty truck}">
    <c:out value="${truck}"> </c:out>
</c:if>

</span>

                <input type="submit"   class="btn btn-primary btn-lg btn-block login-button"  value="OK" style=" margin: auto; font-size: 20px; width: 20% "> </input>



            </form>


        </div>
    </div>
</div>
</body>
</html>
