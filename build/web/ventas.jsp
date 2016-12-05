<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Plataforma Web - Examen Final</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>VENTAS</h1><br>

        <table id="resumen">
            <tr>
                <th>Codigo</th>
                <th>Cod. Libro</th>
                <th>Cliente</th>                
                <th>Total</th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${listaVentas}">
                <tr>
                    <td>${item.codigoVenta}</td>                
                    <td>${item.codigoLibro}</td>
                    <td>${item.titularTarjeta}</td>                    
                    <td>\$${item.totalVenta}</td>
                    <td>
                        <form action="libros" method="post">
                            <input type="hidden" name="action" 
                                   value="resumen">                    
                            <input type="hidden" name="codigoVenta" 
                                   value="${item.codigoVenta}">                    
                            <input type="submit" value="VER DETALLE">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
