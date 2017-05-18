<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle var="bundle" basename="content"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gadget store</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/css/404.css" rel="stylesheet" type="text/css"/>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/component.css" rel='stylesheet' type='text/css'/>
    <link href="/css/flexslider.css" rel="stylesheet"  type="text/css" media="screen"/>
    <link href="/css/font-awesome.css" rel="stylesheet">
    <link href="/css/modalDialog.css" rel="stylesheet"  type="text/css" media="screen"/>
    <link href="/css/skdslider.css" rel="stylesheet"  type="text/css" media="screen"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
    <link href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" rel="stylesheet" />

    <script src="/js/bootstrap.js"></script>
    <script src="/js/cartOperation.js"></script>
    <script src="/js/changeLanguage.js"></script>
    <script src="/js/skdslider.min.js" type="text/javascript"></script>
    <script src="/js/validationJQuery.js"></script>
</head>
<body>

<tg:cart title="MY SHOPPING BAG" blockUser="" button="CREATE ORDER"/>

<!-- header -->
<div class="agileits_header">
    <div class="container">

        <div class="w3l_offers">
            <p><a href="<c:url value='catalog' />"><fmt:message  key="shop_now" bundle="${bundle}"/></a>
            <tg:chooseLanguage/></p>
        </div>

        <div class="agile-login">
            <tg:logIn/>
        </div>



        <div class="product_list_header">
            <form action="#" method="post" class="last">
                <input type="hidden" name="cmd" value="_cart">
                <input type="hidden" name="display" value="1">


                <span id="total_head">$${sessionScope.cartServiceImpl.getAmount()}</span>
                <span id="size_head">(${sessionScope.cartServiceImpl.getNumberOfProductsInCart()})</span>


                <c:if test="${(sessionScope.cartServiceImpl.getNumberOfProductsInCart() > 0)}">
                    <a href="" onclick="clearCart();">Empty cart</a>
                </c:if>

                <a href="#cart" id="cartButton">
                    <i class="fa fa-cart-arrow-down"></i>
                </a>

            </form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<div class="logo_products">
    <div class="container">

        <div class="w3ls_logo_products_left1">
            <ul class="phone_email">
                <li><i class="fa fa-phone" aria-hidden="true"></i><fmt:message  key="call_us" bundle="${bundle}"/> : (+0123) 234 567</li>
            </ul>
        </div>

        <div class="w3ls_logo_products_left">
            <h1><a href="index.html">Gadget Store</a></h1>
        </div>

        <div class="w3l_search">
            <form action="#" method="post">
                <input type="search" name="Search" placeholder="<fmt:message  key="search_product" bundle="${bundle}"/>..." required="">
                <button type="submit" class="btn btn-default search" aria-label="Left Align">
                    <i class="fa fa-search" aria-hidden="true"> </i>
                </button>
                <div class="clearfix"></div>
            </form>
        </div>

        <div class="clearfix"></div>
    </div>
</div>
<!-- //header -->

<!-- navigation -->
<div class="navigation-agileits">
    <div class="container">
        <nav class="navbar navbar-default">

            <div class="navbar-header nav_2">
                <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse"
                        data-target="#bs-megadropdown-tabs">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                <ul class="nav navbar-nav" id="menu">
                    <li class="active"><a href="/index" class="act"><fmt:message  key="home" bundle="${bundle}"/></a></li>
                    <!-- Mega Menu -->
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message  key="laptops" bundle="${bundle}"/><b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <div class="multi-gd-img">
                                    <ul class="multi-column-dropdown">
                                        <h6>All Groceries</h6>
                                        <li><a href="<c:url value='catalog' />"><fmt:message  key="laptops" bundle="${bundle}"/></a></li>
                                    </ul>
                                </div>

                            </div>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message  key="phones" bundle="${bundle}"/><b
                                class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <div class="multi-gd-img">
                                    <ul class="multi-column-dropdown">
                                        <h6>Baby Care</h6>
                                        <li><a href="personalcare.html"><fmt:message  key="phones" bundle="${bundle}"/></a></li>
                                    </ul>
                                </div>

                            </div>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message  key="tablets" bundle="${bundle}"/><b
                                class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <div class="multi-gd-img">
                                    <ul class="multi-column-dropdown">
                                        <h6>All Accessories</h6>
                                        <li><a href="packagedfoods.html"><fmt:message  key="tablets" bundle="${bundle}"/></a></li>
                                    </ul>
                                </div>


                            </div>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message  key="p_area" bundle="${bundle}"/><b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <div class="multi-gd-img">
                                    <ul class="multi-column-dropdown">
                                        <h6>All Household</h6>
                                        <li><a href="<c:url value='/personal' />">Перейти в кабинет</a></li>
                                    </ul>
                                </div>


                            </div>
                        </ul>
                    </li>

                    <li><a href="offers.html"><fmt:message  key="offers" bundle="${bundle}"/></a></li>
                    <li><a href="contactttttt.html"><fmt:message  key="about_us" bundle="${bundle}"/></a></li>
                    <li><a href="contactttttt.html"><fmt:message  key="contact_us" bundle="${bundle}"/></a></li>

                </ul>
            </div>
        </nav>
    </div>
</div>


</body>
</html>