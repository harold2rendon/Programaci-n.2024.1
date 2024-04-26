package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class VerificarStockTest {
            private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

            @Test
            public void testVerificarStock(){
                LOG.info("inicio de prueba para verificar el stock");
                Cliente juan = new Cliente("Juan", "Gomez", "87654321", "Via alterna", "12357654");
                Producto ibuprofeno = new Medicamento("3", "ibuprofeno", "Para el dolor", 3000, 50, "La real", 400);
                Producto aspirina = new Medicamento("5", "aspirina", "Para la fiebre", 4000, 200, "Farmacenter", 500);
                
                Pedido pedidoJuan  = new Pedido(LocalDate.now(), 2);
                pedidoJuan.agregarProducto(ibuprofeno, 60); // Poco stock para suplir
                pedidoJuan.agregarProducto(aspirina, 2); // Stock suficiente para suplir

                boolean stockSuficiente = pedidoJuan.verificarStockSuficiente();
                assert !stockSuficiente : "El sistema debería haber indicado que no hay stock suficiente";
                LOG.info("fin de prueba para verificar el stock");
            }
        }
