<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>

      <div class="container-fluid">
          <div class="container">
            <div class="row">
                <h1 class="text-grey">Login</h1>
            </div>
                <form method="POST" action="${pageContext.request.contextPath}/login">
<%--                <form action="POST" action="http://localhost:8080/login">--%>
              <div class="row">
                <input type="email" name="username" required placeholder="Email"><span></span>
              </div>
              <div class="row">
                <input type="password" name="password" required placeholder="Password"><span></span>
              </div>
              <div class="row">
                <button type="submit">Login</button>
              </div>

            </form>
            <div class="row text-grey">
              <a href="#">Forgot your password?</a>
            </div>
            <div class="row">
                <p>Dont have an account? <a href="#">Sign up here!</a></p>
            </div>
          </div>

          <div class="container">
              <c:if test="${requestScope.isError eq 'true'}">
                <p style="color: red">Login Error!</p>
              </c:if>
          </div>
      </div>

</body>
</html>
