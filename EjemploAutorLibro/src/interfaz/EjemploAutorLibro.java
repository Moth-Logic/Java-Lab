package interfaz;

import logica.Autor;
import logica.Libro;
import java.time.LocalDate;

public class EjemploAutorLibro {
	
	public static void main(String[] args) {
		Autor autor1 = new Autor("Stephen King","E.E.U.U", java.time.LocalDate.of(1947, 9, 21));
		Autor autor2 = new Autor("Andrey Mora","Costa Rica",java.time.LocalDate.of(2005, 1, 1));
		Libro libro1 = new Libro("EL Talisman", "37557721", "Random House", java.time.LocalDate.of(2001, 9, 15))
		libro1.agregarAutor(autor1);
		libro1.agregarAutor(autor2);
	}

}
