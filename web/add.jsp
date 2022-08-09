<%-- 
    Document   : update
    Created on : Jun 1, 2022, 4:26:18 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .update-box{
                width: 60%;
                 color: #fff;
                margin: auto;
                height: 400px;
                margin-top: 10%;
                text-align: center;
     background-image: url(./img/login/pexels-photo-2469122.jpeg);
            }
            label{
                font-size: 20px;
                 margin-right: 70px;
               
            }
            #lb1{
                margin-left: 50px;
            }
            input{
                margin-top: 10px;
                margin-bottom: 10px;
            }
             body{
                background-color: #f1f1f1;
            }
            #smit_btn{
                    width: 40%;
                    font-weight: 700;
                    cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class = "update-box">
            <h1>Add a product</h1>
          
         <form action="addByAdmin" method="post">
                <label for = "lb6" >Enter amount </label>
                <input id = "lb6" type="number"  name="amount" > <br>
                <label for = "lb1" >Enter id:</label>
                <input id = "lb1" type="number"  name="id" > <br>
                <label for = "lb2" >Enter img:</label>
                <input id = "lb2" type="file"  name="img1" > <br>
                <label for = "lb3" >Enter title:</label>
                <input id = "lb3" type="text"  name="title" > <br>
                <label for = "lb4" >Enter price:</label>
                <input id = "lb4" type="number"  name="price"> <br>
                <label for = "lb4" >Enter type</label>
                <select name ="type">
                    <option value="1">Keyboard</option>
                    <option value="2">Mouse</option>
                    <option value="3">Chair</option>
                    <option value="4">Earphone</option>
                </select><br>

           
            <input id = "smit_btn" type="submit" value = "ADD">
        </form>
         <h1>${requestScope.error}</h1>
        </div>
    </body>
</html>
