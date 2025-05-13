<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Computador</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Editar Computador</h1>
        <form action="<%= request.getContextPath() %>/computadores/actualizar" method="post">
            <input type="hidden" name="id" value="${computador.id}">
            <div class="form-group">
                <label for="marca">Marca:</label>
                <input type="text" class="form-control" id="marca" name="marca" value="${computador.marca}" required>
            </div>
            <div class="form-group">
                <label for="categoria">Categoría:</label>
                <input type="text" class="form-control" id="categoria" name="categoria" value="${computador.categoria}">
            </div>
            <div class="form-group">
                <label for="marcaCpu">Marca CPU:</label>
                <input type="text" class="form-control" id="marcaCpu" name="marcaCpu" value="${computador.marcaCpu}">
            </div>
            <div class="form-group">
                <label for="velocidadCpU">Velocidad CPU (GHz):</label>
                <input type="number" step="0.01" class="form-control" id="velocidadCpU" name="velocidadCpU" value="${computador.velocidadCpU}">
            </div>
            <div class="form-group">
                <label for="tecnologiaRam">Tecnología RAM:</label>
                <input type="text" class="form-control" id="tecnologiaRam" name="tecnologiaRam" value="${computador.tecnologiaRam}">
            </div>
            <div class="form-group">
                <label for="capacidadRam">Capacidad RAM (GB):</label>
                <input type="number" class="form-control" id="capacidadRam" name="capacidadRam" value="${computador.capacidadRam}">
            </div>
            <div class="form-group">
                <label for="tecnologiaDisco">Tecnología Disco:</label>
                <input type="text" class="form-control" id="tecnologiaDisco" name="tecnologiaDisco" value="${computador.tecnologiaDisco}">
            </div>
            <div class="form-group">
                <label for="capacidadDisco">Capacidad Disco (GB):</label>
                <input type="number" class="form-control" id="capacidadDisco" name="capacidadDisco" value="${computador.capacidadDisco}">
            </div>
            <div class="form-group">
                <label for="numPuertosUSB">Número de Puertos USB:</label>
                <input type="number" class="form-control" id="numPuertosUSB" name="numPuertosUSB" value="${computador.numPuertosUSB}">
            </div>
            <div class="form-group">
                <label for="numPuertosHDMI">Número de Puertos HDMI:</label>
                <input type="number" class="form-control" id="numPuertosHDMI" name="numPuertosHDMI" value="${computador.numPuertosHDMI}">
            </div>
            <div class="form-group">
                <label for="MarcaMonitor">Marca Monitor:</label>
                <input type="text" class="form-control" id="MarcaMonitor" name="MarcaMonitor" value="${computador.marcaMonitor}">
            </div>
            <div class="form-group">
                <label for="pulgadas">Pulgadas Monitor:</label>
                <input type="number" step="0.1" class="form-control" id="pulgadas" name="pulgadas" value="${computador.pulgadas}">
            </div>
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="number" step="0.01" class="form-control" id="precio" name="precio" value="${computador.precio}">
            </div>
            <div class="form-group">
                <label for="usuario_id">ID de Usuario (Opcional):</label>
                <input type="number" class="form-control" id="usuario_id" name="usuario_id" value="${computador.usuario_id}">
            </div>
            <button type="submit" class="btn btn-primary">Actualizar Computador</button>
            <a href="<%= request.getContextPath() %>/computadores/listar_todo" class="btn btn-secondary ml-2">Cancelar</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
