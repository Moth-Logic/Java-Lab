package logica;

// Custom exception for validation errors in the Grupo class.
// Extends Exception (checked) so callers are forced to handle invalid data.
public class GrupoException extends Exception {

	private static final long serialVersionUID = 1L;

	public GrupoException(String mensaje) {
		super(mensaje);
	}
}
