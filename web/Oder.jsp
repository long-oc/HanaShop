<%-- 
    Document   : Oder
    Created on : Jan 13, 2021, 9:29:53 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/8cab019d69.js" crossorigin="anonymous"></script>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <link href="homecss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="modail hidden" style=" width: 100%;height: 100vh; background-color: #25252594; display: flex;position: absolute; z-index: 1000;justify-content: center ;align-items: center">
            <div class="pop-up-delete " style="margin: 0 auto;
                 width: 50vh;
                 height: 17vh;
                 background-color: white;
                 display: flex;

                 border: none;
                 box-shadow: 0 0 1px 1px #ccc;
                 border-radius: 5px;
                 display: inline-block;
                 ">
                <p style="margin-top: 10px; margin-left: 5px;display: block">
                    Bạn Có Muốn Xóa Sản Phẩm 
                </p>
                <div style="display: flex;
                     flex-direction: row;
                     justify-content: center;
                     align-items: flex-end;
                     width: 100%;
                     height: 60%;" >
                    <button class="yes">Đồng Ý</button>
                    <button class="khong">Không</button>
                </div>
            </div>
        </div>
        <style>
            .yes{
                margin-right: 10px;
                height:  40px;
                width: 45%;
                background-color: #008848;
                color: white;
                font-weight: bolder;
                font-size: 15px;
                border: none;
                outline: none;
                border-radius: 6px;
                cursor: pointer;
            }
            .khong{
                height:  40px;
                width: 46%;
                background-color: #80808075;
                color: gray;
                font-weight: bolder;
                font-size: 15px;
                border: none;
                outline: none;border-radius: 6px;
                cursor: pointer;    
            }
        </style>
        <header>


            <c:set var="USER" value="${sessionScope.USER}"></c:set>
            <c:if test="${USER ne null}" >
                <a href="/" class="histories">Đơn Hàng<br>anh ${USER.customerName}</a>
                <span class="history"> </span>
            </c:if>
            <c:if test="${USER eq null}" >
                <a href="MainController?action=login" class="histories" style="line-height:3;">Đăng Nhập</a>
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
            <a class="temcart no hidden" style="padding-top:13px;padding-bottom: 0px;">
                <div>
                    <i class="icon-cart" style="display: inline-block;"></i>
                    <span class="total" style="       font-weight: 600;  width: 15px;
                          height: 15px;border-radius: 20px; background-color: red;padding: 3px; top:-3px;  position: relative;  font-size: 10px;left: -8px;">1</span>
                </div>
                <div>
                    <b class="card">THANH TOÁN</b><br>
                    <b class="sumorder" style="font-weight: normal; position: relative;
                       bottom: 5px; left: 7px;    color: #faff00; font-size: 13px;">277.000₫</b>
                </div>
            </a>

            <c:set var="numMap" value="${sessionScope.CART}"></c:set>
            <c:if test="${empty numMap}">
                <script>
                    $(".no").addClass("hidden");
                </script>
            </c:if>

            <c:if test="${ numMap ne null }">
                <c:set var="totalQuantity" value="0"></c:set>
                <c:set var="totalPrice" value="0"></c:set>
                <c:forEach items="${numMap.getCart().values()}" var="item"> 
                    <c:set var="totalQuantity" value="${totalQuantity=totalQuantity+item.quantity}"></c:set>
                    <c:set var="totalPrice" value="${totalPrice=totalPrice+item.price*item.quantity}"></c:set>
                </c:forEach>
                <script> $(".no").removeClass("hidden");
                    $(".total").text(${totalQuantity});
                    $(".sumorder").text(${totalPrice} + "₫");
                </script>
            </c:if>



        </a>
    </header>
    <div class="DonHaveAnyThing hidden" style= "text-align: center; margin-left: 150px">
        <i class="far fa-frown" style="font-size:100px ; text-align: center ; margin-top: 50px "></i>
        <p>Không có kết quả với <span></span></p>
        <p> Quý khách vui lòng <span></span></p>
    </div>

    <div class="cart" style="width: 640px;height: 915px;background-color: white;margin: 0 auto; position: relative; z-index: -1;top: 80px">
        <div class="cart-header" style="height: 50px;border-bottom: 1px solid #f0f3f5">
            <c:set var="USER" value="${sessionScope.USER}"></c:set>
            <strong style=" padding-left: 10px;  display: block;  padding-top: 15px;"> Đơn Hàng Anh ${USER.customerName}</strong>
        </div>
        <div class="cart-content">
            <div class="item-group">
                <c:set var="CART" value="${sessionScope.CART.getCart().values()}"></c:set>
                <c:forEach var="items" items="${CART}">
                    <div class="item">

                        <img class="imageItem" src="${items.image.split(" ")[0]}" alt=""/>
                        <div class="colInfo">
                            <span class="nameItem">${items.name}</span>
                            <div class="quan">
                                <a href="MainController?action=removeItem&idRemove=${items.id}" class="down">-</a>
                                <input readonly value="${items.quantity}" type="number" min="0" max="50" class="qty">
                                <a href="MainController?action=addItem&idAdd=${items.id}" class="up">+</a>

                            </div>
                            <form action="MainController">
                                <input name="action" value="deleteItem" type="hidden"  hidden/>
                                <input name="idDel" value="${items.id}"  type="hidden"  hidden/>
                                <p style="background-color: transparent;border: none; outline: none;" class="delete">Xóa</p>
                            </form>
                        </div>
                        <strong data-price="${items.price}" class="price" style="right: 10px; margin-top: 10px;
                                position: absolute;" >${items.price*items.quantity}₫</strong>
                    </div>
                </c:forEach>
                <c:if test="${not empty requestScope.ERRORADD}">
                    <script>
                        $(document).ready(() => {
                            alert('${requestScope.ERRORADD}');
                        });
                    </script>
                </c:if>
            </div>
            <div class="cost">
                <span style="position: relative;
                      right: 50px;">Tiền hàng: </span> 
                <label id="carttotal">
                    <b>${totalPrice}₫</b>
                </label>
            </div>
            <div class="btn-order"><button class="btn-og btn-step">ĐẶT HÀNG</button> <div class="clearall"><button>XÓA GIỎ HÀNG</button></div></div>
        </div>
    </div>
