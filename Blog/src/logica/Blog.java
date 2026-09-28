package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Blog — holds publications in creation order (newest last).
// Publications are identified by their position in the sequence (1-based for
// the user: publication 1 is the first one created). Comments live inside
// each publication and are handled through it.
public class Blog {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	private final Integer codigo;                  // Unique numeric code, assigned by the controller
	private String nombre;
	private String descripcion;
	private final LocalDateTime fechaCreacion;     // Set automatically when created
	private final List<Publicacion> publicaciones;

	public Blog(Integer codigo, String nombre, String descripcion) {
		setNombre(nombre);
		setDescripcion(descripcion);
		this.codigo = codigo;
		this.fechaCreacion = LocalDateTime.now();
		this.publicaciones = new ArrayList<>();
	}

	// --- Getters / setters ---

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del blog no puede ser vacío.");
		}
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null || descripcion.trim().isEmpty()) {
			throw new IllegalArgumentException("La descripción del blog no puede ser vacía.");
		}
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	// --- Publications ---

	// Creates a new publication in this blog (appended last = newest last).
	public void agregarPublicacion(String titulo, String texto, String nombreCreador) {
		Publicacion publicacion = new Publicacion(titulo, texto, nombreCreador);
		this.publicaciones.add(publicacion);
	}

	// Returns the publication at the given 1-based position in the sequence.
	// Throws if the blog has no publications or the number is out of range.
	public Publicacion getPublicacion(int numeroPublicacion) {
		if (publicaciones.isEmpty()) {
			throw new IndexOutOfBoundsException("El blog no tiene publicaciones.");
		}
		if (numeroPublicacion < 1 || numeroPublicacion > publicaciones.size()) {
			throw new IndexOutOfBoundsException("Número de publicación no válido: " + numeroPublicacion);
		}
		return publicaciones.get(numeroPublicacion - 1);
	}

	// Returns the internal list (used only by the controller layer).
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	// Returns a collection with "número - título" for each publication,
	// in the order they were created.
	public List<String> getTitulosPublicaciones() {
		List<String> titulos = new ArrayList<>();
		for (int i = 0; i < publicaciones.size(); i++) {
			titulos.add((i + 1) + " - " + publicaciones.get(i).getTitulo());
		}
		return titulos;
	}

	@Override
	public String toString() {
		return "Blog [código=" + codigo + ", nombre=" + nombre + ", descripción=" + descripcion
				+ ", fechaCreacion=" + FORMATO.format(fechaCreacion) + ", publicaciones=" + publicaciones.size() + "]";
	}
}
