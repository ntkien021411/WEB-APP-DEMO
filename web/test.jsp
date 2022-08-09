<%-- 
    Document   : test
    Created on : Jul 6, 2022, 9:22:30 PM
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
        <link rel="stylesheet" href="./css/grid.css" />
        <title>JSP Page</title>

    </head>
    <body >

    </head>

    <!-- Body SLIDER -->
    <div class="grid wide slider_specail" id="slider">
        <div class="row slider" id="earphone">
            <!-- Tiêu đề -->
            <div class="col l-12 m-12 c-12 slider_top">
                <h4>EARPHONE</h4>
            </div>
            <div class="col l-1 m-12 c-12  form-search1 ">
                <form action="test" method="get" class ="row">
                    <input class ="ipt" type="hidden" name="trans" value ="3">
                    <input type="text" name="name">
                    <input class = "col l-12 m-2 c-12" style="background: #fff;
                           cursor: pointer; padding: 5px;" type="submit" value="SORT">
                </form>
            </div>

            <!-- Sản phẩm  -->
            <div class ="col  l-10 m-12 c-12 ">
                <div class ="row">
                    <c:forEach items="${requestScope.sa}" var="s">
                        <div class="col l-3 m-3 c-6 slider_heading  ">
                            <div class="">
                                <h1>${sa.accountuser}</h1>
                                 <h1>${sa.passuser}</h1>
                                  <h1>${sa.role}</h1>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>


        </div>
    </div>
    <h3>${param.sorttype}</h3>
    <script type="text/javascript">
        function doDelete(img, s, ipt) {
            window.location = "test?" + img + "=" + s + "&trans=" + ipt;
        }
        ;
        var ipt = document.querySelector(".ipt");
        var st = document.getElementById("type");
        st.addEventListener("change", function () {
            doDelete('img', st.value, ipt.value);
        });
        st.value = ${sessionScope.sa};

    </script>
</body>
</html>
