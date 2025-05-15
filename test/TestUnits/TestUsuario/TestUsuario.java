package TestUnits.TestUsuario;

import Models.Entities.Usuario;

public class TestUsuario {

    public static void probarCrearUsuario() {
        System.out.println("Ejecutando prueba: probarCrearUsuario");
        Usuario usuario = new Usuario(100, "test100 test100", "test100", "test100", "test100@gmail.com");
        boolean resultado = true;
        if (usuario == null) resultado = false;
        if (!usuario.getNombre().equals("test100 test100")) resultado = false;
        if (!usuario.getUsername().equals("test100")) resultado = false;
        if (!usuario.getPassword().equals("test100")) resultado = false;
        if (!usuario.getEmail().equals("test100@gmail.com")) resultado = false;

        if (resultado) {
            System.out.println("Prueba crearUsuario: EXITO");
        } else {
            System.err.println("Prueba crearUsuario: FALLÓ");
        }
    }

    public static void probarSettersYGettersUsuario() {
        System.out.println("Ejecutando prueba: probarSettersYGettersUsuario");
        Usuario usuario = new Usuario();
        usuario.setId(20);
        usuario.setNombre("test20 test20");
        usuario.setUsername("test20");
        usuario.setPassword("test20");
        usuario.setEmail("test20@gmail.com");

        boolean resultado = true;
        if (usuario.getId() != 20) resultado = false;
        if (!usuario.getNombre().equals("test20 test20")) resultado = false;
        if (!usuario.getUsername().equals("test20")) resultado = false;
        if (!usuario.getPassword().equals("test20")) resultado = false;
        if (!usuario.getEmail().equals("test20@gmail.com")) resultado = false;

        if (resultado) {
            System.out.println("Prueba settersYGettersUsuario: EXITO");
        } else {
            System.err.println("Prueba settersYGettersUsuario: FALLÓ");
        }
    }

    public static void main(String[] args) {
        probarCrearUsuario();
        probarSettersYGettersUsuario();
    }
}
