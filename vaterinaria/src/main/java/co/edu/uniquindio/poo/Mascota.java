//El peso sera tomado solamente en unidades de kilogramos (KG)
//La edad sera tomada solamente en  años 

package co.edu.uniquindio.poo;

public record Mascota(String nombre, String especie, String raza, byte edad, String género, String  color, Double peso ) {
    public Mascota{
    }
}

