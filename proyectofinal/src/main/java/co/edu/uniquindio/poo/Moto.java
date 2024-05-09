package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int VelocidadMaxima;

    public Moto(String placa, String modelo,Propietario propietario, int tarifaMotoClasica,
            int tarifaMotoHibrida, int tarifacarro) {
        super(placa, modelo, propietario, tarifaMotoClasica, tarifaMotoHibrida, tarifacarro);
        this.VelocidadMaxima = VelocidadMaxima;
    }

    @Override
    public double calcularTarifaVehiculo() {
        
        return tarifaMotoClasica;

    }


}