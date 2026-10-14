package wallrose;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orden {

	private Integer numero;
	private LocalDate fecha;
	private EstadoOrden estado;
	private Cliente cliente;
	private List<LineaOrden> lineas;

	public Orden(Integer numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.fecha = LocalDate.now();
		this.estado = EstadoOrden.INICIADA;
		this.lineas = new ArrayList<>();
	}

	public Integer getNumero() {
		return numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public List<LineaOrden> getLineas() {
		return lineas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double calcularMonto() {
		// TODO
		return 0.0;
	}

	public Double calcularMontoImpuesto() {
		// TODO
		return 0.0;
	}

	public Double calcularMontoTotal() {
		// TODO
		return 0.0;
	}

	public void agregarLinea(LineaOrden linea) {
		// TODO
	}

	public void borrarLinea(Integer numeroLinea) {
		// TODO
	}

	public Integer cantidadLineas() {
		// TODO
		return 0;
	}

	public LineaOrden getLinea(Integer numeroLinea) {
		// TODO
		return null;
	}
}
