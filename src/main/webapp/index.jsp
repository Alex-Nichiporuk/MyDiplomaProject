<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="Bootstrap/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="login">
            <div class="login-triangle"></div>

            <h2 class="login-header">LogiWEB</h2>

            <form class="login-container" action="LoginServlet" method="post">
                <p><input name="login" type="text" placeholder="Login"></p>
                <p><input name ="password" type="password" placeholder="Password"></p>
                <p><input type="submit" value="Log in" ></p>
            </form>
<c:if test="${not empty error}">
<c:out value="${error}"> </c:out>
</c:if>
        </div>
    </div>
</div>
</body>
</html>