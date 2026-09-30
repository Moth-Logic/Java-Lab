package logica;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Factura {
	private Integer codigo;
	private String nombreCliente;
	private LocalDateTime fechaHora;
	private static Double impuesto = 0.13;
	private List<Linea> lineas;

	public Factura(Integer codigo, String nombreCliente) {
		this.codigo = codigo;
		this.nombreCliente = nombreCliente;
		this.fechaHora = LocalDateTime.now();
		this.lineas = new LinkedList<Linea>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void agregarLinea(Integer cantidad, Producto producto) {
		Linea linea = new Linea(cantidad, producto);
		lineas.add(linea);
	}

	public double calcularSubtotal() {
		double subtotal = 0.0;
		Iterator<Linea> iterator = lineas.iterator();
		while (iterator.hasNext()) {
			Linea linea = iterator.next();
			subtotal += linea.getCantidad() * linea.getProducto().getPrecio();
		}
		return subtotal;
	}

	public void borrarLinea(Integer cantidad, Producto producto) {
		Iterator<Linea> iterator = lineas.iterator();
		while (iterator.hasNext()) {
			Linea linea = iterator.next();
			if (Objects.equals(linea.getCantidad(), cantidad)
					&& Objects.equals(linea.getProducto().getCodigo(), producto.getCodigo())) {
				iterator.remove();
				return;
			}
		}
	}


}
