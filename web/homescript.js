/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
                    <div class="buy"><span class="chonmua">Chọn mua</span></div>
                </li>`);
                    }
                });
                if (product.length <= 3) {
                    $(`#\${cateID}`).find(".viewmore").addClass("hidden");
                } else {
                    $(`#\${cateID}`).find(".viewmore").removeClass("hidden");
                }
                let count = 0;
                $(".groupfeature").children().map((key, value) => {

                    $(value).find("li").map((key, value) => {
                        return count = count + 1;

                    });

                    if (count == 0) {
                        $(`#\${cateID}`).addClass("hidden");
                    } else {
                        $(`#\${cateID}`).removeClass("hidden");
                    }
                });


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
        $(document).on('click', '.detail', function (e) {
            $(".modal").removeClass("hidden");
            $(".modal-m").removeClass("hidden");
            var productID = $(e.target).parent().data("id");
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
                    });

                },
                error: function ( {status}) {
                    console.log(status);
                }
            });



        });

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
        var searchKey = $(".searchForm").val();
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
            getMoreProduct(url, cateID, 0, price, searchKey);
        });
        let count = 0;
        let countPro = 0;
        $(".product-body").children().map((key, value) => {

            if ($(value).hasClass('hidden')) {
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
            console.log(value);
            if ($(value).hasClass('hidden')) {
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