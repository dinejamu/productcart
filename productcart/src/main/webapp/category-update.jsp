<%--
    Document   : category-form
    Created on : Jun 13, 2017, 6:00:41 PM
    Author     : HP
--%>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Category Update Form!</h1><br>
        
        <form action="/update-category" method="get">

            Category Id: <input type="text" name="categoryid" readonly value="${category2.categoryid}">&nbsp;
            Category Name: <input type="text" name="categoryname"value="${category2.categoryname}"><br><br>
            <input type="submit" value="Update" class="btn btn-success">

        </form>
    </center>
    </body>
</html>
