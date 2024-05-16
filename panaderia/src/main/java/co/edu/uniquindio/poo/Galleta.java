package co.edu.uniquindio.poo;

public class Galleta extends ProductoBase { 
    private String sabor;

    public Galleta(String sabor, String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
        this.sabor = sabor;
    }

    @Override
    public String DescripcionProducto() {
        return "galleta sabor a: " + sabor;
    }
}


   


