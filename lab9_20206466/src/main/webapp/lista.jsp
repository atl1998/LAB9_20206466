<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19/06/2024
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab9_20206466.beans.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" scope="request" type="ArrayList<com.example.lab9_20206466.beans.Usuario>" />
<html>
    <head>
        <title>Trabajos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <table class="table table-striped mt-3">
                <tr class="table-primary">
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Tipo de Licencia</th>
                    <th>Estado de Licencia</th>
                    <th>Pais de Procedencia</th>
                    <th></th>
                </tr>
                <% for (Usuario usuario : lista) { %>
                <tr>
                    <td><%=usuario.getNombre() %></td>
                    <td><%=usuario.getApellido() %></td>
                    <td><%=usuario.getTipoLicencia() %></td>
                    <td><%=usuario.getEstadoLicencia() %></td>
                    <td><%=usuario.getPaisProcedencia() %></td>

                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>

