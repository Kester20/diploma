<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>


<!DOCTYPE html>
<html>

<head>

        <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Register :: w3layouts</title>

        <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/simpleCart.min.js"></script>
        <script type="text/javascript" src="js/validation.js"></script>
        <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- registration-form -->
<div class="registration-form">
    <div class="container">
        <div class="dreamcrub">
            <ul class="breadcrumbs">
                <li class="home">
                    <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                    <span>&gt;</span>
                </li>
                <li class="women">
                    Registration
                </li>
            </ul>
            <ul class="previous">
                <li><a href="index.html">Back to Previous Page</a></li>
            </ul>
            <div class="clearfix"></div>
        </div>
        <h2>Registration</h2>
        <div class="registration-grids">
            <div class="reg-form">
                <div class="reg">
                    <p>Welcome, please enter the following details to continue.</p>
                    <p>If you have previously registered with us, <a href="#">click here</a></p>




                    <form:form name="registerForm" id="registerForm" method="POST" action="" modelAttribute="userForm"
                          onsubmit="return validateRegisterForm ();">

                        <ul>
                            <spring:bind path="email">
                                <li class="text-info">Email:</li>
                                <li>
                                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                                            autofocus="true" onchange="validateEmail(this);"/>
                                    <form:errors path="email"></form:errors>
                                </li>
                                <li class="showInfo"></li>
                            </spring:bind>
                        </ul>

                        <ul>
                            <spring:bind path="username">
                                <li class="text-info">User name:</li>
                                <li>
                                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                            onchange="isNotEmptyInput(this);"/>
                                    <form:errors path="username"></form:errors>
                                </li>
                                <li class="showInfo"></li>
                            </spring:bind>
                        </ul>

                        <ul>
                            <spring:bind path="password">
                                <li class="text-info">Password:</li>
                                <li>
                                    <form:input type="password" path="password" class="form-control"
                                            placeholder="Password" onchange="checkLengthPassword(this);" />
                                    <form:errors path="password"></form:errors>
                                </li>
                                <li class="showInfo"></li>
                            </spring:bind>
                        </ul>

                        <ul>
                            <spring:bind path="passwordConfirm">
                                <li class="text-info">Confirm password:</li>
                                <li>
                                    <form:input type="password" path="passwordConfirm" class="form-control"
                                            placeholder="Confirm your password"
                                            onchange="checkStringEquals(document.registerForm.password,this);"/>
                                    <form:errors path="passwordConfirm"></form:errors>
                                </li>
                                <li class="showInfo"></li>
                            </spring:bind>
                        </ul>

                        <input type="submit" value="REGISTER NOW">

                        <p class="click">By clicking this button, you are agree to my <a href="#">Policy Terms and
                            Conditions.</a></p>
                    </form:form>


                </div>
            </div>

            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- registration-form -->


<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
