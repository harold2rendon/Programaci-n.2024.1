package co.edu.uniquindio.poo;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class Veterinaria {
    private final String nombre;
    private final LinkedList<Mascota> mascotas;

    public Veterinaria(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        mascotas = new LinkedList<>();
    }
    public String getNombre() {
        return nombre;
    }
    


    public void registrarMascota(Mascota mascota) {
        assert comprobarIdentificacionExiste(mascota.id()) == false: "El número de identificación ya existe.";
        mascotas.add(mascota);
    }

    public Mascota getMascota(String numeroIdentificación) {
        Mascota mascotaf = null;

        for (Mascota mascota : mascotas) {
            if (mascota.id().equals(numeroIdentificación)) {
                mascotaf = mascota;
            }
        }
        return mascotaf;
    }    

    public Collection<Mascota> getMascotas() {
        return Collections.unmodifiableCollection(mascotas);
    }

    private boolean comprobarIdentificacionExiste(String numeroIdentificación) {
        boolean existe = false;

        for (Mascota mascota : mascotas) {
            if (mascota.id().equals(numeroIdentificación)) {
                existe = true;
            }
        }

        return existe;
    }
 
    public LinkedList<Mascota> obtenerMascotasMayoresA(int edad) {
        LinkedList<Mascota> mascotasMayores = new LinkedList<>();
        for (Mascota mascota : mascotas) {
            if (mascota.edad() > edad) {
                mascotasMayores.add(mascota);
            }
        }
        return mascotasMayores;
    }
}


/*
   public class main {
        public static void main(String[] args) {
            Veterinaria amigosPeludos = new Veterinaria("");
    
            // Agregar algunas mascotas de ejemplo
            amigosPeludos.agregarMascota(new Mascota("lukas", "1101505", "perro", "labrador", (byte)3, "macho", "negro", (int) 45.0));
            amigosPeludos.agregarMascota(new Mascota("lukas", "1101505", "perro", "labrador", (byte)14, "macho", "negro", (int) 45.0));
            amigosPeludos.agregarMascota(new Mascota("lukas", "1101505", "perro", "labrador", (byte)12, "macho", "negro", (int) 45.0));
    
 

        // Obtener la lista de mascotas mayores a 10 años
        LinkedList<Mascota> mascotasMayores = amigosPeludos.obtenerMascotasMayoresA(10);
        System.out.println("Mascotas mayores a 10 años:");
        for (Mascota mascota : mascotasMayores) {
            System.out.println(mascota.nombre() + " - " + mascota.edad() + " años");
        }
    }
}
*/


