<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Models.Entities.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalles del Usuario</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .user-details-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .detail-row {
            margin-bottom: 10px;
            padding: 8px 0;
            border-bottom: 1px solid #eee;
        }
        .detail-row:last-child {
            border-bottom: none;
        }
        .label {
            font-weight: bold;
            color: #555;
            display: inline-block;
            width: 120px;
        }
        .value {
            color: #333;
        }
        .logout-button {
            text-align: center;
            margin-top: 20px;
        }
        .logout-button button {
            background-color: #d9534f;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }
        .logout-button button:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <div class="user-details-container">
        <h2>Detalles del Usuario</h2>
        <%
            Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
            if (usuarioLogueado != null) {
        %>
            <div class="detail-row">
                <span class="label">ID:</span>
                <span class="value"><%= usuarioLogueado.getId() %></span>
            </div>
            <div class="detail-row">
                <span class="label">Usuario:</span>
                <span class="value"><%= usuarioLogueado.getUsername() %></span>
            </div>
            <div class="detail-row">
                <span class="label">Nombre:</span>
                <span class="value"><%= usuarioLogueado.getNombre() %></span>
            </div>
            <div class="detail-row">
                <span class="label">Email:</span>
                <span class="value"><%= usuarioLogueado.getEmail() %></span>
            </div>
            <div class="logout-button">
                <button onclick="window.location.href='<%= request.getContextPath() %>/usuario/logout'">Cerrar Sesión</button>
            </div>
        <%
            } else {
        %>
            <p class="error-message">No hay ningún usuario logueado.</p>
            <div class="back-to-login">
                <a href="<%= request.getContextPath() %>/usuario/login">Volver a Iniciar Sesión</a>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
