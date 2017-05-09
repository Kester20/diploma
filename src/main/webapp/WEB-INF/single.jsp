<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gadget store</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/defaultScripts.js" type="application/x-javascript"></script>
    <script src="js/easing.js" type="text/javascript"></script>
    <script src="js/move-top.js" type="text/javascript"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="products">
    <div class="container">
        <div class="col-md-4 products-left">

        <h2>${product.producer.name} ${product.model}</h2>

        <img src="${product.image}" width="400" height="240" class="photo" />


        </div>


        <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids">

                    <div style="background: #eeeeec;width:300px;height:200px;float:left;">

                        <h2 style="font-weight: normal;margin-top:10px;margin-bottom:10px;text-align:center">
                            $${product.cost}
                        </h2>

                        <div style="border-bottom: 1px solid #ddd;"></div>

                        <input class="subm" style="width:150px;margin-left:73px;" type="submit" value="Buy" />

                        <div style="border-bottom: 1px solid #ddd;margin-top:20px;"></div>

                        <input class="subm" style="width:150px;background-color:#fe9126;margin-left:73px;"
                        type="submit" value="Add to wish list" onclick="addToWishList(${product.id})"/>

                    </div>


                    <div style="float:right">
                        <table id="order" style="width:400px;">

                            <tr>
                                <td>
                                    <label class="orderParametersName">Producer:</label>
                                </td>

                                <td>
                                    ${product.producer.name}
                                </td>

                            </tr>

                            <tr>
                                <td>
                                    <label class="orderParametersName">Model:</label>
                                </td>

                                <td>
                                    ${product.model}
                                </td>
                            </tr>

                        </table>

                    </div>

                    <textarea rows="6"  style="overflow: auto;float: right;width:100%;margin-top:20px;"
                        placeholder="Write comment..." id="textarea"></textarea>

                    <button style="float: right; width: 150px;margin-top:20px;" class="subm"
                        onclick="">
                        <i class="fa fa-pencil"></i>Accept
                    </button>

                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>