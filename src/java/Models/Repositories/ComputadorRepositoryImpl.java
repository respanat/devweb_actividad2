package Models.Repositories;

import Models.Entities.Computador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComputadorRepositoryImpl implements ComputadorRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/act2_devweb?serverTimezone=America/Bogota";
    private static final String USUARIO = "ramiro_espana";
    private static final String CONTRASEÑA = "AbcdeUdeC";

    // Método para obtener una conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }

    @Override
    public Computador obtenerComputadorPorId(int id) {
        String sql = "SELECT * FROM Computadores WHERE id = ?";
        Computador computador = null;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                computador = mapResultSetToComputador(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computador;
    }

    @Override
    public List<Computador> obtenerTodosLosComputadores() {
        String sql = "SELECT * FROM Computadores";
        List<Computador> computadores = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                computadores.add(mapResultSetToComputador(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computadores;
    }

    @Override
    public void crearComputador(Computador computador) {
        String sql = "INSERT INTO Computadores (marca, categoria, marcaCpu, velocidadCpU, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, computador.getMarca());
            pstmt.setString(2, computador.getCategoria());
            pstmt.setString(3, computador.getMarcaCpu());
            pstmt.setDouble(4, computador.getVelocidadCpU());
            pstmt.setString(5, computador.getTecnologiaRam());
            pstmt.setInt(6, computador.getCapacidadRam());
            pstmt.setString(7, computador.getTecnologiaDisco());
            pstmt.setInt(8, computador.getCapacidadDisco());
            pstmt.setInt(9, computador.getNumPuertosUSB());
            pstmt.setInt(10, computador.getNumPuertosHDMI());
            pstmt.setString(11, computador.getMarcaMonitor());
            pstmt.setDouble(12, computador.getPulgadas());
            pstmt.setDouble(13, computador.getPrecio());
            pstmt.setObject(14, computador.getUsuario_id()); // setObject para permitir valores null, ya que un computador puede estar o no asignado
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarComputador(Computador computador) {
        String sql = "UPDATE Computadores SET marca = ?, categoria = ?, marcaCpu = ?, velocidadCpU = ?, tecnologiaRam = ?, capacidadRam = ?, tecnologiaDisco = ?, capacidadDisco = ?, numPuertosUSB = ?, numPuertosHDMI = ?, MarcaMonitor = ?, pulgadas = ?, precio = ?, usuario_id = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, computador.getMarca());
            pstmt.setString(2, computador.getCategoria());
            pstmt.setString(3, computador.getMarcaCpu());
            pstmt.setDouble(4, computador.getVelocidadCpU());
            pstmt.setString(5, computador.getTecnologiaRam());
            pstmt.setInt(6, computador.getCapacidadRam());
            pstmt.setString(7, computador.getTecnologiaDisco());
            pstmt.setInt(8, computador.getCapacidadDisco());
            pstmt.setInt(9, computador.getNumPuertosUSB());
            pstmt.setInt(10, computador.getNumPuertosHDMI());
            pstmt.setString(11, computador.getMarcaMonitor());
            pstmt.setDouble(12, computador.getPulgadas());
            pstmt.setDouble(13, computador.getPrecio());
            pstmt.setObject(14, computador.getUsuario_id()); // Usar setObject para permitir valores null
            pstmt.setInt(15, computador.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarComputador(int id) {
        String sql = "DELETE FROM Computadores WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Computador> buscarComputadoresPorCriterio(String criterio) {
        String sql = "SELECT * FROM Computadores WHERE marca LIKE ? OR categoria LIKE ? OR marcaCpu LIKE ? OR tecnologiaRam LIKE ? OR tecnologiaDisco LIKE ? OR MarcaMonitor LIKE ?";
        List<Computador> computadoresEncontrados = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String likeCriterio = "%" + criterio + "%";
            pstmt.setString(1, likeCriterio);
            pstmt.setString(2, likeCriterio);
            pstmt.setString(3, likeCriterio);
            pstmt.setString(4, likeCriterio);
            pstmt.setString(5, likeCriterio);
            pstmt.setString(6, likeCriterio);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                computadoresEncontrados.add(mapResultSetToComputador(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computadoresEncontrados;
    }

    // Método auxiliar para mapear un ResultSet a un objeto Computador
    private Computador mapResultSetToComputador(ResultSet rs) throws SQLException {
        Computador computador = new Computador();
        computador.setId(rs.getInt("id"));
        computador.setMarca(rs.getString("marca"));
        computador.setCategoria(rs.getString("categoria"));
        computador.setMarcaCpu(rs.getString("marcaCpu"));
        computador.setVelocidadCpU(rs.getDouble("velocidadCpU"));
        computador.setTecnologiaRam(rs.getString("tecnologiaRam"));
        computador.setCapacidadRam(rs.getInt("capacidadRam"));
        computador.setTecnologiaDisco(rs.getString("tecnologiaDisco"));
        computador.setCapacidadDisco(rs.getInt("capacidadDisco"));
        computador.setNumPuertosUSB(rs.getInt("numPuertosUSB"));
        computador.setNumPuertosHDMI(rs.getInt("numPuertosHDMI"));
        computador.setMarcaMonitor(rs.getString("MarcaMonitor"));
        computador.setPulgadas(rs.getDouble("pulgadas"));
        computador.setPrecio(rs.getDouble("precio"));
        computador.setUsuario_id((Integer) rs.getObject("usuario_id")); // Usar getObject y hacer casting para permitir null
        return computador;
    }
}
