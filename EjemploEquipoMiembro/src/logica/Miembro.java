package logica;
import java.time.LocalDate;

public class Miembro {
	private String nombre;
	private LocalDate fechaNac;
	private Double altura;
	private Double peso;
	private Rol rol;
	
	public Miembro(String nombre, LocalDate fechaNac, Double altura, Double peso, Rol rol) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.altura = altura;
		this.peso = peso;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
