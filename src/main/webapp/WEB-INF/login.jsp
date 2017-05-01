<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Gadget store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- //navigation -->
<!-- breadcrumbs -->
<div class="breadcrumbs">
    <div class="container">
        <ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
            <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
            <li class="active">Login Page</li>
        </ol>
    </div>
</div>
<!-- //breadcrumbs -->
<!-- login -->
<div class="login">
    <div class="container">
        <h2>Login Form</h2>

        <div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
            <form name="logInForm" method="POST" action="${contextPath}/login">
                <input type="username" name="username" placeholder="Username" required=" ">
                <input type="password" name="password" placeholder="Password" required=" " id="passInLoginForm">
                <label class="errorInput"><span>${error}</span></label>
                <div class="forgot">
                    <a href="#">Forgot Password?</a>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Login">
            </form>
        </div>
        <h4>For New People</h4>
        <p><a href="registered.html">Register Here</a> (Or) go back to <a href="index.html">Home<span
                class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></p>
    </div>
</div>
<!-- //login -->

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>