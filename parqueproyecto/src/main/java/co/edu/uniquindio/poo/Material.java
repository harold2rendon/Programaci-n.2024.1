package co.edu.uniquindio.poo;

public enum Material {
    ARENA(10.000), GRAMA_SINTETICA(35.000), GRAMA_NATURAL(20.000), ASFALTO(40.000);  // Declaración de los materiales junto con sus valores por metro cuadrado
    private final double valorMetroCuadrado;

    private Material(double valorMetroCuadrado) {
        this.valorMetroCuadrado = valorMetroCuadrado;
    }

    public double getValorMetroCuadrado() {
        return valorMetroCuadrado;
    }
    
}
