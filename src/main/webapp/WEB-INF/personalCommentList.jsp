<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gadget store</title>
</head>
<body>
    <table id="orderList" cellpadding="10" border="1" width="100%" >

        <th>Product</th>
        <th>Comment</th>
        <th>Status</th>
        <th>Date</th>


        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td>
                    <img src="${comment.product.image}" width="120" height="60"/>
                </td>

                <td>
                    ${comment.text}
                </td>

                <td>
                    ${comment.status}
                </td>

                <td>
                    ${comment.date}
                </td>

            </tr>
        </c:forEach>

    </table>
</body>
</html>