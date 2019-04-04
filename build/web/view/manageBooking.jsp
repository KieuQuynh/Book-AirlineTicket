<%-- 
    Document   : manageBooking
    Created on : Mar 16, 2019, 4:27:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:if test="${param.typeSearch eq null}">
                        <%@include file="../view/searchBooking.jsp" %>
                    </c:if>
                    <c:if test="${param.typeSearch ne null}">
                       
                        <%@include file="../view/infoBook.jsp" %>
                    </c:if> 
                </div>
            </div>
        </div>
    
        
    </body>
</html>
