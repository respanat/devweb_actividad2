package Models.Repositories;

import Models.Entities.Usuario;
import java.util.List;

public interface UsuarioRepository {
    // Método para crear un nuevo usuario
    void crear(Usuario usuario);

    // Método para obtener un usuario por su ID
    Usuario obtenerPorId(int id);

    // Método para obtener todos los usuarios
    List<Usuario> obtenerTodos();

    // Método para actualizar la información de un usuario
    void actualizar(Usuario usuario);

    // Método para eliminar un usuario por su ID
    void eliminar(int id);

    // Método para obtener un usuario por su nombre de usuario
    Usuario obtenerPorUsername(String username);
}
