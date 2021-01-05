<%-- 
    Document   : login
    Created on : Jan 5, 2021, 1:03:05 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <form>
            UsesrName:<input class="User-Name" type="text" name="txtInput"  ><br>
            Password:<input class="Password" type="password" name="txtPassword"><br>
            <span class="error" style="color: red;"></span><br>
            <input onsubmit=Myfunction() type="submit">
        </form>
    </body>
    <script>
        $(document).on('submit', 'form', function () {
            var userName = $(".User-Name").val();
            var pass = $(".Password").val();
            if (userName === null || userName === "") {
                $(".error").text("UserName Doesnot Empty");
            } else if (!pass || pass === "") {
                $(".error").text("Password Doesnot Empty");
            } else {
                var url = "/HanaShop/LoginController";
                $.ajax({
                    url: url,
                    type: "get",
                    data: {txtInput: userName, txtPassword: pass},
                    success: function (data) {
                        console.log(data);
                        if (data == "True") {
                            window.location.href = "shopping.jsp";
                        } else {
                            $(".error").text("Sai Tai Khoan Hoac Mat Khau");
                        }
                    },
                    error: function (xhr, status, error) {
                        console.log(xhr.responseText);
                        alert("message : \n" +
                                "An error occurred, for more info check the js console" +
                                "\n status : \n" + status + " \n error : \n" + error);
                    }
                });
                return false;
            }
        });
    </script>
</html>
