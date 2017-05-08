<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Gadget store</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/defaultScripts.js" type="application/x-javascript"></script>
    <script src="js/easing.js" type="text/javascript"></script>
    <script src="js/move-top.js" type="text/javascript"></script>
    <script src="js/personalChangeContent.js" type="text/javascript"></script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="products">
    <div class="container">
        <div class="col-md-4 products-left">
            <div class="categories">
                <h2>Personal</h2>
                <ul class="cate">

                    <li>
                        <a href="" onClick="changeContent('a');return false;">
                            <i class="fa fa-arrow-right" aria-hidden="true"></i>Личные данные
                        </a>
                    </li>
                    <li><a href="" onClick="changeContent('b');return false;">
                            <i class="fa fa-arrow-right" aria-hidden="true"></i>Список желаний
                        </a>
                    </li>
                    <li>
                        <a href="" onClick="changeContent('c');return false;">
                            <i class="fa fa-arrow-right" aria-hidden="true"></i>Мои заказы
                        </a>
                    </li>
                    <li>
                        <a href="" onClick="changeContent('d');return false;">
                            <i class="fa fa-arrow-right" aria-hidden="true"></i>Мои отзывы
                        </a>
                    </li>

                </ul>
            </div>
        </div>


        <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids" id="contentChanging">

                    Слева три кнопки, они меняют содержание этого текста.

                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>

</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>