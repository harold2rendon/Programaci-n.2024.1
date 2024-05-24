package co.edu.uniquindio.poo;


// Esta clase actuara como clase padre 
public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private final Propietario propietario;
    private double tarifa;

    // Constructor de la clase vehículo
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        assert placa != null && !placa.isBlank() : "La placa no puede ser nula ni vacía";
        assert modelo != null && !modelo.isBlank() : "El modelo no puede ser nulo ni vacío";

        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    // Métodos get y set de la clase Vehículo
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}