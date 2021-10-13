<%-- 
    Document   : home.jsp
    Created on : Oct 7, 2021, 1:55:20 PM
    Author     : 794974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <div>
        <h2></h2>
        </div>
        <h2>Hello ${username}</h2>
        <div>
            <a href="login?logout" value="logout" name="logout">Logout</a>
        </div>
    </body>
</html>
