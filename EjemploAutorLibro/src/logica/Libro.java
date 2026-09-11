package logica;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Libro {
	private String titulo;
	private String isbn;
	private String editorial;
	private LocalDate fechaPublicacion;
	private List<Autor> autores;
	
	public Libro(String titulo, String isbn, String editorial, LocalDate fechaPublicacion) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.editorial = editorial;
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public void agregarAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	public void agregarAutor(String nombre, String pais, LocalDate fechaNacimiento, LocalDate fechaFallecimiento){
		Autor autor = new Autor(nombre, pais, fechaNacimiento, fechaFallecimiento);
		this.autores.add(autor);
	}
	
	public void agregarAutor(String nombre, String pais, LocalDate fechaNacimiento){
		Autor autor = new Autor(nombre, pais, fechaNacimiento);
		this.autores.add(autor);
	}
	
	public void borrarAutor(int pos) throws Exception {
		if(pos < 0 || pos >= autores.size())
			throw new Exception("Posicion de autor no valida");
		autores.remove(pos);
	}

	@Override
	public String toString() {
		String result = "Libro [titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial + ", fechaPublicacion="
				+ fechaPublicacion + "]";
		for (Autor autor : autores) {
			result += "\t"+autor.toString() + "\n";
		}
		return result;
	}

	
}