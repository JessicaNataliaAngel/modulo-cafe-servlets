<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Cafés</title>
</head>
<body>
    <h2>Cafés Registrados en la Base de Datos</h2>
    
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nombre del Café</th>
            <th>Precio</th>
        </tr>
        <%
            List<String[]> lista = (List<String[]>) request.getAttribute("listaProductos");
            if (lista != null && !lista.isEmpty()) {
                for (String[] p : lista) {
        %>
        <tr>
            <td><%= p[0] %></td>
            <td><%= p[1] %></td>
            <td>$<%= p[2] %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No hay cafés registrados.</td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="index.jsp">Volver al formulario de registro</a>
</body>
</html>
