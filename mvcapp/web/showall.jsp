<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>  
    <body>
        <table border='1'>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${Products}" var="p">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
