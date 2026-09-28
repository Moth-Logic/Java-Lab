package logica;

public enum Rol {
	DIRECTOR_TECNICO,
	DELANTERO,
	DEFENSA,
	PORTERO,
	MEDIOCAMPISTA,
	PREPARADOR_FISICO;
	
	@Override
	public String toString() {
		switch (this) {
		case DIRECTOR_TECNICO:
			return "Director Tecnico";
		case DELANTERO:
			return "Delantero";
		case DEFENSA:
			return "Defensa";
		case PORTERO:
			return "Portero";
		case MEDIOCAMPISTA:
			return "Mediocampista";
		case PREPARADOR_FISICO:
			return "Preparador Fisico";
		default:
			return "Otro.";
		}
	}
}
