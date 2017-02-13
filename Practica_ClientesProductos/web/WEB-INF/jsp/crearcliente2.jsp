<%-- 
    Document   : crearcliente2
    Created on : 08-feb-2017, 18:18:51
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="obtenercliente.htm" method="post">
            Ingrese su nombre:
            <input type="text" name="nombre" size="20">
            <br>
             Ingrese su apellido:
            <input type="text" name="apellido" size="20">
            <br>
             Ingrese su edad:
            <input type="text" name="edad" size="20">
            <br>
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
