<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recordar Contraseña</title>
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
        .forgot-password-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            margin-top: 15px;
            color: green; /* O rojo para errores */
        }
        .back-to-login {
            text-align: center;
            margin-top: 15px;
            font-size: 0.9em;
        }
        .back-to-login a {
            color: #555;
            text-decoration: none;
        }
        .back-to-login a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="forgot-password-container">
        <h2>¿Olvidaste tu Contraseña?</h2>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null && !message.isEmpty()) {
        %>
            <p class="message"><%= message %></p>
        <%
            }
        %>
        <form action="<%= request.getContextPath() %>/usuario/recordar_password" method="post">
            <div class="form-group">
                <label for="identifier">Usuario o Correo Electrónico:</label>
                <input type="text" id="identifier" name="identifier" required>
            </div>
            <button type="submit">Enviar Solicitud</button>
        </form>
        <div class="back-to-login">
            <a href="<%= request.getContextPath() %>/usuario/login">Volver a Iniciar Sesión</a>
        </div>
    </div>
</body>
</html>
