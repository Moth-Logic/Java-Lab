package wallrose;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ControladoraWallRose {

	private static ControladoraWallRose instance;

	private Map<String, Cliente> clientes;
	private Map<Integer, Orden> ordenes;
	private Map<Integer, Producto> productos;

	private Integer consecutivoOrden;
	private Integer consecutivoProducto;
	private Double IV;

	private ControladoraWallRose() {
		clientes = new TreeMap<>();
		ordenes = new TreeMap<>();
		productos = new TreeMap<>();
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

	public Double getIV() {
		return IV;
	}

	// Verificaciones

	private void verificarClienteExistente(String idCliente) {
		if (!clientes.containsKey(idCliente)) {
			throw new IllegalArgumentException("El cliente " + idCliente + " no existe");
		}
	}

	private void verificarClienteNoExistente(String idCliente) {
		if (clientes.containsKey(idCliente)) {
			throw new IllegalArgumentException("Ya existe un cliente con el id " + idCliente);
		}
	}

	private Boolean esEmailValido(String email) {
		return email != null && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	}

	private void verificarEmail(String email) {
		if (!esEmailValido(email)) {
			throw new IllegalArgumentException("El email '" + email + "' no es valido");
		}
	}

	private void verificarProductoExistente(String codigoProducto) {
		try {
			if (!productos.containsKey(Integer.parseInt(codigoProducto))) {
				throw new IllegalArgumentException("El producto " + codigoProducto + " no existe");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("El codigo de producto '" + codigoProducto + "' no es un numero");
		}
	}

	private void verificarOrdenExistente(String numeroOrden) {
		try {
			if (!ordenes.containsKey(Integer.parseInt(numeroOrden))) {
				throw new IllegalArgumentException("La orden " + numeroOrden + " no existe");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("El numero de orden '" + numeroOrden + "' no es un numero");
		}
	}

	private void verificarOrdenIniciada(Orden orden) {
		if (orden.getEstado() != EstadoOrden.INICIADA) {
			throw new IllegalStateException("La orden " + orden.getNumero()
					+ " ya no se puede modificar (estado " + orden.getEstado() + ")");
		}
	}

	private void verificarDatosProducto(String nombre, Double existencias, String unidad, Double precio) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del producto no puede estar vacio");
		}
		if (unidad == null || unidad.trim().isEmpty()) {
			throw new IllegalArgumentException("La unidad del producto no puede estar vacia");
		}
		if (existencias == null || existencias < 0) {
			throw new IllegalArgumentException("Las existencias no pueden ser negativas");
		}
		if (precio == null || precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
	}

	private void verificarCantidad(Double cantidad) {
		if (cantidad == null || cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
		}
	}

	// Clientes

	public List<Cliente> obtenerListadoClientes() {
		return new ArrayList<>(clientes.values());
	}

	public Cliente obtenerCliente(String idCliente) {
		verificarClienteExistente(idCliente);
		return clientes.get(idCliente);
	}

	public void crearCliente(String idCliente, String nombre, String email) {
		verificarClienteNoExistente(idCliente);
		verificarEmail(email);
		clientes.put(idCliente, new Cliente(idCliente, nombre, email));
	}

	public void actualizarCliente(String idCliente, String nombre, String email) {
		verificarClienteExistente(idCliente);
		verificarEmail(email);
		Cliente cliente = clientes.get(idCliente);
		cliente.setNombre(nombre);
		cliente.setEmail(email);
	}

	public void borrarCliente(String idCliente) {
		verificarClienteExistente(idCliente);
		if (!clientes.get(idCliente).getOrdenes().isEmpty()) {
			throw new IllegalStateException("No se puede borrar el cliente " + idCliente + " porque tiene ordenes");
		}
		clientes.remove(idCliente);
	}

	// Ordenes por cliente

	public List<Orden> obtenerListadoOrdenesCliente(String idCliente) {
		verificarClienteExistente(idCliente);
		return new ArrayList<>(clientes.get(idCliente).getOrdenes().values());
	}

	private List<Orden> obtenerListadoOrdenesPorEstado(String idCliente, EstadoOrden estado) {
		List<Orden> resultado = new ArrayList<>();
		for (Orden orden : obtenerListadoOrdenesCliente(idCliente)) {
			if (orden.getEstado() == estado) {
				resultado.add(orden);
			}
		}
		return resultado;
	}

	public List<Orden> obtenerListadoOrdenesIniciadasCliente(String idCliente) {
		return obtenerListadoOrdenesPorEstado(idCliente, EstadoOrden.INICIADA);
	}

	public List<Orden> obtenerListadoOrdenesPendientesCliente(String idCliente) {
		return obtenerListadoOrdenesPorEstado(idCliente, EstadoOrden.PENDIENTE);
	}

	public List<Orden> obtenerListadoOrdenesTerminadasCliente(String idCliente) {
		return obtenerListadoOrdenesPorEstado(idCliente, EstadoOrden.TERMINADA);
	}

	// Productos

	public List<Producto> obtenerListadoProductos() {
		return new ArrayList<>(productos.values());
	}

	public void crearProducto(String nombre, Double existencias, String unidad, Double precio) {
		verificarDatosProducto(nombre, existencias, unidad, precio);
		Integer codigo = consecutivoProducto++;
		productos.put(codigo, new Producto(codigo, nombre, existencias, unidad, precio));
	}

	public Producto obtenerProducto(Integer codigoProducto) {
		verificarProductoExistente(String.valueOf(codigoProducto));
		return productos.get(codigoProducto);
	}

	public void actualizarProducto(Integer codigoProducto, String nombre, Double existencias, String unidad, Double precio) {
		verificarProductoExistente(String.valueOf(codigoProducto));
		verificarDatosProducto(nombre, existencias, unidad, precio);
		Producto producto = productos.get(codigoProducto);
		producto.setNombre(nombre);
		producto.setExistencias(existencias);
		producto.setUnidad(unidad);
		producto.setPrecio(precio);
	}

	public void borrarProducto(Integer codigoProducto) {
		verificarProductoExistente(String.valueOf(codigoProducto));
		if (esProductoUtilizado(codigoProducto)) {
			throw new IllegalStateException("No se puede borrar el producto " + codigoProducto
					+ " porque esta en alguna orden");
		}
		productos.remove(codigoProducto);
	}

	public Boolean esProductoUtilizado(Integer codigoProducto) {
		for (Orden orden : ordenes.values()) {
			for (LineaOrden linea : orden.getLineas()) {
				if (linea.getProducto().getCodigo().equals(codigoProducto)) {
					return true;
				}
			}
		}
		return false;
	}

	// Ordenes

	public List<Orden> obtenerListadoOrdenes() {
		return new ArrayList<>(ordenes.values());
	}

	public Double obtenerMontoTotalPendiente() {
		double total = 0.0;
		for (Orden orden : ordenes.values()) {
			if (orden.getEstado() == EstadoOrden.PENDIENTE) {
				total += orden.calcularMontoTotal();
			}
		}
		return total;
	}

	public void crearOrdenVacia(String idCliente) {
		verificarClienteExistente(idCliente);
		Cliente cliente = clientes.get(idCliente);
		Orden orden = new Orden(consecutivoOrden++, cliente);
		ordenes.put(orden.getNumero(), orden);
		cliente.agregarOrden(orden);
	}

	public Orden obtenerOrden(Integer numeroOrden) {
		verificarOrdenExistente(String.valueOf(numeroOrden));
		return ordenes.get(numeroOrden);
	}

	public List<LineaOrden> obtenerLineasOrden(Integer numeroOrden) {
		return new ArrayList<>(obtenerOrden(numeroOrden).getLineas());
	}

	public void establecerOrdenPendiente(Integer numeroOrden) {
		Orden orden = obtenerOrden(numeroOrden);
		verificarOrdenIniciada(orden);
		if (orden.cantidadLineas() == 0) {
			throw new IllegalStateException("No se puede dejar pendiente una orden sin lineas");
		}
		orden.setEstado(EstadoOrden.PENDIENTE);
	}

	public void establecerOrdenTerminada(Integer numeroOrden) {
		Orden orden = obtenerOrden(numeroOrden);
		if (orden.getEstado() != EstadoOrden.PENDIENTE) {
			throw new IllegalStateException("Solo una orden PENDIENTE se puede terminar (la orden "
					+ numeroOrden + " esta " + orden.getEstado() + ")");
		}
		orden.setEstado(EstadoOrden.TERMINADA);
	}

	public void agregarLineaOrden(Integer numeroOrden, Integer codigoProducto, Double cantidad) {
		Orden orden = obtenerOrden(numeroOrden);
		verificarOrdenIniciada(orden);
		Producto producto = obtenerProducto(codigoProducto);
		verificarCantidad(cantidad);
		orden.agregarLinea(new LineaOrden(producto, cantidad));
	}

	public void actualizarLineaOrden(Integer numeroOrden, Integer numeroLinea, Integer codigoProducto, Double cantidad) {
		Orden orden = obtenerOrden(numeroOrden);
		verificarOrdenIniciada(orden);
		Producto producto = obtenerProducto(codigoProducto);
		verificarCantidad(cantidad);
		LineaOrden linea = orden.getLinea(numeroLinea);
		linea.setProducto(producto);
		linea.setCantidad(cantidad);
	}

	public void borrarLineaOrden(Integer numeroOrden, Integer numeroLinea) {
		Orden orden = obtenerOrden(numeroOrden);
		verificarOrdenIniciada(orden);
		orden.borrarLinea(numeroLinea);
	}

	public void borrarOrden(Integer numeroOrden) {
		Orden orden = obtenerOrden(numeroOrden);
		if (orden.getEstado() == EstadoOrden.TERMINADA) {
			throw new IllegalStateException("No se puede borrar una orden TERMINADA");
		}
		orden.getCliente().borrarOrden(orden);
		ordenes.remove(numeroOrden);
	}

	// Persistencia (serializacion de Java)

	public void guardarDatos(String ruta) throws IOException {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
			// Todo va en el mismo stream para que Java respete las referencias compartidas
			// (un Cliente y sus Ordenes se apuntan entre si, y los Productos se comparten)
			salida.writeObject(clientes);
			salida.writeObject(ordenes);
			salida.writeObject(productos);
			salida.writeObject(consecutivoOrden);
			salida.writeObject(consecutivoProducto);
		}
	}

	@SuppressWarnings("unchecked")
	public void cargarDatos(String ruta) throws IOException, ClassNotFoundException {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta))) {
			// Se lee todo primero y se asigna al final, asi si falla algo no queda a medias
			Map<String, Cliente> clientesLeidos = (Map<String, Cliente>) entrada.readObject();
			Map<Integer, Orden> ordenesLeidas = (Map<Integer, Orden>) entrada.readObject();
			Map<Integer, Producto> productosLeidos = (Map<Integer, Producto>) entrada.readObject();
			Integer consecutivoOrdenLeido = (Integer) entrada.readObject();
			Integer consecutivoProductoLeido = (Integer) entrada.readObject();

			clientes = clientesLeidos;
			ordenes = ordenesLeidas;
			productos = productosLeidos;
			consecutivoOrden = consecutivoOrdenLeido;
			consecutivoProducto = consecutivoProductoLeido;
		}
	}
}
