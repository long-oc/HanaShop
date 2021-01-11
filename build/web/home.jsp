<%-- 
    Document   : home
    Created on : Jan 4, 2021, 9:14:31 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dieu Dao Page</title
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <header>
            <div class="drop-down">
                <div class="top-nav-menu">
                    <span>
                        <i class="nav-menu">
                        </i>
                        DANH MỤC SẢN PHẨM
                        <br>
                    </span>

                </div>
                <hr>
                <div class="body-nav">
                    <ul>

                    </ul>
                </div>
                <span class="txt-slider" style="margin-top: 170px;">0 d</span>
                <input class="slider-price" style="margin-top: 200px;" type="range" name="range" min="0000" max="1000000" step="1000" value="0">


            </div>
            <c:set var="USER" value="${sessionScope.USER}"></c:set>
            <c:if test="${USER ne null}" >
                <a href="/" class="histories">Đơn Hàng<br>anh ${USER.customerName}</a>
                <span class="history"> </span>
            </c:if>
            <c:if test="${USER eq null}" >
                <a href="/" class="histories" style="line-height:3;">Đăng Nhập</a>
                <span class="history"> </span>
            </c:if>
            <a href="#" class="temcart">
                <div>
                    <i  class="item-cart"></i> 

                </div>
                <div>
                    <b class="card">GIỎ HÀNG</b> 

                </div>
            </a>
            <a href="/CartController" class="temcart no hidden" style="padding-top:13px;padding-bottom: 0px;">
                <div>
                    <i class="icon-cart" style="display: inline-block;"></i>
                    <span class="total">1</span>
                </div>
                <div>
                    <b class="card">THANH TOÁN</b><br>
                    <b class="sumorder">277.000₫</b>
                </div>
            </a>
            <c:set var="CART" value="${sessionScope.CART}"></c:set>
            <c:if test="${CART.totalItem eq null or CART.totalItem eq 0 }">
                <script>
                    $(".no").addClass("hidden");
                </script>
            </c:if>
            <c:if test="${CART.totalItem ge 1 }">
                <script> $(".no").removeClass("hidden");
                    $(".total").text(${CART.totalItem});
                    $(".sumorder").text(${CART.totalPrice} + "₫");
                </script> 
            </c:if>
        </a>
    </header>
    <div class="product-body">


    </div>

</body>
<script>
    function getMoreProduct(url, cateID, page_index = 0, price = 0, searchKey = "") {
        $.ajax({
            url: url,
            type: "get",
            async: false,
            data: {cateID: cateID, page_index: page_index, price: price, searchKey: searchKey},
            success: function (product) {
                product.map((value, key) => {
                    if (value.status != false) {
                        $(`#\${cateID}`).find("ul").append(`<li class="product">
                    <a href="#" >
                        <img width="160" height="140" src=\${value.image.split(' ')[0]} alt=\${value.productName}>
                        <div class="product-name">\${value.productName}</div>
                        <div class="price">
                            <strong>\${value.productPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".")}₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>
                </li>`);
                    }
                });
                if (product.length <= 3) {
                    $(`#\${cateID}`).find(".viewmore").addClass("hidden");
                } else {
                    $(`#\${cateID}`).find(".viewmore").removeClass("hidden");
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    var url = "/HanaShop/CateController";
    $.ajax({
        url: url,
        type: "get",
        async: false,
        success: function (cate) {
            cate.map((value, key) => {
                if (value.status != false) {
                    $(".body-nav").find("ul").append(`<li>\${value.cateName}</li>`);
                    $(".product-body").append(` <div id=\${value.cateID} class="groupfeature">
         <h2 class="hometitle">\${value.cateName}</h2>
            <ul class="cate-product">
            </ul>
            <div class="viewmore">Xem thêm sản phẩm khuyến mãi</div>
        </div> </div>`);
                }
            });
        },
        error: function ( {status}) {
            console.log(status);
        }
    });
    $(".product-body").children().map((key, value) => {
        var cateID = $(value).attr("id");

        var url = "/HanaShop/ProductWithFilterController";
        getMoreProduct(url, cateID);
        if ($(`#\${cateID}`).find("li").html() == undefined) {
            $(`#\${cateID}`).addClass("hidden");
        }
    });
    $(document).ready(function () {
        $(".viewmore").click((e) => {
            var cate = $(e.target).parent().attr("id");
            var price = $(".slider-price").val();
            let page_index = 0;
            $(e.target).parent().find("li").map(() => {
                return  page_index = page_index + 1;
            });
            var url = "/HanaShop/ProductWithFilterController";
            getMoreProduct(url, cate, page_index, price, "");
        });
    });
    $(".slider-price").on('change', function (e) {
        console.log(e.target.value);
        $(".txt-slider").text(e.target.value + "d");
        $(".slider-price").val(e.target.value);
        var price = $(".slider-price").val();
        $(".product-body").children().map((key, value) => {

            $(`#\${$(value).attr("id")}`).find("ul").children().map((key, value) => {
                $(value).remove();
            });
        });
        $(".product-body").children().map((key, value) => {
            var cateID = $(value).attr("id");

            var url = "/HanaShop/ProductWithFilterController";
            getMoreProduct(url, cateID, 0, price, "");
        });
    });
</script>
<link href="homecss.css" rel="stylesheet" type="text/css"/>
</html>

