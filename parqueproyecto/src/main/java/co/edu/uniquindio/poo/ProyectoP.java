package co.edu.uniquindio.poo;

import java.util.ArrayList;

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

    
}

