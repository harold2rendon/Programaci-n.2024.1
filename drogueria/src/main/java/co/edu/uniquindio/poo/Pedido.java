package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private LocalDate fecha;
    private int cantidad;
    private Map<Producto, Integer> item;

    public Pedido(LocalDate fecha, int cantidad){
        this.cantidad = cantidad;
        this.item = new HashMap<>();
    }
    public void agregarProducto(Producto producto, int cantidad) {
        item.put(producto, cantidad);
    }
    // Metodo para determinar el costo total  del pedido
    public double calcularCostoTotal() {
        double costoTotal=0;
        for (Map.Entry<Producto, Integer> entry : item.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            costoTotal += producto.getPrecio() * cantidad;
        }
        return costoTotal;
    }
    // Metodo para verificar si hay suficiente producto en Stock
    public boolean verificarStockSuficiente() {
        for (Map.Entry<Producto, Integer> entry : item.entrySet()) {
            Producto producto = entry.getKey();
            int cantidadPedido = entry.getValue();
            int stockDisponible = producto.getStock();
            if (stockDisponible < cantidadPedido) {
                return false; 
            }
        }
        return true;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public Map<Producto, Integer> getItem() {
        return item;
    }
}
