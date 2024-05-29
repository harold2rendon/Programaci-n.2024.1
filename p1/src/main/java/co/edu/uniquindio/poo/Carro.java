package co.edu.uniquindio.poo;

// Clase carro la cual hereda de vehiculo sus atributos
public class Carro extends Vehiculo {
    private static final double TARIFA_POR_HORA = 2.0;

    public Carro(String placa, String modelo,Propietario propietario) {
        super(placa, modelo, propietario);
    }

    @Override
    public double getTarifaPorHora() {
        return TARIFA_POR_HORA;
    }
}
