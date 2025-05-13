<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Computador</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Buscar Computador</h1>
        <form action="<%= request.getContextPath() %>/computadores/buscar" method="post">
            <div class="form-group">
                <label for="criterio">Criterio de Búsqueda:</label>
                <input type="text" class="form-control" id="criterio" name="criterio" placeholder="Ingrese la marca, categoría, etc.">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
            <a href="<%= request.getContextPath() %>/usuario/listar_todo" class="btn btn-secondary ml-2">Cancelar</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
