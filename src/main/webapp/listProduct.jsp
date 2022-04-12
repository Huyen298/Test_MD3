<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/12/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<center>
    <h1>Danh sách sản phẩm</h1>
</center>
<div align="center">
<table border="1" cellpadding="5">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quality</th>
    <th>Color</th>
    <th>Category_id</th>
    <th>Category</th>
</tr>
<c:forEach var="product" items="${listProduct}">
    <tr>
    <td><c:out value="${product.id}"/></td>
    <td><c:out value="${product.name}"/></td>
    <td><c:out value="${product.price}"/></td>
    <td><c:out value="${product.quality}"/></td>
    <td><c:out value="${product.color}"/></td>
    <td><c:out value="${category.category_id}"/></td>
    <td><c:out value="${category.category}"/></td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
