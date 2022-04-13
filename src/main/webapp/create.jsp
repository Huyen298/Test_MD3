<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/13/2022
  Time: 10:53 AM
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
    <h1>Thêm sản phẩm mới</h1>
    <h2>
        <a href="/product?action=product">Danh sách sản phẩm</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thông tin sản phẩm</h2>
            </caption>
            <tr>
                <th>Tên sản phẩm:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giá:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số lượng:</th>
                <td>
                    <input type="text" name="quality" id="quality" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Màu sắc:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category_id:</th>
                <td>
                    <input type="text" name="category_id" id="category_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category_id" id="category" size="45"/>
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
