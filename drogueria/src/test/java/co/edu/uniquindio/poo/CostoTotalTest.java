package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CostoTotalTest {
        private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

        @Test
        public void testCalcularCostoTotal(){
            LOG.info("inicio de prueba  CalcularCostoTotal");
            Cliente maria = new Cliente("Maria", "Gonzales", "12345", "Calle 123", "654321");
            Producto acetaminofen =  new Medicamento("1", "Acetaminofen", "Analgesico", 2000, 100, "Farmacia verde", 500);
            Producto shampoo = new CuidadoPersonal("2", "h&s", "limpieza para el cabello", 30000, 30, "Tienda azul", "Menta, sulfato");
            Producto jabon = new Hogar("4", "Rey", "Multiusos", 1500, 3, "Supermercado rojo", "Uselo en ropa, pisos y otros");

            Pedido pedidoMaria = new Pedido(LocalDate.now(), 3);
            pedidoMaria.agregarProducto(acetaminofen, 2);
            pedidoMaria.agregarProducto(shampoo, 1);
            pedidoMaria.agregarProducto(jabon, 5);
            
            double costoTotalEsperado = (2000 * 2) + (30000 * 1) + (1500 * 5);
            double costoTotalCalculado = pedidoMaria.calcularCostoTotal();
            assert costoTotalCalculado == costoTotalEsperado: "Error en el calculo del costo total" ;
            LOG.info("Prueba  pasada correctamente");

        }

}
