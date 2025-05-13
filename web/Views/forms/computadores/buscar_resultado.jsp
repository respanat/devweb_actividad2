<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados de la Búsqueda</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Resultados de la Búsqueda</h1>

        <c:if test="${not empty computadoresEncontrados}">
            <p>Se encontraron ${computadoresEncontrados.size()} computadores con el criterio: "${criterio}".</p>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Marca</th>
                        <th>Categoría</th>
                        <th>Marca CPU</th>
                        <th>Velocidad CPU</th>
                        <th>RAM (Tecnología/Capacidad)</th>
                        <th>Disco (Tecnología/Capacidad)</th>
                        <th>USB</th>
                        <th>HDMI</th>
                        <th>Monitor (Marca/Pulgadas)</th>
                        <th>Precio</th>
                        <th>Usuario ID</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="computador" items="${computadoresEncontrados}">
                        <tr>
                            <td>${computador.id}</td>
                            <td>${computador.marca}</td>
                            <td>${computador.categoria}</td>
                            <td>${computador.marcaCpu}</td>
                            <td>${computador.velocidadCpU}</td>
                            <td>${computador.tecnologiaRam}/${computador.capacidadRam} GB</td>
                            <td>${computador.tecnologiaDisco}/${computador.capacidadDisco} GB</td>
                            <td>${computador.numPuertosUSB}</td>
                            <td>${computador.numPuertosHDMI}</td>
                            <td>${computador.marcaMonitor}/${computador.pulgadas}"</td>
                            <td>${computador.precio}</td>
                            <td>${computador.usuario_id == null ? 'Sin asignar' : computador.usuario_id}</td>
                            <td>
                                <a href="<%= request.getContextPath() %>/computadores/editar?id=${computador.id}" class="btn btn-primary btn-sm">Editar</a>
                                <a href="<%= request.getContextPath() %>/computadores/eliminar?id=${computador.id}" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de eliminar este computador?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty computadoresEncontrados}">
            <p class="alert alert-info">No se encontraron computadores con el criterio: "${criterio}".</p>
        </c:if>

        <p><a href="<%= request.getContextPath() %>/usuario/listar_todo" class="btn btn-secondary">Volver a la Lista</a></p>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
