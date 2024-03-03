//El peso sera tomado solamente en unidades de kilogramos (KG)
//La edad sera tomada solamente en  años 

package co.edu.uniquindio.poo;

public record Mascota(String nombre, String id, String especie, String raza, byte edad, String género, String  color, int peso ) {
    public Mascota{
        assert nombre != null && !nombre.isBlank(): "El nombre debe ser diferente de null";    
        assert id != null && !id.isBlank(): "El id debe ser diferente de null";
        assert especie != null: "La  especie debe ser diferente de null";
        assert raza != null && raza.isBlank() : "La  raza debe ser diferente de null";
        assert edad > 0 : "La edad debe ser mayor a cero";
        assert género != null && género.isBlank(): "El genero no puede ser null";
        assert color != null && color.isBlank(): "El color no puede ser null";
        assert peso > 0 : "El peso debe ser mayor a cero";
    }
    

    public String nombre() {
        return nombre;
    }


    public String id() {
        return id;
    }


    public String especie() {
        return especie;
    }


    public String raza() {
        return raza;
    }


    public byte edad() {
        return edad;
    }


    public String género() {
        return género;
    }


    public String color() {
        return color;
    }


    public int peso() {
        return peso;
    }


    public boolean isMayorDeDiezAños() {
        return this.edad > 10;
    }

    @Override
    public String toString() {
        return "Mascota [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + ", edad=" + edad + ", genero=" + género + ", color=" + color + ", peso=" + peso + "]";
    }

}



