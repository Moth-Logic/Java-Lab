package logica;

import java.time.LocalDate;

public class Autor {
	private String nombre;
	private String pais;
	private LocalDate fechaNacimiento;
	private LocalDate fechaFallecimiento;
	
	public Autor(String nombre, String pais, LocalDate fechaNacimiento, LocalDate fechaFallecimiento) {
		this.nombre = nombre;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFallecimiento = fechaFallecimiento;
	}
	public Autor(String nombre, String pais, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaFallecimiento() {
		return fechaFallecimiento;
	}
	public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}
	
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", pais=" + pais + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaFallecimiento=" + fechaFallecimiento + "]";
	}
	
	

}
