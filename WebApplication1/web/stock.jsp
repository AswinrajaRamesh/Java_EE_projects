
<%@page import="com.trg.dao.ProductDao"%>
<%@page import="com.trg.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display stocks</title>
    </head>
    <body>
        <%
            ProductDao dao = new ProductDao();
            String temp = request.getParameter("pid");
            int prodID = Integer.parseInt(temp);
            Product p = dao.getProduct(prodID);
        %>
        
        <% if(p == null){%>
                <h1>Product with id <%=prodID%> not found </h1>
                <a href = 'index.html'> Go Back</a>
        <%    }
            else{ %>
                <h1> Product ID : <%= p.getProductId()%> </h1>
                <h1> Name : <%= p.getName()%> </h1>
                <h1> Price : <%= p.getPrice()%></h1>
                <a href = 'index.html'> Go Back</a>
           <% } %>
    </body>
</html>
