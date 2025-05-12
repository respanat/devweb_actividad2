package Controllers;

import Models.Entities.Usuario;
import Models.Repositories.UsuarioRepositoryImpl; // Necesitaremos una implementación del Repository
import Models.Services.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuario/*") // Define la URL base para este servlet. El '*' permite mapear diferentes acciones.
public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService;

    // Se instancia el UsuarioService al inicializar el servlet
    @Override
    public void init() throws ServletException {
        // Por ahora, instanciamos directamente el repositorio. Más adelante usaremos un mecanismo de configuración.
        usuarioService = new UsuarioService(new UsuarioRepositoryImpl());
    }

    // Método para manejar las peticiones GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // Obtiene la parte de la URL después de "/usuario"

        if (pathInfo == null || pathInfo.equals("/")) {
            // Acción por defecto: podría ser listar todos los usuarios o mostrar un formulario de inicio
            listarUsuarios(request, response);
        } else {
            String[] pathParts = pathInfo.substring(1).split("/"); // Divide la ruta en partes
            String action = pathParts[0]; // La primera parte indica la acción

            switch (action) {
                case "listar":
                    listarUsuarios(request, response);
                    break;
                case "agregar":
                    mostrarFormularioAgregar(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                case "buscar":
                    mostrarFormularioBuscar(request, response);
                    break;
		case "login":
                    mostrarFormularioLogin(request, response);
                    break;
		case "recordar_password":
                    mostrarFormularioRecordarPassword(request, response);
                    break;
                default:
                    // Si la acción no se reconoce, se puede mostrar un error
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }

    // Método para manejar las peticiones POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && !pathInfo.equals("/")) {
            String[] pathParts = pathInfo.substring(1).split("/");
            String action = pathParts[0];

            switch (action) {
                case "guardar":
                    guardarUsuario(request, response);
                    break;
                case "actualizar":
                    actualizarUsuario(request, response);
                    break;
                case "buscar":
                    buscarUsuario(request, response);
                    break;
		case "login":
	            procesarLogin(request, response);
        	    break;
		case "recordar_password":
                    procesarRecordarPassword(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }

    // Métodos auxiliares para manejar las diferentes acciones

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
	System.out.println("Número de usuarios obtenidos: " + usuarios.size());
        request.setAttribute("usuarios", usuarios); // Pasa la lista de usuarios a la vista
        request.getRequestDispatcher("/Views/forms/usuarios/listar_todo.jsp").forward(request, response);
    }

    private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/usuarios/agregar.jsp").forward(request, response);
    }

    private void guardarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        Usuario nuevoUsuario = new Usuario(0, username, password, nombre, email); // El ID se generará en la BD
        usuarioService.crearUsuario(nuevoUsuario);
        response.sendRedirect(request.getContextPath() + "/usuario/listar"); // Redirige a la lista de usuarios
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        request.setAttribute("usuario", usuario); // Pasa el usuario a la vista
        request.getRequestDispatcher("/Views/forms/usuarios/editar.jsp").forward(request, response); // Necesitaremos crear este JSP
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        Usuario usuarioActualizado = new Usuario(id, username, password, nombre, email);
        usuarioService.actualizarUsuario(usuarioActualizado);
        response.sendRedirect(request.getContextPath() + "/usuario/listar");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usuarioService.eliminarUsuario(id);
        response.sendRedirect(request.getContextPath() + "/usuario/listar");
    }

    private void mostrarFormularioBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/usuarios/buscar.jsp").forward(request, response);
    }

    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criterio = request.getParameter("criterio");
        Usuario usuarioEncontrado = usuarioService.obtenerUsuarioPorUsername(criterio); // Ejemplo de búsqueda por username
        request.setAttribute("usuarioEncontrado", usuarioEncontrado);
        request.getRequestDispatcher("/Views/forms/usuarios/buscar_resultado.jsp").forward(request, response); // Necesitaremos crear este JSP
    }
    private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/usuarios/login.jsp").forward(request, response);
    }
    private void procesarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameOrEmail = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario = usuarioService.autenticarUsuario(usernameOrEmail, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            response.sendRedirect(request.getContextPath() + "/usuario/listar"); // Redirigimos a la lista para simplificar.
        } else {
            request.setAttribute("errorMessage", "Credenciales inválidas");
            request.getRequestDispatcher("/Views/forms/usuarios/login.jsp").forward(request, response);
        }
    }

   private void mostrarFormularioRecordarPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/forms/usuarios/recordar_password.jsp").forward(request, response);
    }

    private void procesarRecordarPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier");
        Usuario usuarioEncontrado = usuarioService.iniciarRecordarPassword(identifier);

        if (usuarioEncontrado != null) {
            // En una aplicación real, aquí se generaría y enviaría un enlace
            // para restablecer la contraseña al correo electrónico del usuario.
            request.setAttribute("message", "Se ha enviado un enlace para restablecer la contraseña a tu correo electrónico (simulado).");
        } else {
            request.setAttribute("message", "No se encontró ningún usuario con ese nombre de usuario o correo electrónico.");
        }
        request.getRequestDispatcher("/Views/forms/usuarios/recordar_password.jsp").forward(request, response);
    } 
}
