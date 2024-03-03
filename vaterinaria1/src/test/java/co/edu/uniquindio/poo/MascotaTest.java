package co.edu.uniquindio.poo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class MascotaTest {
    private static final Logger LOG = Logger.getLogger(MascotaTest.class.getName());
    

    @Test
    public void datosCompletos() {
        LOG.info("inicio de prueba con datos completos");
        Mascota mascota = new Mascota("lukas", "perro" , "labrador", (byte) 3, "macho", "negro", (Double) 45.0 );
        assertEquals("lukas", mascota.nombre());
        assertEquals("perro", mascota.especie());
        assertEquals("labrador", mascota.raza());
        assertEquals(3, mascota.edad());
        assertEquals("macho", mascota.género());
        assertEquals("negro", mascota.color());
        assertEquals(45, mascota.peso());
        LOG.info("fin de la prueba con datos completos");
    }

    @Test
    public void datosErrados(){
        LOG.info("Inicio de la prueba datos errados");
        Mascota mascota1 = new Mascota("lukas", "perro" , "12", (byte) 3, "macho", "negro", (Double) 45.0 );
        assertEquals("lukas", mascota1.nombre());
        assertEquals("perro", mascota1.especie());
        assertEquals("labrador", mascota1.raza());
        assertEquals(3, mascota1.edad());
        assertEquals("macho", mascota1.género());
        assertEquals("negro", mascota1.color());
        assertEquals(45, mascota1.peso());
        LOG.info("fin de la prueba con datos errados");
    }

    @Test
    public void datosIncompletos(){
        LOG.info("inicio de prueba con datos incompletos");
        
        Mascota mascota2 = new Mascota("piro", " perro" , "abisino", (byte) 1, "hembra", "blanco", (Double) 7.0);
        assertEquals("piro", mascota2.nombre());
        assertEquals(" ", mascota2.especie());
        assertEquals("abisino ", mascota2.raza());
        assertEquals(1, mascota2.edad());
        assertEquals("hembra", mascota2.género());
        assertEquals("blanco", mascota2.color());
        assertEquals(7, mascota2.peso());
        LOG.info("fin de la prueba con datos incompletos");
    }
    @Test
    public void datosNegativos(){
        LOG.info("inicio de prueba con datos negativos");
        
        Mascota mascota2 = new Mascota("piro", "perro" , "abisino", (byte) 1, "hembra", "blanco", (Double) 7.0);
        assertEquals(-1, mascota2.edad());
        assertEquals(-7, mascota2.peso());
        LOG.info("fin de la prueba con datos negativos");
    }
    @Test
    public void mascotasDistintas() {
        LOG.info("Comprobando que dos mascotas iguales se consideren iguales");
        Mascota mascota1 = new Mascota("Bobby", "Perro", "Labrador", (byte) 5, "macho", "Negro", (Double) 30.5);
        Mascota mascota2 = new Mascota("Bobby", "vaca", "equino", (byte) 5, "macho", "Negro", (Double) 30.5);
        assertNotEquals(mascota1, mascota2);
        LOG.info("Fin de comprobacion");
    }

}

