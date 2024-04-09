package co.edu.uniquindio.poo;

public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    
    public Triangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser valores positivos");
        }
        this.base = base;
        this.altura = altura;
    }
    public double calcularArea(){
        return(base*altura)/2;
    }


    @Override
    public double CalcularArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularArea'");
    }
    
    
}
