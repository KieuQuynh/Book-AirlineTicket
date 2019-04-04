<%-- 
    Document   : register
    Created on : Mar 18, 2019, 8:30:17 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet"  href="css/style.css">
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <div class="content">
                <div class="wrapper">
                    <h1>Register</h1>
                    <form action="register" method="POST"> 
                        <h3>New Account</h3>
                        <table>
                            <tbody>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="text" name="email" value="${param.email}"/> ${errorEmail}</td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input type="password" name="password" value="${param.password}"/>${errorData}</td>
                                </tr>
                                <tr>
                                    <td>Verify Password:</td>
                                    <td><input type="password" name="verifypassword" value="${param.verifypassword}"/>${errorData} ${errorPass}</td>
                                </tr>
                            </tbody>
                        </table> 
                                
                        <h3>Contact Information</h3>
                        <table>
                            <tbody>
                                <tr>
                                    <td>FristName</td>
                                    <td><input type="text" name="firstName" value="${param.firstName}"/>${errorData}</td>
                                </tr>
                                <tr>
                                    <td>LastName:</td>
                                    <td><input type="text" name="lastName" value="${param.lastName}"/>${errorData}</td>
                                </tr>
                                <tr>
                                    <td>Address:</td>
                                    <td><input type="text" name="address" value="${param.address}"/>${errorData}</td>
                                </tr>
                                <tr>
                                    <td>Phone Number:</td>
                                    <td><input type="text" name="phoneNumber" value="${param.phoneNumber}"/>${errorData}</td>
                                </tr>
                                <tr>
                                    <select name="sex">
                                        <option value="1">Male</option>
                                        <option value="2">Female</option>
                                    </select>
                                </tr>
                                <tr>
                                    <td>Age:</td>
                                    <td><input type="number" name="age" min="0" value="${param.age}"/>${errorData}</td>
                                </tr>
                                 <tr>
                                    <td>Card Number:</td>
                                    <td><input type="text" name="cardNumber" value="${param.cardNumber}"/>${errorData}</td>
                                </tr>
                                
                                
                            </tbody>
                        </table> 
                                <input type="submit" value="submit"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
