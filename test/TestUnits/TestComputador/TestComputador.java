package TestUnits.TestComputador;

import Models.Entities.Computador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestComputador {

    @Test
    void testCrearComputador() {
        Computador computador = new Computador("Dell", "PC", "Intel", 2.5, "DDR4", 16, "SSD", 512, 2, 1, "Dell", 15.6, 1200.0, null);
        assertNotNull(computador);
        assertEquals("Dell", computador.getMarca());
        assertEquals("Laptop", computador.getCategoria());
        assertEquals("Intel", computador.getMarcaCpu());
        assertEquals(2.5, computador.getVelocidadCpU(), 0.001); // El tercer argumento es la delta para comparar doubles
        assertEquals("DDR4", computador.getTecnologiaRam());
        assertEquals(16, computador.getCapacidadRam());
        assertEquals("SSD", computador.getTecnologiaDisco());
        assertEquals(512, computador.getCapacidadDisco());
        assertEquals(2, computador.getNumPuertosUSB());
        assertEquals(1, computador.getNumPuertosHDMI());
        assertEquals("Dell", computador.getMarcaMonitor());
        assertEquals(15.6, computador.getPulgadas(), 0.001);
        assertEquals(1200.0, computador.getPrecio(), 0.001);
        assertNull(computador.getUsuario_id());
    }

    @Test
    void testSettersAndGettersComputador() {
        Computador computador = new Computador();
        computador.setId(101);
        computador.setMarca("HP");
        computador.setPrecio(950.50);

        assertEquals(101, computador.getId());
        assertEquals("HP", computador.getMarca());
        assertEquals(950.50, computador.getPrecio(), 0.001);
    }

    @Test
    void testComputadorConUsuarioAsignado() {
        Computador computador = new Computador("Apple", "Desktop", "M1", 3.2, "DDR5", 32, "NVMe", 1000, 4, 2, "Apple", 27.0, 2500.0, 5);
        assertEquals(5, computador.getUsuario_id());
    }
}
