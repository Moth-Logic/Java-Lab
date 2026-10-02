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

	public Double calcularMontoImpuesto() {
		return calcularSubtotal() * impuesto;
	}

	public Double calcularTotal() {
		return calcularSubtotal() + calcularMontoImpuesto();
	}

	@Override
	public String toString() {
		String result = "Tienda Backrooms";
		result += "No. factura " + codigo + " - Fecha: " + fechaHora + "\n";
		result += "Cant.\tCod.\tDesc.\tPrecio\tCosto\n";
		for (Linea linea : lineas) {
			Producto p = linea.getProducto();
			result += linea.getCantidad() + "\t" + p.getCodigo() + "\t" + p.getDescripcion() + "\t" + p.getPrecio()
					+ "\t" + (linea.getCantidad() * p.getPrecio()) + "\n";
		}
		result += "Subtotal: " + calcularSubtotal() + "\n";
		result += "Impuesto: " + calcularMontoImpuesto() + "\n";
		result += "Total: " + calcularTotal() + "\n";
		return result;
	}
}