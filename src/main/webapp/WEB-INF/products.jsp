<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${language}"/>
<fmt:setBundle var="bundle" basename="content"/>

<!DOCTYPE html>
<html>
<head>
    <title>Gadget store</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

</head>

<body>

<jsp:include page="header.jsp"></jsp:include>
<script src="js/slider.js"></script>

<!-- //navigation -->
<!-- breadcrumbs -->
<div class="breadcrumbs">
    <div class="container">
        <ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
            <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
            <li class="active">Products</li>
        </ol>
    </div>
</div>
<!-- //breadcrumbs -->
<!--- products --->

<form id="catalogform" action="<c:url value='${contextPath}/catalog' />" method="get"></form>

<div class="products">
    <div class="container">
        <div class="col-md-4 products-left">
            <div class="categories">
                <h2>Categories</h2>


                <input type="submit" value="Select" class="subm" form="catalogform" id="subm"/>



                <ul class="cate">
                <li><i class="fa fa-arrow-right" aria-hidden="true"></i>Price</li>
                <div id="amountVal">
                    <input type="text" name="firstPrice" id="amount_1" class="priceAmount" form="catalogform"/>
                    -<input type="text" name="secondPrice" id="amount_2" class="priceAmount" form="catalogform"/></div>
                <div id="slider-range" class="priceSlider"></div>


                    <li><i class="fa fa-arrow-right" aria-hidden="true"></i>Producers</li>
                    <ul>

                        <c:forEach var="producer" items="${producerList}">

                            <c:forEach var='value' items='${paramValues.checkboxProducer}'>
                                <c:if test="${value eq producer.name}">
                                    <c:set var="checkedProducer" value="checked"/>
                                </c:if>
                            </c:forEach>

                            <li>
                                <a>
                                    <label class="labelCriteriaValues">
                                        <input type="checkbox" id="producerCheckBox" name="checkboxProducer" value="${producer.name}"
                                         form="catalogform" ${checkedProducer}/>${producer.name}
                                    </label>
                                </a>
                            </li>
                            <c:set var="checkedProducer" value=""/>
                        </c:forEach>

                    </ul>
                </ul>
            </div>
        </div>
        <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids">

                    <tg:page />



                    <div class="sorting">

                        <c:set var="selectedProducer" value="${param.selectSort eq 'laptops.producer' ? 'selected' : ''}" />
                        <c:set var="selectedCost" value="${param.selectSort eq 'laptops.cost' ? 'selected' : ''}" />

                        <select form="catalogform" name="selectSort" id="sortBySelect">

                            <option value="producer" ${selectedProducer}>
                                Sort by producer
                            </option>
                            <option value="cost" ${selectedCost}>
                                Sort by price
                            </option>
                        </select>

                        <c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.getQueryString()}"/>

                        <c:choose>
                            <c:when test="${fn:contains(url, '&orderMode')}">
                                <c:set var="rewriteUrl" value="${fn:substringBefore(url, '&orderMode')}"/>

                                    <a href="${rewriteUrl}&orderMode=DESC"><img src="images/arrow2.gif" alt="" class="v-middle"></a>

                            </c:when>

                            <c:otherwise>

                                  <a href="${url}&orderMode=DESC">
                                      <img src="images/arrow2.gif" alt="" class="v-middle"></a>

                            </c:otherwise>
                        </c:choose>


                    </div>
                    <div class="sorting-left">

                        <c:set var="selected6" value="${param.selectShow eq '6' ? 'selected' : ''}" />
                        <c:set var="selected9" value="${param.selectShow eq '9' ? 'selected' : ''}" />
                        <c:set var="selected12" value="${param.selectShow eq '12' ? 'selected' : ''}" />


                        <select form="catalogform" name="selectShow" id="itemOnPage">
                            <option value="6" selected="selected" ${selected6}>
                                Item on page 6
                            </option>
                            <option value="9" ${selected9}>
                                Item on page 9
                            </option>
                            <option value="12" ${selected12}>
                                Item on page 12
                            </option>
                        </select>



                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="agile_top_brands_grids">

                    <tg:catalog_laptop/>

                <div class="clearfix"></div>
            </div>

                <tg:page />

        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--- products --->

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>