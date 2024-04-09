package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProyectoP {
    private String nombreProyecto;
    private ArrayList <ParqueInfantil> listaParqueInfantils;

    public ProyectoP(String nombreProyecto, ArrayList<ParqueInfantil> listaParqueInfantils) {
        this.nombreProyecto = nombreProyecto;
        this.listaParqueInfantils = listaParqueInfantils;
    }
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    public ArrayList<ParqueInfantil> getListaParqueInfantils() {
        return listaParqueInfantils;
    }

    public void agregarParque (ParqueInfantil parqueInfantil){
        for (ParqueInfantil p : listaParqueInfantils) {
            if (p.getNombreParque().equals(parqueInfantil.getNombreParque())) {
                throw new IllegalArgumentException("Ya existe el parque.");
            }
        }
        listaParqueInfantils.add(parqueInfantil);
    }

    public ParqueInfantil obtenerParquePorNombre(String nombre) {
        for (ParqueInfantil parque : listaParqueInfantils) {
            if (parque.getNombreParque().equals(nombre)) {
                return parque;
            }
        }
        return null; // Retorna null si no se encuentra ningún parque con el nombre dado
    }

    public ArrayList <ParqueInfantil> obtenerParquesPorMunicipio(Municipio municipio) {
        ArrayList<ParqueInfantil> parquesMunicipio = new ArrayList<>();
        for (ParqueInfantil parque : listaParqueInfantils) {
            if (parque.getMunicipio().equals(municipio)) {
                parquesMunicipio.add(parque);
            }
        }
        return parquesMunicipio;
    }

    public ArrayList <ParqueInfantil> listarParquesDiseñados() {
        ArrayList <ParqueInfantil> parquesOrdenados = new ArrayList<>(listaParqueInfantils);
        
        // Ordenar los parques por valor total de forma ascendente
        Collections.sort(parquesOrdenados, Comparator.comparingDouble(nullsFirst(Comparator.naturalOrder()));

        return parquesOrdenados;
    }

}

