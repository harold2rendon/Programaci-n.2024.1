package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Puesto {
    private Vehiculo vehiculo;
    private LocalDateTime fechaEntrada;
    private boolean disponible;

    public Puesto() {
        this.disponible = true;
    }
    // Metodo para saber si se ocupa un puesto
    public void ocupado(Vehiculo vehiculo, LocalDateTime fechaEntrada) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.disponible = false;
    }
    // Metodo para saber si no se ocupa un puesto
    public void desocupar() {
        this.vehiculo = null;
        this.fechaEntrada = null;
        this.disponible = true;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public boolean estaDisponible() {
        return disponible;
    }
}
