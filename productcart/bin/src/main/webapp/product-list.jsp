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
    <body>
        <h1>Product List!</h1><br>
        <h3>product id: CName: Name: Desc: Status: Price: </h3>
        <table>
            <c:forEach items="${productList}" var="product">
                <tr>
                   <td>${product.productid}, &nbsp;</td>
                  <td style="font-family: 'Calisto MT'">${product.categoryname}, &nbsp;</td>
                    <td>${product.productcode}, &nbsp;</td>
                   <td>${product.productname}, &nbsp;</td>
                   <td>${product.productdesc}, &nbsp;</td>
                   <td style="color: forestgreen">${product.productstatus} &nbsp;</td>
                    <td>${product.price}, RS.&nbsp;</td>
                     <td><img src="<c:url value='/photo/${product.productimages }'/>"> &nbsp;</td>
                </tr>
            </c:forEach>
            
        </table>
        
        
    </body>
</html>
