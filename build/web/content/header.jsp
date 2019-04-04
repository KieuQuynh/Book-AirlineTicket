<%-- 
    Document   : header
    Created on : Mar 3, 2019, 9:13:58 PM
    Author     : admin
--%>


        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
            <div class="icon">
                
                <div class="logo">
                    <div class="itemLogo ${sessionScope.name eq null ? 'login':'user'}"></div>
                    <c:if test="${sessionScope.name eq null}">
                         <div><a href="login">Login</a></div>
                    </c:if>
                    <c:if test="${sessionScope.name ne null}">
                         <div><a href="">${sessionScope.name}</a></div>
                    </c:if>
                    
                </div>
                
                <div class="logo right">
                    <div class="itemLogo ${sessionScope.name eq null ? 'register':'logout'}"></div>
                     <c:if test="${sessionScope.name eq null}">
                         <div><a href="register">Register</a></div>
                    </c:if>
                    <c:if test="${sessionScope.name ne null}">
                         <div><a href="logout">Logout</a></div>
                    </c:if>
                </div>
                <div class="clear"></div>
            </div>
            <div class="title">
                Fast,Frequent & Safe Flights
            </div>
            <div class="nav">
                 <ul class="menu">
                    <li ><a href="home" class='${active== 'home' ? 'active':'' }'>Home</a></li>
                    <li><span href="search"  class ='${active== 'book' ? 'active':'' }'>Booking</span></li>
                    <li><a href="manage" class ='${active== 'manage' ? 'active':'' }'>Manage Booking</a></li>
                </ul>
            </div>
        </div>
 