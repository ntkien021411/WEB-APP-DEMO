<%-- 
    Document   : shoppingProduct
    Created on : May 28, 2022, 3:18:18 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(img, s) {
                if (confirm("Are you sure to delete this category ?")) {
                    window.location = "delete?img=" + img;
                }
            }
        </script> 

        <style>

            img{
                width: 100%;
            }
            .home_btn{
                float: right;
                /*padding: 5px;*/
                border: 5px solid aqua;
                text-align: center;
            }
            .pay_btn{
                float: right;
                /*padding: 5px;*/
                /*border: 5px solid aqua;*/
                text-align: center;
            }
            .home_btn a{
                text-decoration: none;
                color: black;
            }
            /*            .pay_btn a{
                            text-decoration: none;
                            color: black;
                        }*/
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
                float: left;
                margin-top: 30px;
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

            /*block payment*/
            .modal{
                position: fixed;
                top: 0;
                right: 0;
                bottom: 0;
                left: 0;
                background: rgba(0, 0, 0, 0.4);
                display: none;
                align-items: center;
                justify-content: center;
            }
            .modal.open{
                display: flex;
            }
            .modal-container{
                background-color: #fff;
                height: 70%;
                width: 60%;
                overflow: scroll;
                position: relative;
                animation: modalFadeIn ease 0.5s;
            }
            @keyframes modalFadeIn {
                from{
                    opacity: 0;
                    transform: translateY(-140px);
                }
                to{
                    opacity: 1;
                    transform: translateY(0);
                }
            }
            .modal-header{
                color: black;
                height: 130px;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 30px;
                margin-left: 120px;
            }
            .modal_product.close{
                display: inline-table;
            }
            .modal_product{
                display: none;
            }

            .modal-close-btn button{
                margin-left: 5%;
                font-size: 15px;
                background: #fff;
                border: none;
                float: right;
                margin-bottom: 5px;
                margin-top: 15px;
                padding: 10px;
            }
            .modal-close-btn:hover button{
                border: 2px solid black;
                cursor: pointer;

            }
            .modal-show-btn  button{
                margin-left: 5%;
                font-size: 15px;
                background: #fff;
                border: none;
                margin-bottom: 5px;
            }
            .modal-show-btn:hover button{
                border-bottom: 2px solid black;
                cursor: pointer;

            }

            .modal-body{
                margin-bottom: 10px;
                /*text-align: center;*/
            }
            .modal-label{
                margin-left: 22px;
                padding: 15px;
                font-size: 20px;
            }
            .modal-input{
                width: 60%;
                padding: 5px;
                font-size: 20px;
            }
            .form-pay{
                margin-top: 20px;
            }
            .modal-pay-btn{
                margin-left: 36px;
                padding: 20px;
                font-size: 20px;
                width: 77%;
                margin-top: 10px;
                background-color: #fff;
            }
            .modal-pay-btn a{
                text-decoration: none;
            }

        </style>
    </head>
    <body>
        <c:set var ="s" value="${sessionScope.s}"/>
        <%--<c:set var ="user" value="${sessionScope.username}"  />--%>
        <div class ="naviga-shop" style="width: 10%;">
            <a href="shoptype?tid=1">Keyboard</a>
            <a href="shoptype?tid=4">Earphone</a>
            <a href="shoptype?tid=2">Mouse</a>
            <a href="shoptype?tid=3">Chair</a>
        </div>
        <h1>Product of User</h1>
        <table class ="table_product" border="1" style="width: 80%;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>IMG</th>
                    <th>TITLE</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                    <th>ACTION</th>
                    <th>SUM</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.data}" var = "t">
                    <tr>
                        <td>${t.id}</td>
                        <td style="height: 50px;width: 200px;"><img src="${t.img}" alt="alt"/></td>
                        <td>${t.title}</td>
                        <td>${t.price1}</td>
                        <td><a class ="addOrMinus" href="deletequantity?img=${t.img}">-</a>
                            ${t.quantity}
                            <a class ="addOrMinus" href="addquantity?img=${t.img}">+</a></td>
                        <td>
                            <a class ="deleteP" href="#" onclick="doDelete('${t.img}')" >Delete</a>
                        </td>
                        <td>${t.total1} VND</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total: ${requestScope.total} VND</td>

                </tr>

            </tbody>
        </table>

        <div class = "home_btn"style=" width: 60px">
            <a href="access">HOME</a>
        </div>
        <div class = "pay_btn"style=" width: 60px;">
            <button style="    width: 100%;
                    border: 5px solid aqua;
                    cursor: pointer;
                    background: #fff">PAY</button>
        </div>
        <!--Payment block--> 
        <div class="modal js-modal">
            <div class="modal-container  js-modal-container">

                <div class="modal-close-btn">
                    <button>CLOSE</button>
                </div>
                <header class="modal-header">
                    SHOPPING CART
                </header>

                <div class="modal-show-btn">
                    <button>SHOW</button>
                </div>

                <table class ="modal_product" border="1" " style="width: 95%;    margin: 0px 20px;"> 
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>IMG</th>
                            <th>TITLE</th>
                            <th>PRICE</th>
                            <th>QUANTITY</th>
                            <th>SUM</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.data}" var = "t">
                            <tr>
                                <td>${t.id}</td>
                                <td style="height: 50px;width: 100px;"><img src="${t.img}" alt="alt"/></td>
                                <td>${t.title}</td>
                                <td>${t.price1}</td>
                                <td>
                                    ${t.quantity}
                                </td>
                                <td>${t.total1} VND</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Total: ${requestScope.total} VND</td>
                        </tr>

                    </tbody>
                </table>
                <%
