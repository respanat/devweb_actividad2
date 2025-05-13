package pruebas; // Asegúrate de que este archivo esté en el paquete 'pruebas'

import Models.Repositories.ComputadorRepositoryImpl;
import Models.Entities.Computador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PruebaConexionBD1 {

    public static void main(String[] args) {
        ComputadorRepositoryImpl computadorRepository = new ComputadorRepositoryImpl();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Intentando obtener conexión...");
            // No necesitamos llamar getConnection directamente aquí, el repository lo hace internamente
            List<Computador> computadores = computadorRepository.obtenerTodosLosComputadores();
            System.out.println("Conexión y lectura exitosas.");

            if (computadores.isEmpty()) {
                System.out.println("No se encontraron computadores en la base de datos.");
            } else {
                System.out.println("Datos de la tabla Computadores:");
                for (Computador computador : computadores) {
                    System.out.println("ID: " + computador.getId() +
                                       ", Marca: " + computador.getMarca() +
                                       ", Categoría: " + computador.getCategoria() +
                                       ", Precio: " + computador.getPrecio() +
                                       ", Usuario ID: " + computador.getUsuario_id());
                    // Puedes imprimir más atributos si lo deseas
                }
            }

        } catch (Exception e) { // Catch genérico para simplificar la prueba
            System.err.println("Error durante la prueba de conexión/lectura: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // El repositorio maneja el cierre de la conexión internamente en sus métodos
            // Por lo tanto, no necesitamos un bloque finally para cerrar la conexión aquí.
        }
    }
}
