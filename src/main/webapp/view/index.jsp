<%-- 
    Document   : main
    Created on : Sep 21, 2026, 9:37:25 AM
    Author     : phatn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
        <title>Email Database Demo</title>
    </head>
    <body>
        <h1>Join our email list</h1>
        <p>To Join our email list enter your name and email address below</p>
        <p class="message"><i>${message}</i></p>
        <form action="${pageContext.request.contextPath}/EmailListServlet" method="post">
            <input type="hidden" name="action" value="add">
            
            <label class="pad_top">Email:</label>
            <input type="email" name="email" value="${user.email}" required><br>
            
            <label class="pad_top">First_name:</label>
            <input type="text" name="firstName" value="${user.firstName}" required><br>
            
            <label class="pad_top">Last name:</label>
            <input type="text" name="lastName" value="${user.lastName}" required><br>
            
            <label>&nbsp;</label>
            <input type="submit" value="Join Now" class="margin_left">
        </form>
    </body>
</html>
