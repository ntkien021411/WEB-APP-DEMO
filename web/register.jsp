<%-- 
    Document   : register
    Created on : May 28, 2022, 3:59:55 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel="stylesheet" href="./css/grid.css" />
<link rel="stylesheet" href="./css/login.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <style>
            .sign-form1{

                width: 120%;
                height: 90%;
                /* background-color: aqua; */
                position: absolute;
                top: 10%;
                left: 20%;

            }
            @keyframes move {
                from{
                    transform: translateY(-700px);
                }
                to{
                    transform: translateY(0);
                }
            }
            .warn-form1{
                position: absolute;
                top: 85%;
                left: 35%;
                font-size: 20px;
                animation-name: move;
                animation-delay: 0.3s;
                animation-duration: 1s;
            }
            .choice{
                font-size: 15px;
                margin-top: -23px;
            }
        </style>
    </head>
    <body>

        <div class="row sign-form1">
            <div class ="col c-6 register-form">
                <form action="register" method="post">
                    <div class="row sign-in">
                        <h3 class = "col c-11">Sign up to Website</h3>
                    </div>
                    <div class="row label1">
                        <label class = "col c-10" for="user">USERNAME</label>
                        <input class = "col c-10" type="text" name="user1" id="user" placeholder="username" required>
                    </div>
                    <div class="row label2">
                        <label class = "col c-10" for="pass">PASSWORD</label>
                        <input class = "col c-10" type="password" name="pass1" id="pass" placeholder="password" >
                    </div>

                    <div class="row label2">
                        <label class = "col c-10" for="repass">RE-PASSWORD</label>
                        <input class = "col c-10" type="password" name="repass1" id="repass" placeholder="repassword" required>
                    </div>
                    <div class="row label2">
                        <label class ="choice"  for="u">User</label>
                        <input  class ="role"  value = "0" type="radio"  name="choice" id="u"  required>
                        <label class ="choice"   for="a">Admin</label>
                        <input class ="role"    value = "1"  type="radio"  name="choice" id="a" required>
                    </div>
                    <div class="row btn-sign-in">
                        <button class = "col c-10"type="submit">SIGN IN</button>
                    </div>

                </form>

            </div>

        </div>
        <%
if(request.getAttribute("warning")!=null){
String er = (String)request.getAttribute("warning");
String e1 = (String)request.getAttribute("note");
        %>

        <div class ="warn-form1">
            <h3 style="color:red"><%= er %></h3>
            <h3 style="color:red"><%= e1 %></h3>
        </div>
        <%
            }
        %>


    </body>
</html>