Date dNow = new Date( );
SimpleDateFormat f =  new SimpleDateFormat ("dd-MM-yyyy");
String date =f.format(dNow);
                %>
                <form action="pay" class ="form-pay" method="get">
                   
                    <div class="modal-body">           
                        <label for="email" class="modal-label">Email</label>
                        <input style="    margin-left: 9%;" id ="email"  name ="emailUser" type="email" class="modal-input" placeholder="What is your email?"required>
                    </div> 
                    <div class="modal-body">
                        <label for="phone" class="modal-label">
                            Phone Number
                        </label>
                        <input style="    margin-left: 3%;" id ="phone" name ="phoneUser" type="number" class="modal-input" placeholder="Phonenumber?"required>
                    </div>  
                    <div class="modal-body">
                        <label for="address" class="modal-label">Address</label>
                        <input style="   margin-left: 7.5%;" id ="address" name ="addressUser" type="text" class="modal-input" placeholder="What is your location?" required>
                    </div>  
                    <input type="hidden"  value="<%=date%>" name="dateNow">
                    <div class="modal-body">               
                        <button onclick="showNote()" type="submit" class ="modal-pay-btn">
                            Pay
                        </button>
                    </div>     
                </form>



            </div>

        </div>    

        <script>
            const showBtn = document.querySelector('.modal-show-btn');
            const modalList = document.querySelector('.modal_product');

            const buyBtns = document.querySelector('.pay_btn');
            const modal = document.querySelector('.js-modal');
            const modalContainer = document.querySelector('.js-modal-container');
            const modalClose = document.querySelector('.modal-close-btn');

            function showBuyTicket() {
                modal.classList.add('open');

            }
            function showCloseProduct() {
                modalList.classList.toggle('close');

            }
            showBtn.addEventListener('click', showCloseProduct);


            buyBtns.addEventListener('click', showBuyTicket);
            function removeBuyTicket() {
                modal.classList.remove('open');
            }
            modalClose.addEventListener('click', removeBuyTicket);

            modal.addEventListener('click', removeBuyTicket);

            modalContainer.addEventListener('click', function (event) {
                event.stopPropagation();
            });

            //            modalContainer.addEventListener('click', function (e) {
            //                e.stopPropagation();
            //            });

            function showNote() {
                alert("Thanh toán thành công!!!");
            }
        </script>
    </body>
</html>
