package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Comentario — a user comment on a publication.
// Fields: creation timestamp (set automatically at creation), author email,
// source IP and text.
public class Comentario {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	private final LocalDateTime fechaCreacion;  // Set automatically when created
	private final String email;                 // Author's email
	private final String ip;                    // Author's IP address
	private String texto;                       // Comment content

	public Comentario(String email, String ip, String texto) {
		this.fechaCreacion = LocalDateTime.now();
		this.email = email;
		this.ip = ip;
		setTexto(texto);
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public String getEmail() {
		return email;
	}

	public String getIp() {
		return ip;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			throw new IllegalArgumentException("El texto del comentario no puede ser vacío.");
		}
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "[" + FORMATO.format(fechaCreacion) + "] " + email + " (" + ip + ") escribió: " + texto;
	}
}
