package Models.Repositories;

import Models.Entities.Computador;
import java.util.List;

public interface ComputadorRepository {
    Computador obtenerComputadorPorId(int id);
    List<Computador> obtenerTodosLosComputadores();
    void crearComputador(Computador computador);
    void actualizarComputador(Computador computador);
    void eliminarComputador(int id);

    List<Computador> buscarComputadoresPorCriterio(String criterio);
}
