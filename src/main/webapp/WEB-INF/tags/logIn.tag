<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${locale}" />
<fmt:setBundle var="bundle" basename="content" />

<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name == null}">

       <ul>
            <li><a href="<c:url value='${contextPath}/login' />"><span class="glyphicon glyphicon-user"> </span><fmt:message  key="login" bundle="${bundle}"></fmt:message></a></li>
            <li><a href="<c:url value='${contextPath}/registered' />"><span class="glyphicon glyphicon-lock"> </span><fmt:message  key="create_an_account" bundle="${bundle}"></fmt:message></a></li>
            <li><a href="contact.html"><fmt:message  key="help" bundle="${bundle}"/></a></li>
       </ul>

    </c:when>



    <c:otherwise>

        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

       <ul>
            <li><img class="avatar" src="${userAvatar}" /></li>
            <li><a>${pageContext.request.userPrincipal.name}</a></li>
            <li><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-user"> </span>Logout</a></li>
            <li><a href="contact.html">Help</a></li>
       </ul>

    </c:otherwise>
</c:choose>
