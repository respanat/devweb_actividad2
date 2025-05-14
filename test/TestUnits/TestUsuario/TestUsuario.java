package TestUnits.TestUsuario;

import Models.Entities.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUsuario {

    @Test
    void testCrearUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ramiro España");
        usuario.setUsername("ramiro");
        usuario.setPassword("secreto");
        usuario.setEmail("ramiro@example.com");

	assertNotNull(usuario);
        assertEquals("Ramiro España", usuario.getNombre());
        assertEquals("ramiro", usuario.getUsername());
        assertEquals("secreto", usuario.getPassword());
        assertEquals("ramiro@example.com", usuario.getEmail());
    }

    @Test
    void testSettersAndGettersUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Andrés Pérez");
        usuario.setUsername("andres");
        usuario.setPassword("clave123");
        usuario.setEmail("andres@example.com");

        assertEquals(1, usuario.getId());
        assertEquals("Andrés Pérez", usuario.getNombre());
        assertEquals("andres", usuario.getUsername());
        assertEquals("clave123", usuario.getPassword());
        assertEquals("andres@example.com", usuario.getEmail());
    }
}
