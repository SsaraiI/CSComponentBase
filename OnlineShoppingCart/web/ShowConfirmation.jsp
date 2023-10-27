<%-- 
    Document   : ShowComfirmation
    Created on : Oct 27, 2023, 9:16:51 AM
    Author     : iarsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        body {
          background-color: black;
          color: white;
        }
        a {
            color: white; 
        }

        a:visited {
            color: white;
        }
          
        a:hover {
            color: lightgray;
        }
        img {
            height: 400px;
        }
    </style>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <center>
            <h1>Your Order is confirmed!</h1>
            <h1>The total amout is $<%= request.getAttribute("totalPrice") %></h1>
            <a href = "index.jsp">Back to First Page</a>
            <h1><img src="https://media.tenor.com/oslAUCxTbO4AAAAd/rock-sus.gif" alt="A GIF image"></h1>
         </center>
    </body>
</html>
