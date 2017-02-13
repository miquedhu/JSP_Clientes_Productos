<%-- 
    Document   : visualizarcliente
    Created on : 09-feb-2017, 19:48:37
    Author     : Miguel
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <!-- Añadimos el Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <!--end bootstrap -->
        <script>
            
            function eliminar(){
                var confirmar = confirm("Estas seguro de que quieres eliminar el usuario");
                
                if (!confirmar){
                    return false;
                }
                
                return true;
            }

        </script>
    </head>
    <body>
        
        <div class="container">
            <h1>Ver Cliente</h1>
        <table class="table">
           <t:forEach items="${lista}" var="cliente">
               <tr>
                   <td>${cliente.getNombre()}</td>
                   <td>${cliente.getApellido()}</td>
                   <td>${cliente.getEdad()}</td>
                   <td><a href="${pageContext.request.contextPath}/crearcliente" class="btn btn-info">Crear</a></td>
                   <td><a href="${pageContext.request.contextPath}/modificarcliente?id=${cliente.getId()}" class="btn btn-info">Modificar</a></td>
                   <td><a href="${pageContext.request.contextPath}/modificarcliente/${cliente.getId()}/" class="btn btn-info">Modificar</a></td>
                   <td><a href="${pageContext.request.contextPath}/eliminar/${cliente.getId()}/" class="btn btn-danger" onclick="return eliminar();">Eliminar</a></td>
                     
                    
               
               </tr>
           </t:forEach>
        </table>
            <h1>Ver Producto</h1>
        <table class="table">
           <t:forEach items="${lista}" var="cliente">
               <tr>
                   <td>${cliente.getNombre()}</td>
                   <td>${cliente.getApellido()}</td>
                   <td>${cliente.getEdad()}</td>
                   <td><a href="${pageContext.request.contextPath}/crearcliente" class="btn btn-info">Crear</a></td>
                   <td><a href="${pageContext.request.contextPath}/modificarcliente?id=${cliente.getId()}" class="btn btn-info">Modificar</a></td>
                   <td><a href="${pageContext.request.contextPath}/modificarcliente/${cliente.getId()}/" class="btn btn-info">Modificar</a></td>
                   <td><a href="${pageContext.request.contextPath}/eliminar/${cliente.getId()}/" class="btn btn-danger">Eliminar</a></td>                  
               
               </tr>
           </t:forEach>
        </table>
        </div>
    </body>
</html>
