<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Plataforma Web - Examen Final</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
    </head>
    <body>
        <br>               
        <h2>RESUMEN DE VENTA</h2>
        <label>Titulo:</label>
        <span>${libro.titulo}</span><br>

        <label>Autor:</label>
        <span>${libro.autor}</span><br>   

        <label>Genero:</label>
        <span>${libro.genero}</span><br><br>          

        <h2>INFORMACION DE PAGO</h2>
        <label>Titular:</label>
        <span>${venta.titularTarjeta}</span><br>       

        <label>Num. Tarjeta:</label>
        <span>${venta.numeroTarjeta}</span><br>     

        <label>Total:</label>
        <span>\$${libro.precio}</span><br>
        
        <p>Para volver a la pagina anterior, dale click en el
        boton regresar en el explorador o el boton Regresar 
        que se muestra debajo.</p>

        <form action="" method="post">
            <input type="hidden" name="action" value="back">
            <input type="submit" value="Regresar">
    </form>    
        
    </body>
</html>
