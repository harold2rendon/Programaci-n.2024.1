package co.edu.uniquindio.poo;

public class Medicamento extends Producto {
    private double dosis; // Ls dosis sera en mg

    public Medicamento(String codigoProducto, String nombre, String descripcion, double precio, int stock,
            String proveedor, double dosis) {
        super(codigoProducto, nombre, descripcion, precio, stock, proveedor);
        this.dosis = dosis;
    }

    public double getDosis() {
        return dosis;
    }
    
}
