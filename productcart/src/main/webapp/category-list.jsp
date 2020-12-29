<%-- 
    Document   : category-list
    Created on : Jun 13, 2017, 6:00:53 PM
    Author     : HP
--%>
<%@ include file="header.jsp"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Online Store</title>
    </head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: left;
            padding: 16px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    <body>
    <center>
        <h2>Category List!</h2><br>

        <table>
            <th>Id</th>
            <th>Category Name</th>
            <th>Edit</th>
            <th>Delete</th>

            <c:forEach var="category" items="${categoryList}">
                <tr>

                    <td>${category.categoryid}, &nbsp;</td>
                    <td>${category.categoryname} &nbsp;</td>
                    <td><a href="edit-category?categoryid=${category.categoryid}" class="btn btn-primary"> Edit </a></td>
                    <td><a href="delete-category?categoryid=${category.categoryid}" class="btn btn-danger"> &nbsp;Delete</a></td>
                </tr>
            </c:forEach>
            
        </table>
        </center>
        
    </body>
</html>
