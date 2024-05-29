package co.edu.uniquindio.poo;

import javax.swing.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Main {
    private static Parqueadero parqueadero;

    public static void main(String[] args) {
        // Inicializar el parqueadero
        String nombreParqueadero = JOptionPane.showInputDialog("Ingrese el nombre del parqueadero:");
        String numeroPuestosStr = JOptionPane.showInputDialog("Ingrese el número de puestos del parqueadero:");
        int numeroPuestos = Integer.parseInt(numeroPuestosStr);
        parqueadero = new Parqueadero(nombreParqueadero, numeroPuestos);

        // Menú para que el usuario interactúe
        while (true) {
            String opcion = JOptionPane.showInputDialog("Menú:\n" +
                    "1. Agregar vehículo\n" +
                    "2. Eliminar vehículo\n" +
                    "3. Verificar estado de un puesto\n" +
                    "4. Generar reporte diario\n" +
                    "5. Generar reporte mensual\n" +
                    "6. Obtener información del propietario por puesto\n" +
                    "7. Salir");

            switch (opcion) {
                case "1":
                    agregarVehiculoPorPuesto();
                    break;
                case "2":
                    eliminarVehiculoPorPuesto();
                    break;
                case "3":
                    verificarPuesto();
                    break;
                case "4":
                    generarReporteDiario();
                    break;
                case "5":
                    generarReporteMensual();
                    break;
                case "6":
                    obtenerPropietarioPorPuesto();
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void agregarVehiculoPorPuesto() {
        String[] vehiculoOptions = {"Carro", "Moto"};
        int tipoVehiculo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de vehículo", "Agregar vehículo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehiculoOptions, vehiculoOptions[0]);

        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

        String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
        String apellidoPropietario = JOptionPane.showInputDialog("Ingrese el apellido del propietario:");
        int edadPropietario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del propietario:"));
        String telefonoPropietario = JOptionPane.showInputDialog("Ingrese el teléfono del propietario:");
        String identificacionPropietario = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");
        String correoPropietario = JOptionPane.showInputDialog("Ingrese el correo del propietario:");

        Propietario propietario = new Propietario(nombrePropietario, apellidoPropietario, edadPropietario, telefonoPropietario, identificacionPropietario, correoPropietario);

        if (tipoVehiculo == 0) {
            Vehiculo carro = new Carro(placa, modelo, propietario);
            int posicionI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición I del puesto:"));
            int posicionJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición J del puesto:"));
            parqueadero.agregarVehiculoPorPuesto(carro, posicionI, posicionJ);
        } else if (tipoVehiculo == 1) {
            double velocidadMaxima = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto:"));
            String[] tipoMotoOptions = {"Clásica", "Híbrida"};
            int tipoMotoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el tipo de moto", "Agregar moto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipoMotoOptions, tipoMotoOptions[0]);
            TipoMoto tipo = (tipoMotoSeleccionado == 0) ? TipoMoto.MOTO_CLASICA : TipoMoto.MOTO_HIBRIDA;

            Vehiculo moto = new Moto(placa, modelo, propietario, velocidadMaxima, tipo);
            int posicionI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición I del puesto:"));
            int posicionJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición J del puesto:"));
            parqueadero.agregarVehiculoPorPuesto(moto, posicionI, posicionJ);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de vehículo inválido.");
        }
    }

    private static void eliminarVehiculoPorPuesto() {
        int posicionI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición I del puesto:"));
        int posicionJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición J del puesto:"));
        String fechaSalidaStr = JOptionPane.showInputDialog("Ingrese la fecha y hora de salida (YYYY-MM-DDTHH:MM):");
        LocalDateTime fechaSalida = LocalDateTime.parse(fechaSalidaStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        double costo = parqueadero.eliminarVehiculoPorPuesto(posicionI, posicionJ, fechaSalida);
        JOptionPane.showMessageDialog(null, "El costo total por el tiempo estacionado es: $" + costo);
    }

    private static void verificarPuesto() {
        int posicionI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición I del puesto:"));
        int posicionJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición J del puesto:"));
        boolean disponible = parqueadero.verificarPuesto(posicionI, posicionJ);
        JOptionPane.showMessageDialog(null, "El puesto (" + posicionI + "," + posicionJ + ") está " + (disponible ? "disponible" : "ocupado"));
    }

    private static void generarReporteDiario() {
        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha del reporte (YYYY-MM-DD):");
        LocalDate fecha = LocalDate.parse(fechaString);
        double reporte = parqueadero.generarReporteDiario(fecha);
        JOptionPane.showMessageDialog(null, "Dinero recaudado el " + fecha + ": $" + reporte);
    }

    private static void generarReporteMensual() {
        String mesString = JOptionPane.showInputDialog("Ingrese el mes del reporte (YYYY-MM):");
        YearMonth mes = YearMonth.parse(mesString);
        double reporte = parqueadero.generarReporteMensual(mes);
        JOptionPane.showMessageDialog(null, "Dinero recaudado en " + mes + ": $" + reporte);
    }

    private static void obtenerPropietarioPorPuesto() {
        int posicionI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición I del puesto:"));
        int posicionJ = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición J del puesto:"));
        Propietario propietario = parqueadero.obtenerPropietarioPorPuesto(posicionI, posicionJ);
        if (propietario != null) {
            JOptionPane.showMessageDialog(null, "Propietario del vehículo en el puesto (" + posicionI + "," + posicionJ + "):\n" +
                    "Nombre: " + propietario.getNombres() + " " + propietario.getApellidos() + "\n" +
                    "Edad: " + propietario.getEdad() + "\n" +
                    "Teléfono: " + propietario.getTelefono() + "\n" +
                    "Identificación: " + propietario.getIdentificacion() + "\n" +
                    "Correo: " + propietario.getCorreo());
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehículo en el puesto (" + posicionI + "," + posicionJ + ").");
        }
    }
}


