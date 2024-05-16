package co.edu.uniquindio.poo;

public class Pastel extends ProductoBase {
    private String tamano;
    private String sabor;

    public Pastel(String sabor, String tamano, String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
        this.tamano = tamano;
        this.sabor = sabor;
    }

    @Override
    public double calcularPrecioTotal() {
        return getPrecio() * getCantidad();

    }

    @Override
    public String DescripcionProducto() {
        return "Pastel de: " + sabor + ", tamaño " + tamano; 
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
