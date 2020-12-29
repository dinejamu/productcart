<%-- 
    Document   : product-list
    Created on : Jun 15, 2017, 5:41:46 PM
    Author     : HP
--%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        table.center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <body>
        <h1 style="text-align: center">Product List!</h1><br>
        <table  class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th>product id</th>
                <th>Category Name</th>
                <th>Product Name</th>
                <th>Code</th>
                <th>Description</th>
                <th>Status</th>
                <th>Price</th>
                <th>Images</th>
            </tr>
            </thead>
            <c:forEach items="${productList}" var="product">
                <tr style=text-align:center>
                   <td>${product.productid}, &nbsp;</td>
                  <td style="font-family: 'Calisto MT'">${product.categoryname}, &nbsp;</td>
                    <td>${product.productcode}, &nbsp;</td>
                   <td>${product.productname}, &nbsp;</td>
                   <td>${product.productdesc}, &nbsp;</td>
                   <td style="color: forestgreen">${product.productstatus} &nbsp;</td>
                    <td>RS.${product.price}, &nbsp;</td>
                     <td><img src="<c:url value='/photo/${product.productimages }'/>" class="rounded" alt="Cinque Terre"> &nbsp;</td>
                </tr>
            </c:forEach>
            
        </table>
        
        
    </body>
</html>
