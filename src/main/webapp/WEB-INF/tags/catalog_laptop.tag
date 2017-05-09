<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${language}"/>
<fmt:setBundle var="bundle" basename="content"/>

<ul>

    <c:forEach var="laptop" items="${laptopList}">


        <div class="col-md-4 top_brand_left">
            <div class="hover14 column">
                <div class="agile_top_brand_left_grid">
                    <div class="agile_top_brand_left_grid_pos">
                        <img src="images/offer.png" alt=" " class="img-responsive">
                    </div>
                    <div class="agile_top_brand_left_grid1">
                        <figure>
                            <div class="snipcart-item block">
                                <div class="snipcart-thumb">

                                    <a class="cbp-vm-image" href="<c:url value='/single?idProduct=${laptop.id}' />">
                                        <div class="simpleCart_shelfItem">
                                            <div class="view view-first">
                                                <div class="inner_content clearfix">
                                                    <div class="product_image">
                                                        <img src="${laptop.image}" class="img-responsive" alt=""/>
                                                        <div class="mask">
                                                            <div class="info">Quick View</div>
                                                        </div>
                                                        <div class="product_container">
                                                            <div class="cart-left">
                                                                <p class="title">${laptop.producer.name}</p>
                                                            </div>
                                                        <div class="pricey">
                                                            <span class="item_price">$${laptop.cost}</span>
                                                        </div>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </a>


                                </div>
                                <div class="snipcart-details top_brand_home_details">
                                    <input type="submit" name="submit" value="Add to cart" onclick="addToCart(${laptop.id})"
                                     id="addButton" class="button">
                                </div>
                            </div>
                        </figure>
                    </div>
                </div>
            </div>
        </div>







        </c:forEach>
    </ul>
