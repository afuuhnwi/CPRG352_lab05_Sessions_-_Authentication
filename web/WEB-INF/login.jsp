<%-- 
    Document   : login.jsp
    Created on : Oct 7, 2021, 1:41:14 PM
    Author     : 794974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="">
            <div>
            <label>Username; </label>
            <input type="text" name="username" value="${userObj.username}">
            </div>
             <div>
            <label>Password; </label>
            <input type="password" name="password" value="">
            </div>
            <input type="submit" value="Log in">
        </form>
        <c:if test="${errormessage}">
                <p>Invalid entry. Please enter a valid username and password!!</p>
            </c:if>
        <c:if test="${entrymessage}">
                <p>Invalid entry. Please enter a valid username and password!!</p>
        </c:if>
        <c:if test="${success}">
                <p>you have successfully logged out!!</p>
        </c:if>
    </body>
</html>
