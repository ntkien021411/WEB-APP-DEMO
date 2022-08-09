<%-- 
    Document   : profile
    Created on : Jun 8, 2022, 4:41:46 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/grid.css" />
        <!--<link rel="stylesheet" href="./css/style.css" />-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                font-size: 80px;
                display: inline;
                text-align: center;
            }
            .infor{
                display: inline;
                /*text-align: center;*/
                margin-top: 25px;
                font-size: 30px;
                border-right: 2px solid #aaa;
                border-left:2px solid #aaa;
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
                margin-left: 30px;
                font-family: monospace;
            }
            .header-infor{
                margin-top: 90px;
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
            /*responsive*/
            @media(max-width: 1023px){
                .content label{
                    font-size: 20px;
                }
                .warn{
                    font-size: 20px;
                }
                .change{
                    margin-left: 295px;
                }
                .btn a{
                    padding: 20px;
                    font-size: 15px;
                }
                .user .icon{
                    font-size: 50px;
                }
                .user-name{
                    font-size: 15px;
                }
            }
        </style>
    </head>
    <body>

        <%--<c:set var ="s" value="${s}" />--%>
        <div class = "grid header-infor">
            <div class = "row grid wide ">
                <div class="user col c-3 row ">
                    <i class="fa fa-user-circle icon " >
                    </i>
                    <h1 class = "user-name "> ${sessionScope.username}</h1>
                </div>
                <div class="infor col c-7 row">
                    <h3 class = "col c-12"> Thông Tin </h3>
                    <h4 class ="warn col c-12"
                        style="text-align: center;
                        margin-top: 30px;
                        color: red;"> ${requestScope.note}</h4>
                    <form action="changeP" class = "col c-12 row form" >
                        <div class ="content col c-12 row">
                            <label class = "col c-5">UserName</label>
                            <input  class = "col c-o-2 c-5"type="text" name="userName" value="${sessionScope.username}" readonly="" >
                        </div>
                        <div class ="content col c-12 row">
                            <label class = "col c-5">OldPassWord</label>
                            <input  class = "col c-o-2 c-5"type="password" name="OldPassWord" required>
                        </div>
                        <div class ="content col c-12 row">
                            <label class = "col c-5">NewPassWord</label>
                            <input  class = "col c-o-2 c-5"type="password" name="NewPassWord" required>
                        </div>
                        <div class ="content col c-12 row">
                            <label class = "col c-5">ReNewPassWord</label>
                            <input  class = "col c-o-2 c-5"type="password" name="ReNewPassWord" required>
                        </div>

                        <button type="submit" class ="col  c-3 change">CHANGE</button>
                    </form>
                    <h4 class ="warn col c-12"
                        style="text-align: center;
                        color: red;">${requestScope.warn}</h4>

                </div>
                <div class="btn col  c-2 btn_submit">
                    <button type="button"><a href="access">HOME</a></button>
                </div>
            </div>


        </div>
    </body>
</html>
