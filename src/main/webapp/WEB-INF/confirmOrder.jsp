<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>


<!DOCTYPE html>
<html>

    <head>
        <title>Gadget store</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <script src="/js/jquery-1.11.1.min.js"></script>
        <script src="/js/defaultScripts.js" type="application/x-javascript"></script>
        <script src="/js/easing.js" type="text/javascript"></script>
        <script src="/js/move-top.js" type="text/javascript"></script>
    </head>

    <jsp:include page="header.jsp"></jsp:include>

    <div class="breadcrumbs">
        <div class="container">
            <ol class="breadcrumb breadcrumb1">
                <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
                <li >Create order</li>
                <li class="active">Confirm order</li>
            </ol>
        </div>
    </div>

    <div class="checkout">
        <div class="container">
            <h2>Your shopping cart contains: <span>${sessionScope.cartServiceImpl.getNumberOfProductsInCart()}
                Products for the amount of $${sessionScope.cartServiceImpl.getAmount()}</span></h2>


            <form id="orderForm" method="post" action="<c:url value='/order/add' />">

                <table id="order">

                    <tr>
                        <td>
                            <label class="orderParametersName">Type delivery:</label>
                        </td>

                        <td>
                            <select  name="typeDelivery" id="" class="orderSelect">
                                <option value="PICKUP">
                                    Pickup
                                </option>
                                <option value="ADDRESS" >
                                    Delivery to address
                                </option>
                                <option value="MAIL" >
                                    Delivery by mail
                                </option>
                            </select>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <label class="orderParametersName">Type payment:</label>
                        </td>

                        <td>
                            <select  name="typePayment" id="" class="orderSelect">
                                <option value="CASH">
                                    Cash
                                </option>
                                <option value="CREDIT">
                                    Credit
                                </option>
                                <option value="CARD" >
                                    Card
                                </option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="orderParametersName">Phone number:</label>
                        </td>

                        <td>
                            <input type="text" placeholder="+380936674555" style="width: 220px;"  />
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <label class="orderParametersName">Username:</label>
                        </td>

                        <td>
                            <input type="text" readonly name="userName" value="arsalan" style="width: 220px;">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="orderParametersName">Email:</label>
                        </td>

                        <td>
                            <input type="text" readonly name="userEmail" value="arsalan.noormal@gmail.com" style="width: 220px;">
                        </td>
                    </tr>

                </table>


                <input class="subm" style="margin-left:0px;width:200px;" type="submit" value="Confirm"/>


            </form>
        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>
</html>
