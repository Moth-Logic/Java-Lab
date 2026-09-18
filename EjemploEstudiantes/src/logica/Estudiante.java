package logica;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Set;
import java.util.HashSet;

public class Estudiante {
	private String carnet;
	private String nombre;
	private String email;
	private String telefono;
	private Set<Grupo> grupos;
	
	public Estudiante(String carnet, String nombre, String email, String telefono) throws Exception {
		if (!validarCarnet(carnet)) {
			throw new Exception("Carnet no Valido");
		}
		if (!validarEmail(email)) {
			throw new Exception("email no Valido");
		}
		this.carnet = carnet;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.grupos = new HashSet<Grupo>();
	}
	
	private boolean validarCarnet(String carnet) {
		if (carnet == null) return false;
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(carnet);
		return m.matches();
	}

	private boolean validarEmail(String email) {
		if (email == null) return false;
		Pattern p = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) throws Exception {
		if (!validarCarnet(carnet)) {
			throw new Exception("Carnet no Valido");
		}
		this.carnet = carnet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if (!validarEmail(email)) {
			throw new Exception("email no Valido");
		}
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void agregarGrupo(Grupo grupo) throws Exception {
		if (grupo == null) {
			throw new Exception("El grupo no puede ser nulo.");
		}
		if (grupos.contains(grupo)) {
			throw new Exception("El estudiante ya tiene este grupo registrado.");
		}
		grupos.add(grupo);
	}

	public void eliminarGrupo(Grupo grupo) throws Exception {
		if (grupo == null) {
			throw new Exception("El grupo no puede ser nulo.");
		}
		if (!grupos.contains(grupo)) {
			throw new Exception("El estudiante no tiene este grupo registrado.");
		}
		grupos.remove(grupo);
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Estudiante [carnet=").append(carnet)
		  .append(", nombre=").append(nombre)
		  .append(", email=").append(email)
		  .append(", telefono=").append(telefono)
		  .append("]\nGrupos:\n");
		for (Grupo g : grupos) {
			sb.append("  - ").append(g.getNombreMateria()).append("\n");
		}
		return sb.toString();
	}
}