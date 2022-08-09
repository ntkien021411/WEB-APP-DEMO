<%-- 
    Document   : shoppingProduct
    Created on : May 28, 2022, 3:18:18 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
          
        </script> 

        <style>

            img{
                width: 100%;
            }
            .home_btn{
                float: right;
                padding: 5px;
                border: 5px solid aqua;
                text-align: center;
            }
            .home_btn a{
                text-decoration: none;
                color: black;
            }
            .table_product{
                float: left;
                text-align: center;
            }
            .addOrMinus,.updateP,.deleteP{
                text-decoration: none;
                color: black;
                padding: 10px;
                font-size: 20px;
            }
            .addOrMinus:hover,.updateP:hover,.deleteP:hover{
                border: 3px solid red;
            }
            table td{
                font-size: 20px;
            }
            .naviga-shop{
                 margin-top: 30px;
                float: left;
                margin-right: 50px;
            }
            .naviga-shop a{
                display: block;
                text-decoration: none;
                font-size: 20px;
                padding: 10px;
                color: black;
                border: 3px solid red;
                margin: 30px 0;
            }
        </style>
         <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete this category ?")) {
                    window.location = "delete?id=" + id;
                }
            }
        </script> 
    </head>
    <body>
        <div class ="naviga-shop" style="width: 10%;">
            <a href="shoptype?tid=1">Keyboard</a>
            <a href="shoptype?tid=4">Earphone</a>
            <a href="shoptype?tid=2">Mouse</a>
            <a href="shoptype?tid=3">Chair</a>
            <a href="shop">ListAll</a>
        </div>
         <h1>Product of User</h1>
        <table class ="table_product" border="1" style="width: 70%;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>IMG</th>
                    <th>TITLE</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                    <th>TYPE</th>
                    <th>SUM</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.list1}" var = "s">
                    <tr>
                        <td>${s.id}</td>
                        <td style="height: 50px;width: 200px;"><img src="${s.img}" alt="alt"/></td>
                        <td>${s.title}</td>
                        <td>${s.price1}</td>
                        <td>
                            ${s.quantity}
                        <td>
                           ${s.category.title}
                        </td>
                        <td>${s.total1} VND</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <%--<c:set var ="s" value="${requestScope.s1}" scope="session" />--%>
        <div class = "home_btn"style="width: 5%;">
            <a href="access">HOME</a>
        </div>
    </body>
</html>
