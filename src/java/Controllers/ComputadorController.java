package Controllers;

import Models.Entities.Computador;
import Models.Services.ComputadorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/computadores/*")
public class ComputadorController extends HttpServlet {

    private ComputadorService computadorService;

    @Override
    public void init() throws ServletException {
        computadorService = new ComputadorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            listarComputadores(request, response);
        } else {
            String[] pathParts = pathInfo.substring(1).split("/");
            String action = pathParts[0];
            switch (action) {
		case "listar_todo":
                    listarComputadores(request, response);
                    break;
                case "agregar":
                    mostrarFormularioAgregar(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "eliminar":
                    eliminarComputador(request, response);
                    break;
                case "buscar":
                    mostrarFormularioBuscar(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && !pathInfo.equals("/")) {
            String[] pathParts = pathInfo.substring(1).split("/");
            String action = pathParts[0];
            switch (action) {
                case "guardar":
                    guardarComputador(request, response);
                    break;
                case "actualizar":
                    actualizarComputador(request, response);
                    break;
                case "buscar":
                    buscarComputador(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }

    private void listarComputadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Computador> computadores = computadorService.obtenerTodosLosComputadores();
        request.setAttribute("computadores", computadores);
        request.getRequestDispatcher("/Views/forms/computadores/listar_todo.jsp").forward(request, response);
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/computadores/agregar.jsp").forward(request, response);
    }

    private void guardarComputador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String marcaCpu = request.getParameter("marcaCpu");
        double velocidadCpU = Double.parseDouble(request.getParameter("velocidadCpU"));
        String tecnologiaRam = request.getParameter("tecnologiaRam");
        int capacidadRam = Integer.parseInt(request.getParameter("capacidadRam"));
        String tecnologiaDisco = request.getParameter("tecnologiaDisco");
        int capacidadDisco = Integer.parseInt(request.getParameter("capacidadDisco"));
        int numPuertosUSB = Integer.parseInt(request.getParameter("numPuertosUSB"));
        int numPuertosHDMI = Integer.parseInt(request.getParameter("numPuertosHDMI"));
        String marcaMonitor = request.getParameter("MarcaMonitor");
        double pulgadas = Double.parseDouble(request.getParameter("pulgadas"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        Integer usuario_id = null;
        String usuarioIdParam = request.getParameter("usuario_id");
        if (usuarioIdParam != null && !usuarioIdParam.isEmpty()) {
            usuario_id = Integer.parseInt(usuarioIdParam);
        }

        Computador computador = new Computador(marca, categoria, marcaCpu, velocidadCpU, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, marcaMonitor, pulgadas, precio, usuario_id);
        computadorService.crearComputador(computador);
        response.sendRedirect(request.getContextPath() + "/computadores/listar");
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Computador computador = computadorService.obtenerComputadorPorId(id);
        request.setAttribute("computador", computador);
        request.getRequestDispatcher("/Views/forms/computadores/editar.jsp").forward(request, response);
    }

    private void actualizarComputador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");
        String marcaCpu = request.getParameter("marcaCpu");
        double velocidadCpU = Double.parseDouble(request.getParameter("velocidadCpU"));
        String tecnologiaRam = request.getParameter("tecnologiaRam");
        int capacidadRam = Integer.parseInt(request.getParameter("capacidadRam"));
        String tecnologiaDisco = request.getParameter("tecnologiaDisco");
        int capacidadDisco = Integer.parseInt(request.getParameter("capacidadDisco"));
        int numPuertosUSB = Integer.parseInt(request.getParameter("numPuertosUSB"));
        int numPuertosHDMI = Integer.parseInt(request.getParameter("numPuertosHDMI"));
        String marcaMonitor = request.getParameter("MarcaMonitor");
        double pulgadas = Double.parseDouble(request.getParameter("pulgadas"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        Integer usuario_id = null;
        String usuarioIdParam = request.getParameter("usuario_id");
        if (usuarioIdParam != null && !usuarioIdParam.isEmpty()) {
            usuario_id = Integer.parseInt(usuarioIdParam);
        }

        Computador computador = new Computador(id, marca, categoria, marcaCpu, velocidadCpU, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, marcaMonitor, pulgadas, precio, usuario_id);
        computadorService.actualizarComputador(computador);
        response.sendRedirect(request.getContextPath() + "/computadores/listar");
    }

    private void eliminarComputador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        computadorService.eliminarComputador(id);
        response.sendRedirect(request.getContextPath() + "/computadores/listar");
    }

    private void mostrarFormularioBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/computadores/buscar.jsp").forward(request, response);
    }

    private void buscarComputador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criterio = request.getParameter("criterio");
        // Aquí deberíamos llamar a un método en el servicio para buscar computadores por criterio
        // Por ahora, simplemente redirigimos a una página de resultados (que aún no existe)
        request.setAttribute("criterio", criterio);
        request.getRequestDispatcher("/Views/forms/computadores/buscar_resultado.jsp").forward(request, response);
    }
}
