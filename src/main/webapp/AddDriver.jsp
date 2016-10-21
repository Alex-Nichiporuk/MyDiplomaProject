<%--
  Created by IntelliJ IDEA.
  User: Cj444
  Date: 19.10.2016
  Time: 13:24
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
<jsp:include page="test.jsp"/>
<div class="container" style="margin:  5% auto;  ">
    <div class="row">
        <div class="login" style="width: 100% ; background-color: white ; box-shadow: 0 0 5px 2px;">

            <h2 class="login-header">Add driver</h2>

<form method="post" class="login-container"  action="AddDriverServlet">
                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Driver name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="email"  placeholder="Name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Driver last name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="lastname" id="username"  placeholder="Last name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">City</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-building-o fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="city" id="password"  placeholder="City"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Driver login</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-bell fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="login" id="confirm"  placeholder="Login"/>
                                </div>
                            </div>
                        </div>
                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password"    placeholder="Password"/>
                        </div>
                    </div>
                </div>

<span style="color: red">
     <c:if test="${not empty error}">
        <c:out value="${error}"> </c:out>
    </c:if>
</span>
    <span style="color: green">
<c:if test="${not empty driver}">
    <c:out value="${driver}"> </c:out>
</c:if>

</span>

    <input type="submit"   class="btn btn-primary btn-lg btn-block login-button"  value="OK" style=" margin: auto; font-size: 20px; width: 20% "> </input>



</form>


        </div>
    </div>
</div>
</body>
</html>
