<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Café</title>
</head>
<body>
    <h2>Registrar Nuevo Café</h2>
    
    <form action="ProductoServlet" method="POST">
        <label>Nombre del Café:</label><br>
        <input type="text" name="txtNombre" required><br><br>
        
        <label>Precio:</label><br>
        <input type="number" step="0.01" name="txtPrecio" required><br><br>
        
        <button type="submit">Guardar Café</button>
    </form>

    <br>
    <a href="ProductoServlet">Ver lista de cafés registrados</a>

    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
    %>
        <p style="color: green;"><strong><%= mensaje %></strong></p>
    <%
        }
    %>
</body>
</html>
