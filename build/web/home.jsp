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
        <script src="https://kit.fontawesome.com/8cab019d69.js" crossorigin="anonymous"></script>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <link href="homecss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="modal-m hidden" style="width: 100%;height: 101%;"></div>
        <div class="modal hidden">
            <button class="close" style="height: 30px;width: 30px ;right: 1px;top: 1px ;position: absolute ; background-color: wheat ; border: none;cursor: pointer;    font-size: 1.5rem;
                    font-weight: 700; opacity: 0.6;
                    line-height: 1;">x</button>
            <button class="close" style="height: 40px; width: 66px ;right: 10px;bottom: 4px;position: absolute;background-color: #6c757d; ;border-color: #6c757d ; box-shadow: none;border: none;
                    outline:none; cursor: pointer ;border-radius: 3px ; color: white;font-size: 1rem;">Close</button>
            <img class="image-detail" style="position: relative;
                 left: 50px; margin-top: 25px; margin-left: 10px" class="owl-lazy"  width="660px !important" height="390px !important" data-src="https://cdn.tgdd.vn/Products/Images/2524/221971/bhx/ca-phe-hoa-tan-viva-dam-dac-trung-340g-202005141448192138.jpg" alt="Cà phê hòa tan Viva đậm đặc trưng 340g 2" data-type="1" data-index="1" src="https://cdn.tgdd.vn/Products/Images/2524/221971/bhx/ca-phe-hoa-tan-viva-dam-dac-trung-340g-202005141448192138.jpg">
            <div  style=" width: 630px;background-color: rgba(184,210,182,0.7); margin-left: 130px; padding-right: 10px;">
                <h1 class="nameproduct">Cà phê hòa tan Viva đậm đặc trưng 340g</h1>
                <div class="boxprice" style="margin-left: 20px"><strong style="display: inline-block;
                                                                        font-size: 24px;
                                                                        color: #c10017;
                                                                        vertical-align: middle;">42.000₫</strong> <span class="strike" style="display: inline-block;
                                                                        vertical-align: middle;
                                                                        font-size: 14px;
                                                                        color: #999;
                                                                        text-decoration: line-through;
                                                                        margin-left: 5px;">55.500₫</span> <label style="display: inline-block;
                                                                        vertical-align: middle;
                                                                        font-size: 12px;
                                                                        color: #fff;
                                                                        font-weight: 600;
                                                                        border-radius: 3px;
                                                                        background: #de2000;
                                                                        width: 32px;
                                                                        height: 20px;
                                                                        line-height: 20px;
                                                                        text-align: center;
                                                                        margin-left: 5px;">-24%</label>
                    <c:if var="isAD" test="${sessionScope.USER.roleID ne 2}">
                        <button  style="cursor: pointer; margin-top: 20px; border-color: green; outline:none; text-decoration: none ;border: none ; background-color: #008848; color: white; width:  422px;height: 50px ; border-radius: 4px " class="clickbuy" data-id="221971">Chọn mua</button>
                    </c:if>
                    <div class="shipping" style="display: block;
                         overflow: hidden;
                         padding: 10px;
                         background: #f6f8fa;
                         margin-top: 10px;
                         opacity: 0.8"><div><i class="bhx-sship"></i> <span> Đặt online giao tận nhà ĐÚNG GIỜ (nếu trễ đền 50.000₫)</span></div><div><i class="bhx-swap"></i> <span> Đổi, trả sản phẩm trong 7 ngày </span> <a href="/kinh-nghiem-hay/chinh-sach-doi-tra-1230736" id="detailReturn">(Xem chi tiết)</a></div></div>
                    <h1 style="line-height: 50px">Thông tin sản phẩm</h1>
                    <ul class="infoproduct nospeci">

                        <li>
                            <span>Sản xuất tại</span>
                            <div></div>
                        </li>
                        <li>
                            <span>Thông Tin</span>
                            <div></div>
                        </li>
                    </ul>
                </div>
            </div>
            <div style=" margin-left: 20px;position: absolute ; bottom: 17px;">
                <h1>Sản Phẩm Thường Mua Kèm</h1>
                <div class="recommnent" style="width: 560px;height: 180px;background-color: white; margin-top: 10px ; display: flex">

                </div>
            </div>
        </div>
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
                <span class="txt-slider" style="margin-top: 170px; position: absolute">0 đ</span>
                <input  class="slider-price" style="margin-top: 200px; width: 200px;" type="range" name="range" min="0000" max="1000000" step="1000" value="0">
            </div>
            <form>
                <input class="searchForm" placeholder="Search" style="width: 385px ; height: 34px ; margin-left: 200px ;margin-top: 6px; border-radius: 4px; border: 0;outline: none ;  text-indent: 10px;     font: 14px/18px Helvetica,Arial,sans-serif;" type="text" >
            </form>
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
            <a href="MainController?action=order" class="temcart no hidden" style="padding-top:13px;padding-bottom: 0px;">
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
            <c:if test="${empty numMap.getCart()}">
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
    <div class="product-body ">
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
                    <a class="detail" data-id=\${value.productID} >
                        <img class="image" width="160" height="140" src=\${value.image.split(' ')[0]} alt=\${value.productName}>
                        <div class="product-name">\${value.productName}</div>
                        <div class="price">
                            <strong>\${value.productPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".")}₫</strong>
                            <span>28.000₫</span>
                        </div></a>
    <c:if var="isAD" test="${sessionScope.USER.roleID ne 2}">
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>
    </c:if>
                </li>`);
                    }
                });
                if (product.length <= 3) {
                    $(`#\${cateID}`).find(".viewmore").addClass("hidden");
                } else {
                    $(`#\${cateID}`).find(".viewmore").removeClass("hidden");
                }
                let count = 0;
                $(`#\${cateID}`).children().map((key, value) => {
                    $(value).find("li").map((key, value) => {
                        return count = count + 1;
                    });
                });
                console.log("cate:" + `#\${cateID}` + "is" + count);
                if (count == 0) {
                    $(`#\${cateID}`).addClass("hidden");
                } else {
                    $(`#\${cateID}`).removeClass("hidden");
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
                    $(".body-nav").find("ul").append(`<li data-cate=\${value.cateID}>\${value.cateName}</li>`);
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
    $(document).on('click', '.clickbuy', () => {
        var id = $('.clickbuy').data('id');
        buy(id);
    }
    );
    $(".product-body").children().map((key, value) => {
        var cateID = $(value).attr("id");
        var url = "/HanaShop/ProductWithFilterController";
        getMoreProduct(url, cateID);
        if ($(`#\${cateID}`).find("li").html() == undefined) {
            $(`#\${cateID}`).addClass("hidden");
        }
    });
    $(document).ready(function () {
        $(".body-nav").children().children().click((e) => {
            $(".product-body").children().remove();
            var url = "/HanaShop/CateByID";
            var cateID = $(e.target).data("cate");
            $.ajax({
                url: url,
                type: "get",
                async: false,
                data: {cateID: cateID},
                success: function (data) {
                    console.log(data[0]);
                    if (data[0].status != false) {
                        $(".product-body").append(` <div id=\${data[0].cateID} class="groupfeature">
         <h2 class="hometitle">\${data[0].cateName}</h2>
            <ul class="cate-product">
            </ul>
            <div class="viewmore">Xem thêm sản phẩm khuyến mãi</div>
        </div> </div>`);
                        getMoreProduct("/HanaShop/ProductWithFilterController", cateID);
                    }
                },
                error: function ( {status}) {
                    console.log(status);
                }
            });
        });
        function getListRecommentProduct(productID) {
            $.ajax({
                url: "/HanaShop/RecommentController",
                type: "get",
                async: false,
                data: {productIDRec: productID},
                success: function (data) {
                    $('.recommnent').children().remove();
                    data.map((value, key) => {
                        var url = "/HanaShop/ProductDetail";
                        $.ajax({
                            url: url,
                            type: "get",
                            async: false,
                            data: {productID: value},
                            success: function (data) {
                                data.map((value, key) => {
                                    $('.recommnent').append(`<img data-id="\${value.productID}" class="detail" style="margin: 1px; border: 1px solid #eee; "  width="182px"  src=\${value.image} />`);
                                });
                            },
                            error: function ( {status}) {
                                console.log(status);
                            }
                        });
                    });
                },
                error: function ( {status}) {
                    console.log(status);
                }
            });
        }
        ;
        $(document).on('click', '.detail', function (e) {
            $(".modal").removeClass("hidden");
            $(".modal-m").css("width: 100%; height: 101%");
            $(".modal-m").removeClass("hidden");
            var productID = $(e.target).parent().data("id");
            if(!productID){
                productID=$(e.target).data("id");
            }
            var url = "/HanaShop/ProductDetail";
            $.ajax({
                url: url,
                type: "get",
                async: false,
                data: {productID: productID},
                success: function (data) {
                    data.map((value, key) => {
                        $(".nameproduct").text(`\${value.productName}`);
                        $(".modal").find("strong").text(`\${value.productPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".")}₫`);
                        $(".image-detail").attr('src', value.image.split(' ')[0]);
                        $(".infoproduct").find("li:eq(0) div").text(`\${value.madeIn}`);
                        $(".infoproduct").find("li:eq(1) div").text(`\${value.decription}`);
                        $(".clickbuy").data('id', value.productID);
                    });
                    getListRecommentProduct(productID);
                },
                error: function ( {status}) {
                    console.log(status);
                }
            });
        });
        ;
        $(document).on('click', '.viewmore', (e) => {
            var searchKey = $(".searchForm").val();
            var cate = $(e.target).parent().attr("id");
            var price = $(".slider-price").val();
            let page_index = 0;
            $(e.target).parent().find("li").map(() => {
                return  page_index = page_index + 1;
            });
            var url = "/HanaShop/ProductWithFilterController";
            getMoreProduct(url, cate, page_index, price, searchKey);
        });
    });
    $(".slider-price").on('change', function (e) {
        console.log(e.target.value);
        var searchKey = $(".searchForm").val();
        $(".txt-slider").text(e.target.value.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".") + "đ");
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
            getMoreProduct(url, cateID, 0, price, searchKey);
        });
        let count = 0;
        let countPro = 0;
        $(".product-body").children().map((key, value) => {
            if (!$(value).find("ul").children().html()) {
                countPro = countPro + 1;
            }
            count = count + 1;
        });

        if (count == countPro) {
            $(".DonHaveAnyThing").removeClass("hidden");
            $(".DonHaveAnyThing").children().find("span").first().text(`giá \${price}đ.`);
            $(".DonHaveAnyThing").children().find("span").last().text("nhập giá khác");
        } else {
            $(".DonHaveAnyThing").addClass("hidden");
        }
    });
    $(".searchForm").on('keyup', function (e) {
        $(".searchForm").val(e.target.value);
        var price = $(".slider-price").val();
        var searchKey = e.target.value;
        $(".product-body").children().map((key, value) => {
            $(`#\${$(value).attr("id")}`).find("ul").children().map((key, value) => {
                $(value).remove();
            });
        });
        $(".product-body").children().map((key, value) => {
            var cateID = $(value).attr("id");
            var url = "/HanaShop/ProductWithFilterController";
            getMoreProduct(url, cateID, 0, price, searchKey);
        });
        let count = 0;
        let countPro = 0;
        $(".product-body").children().map((key, value) => {
            if (!$(value).find("ul").children().html()) {
                countPro = countPro + 1;
            }
            count = count + 1;
        });
        if (count == countPro) {
            $(".DonHaveAnyThing").removeClass("hidden");
            $(".DonHaveAnyThing").children().find("span").first().text(`từ khóa '\${searchKey}'.`);
            $(".DonHaveAnyThing").children().find("span").last().text("nhập từ khóa khác");
        } else {
            $(".DonHaveAnyThing").addClass("hidden");
        }
    });
    $(".close").click(function () {
        $(".modal").addClass("hidden");
        $(".modal-m").addClass("hidden");
    });
    $(".modal-m").click(() => {
        $(".modal").addClass("hidden");
        $(".modal-m").addClass("hidden");
    });
</script>
<script>
    function buy(id) {
        var url = "/HanaShop/CartController";
        $.ajax({
            url: url,
            type: "get",
            async: false,
            data: {addID: id},
            success: function (cart) {
                console.log(cart);
                let totalPrice = 0;
                let totalQuantity = 0;
                cart.map((value, key) => {
                    console.log(value.name);
                    totalQuantity = totalQuantity + value.quantity;
                    totalPrice = totalPrice + value.quantity * value.price;
                    $(".no").removeClass("hidden");
                    $(".total").text(totalQuantity);
                    $(".sumorder").text(totalPrice);
                });
            },
            error: function ( {status}) {
                alert("Sản Phẩm Hết Hàng");
            }
        });
    }
    $(document).on('click', '.chonmua', function (e) {
        var id = $(e.target).parent().prev().data("id");
        buy(id);
    });
</script>
</html>

