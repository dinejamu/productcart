<%-- 
    Document   : product-form
    Created on : Jun 15, 2017, 5:41:29 PM
    Author     : HP
--%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add products Page</title>
    </head>
    <style type="text/css">
        .choose::-webkit-file-upload-button {
            color: white;
            display: inline-block;
            background: #1CB6E0;
            border: none;
            padding: 7px 15px;
            font-weight: 700;
            border-radius: 3px;
            white-space: nowrap;
            cursor: pointer;
            font-size: 10pt;
        }
    </style>
    <script>
        $(function(){
            $("input[type='submit']").click(function(){
                var $fileUpload = $("input[type='file']");
                if (parseInt($fileUpload.get(0).files.length)>5){
                    alert("You can only upload a maximum of 5 files");
                    return false;
                }
            });
        });
    </script>
    <center>
    <body>
        <h1>Product Form!</h1>

        <form action="/add-product" method="post" enctype="multipart/form-data">

            <table>
            
                <tr><td>Category : </td><td>
            <select name="categoryname" class="form-control">
                <option>Select Category</option>
                <c:forEach items="${category}" var="cate" >
                    <option value="${cate.categoryid}">${cate.categoryname}</option>
                </c:forEach>
            </select></td></tr>
            <tr><td>Product Name :</td><td><input type="text" name="productname" required class="form-control"></td></tr>
            <tr><td>Product Code :</td><td><input type="text" name="productcode" class="form-control" required></td></tr>
            <tr><td>Product Description :</td><td><input type="text" name="productdesc" class="form-control"></td></tr>
            <tr><td>Product Price :</td><td><input type="number" name="price" class="form-control"></td></tr>
            <tr><td>Product Image : </td><td><input type="file" name="image" id="image1" class="choose" required multiple accept="image/jpg, image/jpeg"> </td></tr>
             <tr><td><input type="submit" class="btn btn-success" name="Save"> <input type="reset" class="btn btn-warning" name="reset"></td></tr>
            </table>

        </form>
    </body>
    </center>
</html>
