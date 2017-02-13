<%-- 
    Document   : crearcliente
    Created on : 08-feb-2017, 17:34:19
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Damos acceso a las librerias de JTLS-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello World!</h1>
        <form:form method="post" commandName="cliente" action="crearcliente.htm">
            <!--Al usar el taglib, se tiene que usar su anotación y el path tiene que tener e
            el mismo nombre que el atributo de la clase-->
            Nombre:<form:input path="nombre" />
            <br/>
            Apellido: <form:input path="apellido" />
            <br/>
            Edad:<form:input path="edad" />
            <br/> 
            <form:button>Enviar</form:button>
        </form:form>
</html>
