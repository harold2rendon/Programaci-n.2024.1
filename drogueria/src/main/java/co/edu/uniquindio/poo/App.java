//intento de hacer interfaz no es tan completa
package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DrogueriaApp drogueriaApp = new DrogueriaApp();
        drogueriaApp.iniciar();
    }
}

class DrogueriaApp {
    private Scanner scanner;
    private Gerente gerente;

    public DrogueriaApp() {
        scanner = new Scanner(System.in);
        Producto paracetamol = new Medicamento("1", "Paracetamol", "Analgesico", 5000, 150, "Farmacia verde", 500);
        Producto shampoo = new CuidadoPersonal("2", "h&s", "limpieza para el cabello", 30000, 30, "Tienda azul", "Menta, sulfato");
        Producto jabon = new Hogar("4", "Rey", "Multiusos", 1500, 3, "Supermercado rojo", "Uselo en ropa, pisos y otros");

        this.gerente  = new Gerente("David", "Villa", "1234567", "Cerca de alla", "098765432", 2500000);
        this.gerente.agregarProducto(jabon, 80);
        this.gerente.agregarProducto(shampoo, 150);
        this.gerente.agregarProducto(paracetamol, 50);
    }
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    realizarPedido();
                    break;
                case 2:
                    listarProductosConStockMayorA100();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
        System.out.println("¡Gracias por visitar la Droguería Saludable!");
    }

    private void mostrarMenu() {
        System.out.println("Bienvenido a la Droguería Saludable");
        System.out.println("1. Realizar Pedido");
        System.out.println("2. Listar Productos con Stock Mayor a 100");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opción:");
    }

    private void realizarPedido() {
        System.out.println("Creación de nuevo pedido:");

        Cliente cliente = solicitarDatosCliente();

        Pedido pedido = new Pedido(LocalDate.now(), 0);
        boolean agregarOtroProducto = true;

        while (agregarOtroProducto) {
            System.out.println("Seleccione un producto para agregar al pedido:");
            listarProductosDisponibles();

            System.out.println("Ingrese el código del producto:");
            int codigoProducto = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Ingrese la cantidad deseada:");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); 

            
            Producto producto = null;
            for (Producto product : gerente.obtenerProductosStockMayorA100()) {
                System.out.println("codigo del producto"+ product.getCodigoProducto());
                if (product.getCodigoProducto().equals(String.valueOf(codigoProducto))) {
                    producto = product;
                    break;
                }
            }

            if (producto != null) {
                pedido.agregarProducto(producto, cantidad);
                System.out.println("Producto agregado al pedido.");
            } else {
                System.out.println("No se encontró ningún producto con el código ingresado.");
            }

            System.out.println("¿Desea agregar otro producto? (S/N)");
            String respuesta = scanner.nextLine();
            agregarOtroProducto = respuesta.equalsIgnoreCase("S");
        }

        
        System.out.println("Resumen del pedido:");
        System.out.println(pedido);
    }

    private Cliente solicitarDatosCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombres = scanner.nextLine();

        System.out.println("Ingrese los apellidos del cliente:");
        String apellidos = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese el número de teléfono del cliente:");
        String telefono = scanner.nextLine();

        return new Cliente(nombres, apellidos, dni, direccion, telefono);
    }

    private void listarProductosConStockMayorA100() {
        Collection<Producto> productos = gerente.obtenerProductosStockMayorA100();
        System.out.println("Productos con stock mayor a 100:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    
    private void listarProductosDisponibles() {
        System.out.println("Productos disponibles:");
        for (Producto producto : gerente.obtenerProductosStockMayorA100()) {
            System.out.println(producto.getCodigoProducto() + ": " + producto.getNombre());
        }
    }
}
