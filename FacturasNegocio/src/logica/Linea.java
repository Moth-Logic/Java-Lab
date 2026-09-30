package logica;

public class Linea {
	private Integer cantidad;
	private Producto producto;

	public Linea(Integer cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

}
