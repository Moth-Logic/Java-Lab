package logica;

public enum Rol {
	DIRECTOR_TECNICO("Director Técnico"),
	DELANTERO("Delantero"),
	DEFENSA("Defensa"),
	PORTERO("Portero"),
	MEDIOCAMPISTA("Mediocampista"),
	PREPARADOR_FISICO("Preparador Físico");

	private final String nombreVisible;

	Rol(String nombreVisible) {
		this.nombreVisible = nombreVisible;
	}
	
	@Override
	public String toString() {
		return nombreVisible;
	}
}
