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

        <h1>TIENDA DE LIBROS</h1><br>

        <table>
            <tr>
                <th>Codigo</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Genero</th>
                <th>Precio</th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${listaLibros}">
                <tr>
                    <td>${item.codigo}</td>                
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.genero}</td>
                    <td>\$${item.precio}</td>
                    <td id='comprar'>
                        <form action="libros" method="post">
                            <input type="hidden" name="action" 
                                   value="comprar">                    
                            <input type="hidden" name="codigo" 
                                   value="${item.codigo}">                    
                            <input type="submit" value="¡COMPRAR!">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
