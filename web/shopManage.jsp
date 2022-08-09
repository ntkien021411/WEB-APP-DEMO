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
            function doDelete(id,img) {
                if (confirm("Are you sure to delete this category ?")) {
                    window.location = "delete?id=" + id + "&img=" + img;
                }
            }
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
    </head>
    <body>
        <c:set var ="s" value="${sessionScope.s}"/>
        <%--<c:set var ="user" value="${sessionScope.username}"  />--%>
        <h1>Manage Product Shop </h1>
        <table class ="table_product" border="1" style="width: 80%;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>IMG</th>
                    <th>TITLE</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                    <th>ACTION</th>
                    <th>TYPE</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.data}" var = "t">
                    <tr>
                        <td>${t.id}</td>
                        <td style="height: 50px;width: 200px;"><img src="${t.img}" alt="alt"/></td>
                        <td>${t.title}</td>
                        <td>${t.price1}</td>
                        <td>
                            ${t.quantity}
                        <td><a class ="updateP"href="update?img=${t.img}">Update</a>
                            <a class ="deleteP" href="#" onclick="doDelete('${t.id}','${t.img}')" >Delete</a>
                        </td>
                        <td>${t.category.title}</td>
                    </tr>
                </c:forEach>


            </tbody>
        </table>

        <div class = "home_btn"style="width: 5%;">
            <a href="access">HOME</a>
        </div>
        <div class = "home_btn"style="width: 5%;">
            <a href="addByAdmin">ADD</a>
        </div>
    </body>
</html>
