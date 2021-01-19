<%-- 
    Document   : admin
    Created on : Jan 17, 2021, 8:34:45 PM
    Author     : Long
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Admin Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>

        <c:if test="${sessionScope.USER.roleID ne 2}">

            Sorry You Do Not Admin
        </c:if>
        <c:if test="${sessionScope.USER.roleID eq 2}">

            <c:if test="${empty product}">
                <table class="table" border="1">
                    <thead>
                        <tr>
                            <th >ProductID</th>
                            <th>ProductName</th>
                            <th>Price</th>
                            <th>MadeIn</th>
                            <th>Image</th>
                            <th>Decription</th>
                            <th>Quantity</th>
                            <th>CreateDate</th>
                            <th>CateName</th>
                            <th>Status</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="product" value="${sessionScope.PRODUCTAD}" ></c:set>

                        <c:if test="${not empty product}">
                            <c:forEach var="p" items="${product}">

                                <tr>
                            <form action="MainController">

                                <td><input type="hidden" name="txtProductID" value="${p.productID}">${p.productID}</td>
                                <td><textarea class="ip"  name="txtProductName" value="${p.productName}">${p.productName}</textarea></td>
                                <td><input class="ip" style="width: 80px;" type="number" name="txtPrice" value="${p.productPrice}" step="0.01" min="1"></td>
                                <td><input class="ip" style="width: 125px;"  type="text" name="txtMadeIn" value="${p.madeIn}"></td>
                                <td><img style="width: 50px;height: 50px;" src="${p.image.split(" ")[0]}" ><input class="file" accept="image/png, image/jpeg" type="file" value="${p.image}">
                                    <input class="txtImage" type="hidden" value="${p.image}" name="txtImage"></td>
                                <td><textarea class="ip" style="height: auto;" name="txtDecription" > ${p.decription}</textarea></td>
                                <td><input class="ip" style="width: 30px;"  type="number" min="0" name="txtQuantity" value="${p.quantity}"></td>
                                <td>${p.createDate}</td>
                                <td>
                                    <c:if test="${not empty sessionScope.CATEAD}"> 
                                        <select name="CateAD">
                                            <c:forEach var="cate" items="${sessionScope.CATEAD}">
                                                <option  value="${cate.cateID}" ${p.cateName == cate.cateName ? "selected" : ""}>${cate.cateName}</option>
                                            </c:forEach>
                                        </select>
                                    </c:if>     
                                </td>
                                <td><select name="status">
                                        <option value="true" ${p.status == "true" ? "selected" : ""} >True</option>
                                        <option value="false" ${p.status == "false" ? "selected" : ""}>False</option>
                                    </select></td>
                                <td>
                                    <input type="hidden" name="action" value="updateAD">
                                    <input type="submit" value="Update"></td>
                                <td><a href="MainController?action=deleteAD&idDelAD=${p.productID}">Delete</a></td>
                            </form>

                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <br>
        <table border="1">
            <thead>
                <tr>

                    <th>ProductName</th>
                    <th>Price</th>
                    <th>MadeIn</th>
                    <th>Image</th>
                    <th>Decription</th>
                    <th>Quantity</th>
                    <th>CateName</th>
                    <th>Status</th>
                    <th>Create</th>

                </tr>
            </thead>
            <tbody>
            <form action="MainController">
                <tr>
                    <td><textarea name="txtProductName" ></textarea></td>
                    <td><input name="txtPrice" type="number" step="0.01" min="1" value="1" ></td>
                    <td><input name="txtMadeIn" type="text" ></td>
                    <td><img style="width: 50px;height: 50px;" ><input class="file" accept="image/png, image/jpeg" type="file" value="">
                        <input class="txtImage" type="hidden" value="" name="txtImage"></td>
                    <td><textarea style="height: auto;" name="txtDecription" ></textarea></td>
                    <td><input style="width: 30px;"  type="number" min="1" value="1" name="txtQuantity"></td>
                    <td>
                        <c:if test="${not empty sessionScope.CATEAD}"> 
                            <select name="CateAD">
                                <c:forEach var="cate" items="${sessionScope.CATEAD}">
                                    <option  value="${cate.cateID}">${cate.cateName}</option>
                                </c:forEach>
                            </select>
                        </c:if>     
                    </td>
                    <td><select name="status">
                            <option value="true" ${p.status == "true" ? "selected" : ""} >True</option>
                            <option value="false" ${p.status == "false" ? "selected" : ""}>False</option>
                        </select></td>
                    <td><input type="submit" value="Create">
                        <input type="hidden" name="action" value="CreateAD"></td>
                </tr>
            </form>
        </tbody>
    </table>

    <script>
        $(".file").on('change', (e) => {
            $(e.target).prev().attr('src', e.target.value.split("C:\\fakepath\\")[1]);
            $(e.target).next().val(e.target.value.split("C:\\fakepath\\")[1]);
        });
    </script>
</c:if>
<c:if test="${empty product }">
    Sorry Don't Have Product
</c:if>
</c:if>
</body>
<style>
    .file{

    }
    table{
        width: 99vw;
    }
</style>
</html>
