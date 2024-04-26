package co.edu.uniquindio.poo;

public abstract class Persona {
    private String nombres;
    private String  apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    public Persona(String nombres, String apellidos, String dni, String direccion, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
}
