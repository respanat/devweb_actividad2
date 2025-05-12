package Models.Services;

import Models.Entities.Usuario;
import Models.Repositories.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    // Se declara una instancia del repositorio de Usuario
    private UsuarioRepository usuarioRepository;

    // Constructor que recibe una instancia del repositorio (Inyección de Dependencias)
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para crear un nuevo usuario, invoca el método correspondiente del repositorio
    public void crearUsuario(Usuario usuario) {
        // Aquí se podrían agregar validaciones de negocio antes de guardar
        usuarioRepository.crear(usuario);
    }

    // Método para obtener un usuario por su ID, invoca el método del repositorio
    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepository.obtenerPorId(id);
    }

    // Método para obtener todos los usuarios, invoca el método del repositorio
    /*public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodos();
    }*/
    public List<Usuario> obtenerTodosLosUsuarios() {
    List<Usuario> usuarios = usuarioRepository.obtenerTodos();
    System.out.println("UsuarioService - Número de usuarios obtenidos del repositorio: " + usuarios.size());
    return usuarios;
}

    // Método para actualizar la información de un usuario, invoca el método del repositorio
    public void actualizarUsuario(Usuario usuario) {
        // Aquí se podrían agregar validaciones de negocio antes de actualizar
        usuarioRepository.actualizar(usuario);
    }

    // Método para eliminar un usuario por su ID, invoca el método del repositorio
    public void eliminarUsuario(int id) {
        // Aquí se podrían agregar validaciones de negocio antes de eliminar
        usuarioRepository.eliminar(id);
    }

    // Método para obtener un usuario por su nombre de usuario, invoca el método del repositorio
    public Usuario obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.obtenerPorUsername(username);
    }
    
    public Usuario autenticarUsuario(String usernameOrEmail, String password) {
        Usuario usuario = usuarioRepository.obtenerPorUsername(usernameOrEmail); // Buscar por username o email

        if (usuario == null) {
            return null; // Usuario no encontrado
        }

        // Verificar si la contraseña coincide
        if (usuario.getPassword().equals(password)) {
            return usuario; // Autenticación exitosa
        } else {
            return null; // Contraseña incorrecta
        }
    }

    public Usuario iniciarRecordarPassword(String identifier) {
        Usuario usuario = usuarioRepository.obtenerPorUsername(identifier);
        if (usuario == null) {
            usuario = usuarioRepository.obtenerPorEmail(identifier);
        }
        // En una aplicación real, aquí se enviaría un correo electrónico
        // con un enlace para restablecer la contraseña.
        return usuario; // Devolvemos el usuario encontrado (o null si no se encuentra)
    }
}
