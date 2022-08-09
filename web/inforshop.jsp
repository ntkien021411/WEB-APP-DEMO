<%-- 
    Documclass="col c-12 btn-choice" ent   : inforshop
    Created on : Jul 9, 2022, 10:12:46 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/grid.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
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

            .user .icon{
                margin-left: 20px;
                font-size: 60px;
                display: inline;
                text-align: center;
            }
            .infor{
                display: inline;
                /*text-align: center;*/
                height: 600px;
                margin-top: 25px;
                font-size: 30px;
                border-right: 2px solid #aaa;
                border-left:2px solid #aaa;
                border-bottom: 2px solid #aaa;
            }
            .infor h3{
                text-align: center;
            }
            .btn a{
                text-decoration: none;
                color: black;
                padding: 40px;
                font-size: 20px;
            }
            .btn{
                margin-top: 25px;
            }

            .user-name{
                margin-top: 25px;
                margin-left: 20px;
                font-family: monospace;
            }
            .header-infor{
                margin-top: 50px;
            }

            .change{

                margin-left: 365px;
                margin-top: 10px;
                padding: 5px;
                font-size: 15px;
            }
            .btn_submit{
                margin-left: 20px;
            }
            /*            .content{
                            width: 100%;
                            
                        }
                        .content input{
                            width: 70%;
                        }
                        .content label{
                            width: 30%;
                        }*/
            .content{
                margin: 10px 0;
            }
            .form{
                margin-top: 30px;
            }
            .btn-choice button{
                font-size: 15px;
                padding: 10px 10px;
                background: #fff;
                border: none;
                cursor: pointer;
                /*text-align: center;*/
                /*color: #fff;*/
                border: 2px solid black;
                /*margin-bottom: 20px;*/
                margin-left: 10px;

            }
            .userInfor{
                height: 250px;
                margin-bottom: 10px;
                border: 2px solid black;
                border-radius: 30px;
                margin-left:  40px;
            }

            .userInfor img {
                width: 40%;
                margin-left: 25%;
                position: relative;
                top: 20px;
            }

            .chart input{
                transform: rotate(-90deg);
                width: 350px;
                height: 100%;
                cursor: pointer;

            }
            .chart{
                position: relative;
                top: 130px;
                /*margin-right: 40px;*/
            }
            .content-chart{
                position: relative;
                top: 125px;
                left: 165px;
                font-size: 25px;
            }
            .chart-interpret{
                position: relative;
                top: 130px;
            }
            .content-interpret{
                font-size: 17px;
                font-style: italic;
                margin-bottom: 15px;
            }
            .max-chart{
                left: 150px;
                position: relative;
                top: -120px;

            }
            @media (max-width: 1112px){
                .chart {
                    position: relative;
                    top: -50px;
                    /* margin-right: 40px; */
                    margin-right: 20px;
                    right: -100px;

                }
                .chart-interpret {
                    position: relative;
                    top: -140px;
                    right: -140px;
                }


            }
            @media (max-width: 1113px){

                .userInfor {
                    height: 250px;
                    margin-bottom: 10px;
                    border: 2px solid black;
                    border-radius: 30px;
                    margin-left: 40px;
                    position: relative;
                    top: -200px;
                    left: 100px;
                }

            }
        </style>
    </head>
    <body>
        <div class = "grid header-infor">
            <div class = "row grid  ">
                <div class="user col l-2 m-2 c-2  ">
                    <i class="fa fa-user-circle icon " >
                    </i>
                    <h1 class = "user-name "> ${sessionScope.username}</h1>
                </div>

                <div class="infor col l-8 m-8 c-8 ">
                    <div class ="row">
                        <h3 class = "col l-12 m-12 c-12">THỐNG KÊ</h3>

                        <div class ="col l-2 m-12 c-1 " style="
                             margin-right: 20px;
                             margin-top: 50px;">
                            <form class=" btn-choice" action="InforShop" method="get">
                                <button  type="submit"><i class="fa fa-user-o" aria-hidden="true"></i></button>
                            </form>
                            <form style=" margin-top: 80px;" class=" btn-choice" action="InforShop" method="post">
                                <button  type="submit"><i class="fa fa-bar-chart" aria-hidden="true"></i></button>
                            </form>

                        </div>
                        <div class ="col  l-9 m-9 c-9  " style=" margin-top: 20px;">
                            <div class ="row">
                                <c:if test="${sessionScope.role == 1}">
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">số lượng người dùng: ${sessionScope.userQ}</p>
                                            <img  src="./img/login/avatar.png"  alt="đây là ảnh user"/>
                                        </div>
                                    </div>
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">sản phẩm bán chạy: ${sessionScope.qP} sản phẩm</p>
                                            <img src="${sessionScope.imgP}"  alt="đây là ảnh product"/>
                                        </div>

                                    </div>
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">số lượng đơn hàng: ${sessionScope.orderQ}</p>
                                            <img src="./img/login/order.jpg"  height="height" alt="đây là ảnh order"/>
                                        </div>

                                    </div>
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">số lượng sản phẩm: ${sessionScope.allPQ}</p>
                                            <img src="./img/login/product.jpg"   alt="đây là ảnh quantity product"/>
                                        </div>

                                    </div>
                                            <c:set value="${sessionScope.maxP}" var="max" />
                                           <c:set value="${sessionScope.minP}" var="min" /> 
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">sản phẩm giá cao nhất: ${max.price1}</p>
                                            <img src="${max.img}"   alt="đây là ảnh quantity product"/>
                                        </div>

                                    </div>
                                    <div class=" col l-3 m-3 c-6 userInfor" >
                                        <div class = "row">
                                            <p style="font-size: 20px;margin-top: 10px;" class = "col l-12">sản phẩm giá thấp nhất: ${min.price1}</p>
                                            <img src="${min.img}"   alt="đây là ảnh quantity product"/>
                                        </div>

                                    </div>

                                </c:if>

                                <c:if test="${sessionScope.role == 0}">


                                    <div class ="col l-2 m-2 c-2">
                                        <div class ="row">
                                            <div class=" col l-12 m-12 c-12  chart-interpret" >
                                                <p class ="content-interpret" >1: <i>user take order / user have in list</i> </p>
                                            </div>
                                            <div class=" col l-12 m-12 c-12  chart-interpret" >
                                                <p class ="content-interpret" >2:<i>product order / list product</i></p>
                                            </div>
                                            <div class=" col l-12 m-12 c-12  chart-interpret" >
                                                <p class ="content-interpret" >3:<i>order overtargets > 2M VND</i></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class=" col l-8 m-8 c-8 ">
                                        <div class ="row">
                                            <div class=" col l-3 m-3 c-3  chart" >
                                                <p class ="max-chart" >${sessionScope.userTakeOrder}%</p>
                                                <input id="" type="range" value="${sessionScope.userTakeOrder}" min="1" max="100" />
                                                <p class ="content-chart" >1</p>
                                            </div>
                                            <div class=" col l-3 m-3 c-3 chart" >
                                                <p class ="max-chart" >${sessionScope.productOrder}%</p>
                                                <input id="" type="range" value="${sessionScope.productOrder}" min="1" max="100" />
                                                <p class ="content-chart" >2</p>
                                            </div>
                                            <div class=" col l-3 m-3 c-3 chart" >
                                                <p class ="max-chart" >${sessionScope.orderOverTarget}%</p>
                                                <input id="" type="range" value="${sessionScope.orderOverTarget}" min="1" max="100" />
                                                <p class ="content-chart" >3</p>
                                            </div>
                                        </div>

                                    </div>



                                </c:if>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="btn col  l-1  m-1 c-11 btn_submit ">
                    <button type="button"><a href="access">HOME</a></button>
                </div>

            </div>


        </div>
    </body>
</html>
