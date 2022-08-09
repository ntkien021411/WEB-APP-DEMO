<%-- 
    Document   : login
    Created on : May 28, 2022, 3:59:51 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/logo/logo-K-3.png" type="image/x-icon" />
        <link rel="stylesheet" href="./css/grid.css" />
        <link rel="stylesheet" href="./css/login.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Sign In</title>

        <style>
            html{
                scroll-behavior: smooth;
            }

            @keyframes move {
                from{
                    transform: translateY(-500px);
                }
                to{
                    transform: translateY(0);
                }
            }
            .warn-form{
                width: 30%;
                height: 20%;
                position: absolute;
                top: 540px;
                left: 250px;
                z-index: 1;
                animation-name: move;
                animation-delay: 0.3s;
                animation-duration: 1s;
                font-size: 20px;
            }

            .warn-form h3{
                font-size: 25px;
            }
        </style>

    </head>
    <body>

        <div class ="warn-form">
            <h3 style="color:red">${requestScope.error}</h3>
            <h3 style="color:red">${requestScope.success}</h3>
            <h3 style="color:red">${requestScope.note}</h3>
        </div>

        <%
//     Cookie[] listCookie = request.getCookies();
//     String user = "";
//     String pass = "";
//     int co = 0;
//     if(listCookie != null){
//        while(co < listCookie.length){
//          if(listCookie[co].getName().equals("user")){
//            user = listCookie[co].getValue();
//           }
//          if(listCookie[co].getName().equals("pass")){
//            pass = listCookie[co].getValue();
//           }
//          co++;
//        }
//  
//      }
        %>
        <div class="row sign-form">
            <div class ="col c-6 login-form">
                <form action="login" method="post">
                    <div class="row sign-in">
                        <h3 class = "col c-11">Sign in to Website</h3>
                    </div>
                    <div class="row label1">
                        <label class = "col c-10" for="user">USERNAME</label>
                        <input class = "col c-10" type="text" value="${cookie.user.value}" name="user" id="user" placeholder="username" required checked>
                    </div>
                    <div class="row label2">
                        <label class = "col c-10" for="pass">PASSWORD</label>
                        <input class = "col c-10" type="password" value="${cookie.pass.value}" name="pass" id="pass" placeholder="password" required>
                    </div>
                    <div class="row " style="margin-left: 10px;">
                        <input  type="checkbox" id ="check" name="check" value ="ON" ${cookie.pass != null?'checked':''}>
                        <label  style="
                                font-size: 15px;"for="check">Remember to me</label>
                    </div>
                    <div class="row btn-sign-in">
                        <button class = "col c-10"type="submit" >SIGN IN</button>
                    </div>
                </form>

            </div>
            <div class ="col c-6 register-form">
                <div class="row header1">
                    <h3 class = "col c-11">Hello Friend !</h3></div>
                <div class="row header2">
                    <h5 class = "col c-11">Enter your personal details and start journey with us</h5>
                </div>
                <div class="row btn-sign-up">
                    <button class = "col c-10" ><a href="register.jsp">SIGN UP</a></button>
                </div>
            </div>
        </div>




    </body>
</html>
