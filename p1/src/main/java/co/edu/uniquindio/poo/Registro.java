package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

// Clase para realizar el registro de vehiculos, ademas de conocer algunos registros diarios y mensuales

public class Registro {
    private final LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private final Vehiculo vehiculo;

    // Constructor de la clase Registro
    public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo) {
        assert fechaEntrada != null : "La fecha de entrada no puede ser nula";

        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;
    }

    // Método para calcular el tiempo que estuvo estacionado un vehículo
    public int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long horas = tiempo.toHours();
        return (int) horas;
    }

    // Método para calcular el precio de la tarifa para cualquier vehículo
    public double calcularTarifa() {
        int tiempoEstacionado = calcularTiempo(fechaEntrada, fechaSalida);
        double tarifaPorHora = vehiculo.getTarifa();
        return tiempoEstacionado * tarifaPorHora;
    }

    // Métodos get y set de la clase Registro
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Registro [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", vehiculo=" + vehiculo
                + "]";
    }
}
