package logica;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Equipo {
	private String nombre;
	private LocalDate fundacion;
	private String ubicacion;
	private String estadio;
	private Miembro entrenador;
	private List<Miembro> jugadores;
	
	public Equipo(String nombre, LocalDate fundacion, String ubicacion, String estadio, Miembro entrenador,
			List<Miembro> jugadores) {
		super();
		this.nombre = nombre;
		this.fundacion = fundacion;
		this.ubicacion = ubicacion;
		this.estadio = estadio;
		this.jugadores = new ArrayList<Miembro>();
		if (entrenador != null) {
			setEntrenador(entrenador);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFundacion() {
		return fundacion;
	}

	public void setFundacion(LocalDate fundacion) {
		this.fundacion = fundacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Miembro getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Miembro entrenador) {
		if (entrenador == null)
			throw new IllegalArgumentException("El entrenador no puede ser nulo.");
		entrenador.setRol(Rol.DIRECTOR_TECNICO);
		this.entrenador = entrenador;
	}
	
	public void setEntrenador(String nombre, LocalDate fechaNac, Double altura, Double peso) {
		this.entrenador = new Miembro(nombre, fechaNac, altura, peso, Rol.DIRECTOR_TECNICO);
	}
	
	public void agregarJugador(Miembro jugador) {
		jugadores.add(jugador);
	}
	
	public void agregarJugador(String nombre, LocalDate fechaNac, Double altura, Double peso, Rol rol) {
		Miembro jugador = new Miembro(nombre, fechaNac ,altura, peso, rol);
		jugadores.add(jugador);
	}
	
	public Miembro obtenerJugador(int pos) throws Exception {
		if (pos < 0 || pos >= jugadores.size())
			throw new Exception("Jugador: Posicion no válida");
		return jugadores.get(pos);
	}
	
	public Miembro borrarJugador(int pos) throws Exception {
		if (pos < 0 || pos >= jugadores.size())
			throw new Exception("Jugador: Posicion no válida");
		return jugadores.remove(pos);
	}
	
	@Override
	public String toString() {
		String result = "Equipo:" + nombre + "\n";
		result += "Fundacion:" + fundacion.toString() + "\n";
		result += "Estadio: " + estadio + ", " + ubicacion + "\n";
		result += "Entrenador: " + (entrenador != null ? entrenador.getNombre() : "(sin asignar)") + "\n";
		result += "Jugadores: \n";
		for  (Miembro jugador : jugadores) {
			result += "\t" + jugador.getNombre() + " (" + jugador.getRol() + ")\n";
		}
		return result;
	}
	

}
