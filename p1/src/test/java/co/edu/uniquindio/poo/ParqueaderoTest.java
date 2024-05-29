package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    // Prueba para agregarVehiculoPorPuesto
    @Test
    public void agregarVehiculoPorPuesto(){
        Parqueadero parqueadero = new Parqueadero("parqueadero sur", 5);
        Propietario propietario = new Propietario("Luis", "sandoval", 30, "320543123","65432", "luis@got.co");
        Carro carro = new Carro("ABC123","2003", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 2, 3);
        assertEquals(false, parqueadero.verificarPuesto(2, 3));
    }

    // Prueba para eliminarVehiculoPorPuesto
    @Test
    public void eliminarVehiculoPorPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero sur", 5);
        Propietario propietario = new Propietario("Luis", "sandoval", 30, "320543123","65432", "luis@got.co");
        Carro carro = new Carro("ABC123","2003", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 3, 1);
        assertEquals(false, parqueadero.verificarPuesto(3, 1));
        parqueadero.eliminarVehiculoPorPuesto(3, 1, LocalDateTime.now().plusHours(1));
    }

    /*
    Prueba para agregarVehiculoPorPuestoInvalido
    La prueba deberia fallar ya que el puesto debe estar entre el numero de puestos creados
    Por ende la prueba es correcta
    */
    @Test
    public void agregarVehiculoPorPuestoInvalido() {
        Parqueadero parqueadero = new Parqueadero("parqueadero sur", 5);
        Propietario propietario = new Propietario("Luis", "sandoval", 30, "320543123","65432", "luis@got.co");
        Carro carro = new Carro("ABC123","2003", propietario);
        assertThrows(Throwable.class, () -> parqueadero.agregarVehiculoPorPuesto(carro, 5, 8));
    }

    /* 
    Prueba para eliminarVehiculoInvalidoPuesto
    La prueba deberia fallar ya que el puesto debe estar entre el numero de puestos creados
    Por ende la prueba es correcta
    */ 
    @Test
    public void eliminarVehiculoInvalidoPuesto() {
        Parqueadero parqueadero = new Parqueadero("parqueadero sur", 5);
        Propietario propietario = new Propietario("Luis", "sandoval", 30, "320543123","65432", "luis@got.co");
        Carro carro = new Carro("ABC123","2003", propietario);
        parqueadero.agregarVehiculoPorPuesto(carro, 2, 1);
        assertThrows(Throwable.class, () -> parqueadero.eliminarVehiculoPorPuesto(6, 9, null));
    }

    /*
    prueba propietario edad menor a dieciseis
    La prueba deberia fallar ya que debe ser mayor dieciseis
    Por ende la prueba es correcta
    */
    @Test
    public void propietarioEdadMenor(){
        Propietario propietario = new Propietario("Luis", "sandoval", 15, "320543123","65432", "luis@got.co");
        assertEquals(30, propietario.getEdad());
    }

    /*
    Prueba con nombres y apellidos en blanco 
    La prueba deberia fallar ya que los nombres y apellidos se ingresaron en blanco
    Por ende la prueba es correcta
    */
    @Test
    public void nombresApellidosPropietarioEnBlanco() {
        Propietario propietario = new Propietario(" ", " ", 16, "320543123", "65432", "luis@got.co");
        assertEquals("Luis", propietario.getNombres());
        assertEquals("sandoval", propietario.getApellidos());
    }

    /*
    Prueba fecha de entrada nula 
    La prueba deberia fallar ya que se ingresa una fecha de entrada nula 
    Por ende la prueba es correcta
    */
    @Test
    public void fechaEntradaNula(){
        Registro registro = new Registro(null, null, null);
        assertEquals(2022-05-24, registro.getFechaEntrada());
    }

    /*
    Prueba puestos de parqueadero negativo
    La prueba deberia fallar ya que los puestos de parqueadero no pueden ser negativos
    Por ende la prueba es correcta
     */
    @Test 
    public void puestoNegativos(){
        Parqueadero parqueadero = new Parqueadero("parqueadero sur", -5);
        assertEquals(5, parqueadero.getPuestos());
    }

    /* 
    Prueba tipo de moto nula
    La prueba deberia fallar ya que el tipo de moto no puede ser nulo
    Por ende la prueba es correcta
    */
    @Test
    public void tipoMotoNula(){
        Moto moto = new Moto("ABC23D", "2024", null, 90, null);
        assertEquals(TipoMoto.MOTO_CLASICA, moto.getTipoMoto());
    }
}