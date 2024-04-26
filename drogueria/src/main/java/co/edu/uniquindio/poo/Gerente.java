package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Gerente extends Empleado{
    private Map<Producto, Integer> stock;
    public Gerente(String nombres, String apellidos, String dni, String direccion, String telefono, double salario) {
        super(nombres, apellidos, dni, direccion, telefono, salario);
        this.stock = new HashMap<>();
    }
    // Metodo para agregar productos
    public void agregarProducto(Producto producto, int cantidad){
        if (stock.containsKey(producto)){
            int stockActual = stock.get(producto);
            stock.put(producto,stockActual + cantidad);
            }else {
                stock.put(producto,cantidad);
            }
        }
    // Metodo para eliminar productos
    public void eliminarUnoDeProducto(Producto producto, int cantidad){
        if(stock.containsKey(producto)){
            int stockActual = stock.get(producto);
            int nuevoStock =  stockActual - cantidad;
            if(nuevoStock <= 0){
                stock.remove(producto);
            } else {
                stock.put(producto,  nuevoStock);
            }
        }
    }
    // Metodo para obtener productos con stock mayor a 100
            public Collection<Producto> obtenerProductosStockMayorA100(){
                Collection<Producto> ProductosStockMayorA100 = new LinkedList<>();
                for (Map.Entry<Producto, Integer> entry : stock.entrySet()){
                    Producto producto = entry.getKey();
                    int cantidadStock = entry.getValue();
                    if (cantidadStock > 100) {
                        ProductosStockMayorA100.add(producto);
                    }
                }
                return  ProductosStockMayorA100;
            }
        }
    
    