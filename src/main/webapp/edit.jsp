<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/13/2022
  Time: 1:42 PM
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
    <h1>Cập nhật thông tin sản phẩm</h1>
    <h2>
        <a href="/product?action=product">Danh sách sản phẩm</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Thông tin sản phẩm
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Giá sản phẩm:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số lượng:</th>
                <td>
                    <input type="text" name="quality" size="45"
                           value="<c:out value='${product.quality}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Màu sắc:</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category_id:</th>
                <td>
                    <input type="text" name="category_id" size="45"
                           value="<c:out value='${product.category.id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category" size="45"
                           value="<c:out value='${product.category.category}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
