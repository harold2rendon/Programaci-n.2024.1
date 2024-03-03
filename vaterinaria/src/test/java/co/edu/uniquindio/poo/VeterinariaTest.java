package co.edu.uniquindio.poo;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.uniquindio.poo.Mascota;
import co.edu.uniquindio.poo.Veterinaria;




public class VeterinariaTest {
    private static final Logger LOG = Logger.getLogger( MascotaTest.class.getName());
    
  
    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        var veterinaria = new Veterinaria("amigos peludos");

        assertEquals("amigos peludos", veterinaria.getNombre());

        LOG.info("Finalización datosCompletos");
    }
     @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");

        assertThrows(Throwable.class, () -> new Veterinaria(null));

        LOG.info("Finalización datosNulos");
    }
}