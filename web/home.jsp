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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="homecss.css" rel="stylesheet" type="text/css"/>
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
                <c:if test="${USER eq null}" >
                    <a href="/" class="histories" style="line-height:3;">Đăng Nhập</a>
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
    <div class="product-body">

        <div class="groupfeature">
          
        </div>
        </div>

</body>
<style>
    .product-body{
        padding-top: 100px;
        padding-left: 435px;
        width: 980px;
    }
    .product-body ul{
        list-style-type: none;
        display: flex;
        flex-wrap: wrap;
    }
    .product-body ul li{
        width: 242.8px;
        border: 1px solid #eee;
    }
    .product-body h2{
        text-transform: uppercase;
    }
    .cate-product{
        background-color: white;

    }
    .groupfeature{
        margin-bottom: 15px;
    }
    .viewmore{
        text-align: center;
    }
    img{

        margin-left: 48px;
    }
    .product a{
        text-decoration: none;
        color: black;
    }
    .buy {

        text-align: center;
        width: 203px;
        height: 40px;
        border-radius: 4px;
        border: 1px solid #008848;
        margin-left: 20px;
        cursor: pointer;
    }
    .chonmua{
        display: block;
        margin-top: 10px;
        text-transform: uppercase;
        color:#008848;
    }
    .product{
        padding-bottom: 16px;
        margin-bottom: 0.5px;
    }
    .product-name{
        padding-left: 7px;
        padding-bottom: 15px;
    }
    .price{
        padding-left: 10px;
        margin-bottom: 30px;
    }.hometitle{
        margin-bottom: 12px;
    }
    .price strong{
        font-size: 13px;
        color: #b10e0e;
    }
    .price span{
        text-decoration: line-through;
        color: gray;
        padding-left: 5px;
    }
    .viewmore{
        overflow: hidden;
        display: block;
        font-size: 14px;
        line-height: 45px;
        color: #0064c2;
        text-align: center;
        padding: 10px 0;
        width: 980px;
        height: 50px;
        background-color: white;
        padding-top: 0px;
        cursor: pointer;
    }
</style>






















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
    }
    .histories a:hover{
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

<script>
$(document).ready(function(){
  var url = "/HanaShop/ProductController";
                        $.ajax({
                            url: url,
                            type: "get",
                            
                            success: function ( [{cate,product}] ) {
                                
                               cate.map((v)=>{
                                  var a=$(".groupfeature").html();
                                  $(".groupfeature").html(a+$(' <h2 class="hometitle">Đồ uống các loại</h2>
            <ul class="cate-product">
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>
                <li class="product">
                    <a href="#" >
                        <img width="160" height="160" src="https://cdn.tgdd.vn/Products/Images/2947/79217/bhx/sua-trai-cay-nutriboost-huong-cam-1-lit-201906211625269518_300x300.jpg" alt="Sữa trái cây Nutriboost hương cam 1 lít">
                        <div class="product-name">Sữa trái cây Nutriboost hương cam 1 lít</div>
                        <div class="price">
                            <strong>21.000₫</strong>
                            <span>28.000₫</span>
                        </div></a>
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>

                </li>

            </ul>
            <div class="viewmore">Xem thêm 214 sản phẩm khuyến mãi</div>
        </div>'));
                               });
                               
                            },
                            error: function ( {status}) {
                                
                                console.log(status);
                            }
                        });
});
</script>


</html>
