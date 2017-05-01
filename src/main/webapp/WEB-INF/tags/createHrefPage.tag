<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="url" required="true"  %>
<%@ attribute name="nameHref" required="true"  %>
<%@ attribute name="page" required="true"  %>


<c:choose>
    <c:when test="${fn:contains(url, '&page')}">
        <c:set var="rewriteUrl" value="${fn:substringBefore(url, '&page')}"/>

        <c:choose>
            <c:when test="${currentPage == page}">
                <li class="active">
                    <a href="${rewriteUrl}&page=${page}">${nameHref}</a>
                </li>
            </c:when>

            <c:otherwise>
                <li >
                    <a href="${rewriteUrl}&page=${page}">${nameHref}</a>
                </li>
            </c:otherwise>
        </c:choose>



    </c:when>

    <c:otherwise>

        <c:choose>
            <c:when test="${currentPage == page}">
                <li class="active">
                    <a href="${url}&page=${page}">${nameHref}</a>
                </li>
            </c:when>

            <c:otherwise>
                <li >
                    <a href="${url}&page=${page}">${nameHref}</a>
                </li>
            </c:otherwise>
        </c:choose>



    </c:otherwise>
</c:choose>
