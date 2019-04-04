<%-- 
    Document   : login
    Created on : Mar 13, 2019, 3:24:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Email : <input type="text" name="email" value="${param.email}"/>${errorEmail}</br>
            Password: <input type="password" name="password"value="${param.password}"/>${errorPass}
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
