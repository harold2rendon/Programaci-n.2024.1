package co.edu.uniquindio.poo;

public enum Municipio {
    ARMENIA(0), CARLARCA(10.000), MONTENEGRO(20.000), QUIMBAYA(30.000), TEBAIDA(15.000), CIRCASIA(18.000), FILANDIA(22.000), GENOVA(70.000), SALENTO(50.000), PIJAO(40.000),CORDOBA(30.000), BUENAVISTA(35.000); // Declaracion de los municipios junto con sus sobrecostos
    
    private final double sobreCosto;  

    private Municipio(double sobreCosto) {    
        this.sobreCosto = sobreCosto;
    }

    public double getSobreCosto() {
        return sobreCosto;
    }
}