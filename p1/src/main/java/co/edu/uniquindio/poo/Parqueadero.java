package co.edu.uniquindio.poo;

import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private final int numeroPuestos;
    private final Collection<Registro> registros;
    private final Hashtable<String, Puesto> puestos;
    private final Collection<Vehiculo> vehiculos;
    private Map<LocalDate, Double> ingresosDiarios;


    // Constructor de la clase parqueadero
    public Parqueadero(String nombre, int numeroPuestos) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede ser nulo ni tampoco vacío";
        assert numeroPuestos > 0 : "El número de puestos no puede ser negativo ni tampoco cero";

        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        this.registros = new LinkedList<>();
        this.puestos = new Hashtable<>();
        this.vehiculos = new LinkedList<>();
        this.ingresosDiarios = new HashMap<>();


        crearPuestos(numeroPuestos);
    }

    // Métodos get de la clase parqueadero
    public String getNombre() {
        return nombre;
    }

    public int getNumeroPuestos() {
        return numeroPuestos;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public Hashtable<String, Puesto> getPuestos() {
        return puestos;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Método para crear el número de puestos que va a tener el parqueadero
    private void crearPuestos(int numeroPuestos) {
        for (int i = 0; i < numeroPuestos; i++) {
            for (int j = 0; j < numeroPuestos; j++) {
                this.puestos.put(i + "-" + j, new Puesto());
            }
        }
    }

    // Método para verificar si el puesto de un parqueadero está ocupado o disponible
    public boolean verificarPuesto(int posicionI, int posicionJ) {
        String key = posicionI + "-" + posicionJ;
        Puesto puesto = puestos.get(key);
        return puesto != null && puesto.estaDisponible();
    }

    // Método para agregar un vehículo al parqueadero por puesto, solo se podrá agregar si el puesto está disponible
    public void agregarVehiculoPorPuesto(Vehiculo vehiculo, int posicionI, int posicionJ) {
        String key = posicionI + "-" + posicionJ;
        Puesto puesto = puestos.get(key);
        if (puesto != null && puesto.estaDisponible()) {
            puesto.ocupado(vehiculo, LocalDateTime.now());
        }
    }
    // Método para eliminar un vehículo de un puesto del parqueadero, solo se elimina si está ocupado
    public double eliminarVehiculoPorPuesto(int posicionI, int posicionJ, LocalDateTime fechaSalida) {
        String key = posicionI + "-" + posicionJ;
        Puesto puesto = puestos.get(key);
        if (puesto != null && !puesto.estaDisponible()) {
            LocalDateTime fechaEntrada = puesto.getFechaEntrada();
            long minutosEstacionado = ChronoUnit.MINUTES.between(fechaEntrada, fechaSalida);
            double costo = calcularCosto(puesto.getVehiculo(), minutosEstacionado);
            puesto.desocupar();
            registrarIngreso(fechaSalida.toLocalDate(), costo);
            return costo;
        }
        return 0.0;
    }
    // Metodo para clacular el costo de estacionamiento
    private double calcularCosto(Vehiculo vehiculo, long minutosEstacionado) {
        double tarifaPorHora;
        if (vehiculo instanceof Carro) {
            tarifaPorHora = 2000.0; // Tarifa por hora para carros
        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            tarifaPorHora = moto.getTipoMoto() == TipoMoto.MOTO_CLASICA ? 1000.0 : 1500.0;
        } else {
            tarifaPorHora = 0.0;
        }
        return (minutosEstacionado / 60.0) * tarifaPorHora;
    }
    // Metodo para registrar el ingreso de un vehiculo
    private void registrarIngreso(LocalDate fecha, double ingreso) {
        ingresosDiarios.put(fecha, ingresosDiarios.getOrDefault(fecha, 0.0) + ingreso);
    }

    // Método para generar un reporte del dinero que se recauda diariamente por vehículo en el parqueadero
    public double generarReporteDiario(LocalDate fecha) {
        return ingresosDiarios.getOrDefault(fecha, 0.0);
    }

    // Método para obtener la información de un propietario por medio del puesto que ocupa un vehículo
    public Propietario obtenerPropietarioPorPuesto(int posicionI, int posicionJ) {
        String key = posicionI + "-" + posicionJ;
        Puesto puesto = puestos.get(key);
        if (puesto != null && !puesto.estaDisponible()) {
            return puesto.getVehiculo().getPropietario();
        }
        return null;
    }
    // Método para generar un reporte del dinero recaudado mensualmente
    public double generarReporteMensual(YearMonth mes) {
        return ingresosDiarios.entrySet().stream()
                .filter(entry -> YearMonth.from(entry.getKey()).equals(mes))
                .mapToDouble(Map.Entry::getValue)
                .sum();
    }
}

