package wallrose;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;

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

	// Suma del costo de todas las lineas (sin impuesto)
	public Double calcularMonto() {
		double monto = 0.0;
		for (LineaOrden linea : lineas) {
			monto += linea.calcularCosto();
		}
		return monto;
	}

	public Double calcularMontoImpuesto() {
		return calcularMonto() * ControladoraWallRose.getInstance().getIV();
	}

	public Double calcularMontoTotal() {
		return calcularMonto() + calcularMontoImpuesto();
	}

	public void agregarLinea(LineaOrden linea) {
		lineas.add(linea);
	}

	// numeroLinea va de 1 a cantidadLineas()
	public void borrarLinea(Integer numeroLinea) {
		verificarNumeroLinea(numeroLinea);
		lineas.remove(numeroLinea - 1);
	}

	public Integer cantidadLineas() {
		return lineas.size();
	}

	// numeroLinea va de 1 a cantidadLineas()
	public LineaOrden getLinea(Integer numeroLinea) {
		verificarNumeroLinea(numeroLinea);
		return lineas.get(numeroLinea - 1);
	}

	private void verificarNumeroLinea(Integer numeroLinea) {
		if (numeroLinea == null || numeroLinea < 1 || numeroLinea > lineas.size()) {
			throw new IllegalArgumentException("La linea " + numeroLinea + " no existe en la orden " + numero);
		}
	}
}
