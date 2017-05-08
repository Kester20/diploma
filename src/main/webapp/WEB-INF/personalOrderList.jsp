<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table id="orderList" cellpadding="10" border="1" width="100%" >

        <th>Id</th>
        <th>Products</th>
        <th>Type delivery</th>
        <th>Type payment</th>
        <th>Status</th>
        <th>Date</th>

        <c:forEach var="order" items="${orderList}">

            <tr>
                <td>
                    ${order.id}
                </td>

                <td>
                    <c:forEach var="product" items="${order.productList}">
                        <img src="${product.image}" width="120" height="60"/>
                    </c:forEach>
                </td>

                <td>
                    ${order.typeDelivery}
                </td>

                <td>
                    ${order.typePayment}
                </td>

                <td>
                    ${order.status}
                </td>

                <td>
                    ${order.date}
                </td>
            </tr>

        </c:forEach>

    </table>
</body>
</html>