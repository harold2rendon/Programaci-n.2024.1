package co.edu.uniquindio.poo;
// Clase comprador la cual hereda de persona sus atributos
public class Comprador extends Persona {
    
    public Comprador(String nombres, String apellidos, Byte edad, String telefono, String identificacion,
            String correo) {
        super(nombres, apellidos, edad, telefono, identificacion, correo);
    }
}