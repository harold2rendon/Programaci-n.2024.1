package co.edu.uniquindio.poo;

public abstract class ProductoBase {
    private String nombre;
    private double precio;
    private int cantidad;
    

    public ProductoBase(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularPrecioTotal() {
        return precio * cantidad;
    }
    
    public abstract String DescripcionProducto();
}


