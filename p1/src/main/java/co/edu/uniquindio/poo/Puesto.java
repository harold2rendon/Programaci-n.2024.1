package co.edu.uniquindio.poo;

// Clase puesto se usara en el parqueadero para ubicar vehiculos
public class Puesto {
    private final int posicionI;
    private final int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;

    // Constructor de la clase Puesto
    public Puesto(int posicionI, int posicionJ, Estado estado) {
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
    }

    // Métodos get y set de la clase Puesto
    public int getPosicionI() {
        return posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public Estado getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}