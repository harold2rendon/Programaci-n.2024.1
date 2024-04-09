package co.edu.uniquindio.poo;

import java.util.List;

public class ParqueInfantil {
    private String nombreParque;
    private String descripcion;
    private Municipio municipio;
    private List <Zona> listaZonas;
    private Material material;
    private FiguraGeometrica figuraGeometrica;
    
    
    public ParqueInfantil(String nombreParque, String descripcion, Municipio municipio, List<Zona> listaZonas,
            Material material, FiguraGeometrica figuraGeometrica) {
        this.nombreParque = nombreParque;
        this.descripcion = descripcion;
        this.municipio = municipio;
        this.listaZonas = listaZonas;
        this.material = material;
        this.figuraGeometrica = figuraGeometrica;
    }

    public void agregarZona(Zona zona) {
        for (Zona z : listaZonas) {
            if (z.getNombre().equals(zona.getNombre())) {
                throw new IllegalArgumentException("Ya existe una zona con ese nombre en el parque.");
            }
        }
        listaZonas.add(zona);
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

    public Material getMaterial() {
        return material;
    }

    public FiguraGeometrica getFiguraGeometrica() {
        return figuraGeometrica;
    }
}


