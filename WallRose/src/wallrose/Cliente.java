package wallrose;

import java.util.HashMap;
import java.util.Map;

public class Cliente {

	private String id;
	private String nombre;
	private String email;
	private Map<Integer, Orden> ordenes;

	public Cliente(String id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.ordenes = new HashMap<>();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<Integer, Orden> getOrdenes() {
		return ordenes;
	}

	public void agregarOrden(Orden orden) {
		
	}

	public void borrarOrden(Orden orden) {
	
	}
}
