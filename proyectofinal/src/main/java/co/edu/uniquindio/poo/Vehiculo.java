package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario Propietario;
    public int tarifaMotoClasica;
    public int tarifaMotoHibrida;
    public int tarifacarro;

    
    public Vehiculo(String placa, String modelo,Propietario propietario, int tarifaMotoClasica,
            int tarifaMotoHibrida, int tarifacarro) {
        this.placa = placa;
        this.modelo = modelo;
        Propietario = propietario;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifacarro = tarifacarro;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return Propietario;
    }
    
public void setTarifaMotoClasica(int tarifaMotoClasica) {
        this.tarifaMotoClasica = tarifaMotoClasica;
    }

    public void setTarifaMotoHibrida(int tarifaMoto) {
        this.tarifaMotoHibrida = tarifaMoto;
    }

    public void setTarifaCarro(int carro) {
        this.tarifacarro = carro;
    }
    public abstract double calcularTarifaVehiculo();
    tiempoEstacionado= horaSalida - horaIngreso;

}
