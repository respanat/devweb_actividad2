package Models.Services;

import Models.Entities.Computador;
import Models.Repositories.ComputadorRepository;
import Models.Repositories.ComputadorRepositoryImpl;
import java.util.List;

public class ComputadorService {

    private final ComputadorRepository computadorRepository;

    public ComputadorService() {
        this.computadorRepository = new ComputadorRepositoryImpl();
    }

    public ComputadorService(ComputadorRepository computadorRepository) {
        this.computadorRepository = computadorRepository;
    }

    public Computador obtenerComputadorPorId(int id) {
        return computadorRepository.obtenerComputadorPorId(id);
    }

    public List<Computador> obtenerTodosLosComputadores() {
        return computadorRepository.obtenerTodosLosComputadores();
    }

    public void crearComputador(Computador computador) {
        computadorRepository.crearComputador(computador);
    }

    public void actualizarComputador(Computador computador) {
        computadorRepository.actualizarComputador(computador);
    }

    public void eliminarComputador(int id) {
        computadorRepository.eliminarComputador(id);
    }

    public List<Computador> buscarComputadoresPorCriterio(String criterio) {
        return computadorRepository.buscarComputadoresPorCriterio(criterio);
    }

}
