<%-- 
    Document   : index
    Created on : May 21, 2022, 5:46:12 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="icon" href="./img/logo/logo-K-3.png" type="image/x-icon" />
        <link rel="stylesheet" href="./css/grid.css" />
        <!--<link rel="stylesheet" href="./css/style.css" />-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>KShop</title>
        <style>
            /* Reset CSS */

            *{  /*Tham chiếu tới tất cả các thẻ */
                /* Emmet */
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            html{
                font-family: Arial, Helvetica, sans-serif;
                /* xét dạng dữ không chân cho toàn bộ content  */
                /* scroll-behavior: smooth; */
            }

            body{
                background-color: #f1f1f1;
            }
            /*! HEADER */
            .header,.slider_specail,.slider{
                background-color: #fff;
            }



            .navigation div a{
                text-decoration: none;
                color: black;
            }
            .navigation .naviga:hover a{
                border-bottom: 2px solid #000000;
            }
            .logo img{
                width: 100%;
            }

            .navigation .naviga{
                font-size: 15px;
                padding-top: 20px;
                padding-bottom: 20px;
                font-weight: 600;
                display: flex;
                justify-content: center;
                align-items: center;
                cursor: pointer;
            }
            /*! SLIDER */


            @keyframes display {
                0% {
                    transform: translateX(200px);
                    opacity: 0;
                }
                10% {
                    transform: translateX(0);
                    opacity: 1;
                }
                20% {
                    transform: translateX(0);
                    opacity: 1;
                }
                30% {
                    transform: translateX(-200px);
                    opacity: 0;
                }
                100% {
                    transform: translateX(-200px);
                    opacity: 0;
                }
            }

            .pic-ctn {
                position: relative;
                width: 100%;
                height: 500px;
                margin-top: 30px;
            }

            .pic-ctn > img {
                position: absolute;
                top: 0;
                left: 30%;
                opacity: 0;
                animation: display 10s infinite;
                border-radius: 50px;
                border: 5px solid black;
            }
            .pic-ctn img{
                width: 60%;
                height: 500px;
            }

            img:nth-child(2) {
                animation-delay: 2s;
            }
            img:nth-child(3) {
                animation-delay: 4s;
            }
            img:nth-child(4) {
                animation-delay: 6s;
            }
            .slider_specail-content{
                margin-top: 30px;
                padding-bottom: 10px;
                text-align: center;
                padding-top: 10px;
                padding-bottom: 10px;
            }

            /* Footer */
            .footer {
                background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
                background-size: 400% 400%;
                animation: gradient 15s ease infinite;
                height: 300px;
            }
            @keyframes gradient {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }
            .footer{
                /*background-color: black;*/
                display: flex;
                justify-content: center;
                align-items: center;
                color: #fff;
                margin: 0;
            }
            .footer_heading1 {
                margin-top: 10px;
                font-size: 40px;
                margin-bottom: 20px;
                color: red;
            }

            .footer_heading {
                margin-top: 10px;
                font-size: 40px;
                margin-bottom: 20px;
                color: #fff;

            }

            .footer a{

                text-decoration: none;
                font-size: 30px;
                color: #fff;
                margin: 0 10px;
                padding-left: 20px;
                padding-right: 20px;

            }
            .footer div{
                display: flex;
                align-items: center;
                justify-content: center;
                padding-bottom: 10px;
                padding-top: 10px;

            }
            .footer a:hover{
                /* opacity: 0.5; */
                font-size: 40px;

            }
            /* Footer */
            /* slider */
            /* .slider{
              margin-top: 10px;
            } */
            /* .slider_heading:hover h1{
              border: none;
            } */
            .slider_heading .slider_product{
                margin-bottom: 12px;
            }
            .slider_heading{
                margin-bottom: 20px;
            }
            .slider_heading_content{
                font-size: 30px;
                margin-bottom: 20px;
                margin-top: 30px;
                text-align: center;
                margin-left: 10px;
                border-bottom: 2px solid black;
            }
            /* .slider_heading_content:hover {
              padding: 10px;
              border: 5px solid blue;
            } */
            .slider_top{
                margin-left: 0;
                margin-right: 0;
            }
            .slider_top{
                border-bottom: 3px solid black;
                margin-bottom: 10px;
            }
            .slider_top h4{
                font-size: 30px;
                padding: 10px 10px;
            }

            .slider_heading p{
                opacity: 0.5;

            }

            .slider_product img{
                width: 200px;
            }
            .slider_product p{
                padding: 5px;
            }
            .slider_product a{
                color: red;
                margin-left: 5px;

            }
            /* .slider_heading .btn_buy{
                display: none;
            }
            .slider_heading:hover .btn_buy{
              display: block;
            } */
            .slider_heading:hover {
                border: 1px solid rgb(179 179 189 / 58%);
            }
            .slider_product h5{
                font-size: 15px;
                color: red;
                display: inline-block;
                /* padding: 10px; */
                padding-left: 5px;
            }
            .slider_heading:hover h5,  .slider_heading:hover a{
                font-size: 30px;
                font-weight: 600;
            }
            /* .slider_heading:hover h3{
              color: blue;
              cursor: pointer;
              font-size: 30px;
            } */
            .slider_heading h3{
                font-size: 13px;
                padding-left: 5px;
                /* padding: 10px; */
            }
            .slider{
                margin-left: 12px;
                margin-right: 12px;
            }

            .btn_buy button{
                cursor: pointer;
                width: 200px;
                font-size: 15px;
                background-color: red;
                color: #fff;
                padding-top: 10px;
                padding-bottom: 10px;
                border-radius: 20px;
                border: none;
            }

            /* Modal shopping item */
            .modal-shopping-item{
                background-color: #fff;
                height: 35%;
                width: 50%;
                position: absolute;
                z-index: 2;
                display: none;
                top: 165px;
                right: 15%;
                border: 1px solid rgb(179 179 189 / 58%);
                overflow: scroll;
            }
            .modal-shopping-item.open{
                display: block;
            }
            .modal-container{
                margin-top: 20px;
                margin-bottom: 20px;
            }
            item-footer12{
                margin-right: 10px;
            }
            .item-footer12{
                margin-right: 10px;
            }
            .item-footer12 button{
                margin-top: 10px;
                background-color: orange;
                padding-top: 5px;
                padding-bottom: 5px;
                width: 70%;
                color: #fff;
                cursor: pointer;
            }


            .item-footer1{
                margin-right: 10px;
            }
            .item-footer1 button{
                cursor: pointer;
                margin-top: 10px;
                background-color: orange;
                padding-top: 5px;
                padding-bottom: 5px;
                width: 100%;
            }
            .item-footer1 button a{
                font-size: 15px;
                color: #fff;
                text-decoration: none;
            }
            /* Modal shopping */
            .item_img img{
                width: 50%;
                padding: 10px;
            }
            .item_img p{
                width: 50%;
                padding: 10px;
                margin: auto 0;
            }
            .item_img h4,.item_price h4{
                text-align: center;
                border-bottom: 1px solid black;

            }
            .item_price p{
                margin: auto 0;
                /* margin: 30px 5px 30px 10px; */
                margin-top: 40%;
                font-size: 20px;
                display: inline-block;
            }
            .item_price h3{

                display: inline-block;
            }
            .item-product{
                margin-left: 5px;
                margin-right: 5px;
                padding-bottom: 10px;
                margin-top: 20px;
            }



            /*user*/
            .close{
                display: none;
            }

            .sub-profile {
                list-style-type: none;

            }
            .sub-profile li a{
                text-decoration: none;
                font-size: 15px;
                color: black;
                display: none;
            }
            .fa-user-circle:hover .sub-profile li a{
                display: block;
            }

            .user:hover .sub-profile li{
                display: block;
            }

            .user {
                position: absolute;
                top: 45px;
                right: 5%;
                font-size: 30px;
                color: #000;
                cursor: pointer;
            }
            .item-product table{
                width: 98%;
            }
            img{
                width: 40%;
            }
            .length_shop{
                margin-left: 3px;
                font-size: 10px;
                padding: 2px;
                font-size: 11px;
                position: relative;
                top: -6px;
                border: 2px solid red;
                border-radius: 10px;
            }

            .form-search{
                margin-top: 40px;
            }
            .form-search select{
                height: 30px;
            }
            .form-search button{
                padding: 5px;
                font-size: 13px;
                cursor: pointer;
            }
            .form-search input{
                height: 30px;
                width: 200px;
            }
            .form-search1{
                margin-top: 40px;
                margin-right:  20px;
            }
            .form-search1 input, .form-search1 select{
                margin-bottom:  20px;
            }
            .form-search1 select{
                height: 30px;
            }
            /*responsive*/
            @media(max-width: 1023px){
                .slider_heading h3,.slider_product p{
                    font-size: 12px;
                }
                .btn_buy button{
                    font-size: 12px;
                    width: 80%;
                }
                .slider_product img {
                    width: 80%;
                }
                .slider_heading:hover h5,  .slider_heading:hover a{
                    font-size: 20px;
                    font-weight: 600;
                }

            }
            @media (min-width: 741px) and (max-width: 741px){

                .slider_product img {
                    width: 50%;
                }
                .btn_buy button {
                    font-size: 10px;
                    width: 50%;
                }
                .navigation .resgister{
                    /*margin-left: 10%;*/
                }
                .navigation .login{
                    /*margin-left: 10%;*/
                }


            }
            @media (max-width: 740px){

                .slider_heading h3, .slider_product p {
                    font-size: 13px;
                }


            }
        </style>

    </head>
    <body>

        <!-- Web bán hàng đồ công nghệ  -->
        <!-- Header 
        HOME , Earphone , keyboard,mouse,ghế
        -->

        <!-- Header 
       HOME , Earphone , keyboard,mouse,ghế
        -->
        <!-- HEADER 1 -->
        <c:set var ="s" value="${sessionScope.s}"  />
        <%--<c:set var ="user" value="${sessionScope.username}" scope="session"/>--%>
        <div class="grid header" id="header">
            <div class="row grid  navigation">
                <div class="col l-1 m-1 c-1 logo">
                    <a href=""><img src="./img/logo/logo-K-3.png" alt="" /></a>
                </div>
                <div class="col  l-8 m-8 c-5 logo ">
                    <form style="    margin-left: 30px;" class ="form-search row"action="search" method = "get">
                        <select  class = "col l-2 m-2 c-12" id = "type"name ="type">
                            <option value="0">Default</option>
                            <option value="1">Keyboard</option>
                            <option value="2">Mouse</option>
                            <option value="3">Chair</option>
                            <option value="4">Earphone</option>
                        </select>
                        <select class = "col l-2 m-2 c-2 c-12" name ="MMprice">
                            <option value="0">Default</option>
                            <option value="1">Biggest price</option>
                            <option value="2">Smallest price</option>

                        </select>
                        <!--<input class = "col c-2" type="hidden" name="s1" value ="${s}">-->
                        <input class = "col l-2 m-2 c-6" type="number" name="priceFrom" placeholder="Nhập giá">
                        <input class = "col l-2 m-2 c-6" type="text" id = "nameP"name="nameP" placeholder="Nhập tên ">
                        <button style="background-color: #fff;" class = "col l-2 m-2 c-6" type="submit" value=""><i class="fa fa-search"></i></button>
                    </form>
                </div>
                <c:if test="${s != 1}">
                    <div class="col l-1 m-1 c-o-1 c-1 naviga  resgister">
                        <a class ="rg" href="register.jsp">Register</a>
                    </div>
                    <div class="col l-1 m-1 c-1  naviga login">
                        <a id ="lg" class ="lg" href="login.jsp">Login</a>
                    </div>
                </c:if>

            </div>
        </div>
        <!-- HEADER2 -->
        <div class="grid header " id="header">
            <div class="row grid wide navigation">
                <div class="col l-1 l-o-1  m-1 m-o-1 c-1 c-o-1 naviga">
                    <!-- <a href="#">HOME</a> -->
                    <a href="access">HOME</a>
                </div>
                <div class="col l-1 l-o-1 m-1 m-o-1 c-1 c-o-1 naviga">
                    <!-- <a href="#earphone">EARPHONE</a> -->
                    <a href="trans?trans=4">EARPHONE</a>
                </div>
                <div class="col l-1 l-o-1 m-1 m-o-1 c-1 c-o-1 naviga">
                    <!-- <a href="#keyboard">KEYBOARD</a> -->
                    <a href="trans?trans=1">KEYBOARD</a>
                </div>
                <div class="col l-1 l-o-1 m-1 m-o-1 c-1 c-o-1 naviga">
                    <!-- <a href="#mouse">MOUSE</a> -->
                    <a href="trans?trans=2">MOUSE</a>
                </div>
                <div class="col l-1 l-o-1 m-1 m-o-1 c-1 c-o-1 naviga">
                    <!-- <a href="#chair">CHAIR</a> -->
                    <a href="trans?trans=3">CHAIR</a>
                </div>
                <c:if test="${sessionScope.acc.role == 1 }">
                    <div class="col l-1 m-1 c-1  naviga ">
                        <!-- <a href="#chair">CHAIR</a> -->
                        <a href="shop">ADMIN</a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.acc.role != 1 }">
                    <div class="col l-1 m-1 c-1  naviga shopping-cart">
                        <i class="fa fa-shopping-cart"></i>
                        <c:if test="${s == 1}">
                            <h3 class="length_shop">${requestScope.length}</h3>
                        </c:if>
                    </div>
                </c:if>
            </div>
        </div>
        <!--user-->
        <c:if test="${s == 1}">

            <div class="user row ">

                <div class = "col l-10 m-10 c-10 row" >

                    <p style="font-size: 15px;" class = "col l-2 m-2 c-1" >${sessionScope.username}</p>


                </div>
                <i class="fa fa-user-circle col l-1 m-1 c-1" >
                    <ul class = "sub-profile" >
                        <li><a  href="profile">Profile</a>
                        </li>
                        <c:if test="${sessionScope.role == 0}">
                            <li><a href="url">Help</a></li>
                            </c:if>
                            <c:if test="${sessionScope.role == 1}">
                            <li><a href="InforShop">Shop</a></li>
                            </c:if>
                        <li><a href="logout?logout=ok">Exit</a></li>
                    </ul>
                </i>

            </div>
        </c:if>



        <!-- Body SLIDER -->
        <div class="grid wide slider_specail" id="slider">
            <div class="row slider" id="earphone">
                <!-- Tiêu đề -->
                <div class="col l-12 m-12 c-12 slider_top">
                    <h4>SẢN PHẨM</h4>
                </div>
                <div class="col l-1 m-12 c-12  form-search1 ">
                    <form action="sort" method="get" class ="row">
                        <input class ="ipt" type="hidden" name="trans" value ="5">
                        <select  id = "choiceType" class = "col l-12 m-12 c-12" id = "type" name ="sorttype">
                            <!--<option value="0">Default</option>-->
                            <option value="1">Increase Price</option>
                            <option value="2">Decrease Price</option>
                        </select>
                        <input  type="hidden" name="price" value ="4">
                        <!--                        <select class = "col l-12 m-5 c-12" name ="price" id = "priceType">
                                                    <option value="01">All</option>
                                                    <option value="0">< 1M</option>
                                                    <option value="1">> 1M</option>
                                                    <option value="2">> 3M</option>
                        
                                                </select>-->
                                                <input class = "col l-12 m-2 c-12" style="background: #fff;
                                                       cursor: pointer; padding: 5px;" type="submit" value="SORT">
                    </form>
                </div>

                <!-- Sản phẩm  -->
                <div class ="col  l-10 m-12 c-12 ">
                    <div class ="row">
                        <c:forEach items="${sessionScope.datas}" var="s">
                            <div class="col l-4 m-4 c-6 slider_heading  ">
                                <div class="">
                                    <form  action="add" method="get">
                                        <input type="hidden" name="trans1" value ="5"> 
                                        <input type="hidden" name="trans" value ="${s.category.id}"> 
                                        <div class="col l-12 m-12 c-12  slider_product">
                                            <img class ="slider_img"
                                                 src="${s.img}"
                                                 alt=""
                                                 />
                                            <input type="hidden" name="img" value ="${s.img}">

                                        </div>
                                        <div class="col l-12  m-12 c-12  slider_product">
                                            <h3>${s.title}</h3>
                                            <input type="hidden" name="title" value="${s.title}">
                                        </div>
                                        <div class="col l-12  m-12 c-12 slider_product">
                                            <p>Tai nghe không dây</p>
                                        </div>
                                        <div class="col l-12 m-12   slider_product">

                                            <h5 >${s.price1}</h5><a href="">đ</a>
                                            <input type="hidden" name="price" value = "${s.price}">
                                        </div>
                                        <div class="col l-12 m-12 c-12  slider_product btn_buy">
                                            <button type="submit">THÊM VÀO GIỎ HÀNG</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>


            </div>
        </div>

        <!-- Footer -->
        <!-- Footer -->
        <div class="grid footer">
            <div class="row" id="footer">
                <div class="col l-12 m-12 c-12 footer_heading footer_heading1 footer_heading2">
                    FIND ME ON
                </div>
                <div class="col l-12 m-12 c-12"> 
                    <a class ="" href="https://www.instagram.com/k1el2783/"
                       ><i class="fa fa-instagram "></i
                        ></a>
                </div> 
                <div class="col l-12 m-12 c-12"> 
                    <a class =""href="https://www.facebook.com/profile.php?id=100034859552099"
                       ><i class="fa fa-facebook "></i
                        ></a>
                </div> 
                <div class="col l-12 m-12 c-12"> 
                    <a class ="" href="https://www.youtube.com/channel/UC7vl90aldoU51_gpVzDJbYA"
                       ><i class="fa fa-youtube-play"></i
                        ></a>
                </div> 
                <div class="col l-12 m-12 c-12">Nguyễn Trung Kiên</div>
            </div>
        </div>

        <!-- modal-shopping-item -->
        <c:if test="${s == 1}">
            <div class="modal-shopping-item modal">

                <div class="row modal-container">
                    <div class="col item-footer1 l-4 l-o-1 m-4 m-o-1 c-4 c-o-1">
                        <button type="submit"><a href="shop">Xem Giỏ Hàng</a></button>
                    </div>
                    <div  class="modal-close-btn col item-footer12 l-4 l-o-1 m-4 m-o-1 c-4 c-o-1 ">
                        <button>CLOSE</button>
                    </div>
                    <div class="item-product col l-12 m-12 c-12">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>IMG</th>
                                    <th>TITLE</th>
                                    <th>PRICE</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.data1}" var = "s">
                                    <tr>
                                        <td>${s.id}</td>
                                        <td><img src="${s.img}" alt="alt"/></td>
                                        <td>${s.title}</td>
                                        <td>${s.price1}</td>

                                    </tr>
                                </c:forEach>

                            </tbody>

                        </table>
                    </div>



                </div>
            </div>
        </c:if>
        <script >
