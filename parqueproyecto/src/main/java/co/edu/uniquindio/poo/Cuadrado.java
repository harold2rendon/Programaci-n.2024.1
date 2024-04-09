package co.edu.uniquindio.poo;

public class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado){
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
