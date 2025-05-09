
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Buscar Usuario</h1>
        <form action="<%= request.getContextPath() %>/usuario/buscar" method="post">
            <div class="form-group">
                <label for="criterio">Buscar por Nombre de Usuario:</label>
                <input type="text" class="form-control" id="criterio" name="criterio" required>
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
            <a href="<%= request.getContextPath() %>/usuario/listar" class="btn btn-secondary">Volver a la Lista</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
