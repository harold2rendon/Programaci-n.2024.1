package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ProductoBase pastel = new  Pastel("chocolate", "grande" , "pastel de chocolate", 10000, 3 );
        ProductoBase pan = new Pan("artesnal", "500", "pan artesanal", 5000, 1);
        ProductoBase galleta = new Galleta("chispas", "Galleta de chispas" , 1000, 6);

        System.out.println(pastel.DescripcionProducto() + " - Precio Total: $" + pastel.calcularPrecioTotal());
        System.out.println(pan.DescripcionProducto() + " - Precio Total: $" + pan.calcularPrecioTotal());
        System.out.println(galleta.DescripcionProducto() + " - Precio Total: $" + galleta.calcularPrecioTotal());
    }
}



        
