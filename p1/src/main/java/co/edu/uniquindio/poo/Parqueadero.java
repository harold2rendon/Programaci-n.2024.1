package co.edu.uniquindio.poo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private final int numeroPuestos;
    private final Collection<Registro> registros;
    private final Hashtable<String, Puesto> puestos;
    private final Collection<Vehiculo> vehiculos;

    // Constructor de la clase parqueadero
    public Parqueadero(String nombre, int numeroPuestos) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede ser nulo ni tampoco vacío";
        assert numeroPuestos > 0 : "El número de puestos no puede ser negativo ni tampoco cero";

        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        this.registros = new LinkedList<>();
        this.puestos = new Hashtable<>();
        this.vehiculos = new LinkedList<>();

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
            int posicionI = i + 1;

            for (int j = 0; j < numeroPuestos; j++) {
                int posicionJ = j + 1;
                String llave = "(" + posicionI + "," + posicionJ + ")";
                puestos.put(llave, new Puesto(posicionI, posicionJ, Estado.DISPONIBLE));
            }
        }
    }

    // Método para verificar si el puesto de un parqueadero está ocupado o disponible
    boolean verificarPuesto(int posicionI, int posicionJ) {
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        return puesto != null && puesto.getEstado() == Estado.DISPONIBLE;
    }

    // Método para agregar un vehículo al parqueadero por puesto, solo se podrá agregar si el puesto está disponible
    public void agregarVehiculoPorPuesto(Vehiculo vehiculo, int posicionI, int posicionJ) {
        assert verificarPuesto(posicionI, posicionJ) : "Error, el puesto está ocupado";

        if (verificarPuesto(posicionI, posicionJ)) {
            Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
            puesto.setVehiculo(vehiculo);
            actualizarEstadoPorPuesto(posicionI, posicionJ, Estado.OCUPADO);
            LocalDateTime fechaEntrada = LocalDateTime.now();
            Registro registro = new Registro(fechaEntrada, null, vehiculo);
            registros.add(registro);
            vehiculos.add(vehiculo);
        }
    }

    // Método para eliminar un vehículo de un puesto del parqueadero, solo se podrá eliminar si el puesto está ocupado
    public void eliminarVehiculoPorPuesto(int posicionI, int posicionJ, LocalDateTime fechaSalida) {
        assert !verificarPuesto(posicionI, posicionJ) : "Error. El puesto se encuentra libre";

        if (!verificarPuesto(posicionI, posicionJ)) {
            Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
            Vehiculo vehiculoPuesto = puesto.getVehiculo();

            for (Registro registro : registros) {
                if (registro.getVehiculo().equals(vehiculoPuesto) && registro.getFechaSalida() == null) {
                    registro.setFechaSalida(fechaSalida);
                }
            }
            puesto.setVehiculo(null);
            actualizarEstadoPorPuesto(posicionI, posicionJ, Estado.DISPONIBLE);
        }
    }

    // Método para actualizar el estado de un puesto del parqueadero
    private void actualizarEstadoPorPuesto(int posicionI, int posicionJ, Estado estado) {
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        puesto.setEstado(estado);
    }

    // Método para generar un reporte del dinero que se recauda diariamente por vehículo en el parqueadero
    public Collection<Double> generarReporteDiario(LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha) && registro.getFechaSalida() != null) {
                Vehiculo vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();

                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.MOTO_CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }
                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return reporteDiario;
    }

    // Método para obtener la información de un propietario por medio del puesto que ocupa un vehículo
    public Propietario obtenerPropietarioPorPuesto(int posicionI, int posicionJ) {
        Puesto puesto = puestos.get("(" + posicionI + "," + posicionJ + ")");
        if (puesto != null && puesto.getEstado() == Estado.OCUPADO) {
            Vehiculo vehiculo = puesto.getVehiculo();
            return vehiculo.getPropietario();
        }
        return null;
    }

    // Método para generar un reporte del dinero recaudado mensualmente
    public double generarReporteMensual(YearMonth mes) {
        double dineroRecaudado = 0.0;
        int año = mes.getYear();
        int mesBuscado = mes.getMonthValue();
        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().getYear() == año
                    && registro.getFechaEntrada().toLocalDate().getMonthValue() == mesBuscado) {
                dineroRecaudado += registro.calcularTarifa();
            }
        }
        return dineroRecaudado;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", numeroPuestos=" + numeroPuestos + ", registros=" + registros
                + ", puestos=" + puestos + ", vehiculos=" + vehiculos + "]";
    }
}
