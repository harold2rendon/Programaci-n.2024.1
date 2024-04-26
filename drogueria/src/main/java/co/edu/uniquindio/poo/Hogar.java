package co.edu.uniquindio.poo;

public class Hogar extends Producto {
    private String indicaciones;

    public Hogar(String codigoProducto, String nombre, String descripcion, double precio, int stock, String proveedor,
            String indicaciones) {
        super(codigoProducto, nombre, descripcion, precio, stock, proveedor);
        this.indicaciones = indicaciones;
    }

    public String getIndicaciones() {
        return indicaciones;
    }
}
