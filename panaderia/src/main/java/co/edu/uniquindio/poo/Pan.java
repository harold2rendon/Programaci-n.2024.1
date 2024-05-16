package co.edu.uniquindio.poo;

public class Pan extends ProductoBase {
    
    private String tipo;
    private String peso;

    public Pan(String tipo, String peso, String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
        this.tipo = tipo ;
        this.peso = peso;
    }
    @Override
    public double calcularPrecioTotal() {
        return getPrecio()*getCantidad();
    }
    @Override
    public String DescripcionProducto() {
        return "Pan " + tipo + " de: " + peso + " gramos";
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    

    
    
}
