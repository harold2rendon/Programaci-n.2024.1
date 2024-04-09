package co.edu.uniquindio.poo;

public class Zona {
    private String nombre;
    private Material material;
    private FiguraGeometrica figuraGeometrica;

    public Zona(String nombre, Material material, FiguraGeometrica figuraGeometrica) {
        this.nombre = nombre;
        this.material = material;
        this.figuraGeometrica = figuraGeometrica;
    }

    public String getNombre() {
        return nombre;
    }

    public Material getMaterial() {
        return material;
    }

    public FiguraGeometrica getFiguraGeometrica() {
        return figuraGeometrica;
    }

}
