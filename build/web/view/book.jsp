<%-- 
    Document   : book
    Created on : Mar 13, 2019, 5:00:53 PM
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
        <link rel="stylesheet"  href="./css/book.css">

    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <div class="content">
                <div class="wrapper">

                    <c:if test="${resultSearch eq ''}">
                        <form action="book" method="POST">
                            <div class="addressFlight">
                                <span>Departure :</span>${from.getName()}<span>Return :</span>${to.getName()}
                            </div>
                            <div class="infoFlight">
                                <h1>Select Departing Flight</h1> 

                                <div class="item">
                                    <h2>${from.getName()}<span>to</span> ${to.getName()}</h2>

                                    <div class="time">${param.departure}</div>
                                    <table>
                                        <thead>
                                            <tr>
                                                <td>Departs</td>
                                                <td>Arrives</td>
                                                <td>Flight Detail</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="s">
                                                <tr>
                                                    <td>${s.getDepart()}</td>
                                                    <td>${s.getArrival()}</td>
                                                    <td>${s.getRoundTime()}</td>
                                                    <td><div class="chooseInfo">
                                                            <input type="radio"
                                                                   name="choose1" value="${s.getID()}"/><span class="price">$ ${s.getPrice()}</span>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                                <c:if test="${param.typeTrip eq 'roundTrip'}">
                                    <div class="item">
                                        <h2>${to.getName()}<span>to</span> ${from.getName()}</h2>
                                        <div class="time">${param.returns}</div>   
                                        <table>
                                            <thead>
                                                <tr>
                                                    <td>Departs</td>
                                                    <td>Arrives</td>
                                                    <td>Flight Detail</td>
                                                    <td></td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${list2}" var="s">
                                                    <tr>
                                                        <td>${s.getDepart()}</td>
                                                        <td>${s.getArrival()}</td>
                                                        <td>${s.getRoundTime()}</td>
                                                        <td><div class="chooseInfo">
                                                                <input type="radio" 
                                                                       name="choose2" value="${s.getID()}"/><span class="price">$ ${s.getPrice()}</span>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table> 
                                    </div>

                                </c:if> 
                                <input type="submit" value="Save"class="btnSubmit"/>

                            </div>
                        </form>
                    </c:if>  
                    <c:if test="${resultSearch ne ''}">
                        <div class="errorSearch">${resultSearch}</div>
                    </c:if>
                </div>

            </div>
        </div>
    </body>
</html> 
