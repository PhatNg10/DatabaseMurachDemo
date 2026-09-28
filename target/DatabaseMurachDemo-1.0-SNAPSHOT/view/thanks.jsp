<%-- 
    Document   : thanks
    Created on : Sep 21, 2026, 7:57:47 PM
    Author     : phatn
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/thanks.css">
        <title>Thank You</title>
    </head>
    <body>
        <h1>Thank you for joining our email list!</h1>

        <p>Thank you for joining our email list.</p>

        <p>
            Your information has been successfully added.
        </p>

        <p>
            Email: ${user.email}<br>
            First name: ${user.firstName}<br>
            Last name: ${user.lastName}
        </p>

        <p>
            <a href="${pageContext.request.contextPath}/EmailListServlet?action=add">
                Return to Email List
            </a>
        </p>
    </body>
</html>