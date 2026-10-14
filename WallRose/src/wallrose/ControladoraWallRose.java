package wallrose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladoraWallRose {

	private static ControladoraWallRose instance;

	private Map<String, Cliente> clientes;
	private Map<Integer, Orden> ordenes;
	private Map<Integer, Producto> productos;

	private Integer consecutivoOrden;
	private Integer consecutivoProducto;
	private Double IV;

	private ControladoraWallRose() {
		clientes = new HashMap<>();
		ordenes = new HashMap<>();
		productos = new HashMap<>();
		consecutivoOrden = 1;
		consecutivoProducto = 1;
		IV = 0.13;
	}

	public static ControladoraWallRose getInstance() {
		if (instance == null) {
			instance = new ControladoraWallRose();
		}
		return instance;
	}

	// Verificaciones

	private void verificarClienteExistente(String idCliente) {
		// TODO
	}

	private void verificarClienteNoExistente(String idCliente) {
		// TODO
	}

	private Boolean esEmailValido(String email) {
		// TODO
		return false;
	}

	private void verificarEmail(String email) {
		// TODO
	}

	private void verificarProductoExistente(String codigoProducto) {
		// TODO
	}

	private void verificarOrdenExistente(String numeroOrden) {
		// TODO
	}

	//Clientes

	public List<Cliente> obtenerListadoClientes() {
		// TODO
		return null;
	}

	public Cliente obtenerCliente(String idCliente) {
		// TODO
		return null;
	}

	public void crearCliente(String idCliente, String nombre, String email) {
		// TODO
	}

	public void actualizarCliente(String idCliente, String nombre, String email) {
		// TODO
	}

	public void borrarCliente(String idCliente) {
		// TODO
	}

	//Ordenes por cliente

	public List<Orden> obtenerListadoOrdenesCliente(String idCliente) {
		// TODO
		return null;
	}

	private List<Orden> obtenerListadoOrdenesPorEstado(String idCliente, EstadoOrden estado) {
		// TODO
		return null;
	}

	public List<Orden> obtenerListadoOrdenesIniciadasCliente(String idCliente) {
		// TODO
		return null;
	}

	public List<Orden> obtenerListadoOrdenesPendientesCliente(String idCliente) {
		// TODO
		return null;
	}

	public List<Orden> obtenerListadoOrdenesTerminadasCliente(String idCliente) {
		// TODO
		return null;
	}

	//Productos

	public List<Producto> obtenerListadoProductos() {
		// TODO
		return null;
	}

	public void crearProducto(String nombre, Double existencias, String unidad, Double precio) {
		// TODO
	}

	public Producto obtenerProducto(Integer codigoProducto) {
		// TODO
		return null;
	}

	public void actualizarProducto(Integer codigoProducto, String nombre, Double existencias, String unidad, Double precio) {
		// TODO
	}

	public void borrarProducto(Integer codigoProducto) {
		// TODO
	}

	public Boolean esProductoUtilizado(Integer codigoProducto) {
		// TODO
		return false;
	}

	// Ordenes

	public List<Orden> obtenerListadoOrdenes() {
		// TODO
		return null;
	}

	public Double obtenerMontoTotalPendiente() {
		// TODO
		return 0.0;
	}

	public void crearOrdenVacia(String idCliente) {
		// TODO
	}

	public Orden obtenerOrden(Integer numeroOrden) {
		// TODO
		return null;
	}

	public List<LineaOrden> obtenerLineasOrden(Integer numeroOrden) {
		// TODO
		return null;
	}

	public void establecerOrdenPendiente(Integer numeroOrden) {
		// TODO
	}

	public void establecerOrdenTerminada(Integer numeroOrden) {
		// TODO
	}

	public void agregarLineaOrden(Integer numeroOrden, Integer codigoProducto, Double cantidad) {
		// TODO
	}

	public void actualizarLineaOrden(Integer numeroOrden, Integer numeroLinea, Integer codigoProducto, Double cantidad) {
		// TODO
	}

	public void borrarLineaOrden(Integer numeroOrden, Integer numeroLinea) {
		// TODO
	}

	public void borrarOrden(Integer numeroOrden) {
		// TODO
	}
}
