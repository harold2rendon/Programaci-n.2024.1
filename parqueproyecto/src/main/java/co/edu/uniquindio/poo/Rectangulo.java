package co.edu.uniquindio.poo;

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    


    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public double calcularArea(){
        return base*altura;
    }



    @Override
    public double CalcularArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularArea'");
    }
    
    
}