//        function submit(img, s, ipt,pt) {
//            window.location = "sort?" + img + "=" + s + "&trans=" + ipt + "&price=4";
//        }
////        ;
//        var pt = document.getElementById("priceType");
//        var ipt = document.querySelector(".ipt");
//        var st = document.getElementById("choiceType");
//         st.addEventListener("change", function () {
//            submit('sorttype', st.value, ipt.value);
//        });
//        st.addEventListener("change", function () {
//            submit('sorttype', st.value, ipt.value,pt.value);
//        });
//        pt.value = ${sessionScope.priceBefore};
//        st.value = ${sessionScope.choiceBefore};
        </script>
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                        function loadMore() {
                            var amount = document.getElementsByClassName("product").length;
                            $.ajax({
                                url: "/Project_banhang/load",
                                type: "get", //send it through get method
                                data: {
                                    exits: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
        </script> 
        <script>
            // nhấp nháy footer
//            var a = document.querySelector(".footer_heading");
//            setInterval(function () {
//                a.classList.toggle("footer_heading");
//            }, 1000);


            // đóng mở khối thồng tin về sản phẩm hàng
            var open_item = document.querySelector(".modal-shopping-item");
            function open_shoppingItem() {
                open_item.classList.toggle("open");
            }

            var shopping_item = document.querySelector(".fa-shopping-cart");
            shopping_item.addEventListener("click", open_shoppingItem);


            const modalClose = document.querySelector('.modal-close-btn');
            modalClose.addEventListener('click', open_shoppingItem);



        </script>
    </body>
</html>
