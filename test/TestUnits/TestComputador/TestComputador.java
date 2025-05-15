package TestUnits.TestComputador;

import Models.Entities.Computador;

public class TestComputador {

    public static void probarCrearComputador() {
        System.out.println("Ejecutando prueba: probarCrearComputador");
        Computador computador = new Computador("Dell", "Laptop", "Intel", 2.5, "DDR4", 16, "SSD", 512, 2, 1, "Dell", 15.6, 1200.0, null);
        boolean resultado = true;
        if (computador == null) resultado = false;
        if (!computador.getMarca().equals("Dell")) resultado = false;
        if (!computador.getCategoria().equals("Laptop")) resultado = false;
        if (!computador.getMarcaCpu().equals("Intel")) resultado = false;
        if (Math.abs(computador.getVelocidadCpU() - 2.5) > 0.001) resultado = false;
        if (!computador.getTecnologiaRam().equals("DDR4")) resultado = false;
        if (computador.getCapacidadRam() != 16) resultado = false;
        if (!computador.getTecnologiaDisco().equals("SSD")) resultado = false;
        if (computador.getCapacidadDisco() != 512) resultado = false;
        if (computador.getNumPuertosUSB() != 2) resultado = false;
        if (computador.getNumPuertosHDMI() != 1) resultado = false;
        if (!computador.getMarcaMonitor().equals("Dell")) resultado = false;
        if (Math.abs(computador.getPulgadas() - 15.6) > 0.001) resultado = false;
        if (Math.abs(computador.getPrecio() - 1200.0) > 0.001) resultado = false;
        if (computador.getUsuario_id() != null) resultado = false;

        if (resultado) {
            System.out.println("Prueba crearComputador: EXITO");
        } else {
            System.err.println("Prueba crearComputador: FALLÓ");
        }
    }

    public static void probarSettersYGettersComputador() {
        System.out.println("Ejecutando prueba: probarSettersYGettersComputador");
        Computador computador = new Computador();
        computador.setId(101);
        computador.setMarca("HP");
        computador.setPrecio(950.50);

        boolean resultado = true;
        if (computador.getId() != 101) resultado = false;
        if (!computador.getMarca().equals("HP")) resultado = false;
        if (Math.abs(computador.getPrecio() - 950.50) > 0.001) resultado = false;

        if (resultado) {
            System.out.println("Prueba settersYGettersComputador: EXITO");
        } else {
            System.err.println("Prueba settersYGettersComputador: FALLÓ");
        }
    }

    public static void probarComputadorConUsuarioAsignado() {
        System.out.println("Ejecutando prueba: probarComputadorConUsuarioAsignado");
        Computador computador = new Computador("Apple", "Desktop", "M1", 3.2, "DDR5", 32, "NVMe", 1000, 4, 2, "Apple", 27.0, 2500.0, 5);
        boolean resultado = true;
        if (computador.getUsuario_id() != 5) resultado = false;

        if (resultado) {
            System.out.println("Prueba computadorConUsuarioAsignado: EXITO");
        } else {
            System.err.println("Prueba computadorConUsuarioAsignado: FALLÓ");
        }
    }

    public static void main(String[] args) {
        probarCrearComputador();
        probarSettersYGettersComputador();
        probarComputadorConUsuarioAsignado();
    }
}
