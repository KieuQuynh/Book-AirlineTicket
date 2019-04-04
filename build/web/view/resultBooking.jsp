<%-- 
    Document   : manageBook
    Created on : Mar 15, 2019, 9:09:06 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  href="./css/style.css">
        <link rel="stylesheet"  href="./css/manageBook.css">
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <div class="content">
                <div class="wrapper">
                    <div class="infoBox">
                        <%@include file="../view/infoBook.jsp" %>
                    </div>
                    
                </div> 
            </div>
        </div>
    </body>
</html>
