package co.edu.uniquindio.poo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class MascotaTest {
    private static final Logger LOG = Logger.getLogger(MascotaTest.class.getName());

    @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");
        assertThrows(Throwable.class, () -> new Mascota(null, null, null, null, (byte) 3, null, null, (int) 45 ));
        LOG.info("Finalización datosNulos");
        }
    /**
     *  * Prueba para verificar que los datos de una mascota no estén vacios
     */  
    @Test
    public void datosVacios() {
        LOG.info("Inicio datosVacios");
        assertThrows(Throwable.class, () -> new Mascota("", "", "", "labrador", (byte) 3, "macho", "negro", (int) 45));
        LOG.info("Finalización datosVacios");
    }
    /**
    *  Prueba para verificar que la edad de la mascota este correcta
    */  
    @Test
    public void edadNegativos(){
        LOG.info("inicio de prueba con datos negativos");
        assertThrows(Throwable.class, () -> new Mascota("lukas", "1101505", "perro" , "labrador", (byte) -3, "macho", "negro", (int) 45 ));
        LOG.info("fin de la prueba con datos negativos");
    }
     /**
     * * Prueba para verificar que dos la mascotas sean distintas
     */
    @Test
    public void pesoNegativo() {
        LOG.info("inicio de prueba con datos negativos");
        assertThrows(Throwable.class, () -> new Mascota("lukas", "1101505", "perro" , "labrador", (byte) 3, "macho", "negro", (int) -45));
        LOG.info("fin de la prueba con datos negativos");
    }
}