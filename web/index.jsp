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
                width: 100%;
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
                font-size: 15px;
                padding-left: 5px;
                /* padding: 10px; */
            }
            .slider{
                margin-left: 12px;
                margin-right: 12px;
            }

            .btn_buy button{
                cursor: pointer;
                width: 100%;
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
                /*overflow: scroll;*/
                cursor: pointer;
            }
            .modal-shopping-item.open{
                display: block;
            }
            .modal-container{
                margin-top: 20px;
                margin-bottom: 20px;
            }
            .item-footer p{
                margin-top: 10px;
                padding-top: 5px;
                padding-bottom: 5px;
                font-size: 15px;
                cursor: pointer;
                margin-left: 30px;
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

            /*responsive*/
            @media (max-width: 1023px){
                .slider_heading h3,.slider_product p{
                    font-size: 10px;
                }
                .btn_buy button{
                    font-size: 12px;
                    width: 80%;
                }
                .slider_heading:hover h5,  .slider_heading:hover a{
                    font-size: 20px;
                    font-weight: 600;
                }

            }
            @media (max-width: 739px){
                .form-search{
                    /*margin-top: 5px;*/
                }
                .user {
/*                    position: absolute;
                    top: 10px;
                    right: 5%;
                    font-size: 50px;
                    color: #000;
                    cursor: pointer;*/
                }
                .logo img{
                    /*margin-top: 5px;*/
                }      
                .navigation .resgister{
                           /*margin-left: 10%;*/
                }
                .navigation .login{
                        /*margin-left: 10%;*/
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
                    <div class="col l-1 m-1  c-o-1 c-1 naviga  resgister">
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
            <div class="row slider">
                <div class="col l-12 m-12 c-12 slider_heading slider_specail-content">
                    <h1>DANH MỤC SẢN PHẨM</h1>
                </div>
                <div class="col l-10 m-10 c-9 pic-ctn">

                    <img src="./img/product1/12.webp" alt="" class="pic" />
                    <img src="./img/product2/6.png" alt="" class="pic" />
                    <img src="./img/product3/3.jpg" alt="" class="pic" />
                    <img
                        src="./img/product4/ghe-herman-miller-cosm-phien-ban-lung-cao-leaf-arm-15249.jpg"
                        alt=""
                        class="pic"
                        />
                    <%--<c:forEach items="${requestScope.data}" var ="dt">
                        <img src="${dt.img}" style="animation-delay: ${dt.id +4}s;" alt="" class="pic" />
                      
                    </c:forEach>--%>
                </div>
            </div>
            <!--EARPHONE -->
            <div class="row slider" id="earphone">
                <!-- Tiêu đề -->
                <div class="col l-12 m-12 c-12 slider_heading_content">
                    <h4>CÁC SẢN PHẨM MỚI</h4>
                </div>
                <!--SẢN PHẨM MỚI-->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="./img/product1/resizer (5).jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <h3 >DareU VH350se jack 3.5</h3>

                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <p>Tai nghe không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12   slider_product">
                            <h5 value="299000">299,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product btn_buy">
                            <a href="trans?trans=4"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12  slider_product">
                            <img
                                class="slider_img"
                                src="./img/product2/resizer (5).jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <h3 >Keycool KC84 B02 White Grey</h3>

                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <p>Bàn phím không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <h5 value="1449000">1,449,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 slider_product">
                            <img
                                class="slider_img"
                                src="./img/product3/resizer (5).jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <h3 >Logitech Ergo M575</h3>

                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <p>Chuột không dây</p>
                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <h5 value="890000">890,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 slider_product btn_buy">
                            <a href="trans?trans=2"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 slider_product">
                            <img
                                class="slider_img"
                                src="./img/product2/Vortex-BT66-(2).jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <h3 >Vortex BT66</h3>

                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <p>Bàn phím không dây</p>
                        </div>
                        <div class="col l-12 m-12 slider_product">
                            <h5 value="3200000">3,200,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <div class="col l-12 m-12 c-12  slider_heading_content">
                    <h4>CÁC SẢN PHẨM NỔI BẬT</h4>
                </div>
                <div class="col l-12 m-12 c-12 slider_top">
                    <h4>EARPHONE</h4>
                </div>
                <!-- Sản phẩm 1 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product1/637121948960271224_HASP-Tainghe-ivalue-00630784-2.webp"
                                alt=""
                                />

                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3 >Ivalue Y933</h3>

                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Tai nghe không dây</p>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product">
                            <h5 value="350000">350,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=4"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <!-- Sản phẩm 2 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product1/637121958918503274_HASP-Tainghe-ivalue-BT006-RED-00630786-3.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Ivalue BT008</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Tai nghe không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="450000">450,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=4"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm3 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product1/637121963723682419_HASP-Tainghe-ivalue-T1390-RED-Black-0063788-2.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Ivalue T-139</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Tai nghe chụp tai</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="404000">404,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=4"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 4 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product1/637224540254050984_anh-dai-dien.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Ivalue M-13</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Tai nghe nhét tai</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="250000">250,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product btn_buy">
                            <a href="trans?trans=4"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
            </div>

            <!--END EARPHONE -->

            <!--KEYBOARD -->
            <div class="row slider" id="keyboard">
                <!-- Tiêu đề -->
                <div class="col l-12 m-12 c-12 slider_top">
                    <h4>KEYBOARD</h4>
                </div>
                <!-- Sản phẩm 1 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img class="slider_img" src="img/product2/2.webp" alt="" />
                        </div>
                        <div class="col l-12 m-12 c-12  slider_product">
                            <h3>DARE-U EK1280 Black Brown</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Bàn phím có dây</p>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product">
                            <h5 value="829000">829,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <!-- Sản phẩm 2 -->
                <div class="col l-3 m-3 c-6  slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product2/637746497683112724_00788801-6.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Gaming Prolink GMK-6001M</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Bàn phím có dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="600000">600,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 3 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img class="slider_img" src="img/product2/1.webp" alt="" />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Magic Keyboard 2021 Touch ID</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Bàn phím không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="3899000">3,899,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 4 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product2/637620331934374889_PROLiNK PCWM-7003 (1).webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Prolink PCWM7003</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Bàn phím có dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="450000">450,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=1"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--END KEYBOARD -->

            <!--MOUSE -->
            <div class="row slider" id="mouse">
                <!-- Tiêu đề -->
                <div class="col l-12 m-12 c-12 slider_top">
                    <h4>MOUSE</h4>
                </div>
                <!-- Sản phẩm 1 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product3/637418984502900576_M221.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Logitech M221</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Chuột không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="319000">319,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=2"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <!-- Sản phẩm 2 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product3/637114960259389596_Microsoft Modern (3) bia.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Bluetooth Microsoft Modern</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Chuột không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="900000">900,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=2"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 3 -->
                <div class="col l-3 m-3 c-6  slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product3/637830484484623519_chuot-magic-mouse-2-2022-den-dd.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Magic Mouse 2 2022</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Chuột không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="2691000">2,691,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=2"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 4 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product3/637750810643666468_chuot-khong-day-xiaomi-mi-dual-mode-wireless-dd.webp"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>Xiaomi Mi Dual Mode Wireless</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Chuột không dây</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="290000">290,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=2"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--END MOUSE -->

            <!--CHAIR -->
            <div class="row slider" id="chair">
                <!-- Tiêu đề -->
                <div class="col l-12 m-12 c-12 slider_top">
                    <h4>CHAIR</h4>
                </div>
                <!-- Sản phẩm 1 -->
                <div class="col l-3 m-3  c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product4/ghe-herman-miller-cosm-phien-ban-lung-cao-leaf-arm-15249.jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>SMA Spider 01 - SP01</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Ghế công thái học</p>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product">
                            <h5 value="2650000">2,650,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=3"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
                <!-- Sản phẩm 2 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product4/ghe-van-phong-cong-thai-hoc-sma-ergonomic-05-e05-14307.jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>SMA Ergonomic 05 - E05</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Ghế công thái học</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="8500000">8,500,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=3"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 3 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product4/ghe-cong-thai-hoc-tech-h-15483.jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>SMA Tech H</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Ghế công thái học</p>
                        </div>
                        <div class="col l-12  m-12 c-12 slider_product">
                            <h5 value="2650000">2,650,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12  c-12 slider_product btn_buy">
                            <a href="trans?trans=3"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>

                <!-- Sản phẩm 4 -->
                <div class="col l-3 m-3 c-6 slider_heading">
                    <div class="row">
                        <div class="col l-12 m-12 c-12 slider_product">
                            <img
                                class="slider_img"
                                src="img/product4/ghe-cong-thai-hoc-sma-life-02-15399.jpg"
                                alt=""
                                />
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h3>SMA Life 02</h3>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <p>Ghế công thái học</p>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product">
                            <h5 value="5500000">5,500,000</h5>
                            <a href="">đ</a>
                        </div>
                        <div class="col l-12 m-12 c-12 slider_product btn_buy">
                            <a href="trans?trans=3"><button type="button">SẢN PHẨM</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <!--END CHAIR -->
        </div>

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
        <div class="modal-shopping-item">
            <div class="row modal-container">

                    <div class="col item-footer1 l-4 l-o-1 m-4 m-o-1 c-4 c-o-1">
                        <button type="submit"><a href="shop">Xem Giỏ Hàng</a></button>
                    </div>
                    <div  class="modal-close-btn col item-footer12 l-4 l-o-1 m-4 m-o-1 c-4 c-o-1 ">
                        <button>CLOSE</button>
                    </div>
                  
                </div>

        </div>
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
