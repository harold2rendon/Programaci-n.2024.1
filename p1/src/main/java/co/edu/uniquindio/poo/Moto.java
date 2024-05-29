package co.edu.uniquindio.poo;

// Clase moto la cual hereda de vehiculo sus atributos, ademas tinene atributos propios commo la velocidad maxima
public class Moto extends Vehiculo {
    private final double velocidadMaxima;
    private final TipoMoto tipoMoto;
    private static final double TARIFA_POR_HORA_CLASICA = 1.0; 
    private static final double TARIFA_POR_HORA_HIBRIDA = 1.5; 


    // Constructor de la clase
    public Moto(String placa, String modelo, Propietario propietario, double velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);

        assert velocidadMaxima > 0 : "La velocidad máxima debe ser mayor a cero";
        assert tipoMoto != null : "El tipo de moto debe ser diferente de nulo";

        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
    }

    // Métodos get de la clase Moto
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    @Override
    public double getTarifaPorHora() {
        return (tipoMoto == TipoMoto.MOTO_CLASICA) ? TARIFA_POR_HORA_CLASICA : TARIFA_POR_HORA_HIBRIDA;
    }
}