</body>
<style>
    a{
        outline: none;
        text-decoration: none;
        color: black;
    }
    .delete{ text-decoration: none;
             top:48px;
             position: absolute;
             left: 200px;
             bottom: 50px;
             cursor: pointer;
             font-size: 13px;
             color: #0081bd;}
    .item{
        height: 87px;
        background-color: white;
        border-bottom: 1px solid #f0f3f5;
        position: relative;
        padding: 12px 10px 10px;
        display: flex;
    }
    body{
        position: relative;
        z-index: -2;
    }
    .imageItem{
        margin-top: 10px;
        width: 60px;
        height: 60px;
        position: relative;
        left: 0;
    }
    .nameItem{

    }
    .colInfo{
        display: flex;
        flex-direction: column;
        margin-top: 10px;
        padding-left: 10px;
    }
    .qty{
        width: 34px;

        font-size: 14px;
        outline: none;
        text-align: center;
        border: 1px solid #ededed;
    }
    .quan{
        display: flex;
        text-align: center;

    }
    .up{
        border: 1px solid #ededed;
        position: relative;
        width: 30px;
        height: 26px;
        display: block;
        border-radius: 0 4px 4px 0;
        padding-top: 6px;
        cursor: pointer;
        font-size: 20px;
    }
    .down{
        border: 1px solid #ededed;
        display: block;
        padding-top: 6px;
        position: relative;
        width: 30px;
        height:  26px;
        border-radius: 4px 0 0 4px;
        cursor: pointer;
        font-size: 20px;

    }
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    .cart{
        height: auto !important;
    }
    .cost{
        position: absolute;
        right: 10px;
    }
    .btn-order{
        display: flex;
        flex-direction: column;
        margin: 20px 10px;
    }
    .btn-og{background-color: #008848;
            border: none;
            outline: none;
            height: 48px;
            font-weight: bold;
            color: #fff !important;
            border-radius: 4px;
            cursor: pointer;
    }
    .clearall button{
        height: 48px;
        width: 100%;
        border: none;
        outline: none;
        color: #0081bd;
        background: transparent;
        cursor: pointer;
    }
</style>
<script>






    $(document).on('click', '.delete', (e) => {
        console.log($(e.target).parent().find("form"));
        $('.modail').removeClass("hidden");
        $(document).on('click', '.khong', () => {
            $('.modail').addClass("hidden");
        });
        $(document).on('click', '.yes', () => {

            console.log($(e.target).parent().attr("action"));
            $(e.target).parent().submit();
            even.preventDefault();
        });
    }
    );







    $(document).on('click', '.up', function (e) {

        $(e.target).prev().prev().css("pointer-events", "auto");
        $(e.target).prev().prev().css("opacity", "1");

    });
    $(document).on('click', '.down', function (e) {
        if ($(e.target).next().val() * 1 < 2) {
            $(e.target).css("pointer-events", "none");
            $(e.target).css("opacity", "0.5");
        }
    });
</script>
</html>
