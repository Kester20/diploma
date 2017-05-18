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
    <table  width="100%" id="order">
        <tr>

            <td>
                <label class="orderParametersName">Phone number:</label>
            </td>

            <td>
                <label style="color:#fe9126;">+380936674555</label>
            </td>

        </tr>

        <tr>
            <td>
                <label class="orderParametersName">Username:</label>
            </td>

            <td>
                <label style="color:#fe9126;">${userName}</label>
            </td>
        </tr>

        <tr>
            <td>
                <label class="orderParametersName">Email:</label>
            </td>

            <td>
                <label style="color:#fe9126;">${userEmail}</label>
            </td>
        </tr>
    </table>
</body>
</html>