package co.edu.uniquindio.poo;

import java.util.List;

public class ParqueInfantil {
    private String nombreParque;
    private String descripcion;
    private List <Zona> listaZonas;
    private Municipio municipio;
    
    public ParqueInfantil(String nombreParque, String descripcion, List<Zona> listaZonas, Municipio municipio) {
        this.nombreParque = nombreParque;
        this.descripcion = descripcion;
        this.listaZonas = listaZonas;
        this.municipio = municipio;
    }
    public String getNombreParque() {
        return nombreParque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Zona> getListaZonas() {
        return listaZonas;
    }

    public Municipio getMunicipio() {
        return municipio;
    }
}
