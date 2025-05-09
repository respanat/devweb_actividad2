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
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodos();
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
}
