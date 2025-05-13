<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado de la Búsqueda</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Resultado de la Búsqueda</h1>
        <c:if test="${usuarioEncontrado != null}">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${usuarioEncontrado.nombre}</h5>
                    <p class="card-text">Nombre de Usuario: ${usuarioEncontrado.username}</p>
                    <p class="card-text">Correo Electrónico: ${usuarioEncontrado.email}</p>
                    <a href="<%= request.getContextPath() %>/usuario/editar?id=${usuarioEncontrado.id}" class="btn btn-primary">Editar</a>
                    <a href="<%= request.getContextPath() %>/usuario/eliminar?id=${usuarioEncontrado.id}" class="btn btn-danger" onclick="return confirm('¿Estás seguro de eliminar este usuario?')">Eliminar</a>
                </div>
            </div>
        </c:if>
        <c:if test="${usuarioEncontrado == null}">
            <p class="alert alert-warning">No se encontró ningún usuario con el criterio de búsqueda.</p>
        </c:if>
        <p><a href="<%= request.getContextPath() %>/usuario/buscar" class="btn btn-secondary mt-3">Volver a Buscar</a></p>
        <p><a href="<%= request.getContextPath() %>/usuario/listar_todo" class="btn btn-secondary mt-3">Volver a la Lista</a></p>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
