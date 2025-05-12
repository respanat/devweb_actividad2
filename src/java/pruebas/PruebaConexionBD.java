package pruebas; // Puedes crear un nuevo paquete llamado 'pruebas'

import Models.Repositories.UsuarioRepositoryImpl;
import Models.Entities.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PruebaConexionBD {

    public static void main(String[] args) {
        UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Intentando obtener conexión...");
            connection = usuarioRepository.getConnection();
            System.out.println("Conexión exitosa.");

            System.out.println("Intentando leer datos de la tabla Usuarios...");
            statement = connection.createStatement();
            String sql = "SELECT * FROM Usuarios";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Username: " + username + ", Nombre: " + nombre + ", Email: " + email);
            }
            System.out.println("Lectura de datos exitosa.");

        } catch (SQLException e) {
            System.err.println("Error durante la prueba de conexión: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierra los recursos en el bloque finally para asegurar que se cierren incluso si ocurre una excepción
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (statement != null) statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
