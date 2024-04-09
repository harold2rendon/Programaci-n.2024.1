package co.edu.uniquindio.poo;

public class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public double calcularArea(){
        return Math.PI*radio*radio;
    }




    @Override
    public double CalcularArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalcularArea'");
    }
}
