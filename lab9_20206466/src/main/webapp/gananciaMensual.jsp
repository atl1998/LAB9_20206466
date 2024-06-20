<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19/06/2024
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <th>Fecha</th>
                    <th>Cantidad de alquileres</th>
                    <th>ganancia del mes</th>
                    <th>perdidas del mes</th>
                    <th>Promedio de autonomia</th>
                </tr>
                <% for (Usuario usuario : lista) { %>
                <tr>
                    <td><%=usuario.getNombre() %></td>
                    <td><%=usuario.getApellido() %></td>
                    <td><%=usuario.getTelefono() %></td>

                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>
