package wallrose;

import java.io.Serializable;

public class LineaOrden implements Serializable {

	private static final long serialVersionUID = 1L;

	private Producto producto;
	private Double cantidad;

	public LineaOrden(Producto producto, Double cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double calcularCosto() {
		return cantidad * producto.getPrecio();
	}
}
