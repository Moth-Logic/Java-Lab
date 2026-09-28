package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Publicacion — a post inside a blog.
// Fields: title, text, creator name and publication date (set automatically).
// Keeps an ordered list of comments (order of insertion).
// Publications are identified by their position in the blog's list (1-based
// numbering is applied by Blog, this class works with 0-based list indexes).
public class Publicacion {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	private String titulo;
	private String texto;
	private String nombreCreador;
	private final LocalDateTime fechaPublicacion;  // Set automatically when created
	private final List<Comentario> comentarios;

	public Publicacion(String titulo, String texto, String nombreCreador) {
		setTitulo(titulo);
		setTexto(texto);
		setNombreCreador(nombreCreador);
		this.fechaPublicacion = LocalDateTime.now();
		this.comentarios = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("El título no puede ser vacío.");
		}
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			throw new IllegalArgumentException("El texto no puede ser vacío.");
		}
		this.texto = texto;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}

	public void setNombreCreador(String nombreCreador) {
		if (nombreCreador == null || nombreCreador.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del creador no puede ser vacío.");
		}
		this.nombreCreador = nombreCreador;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	// Adds a comment to this publication (appended at the end of the list).
	public void agregarComentario(String email, String ip, String texto) {
		Comentario comentario = new Comentario(email, ip, texto);
		this.comentarios.add(comentario);
	}

	// Deletes the comment at the given position (0-based).
	// Throws if the publication has no comments or the position is out of range.
	public void eliminarComentario(int posComentario) {
		if (comentarios.isEmpty()) {
			throw new IndexOutOfBoundsException("La publicación no tiene comentarios.");
		}
		if (posComentario < 0 || posComentario >= comentarios.size()) {
			throw new IndexOutOfBoundsException("Posición de comentario no válida: " + (posComentario + 1));
		}
		comentarios.remove(posComentario);
	}

	// Human-readable representation of the publication and all its comments.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Título: ").append(titulo).append("\n");
		sb.append("Creador: ").append(nombreCreador).append("\n");
		sb.append("Fecha: ").append(FORMATO.format(fechaPublicacion)).append("\n");
		sb.append("Texto: ").append(texto).append("\n");
		sb.append("Comentarios (").append(comentarios.size()).append("):");
		if (comentarios.isEmpty()) {
			sb.append(" (ninguno)");
		} else {
			for (int i = 0; i < comentarios.size(); i++) {
				sb.append("\n  ").append(i + 1).append(". ").append(comentarios.get(i));
			}
		}
		return sb.toString();
	}
}
