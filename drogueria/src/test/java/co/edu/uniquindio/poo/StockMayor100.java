package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class StockMayor100 {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());
    
    @Test
    public void  testStockMayor100(){
        LOG.info("inicio de prueba para obtener el stock mayor a 100");
        Producto paracetamol = new Medicamento("1", "Paracetamol", "Analgesico", 5000, 150, "Farmacia verde", 500);
        Producto shampoo = new CuidadoPersonal("2", "h&s", "limpieza para el cabello", 30000, 30, "Tienda azul", "Menta, sulfato");
        Producto jabon = new Hogar("4", "Rey", "Multiusos", 1500, 3, "Supermercado rojo", "Uselo en ropa, pisos y otros");

        Gerente gerente  = new Gerente("David", "Villa", "1234567", "Cerca de alla", "098765432", 2500000);
        gerente.agregarProducto(jabon, 80);
        gerente.agregarProducto(shampoo, 150);
        gerente.agregarProducto(paracetamol, 50);

        Collection<Producto> productosStockMayor100 = gerente.obtenerProductosStockMayorA100();
        assertEquals(1, productosStockMayor100.size(),"Error al obtener productos con  stock mayor a 100");
        assertTrue(productosStockMayor100.contains(paracetamol), "Error al obtener productos con  stock mayor a 100");
        LOG.info("de prueba para obtener el stock mayor a 100");

    }
}
