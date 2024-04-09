package co.edu.uniquindio.poo;

public class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado){
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser un valor positivo");
        }
        this.lado=lado;
    }
    public double calcularArea(){
        return lado*lado;
        
    }


    @Override
    public double CalcularArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularArea'");
    }
    
}
