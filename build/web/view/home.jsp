<%-- 
    Document   : home
    Created on : Mar 3, 2019, 10:20:02 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet"  href="css/style.css">  
              <link rel="stylesheet" href="css/home.css">
              <script src="JS/js.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <div class="content">
                <form class="table" action="search" method="GET">
                    <div class="nameTable">
                        Flight
                    </div>
                    <div class="contentTable">
                        <div class="option">
                        
                            <div class="optionInput">  <input type="radio" name="typeTrip" value="roundTrip" checked id="roundtrip"> Round Trip </div>
                            <div class="optionInput"> <input type="radio" name="typeTrip" value="oneTrip" ${param.typeTrip eq 'oneTrip' ? 'checked':''} id="onetrip" > One Trip</div>
                        </div>
                        <table class="box">
                            <tbody>
                                <tr>
                                    <td>
                                        From : 
                                    </td>
                                    <td>
                                       
                                        <select id="from" name="from" >
                                           
                                            <c:forEach items="${list1}" var="s">
                                                <option value="${s.getID()}" ${param.from eq s.getID() ? 'selected':''} >${s.getName()}</option>
                                            </c:forEach>
                                         </select>
                                     
                                    </td>
                                </tr>
                                <tr>
                                      <td>
                                        To : 
                                    </td>
                                    <td>
                                     
                                         <select  name="to">
                                            
                                            <c:forEach items="${list2}" var="s">
                                                
                                                <option value="${s.getID()}" ${param.to eq s.getID() ? 'selected':''} >${s.getName()}</option>
                                            </c:forEach>
                                         </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Departure</td>
                                    <td> <input type="date" name="departure" id="departure" value="${param.departure}"/> 
                                        <c:if test="${param.departure eq ''}">
                                            <span class="myError">${errorData}</span>
                                        </c:if>
                                        
                                    </td> 
                                     
                                </tr>
                                
                                <tr>
                                    <td>Return</td>
                                    <td> <input type="date" name="returns"  id="return" min="2019-03-13"  value="${param.returns}"/>
                                        <c:if test="${param.typeTrip eq 'roundTrip' && param.returns eq ''}">
                                            <span class="myError">${errorData}</span>
                                        </c:if>
                                        
                                    </td>
                                </tr>
                           
                            </tbody>
                        </table>
                        <div class="myError">  ${myError} <div>
                        <div class="myError">  ${errorDate} <div>
                        <div class="myError">  ${errorReturnDate} <div>
                         <input type="submit" id="btn1" value="Search" class="btn"/>
                    </div>
                   
                </form>
            </div>
        </div>
    </body>
</html>
