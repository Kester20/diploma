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
    <link href="/css/404.css" rel='stylesheet' type='text/css'/>
</head>
<body>
<div class="wrapper row2">
    <div id="container" class="clear">

        <section id="fof" class="clear">

            <div class="hgroup">
                <h1><span><strong><%=response.getStatus() %></strong></span></h1>
                <h2>${exception.message}</span></h2>
            </div>
            <p>Please contact support</p>
            <p><a href="javascript:history.go(-1)">&laquo; Go Back</a> / <a href="<c:url value='${contextPath}/index' />">Go Home &raquo;</a></p>

        </section>

    </div>
</div>


<!--
    Failed URL: ${url}
    Exception:  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste}
    </c:forEach>
  -->

</body>
</html>