package Models.Repositories;

import Models.Entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    // Información de la conexión a la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/act2_devweb?serverTimezone=America/Bogota"; // Ajusta la zona horaria si es necesario
    private static final String JDBC_USER = "ramiro_espana";
    private static final String JDBC_PASSWORD = "AbcdeUdeC";

    // Método para obtener una conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public void crear(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, nombre, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setString(4, usuario.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // En un entorno real, se debería manejar la excepción de forma más robusta
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE Usuario SET username = ?, password = ?, nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setInt(5, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorUsername(String username) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
