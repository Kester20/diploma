<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gadget store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- //navigation -->
<!-- breadcrumbs -->
<div class="breadcrumbs">
    <div class="container">
        <ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
            <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
            <li class="active">Register Page</li>
        </ol>
    </div>
</div>
<!-- //breadcrumbs -->
<!-- register -->
<div class="register">
    <div class="container">
        <h2>Register Here</h2>
        <div class="login-form-grids">
            <h5>profile information</h5>

            <form:form name="registerForm" id="registerForm" method="POST" action="" modelAttribute="userForm"
                       onsubmit="return validateRegisterForm ();">

                <spring:bind path="email">
                    <form:input type="email" path="email" placeholder="Email"
                                autofocus="true" onchange="validateEmail(this);"/>
                    <form:errors path="email"></form:errors>
                    <label class="showInfo"></label>
                    <br>
                </spring:bind>


                <spring:bind path="username">
                    <form:input type="text" path="username" placeholder="Username"
                                onchange="isNotEmptyInput(this);"/>
                    <form:errors path="username"></form:errors>
                    <label class="showInfo"></label>
                </spring:bind>


                <spring:bind path="password">
                    <form:input type="password" path="password"
                                placeholder="Password" onchange="checkLengthPassword(this);"/>
                    <form:errors path="password"></form:errors>
                    <label class="showInfo"></label>
                </spring:bind>


                <spring:bind path="passwordConfirm">
                    <form:input type="password" path="passwordConfirm"
                                placeholder="Confirm your password"
                                onchange="checkStringEquals(document.registerForm.password,this);"/>
                    <form:errors path="passwordConfirm"></form:errors>
                    <label class="showInfo"></label>
                </spring:bind>

                <input type="submit" value="Register">
            </form:form>
        </div>
        <div class="register-home">
            <a href="index.html">Home</a>
        </div>
    </div>
</div>
<!-- //register -->

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>