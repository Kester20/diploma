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
    <script src="/js/jquery-1.11.1.min.js"></script>
    <script src="/js/defaultScripts.js" type="application/x-javascript"></script>
    <script src="/js/easing.js" type="text/javascript"></script>
    <script src="/js/move-top.js" type="text/javascript"></script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- //navigation -->
<!-- breadcrumbs -->
<div class="breadcrumbs">
          <div class="container">
              <ol class="breadcrumb breadcrumb1">
                  <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
                  <li class="active">Create order</li>
              </ol>
          </div>
      </div>
<!-- //breadcrumbs -->
<!-- checkout -->
<div class="checkout">
    <div class="container">
        <h2>Your shopping cart contains: <span>${sessionScope.cartServiceImpl.getNumberOfProductsInCart()} Products</span></h2>
        <div class="checkout-right">
            <table class="timetable_sub">
                <thead>
                <tr>
                    <th>SL No.</th>
                    <th>Product</th>
                    <th>Quality</th>
                    <th>Product Name</th>

                    <th>Price</th>
                    <th>Remove</th>
                </tr>
                </thead>

                <c:set var="index" value="1" />

                <c:forEach var="cartMap" items="${sessionScope.cartServiceImpl.cart.products}">



                    <tr class="rem1">

                        <td class="invert">${index}</td>

                        <c:set var="index" value="${index + 1}" />

                        <td ><a href="single.html">
                            <img src="${cartMap.key.image}" class="cart_image" alt=""/></a>
                        </td>

                        <td class="invert">
                            <div class="quantity">
                                <input type="number" value="${cartMap.value}" name="number" min="1" max="10" onchange="updateTotal('${cartMap.key.id}',this.value)"/>
                            </div>
                        </td>

                        <td class="invert">${cartMap.key.producer.name}</td>

                        <td class="invert">$${cartMap.key.cost}</td>

                        <td class="invert">
                            <div class="rem">
                                <div class="close1" onclick="deleteProductFromCart(${cartMap.key.id})">
                            </div>

                        </td>
                    </tr>

                </c:forEach>

                <!--quantity-->
                <script>
									$('.value-plus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
										divUpd.text(newVal);
									});

									$('.value-minus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
										if(newVal>=1) divUpd.text(newVal);
									});

                </script>
                <!--quantity-->
            </table>
        </div>
        <div class="checkout-left">
            <div class="checkout-left-basket">
                <a href="<c:url value='/order/confirm' />"><h4>Next</h4></a>
                <ul>
                    <c:forEach var="cartMap" items="${sessionScope.cartServiceImpl.cart.products}">
                        <li>${cartMap.key.producer.name} <i>-</i> <span>$${cartMap.key.cost * cartMap.value} </span></li>
                    </c:forEach>
                    <li>Total <i>-</i> <span>$${sessionScope.cartServiceImpl.getAmount()}</span></li>
                </ul>
            </div>
            <div class="checkout-right-basket">
                <a href="<c:url value='catalog' />"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Continue
                    Shopping</a>
            </div>
            <div class="clearfix"></div>
        </div>


    </div>
</div>
<!-- //checkout -->

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>