package co.edu.uniquindio.poo;

public class Producto {
    private String codigoProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String proveedor;
    public Producto(String codigoProducto, String nombre, String descripcion, double precio, int stock,
            String proveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }
    public String getCodigoProducto() {
        return codigoProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public String getProveedor() {
        return proveedor;
    }
    
}
