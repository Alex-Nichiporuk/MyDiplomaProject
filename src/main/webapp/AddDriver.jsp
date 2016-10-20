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
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script src="Bootstrap/js/DropDown.js"></script>
</head>
<body>
<jsp:include page="ManagerBar.jsp"/>
<div style="margin: 0px">
    <jsp:include page="ManDrivBar.jsp"/>
        <div class="container">
            <div class="row main">

<form method="post" action="AddDriverServlet">
                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Driver name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
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
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="city" id="password"  placeholder="City"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">Driver login</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="login" id="confirm"  placeholder="Login"/>
                                </div>
                            </div>
                        </div>
                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="password"    placeholder="Password"/>
                        </div>
                    </div>
                </div>


                        <div class="form-group "  >
                            <input type="submit"   class="btn btn-primary btn-lg btn-block login-button" value="submit"> </input>
                        </div>
</form>

                <c:if test="${not empty driver}">
                    <c:out value="${driver}"> </c:out>
                </c:if>
                </div>
            </div>
        </div>
</body>
</html>
