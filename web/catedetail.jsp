<%-- 
    Document   : catedetail
    Created on : Jan 7, 2021, 10:46:58 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="homecss.css" rel="stylesheet" type="text/css"/>
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
                        <li>RAU AN TOÀN 4KFARM</li>
                        <li>THỊT, CÁ, TRỨNG, RAU CỦ</li>
                        <li>ĐỒ UỐNG CÁC LOẠI</li>
                        <li>SỮA CÁC LOẠI</li>
                    </ul>
                </div>


            </div>
            <c:set var="USER" value="${sessionScope.USER}"></c:set>
            <c:if test="${USER ne null}" >
                <a href="/" class="histories">Đơn Hàng<br>anh ${USER.customerName}</a>
                <span class="history"> </span>
            </c:if>
            <a href="#" class="temcart">
                <div>
                    <i class="item-cart"></i> 

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
</body>
<style>
    .hidden{
        display: none !important;
    }


    .histories{
        margin-top: 5px;
        position: absolute;
        right:  250px;
        display: flex;
        text-decoration: none;
        color:white;
        font-size: 12px;
        text-decoration: none;
    }
   
    .temcart{
        text-decoration: none;
        color: white;
        background-color: rgb(3, 117, 64);
        padding-top: 14px;
        padding-bottom: 14px;
        padding-left: 15px;
        padding-right: 15px;

        position: absolute;
        right:  80px;
        display: flex;
    }
    .icon-cart{
        background-position: -256px -33px;
        width: 22px !IMPORTANT;
        height: 22px !IMPORTANT;
        background-image:  url(https://cdn.tgdd.vn/bachhoaxanh/www/Content/images/desktop/bhxdesk@2x.v202101041331.png);
        background-repeat: no-repeat;
        background-size: 500px auto;
        display: inline-block;
        height: 30px;
        width: 30px;
        line-height: 30px;
        vertical-align: middle;
    }
    .card{
        margin-left: 5px;
        margin-top:5px;
    }

</style>
</html>
