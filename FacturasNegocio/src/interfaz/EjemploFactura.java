package interfaz;

import java.util.LinkedList;
import java.util.List;

import logica.Producto;
import logica.Factura;


public class EjemploFactura {

    public static void main(String[] args) {
        List<Producto> productos = new LinkedList<>();
        productos.add(new Producto(6767, "Blahaj", 10000.0));
        productos.add(new Producto(4521, "Foto de Andrey con beso", 250.0));
        productos.add(new Producto(6969, "Yellow Avatar Dih", 4000.0));
        productos.add(new Producto(6456, "Blahaj", 10000.0));
        productos.add(new Producto(202601, "Soviet Brainrot", 2675.0));
        productos.add(new Producto(202602, "6-7", 840.0));
        productos.add(new Producto(202603, "Jimothy, el mapache esférico", 15300.0));
        productos.add(new Producto(202604, "Train Dog", 1250.0));
        productos.add(new Producto(202605, "Drooling Cat", 5690.0));
        productos.add(new Producto(202606, "“Say Wallahi Bro”", 3200.0));
        productos.add(new Producto(202607, "Punch the Monkey", 4750.0));
        productos.add(new Producto(202608, "Kool-Aid Pineapples / “dat bih gah”", 8990.0));
        productos.add(new Producto(202609, "“Thank You… Chainsaw Man”", 1990.0));
        productos.add(new Producto(202610, "The Great Meme Reset", 11250.0));

        Factura factura = new Factura(1, "Benjamin Netanyahu");
        factura.agregarLinea(1, productos.get(0));
        factura.agregarLinea(2, productos.get(1));
        factura.agregarLinea(1, productos.get(2));
        factura.agregarLinea(3, productos.get(3));
        factura.agregarLinea(2, productos.get(4));
        factura.agregarLinea(1, productos.get(5));
        factura.agregarLinea(2, productos.get(6));
        factura.agregarLinea(1, productos.get(7));
        factura.agregarLinea(3, productos.get(8));
        factura.agregarLinea(2, productos.get(9));
        factura.agregarLinea(1, productos.get(10));
        factura.agregarLinea(2, productos.get(11));
        factura.agregarLinea(1, productos.get(12));
        factura.agregarLinea(3, productos.get(13));

        System.out.println(factura);
    }
}
