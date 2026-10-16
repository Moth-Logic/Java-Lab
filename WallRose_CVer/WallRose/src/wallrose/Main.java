package wallrose;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main {

	private static final String ARCHIVO = "wallrose.dat";

	public static void main(String[] args) {
		ControladoraWallRose controladora = ControladoraWallRose.getInstance();

		try {
			// 1. Clientes de ejemplo
			controladora.crearCliente("101", "Maria Rojas", "maria.rojas@correo.com");
			controladora.crearCliente("102", "Carlos Mora", "carlos.mora@correo.com");
			controladora.crearCliente("103", "Ana Vargas", "ana.vargas@correo.com");

			// 2. Productos de ejemplo
			controladora.crearProducto("Rosa roja", 200.0, "unidad", 1500.0);
			controladora.crearProducto("Girasol", 120.0, "unidad", 1200.0);
			controladora.crearProducto("Tierra abonada", 50.0, "kg", 800.0);
			controladora.crearProducto("Maceta mediana", 30.0, "unidad", 4500.0);

			// 3. Una orden de compra con varias lineas
			controladora.crearOrdenVacia("101");
			List<Orden> ordenesMaria = controladora.obtenerListadoOrdenesCliente("101");
			Integer numeroOrden = ordenesMaria.get(ordenesMaria.size() - 1).getNumero();

			controladora.agregarLineaOrden(numeroOrden, 1, 12.0); // 12 rosas rojas
			controladora.agregarLineaOrden(numeroOrden, 3, 2.5); // 2.5 kg de tierra
			controladora.agregarLineaOrden(numeroOrden, 4, 2.0); // 2 macetas
			controladora.establecerOrdenPendiente(numeroOrden);

			System.out.println("===== ANTES DE GUARDAR =====");
			imprimirTodo(controladora);

			// 4. Guardar en disco
			controladora.guardarDatos(ARCHIVO);
			System.out.println("\n>> Datos guardados en " + ARCHIVO);

			// Cambio temporal para comprobar despues que la carga de verdad restaura todo
			controladora.crearCliente("999", "Cliente Temporal", "temporal@correo.com");
			System.out.println(">> Se creo un cliente temporal. Clientes en memoria: "
					+ controladora.obtenerListadoClientes().size());

			// 5. Cargar de disco
			controladora.cargarDatos(ARCHIVO);
			System.out.println(">> Datos cargados de " + ARCHIVO + ". Clientes en memoria: "
					+ controladora.obtenerListadoClientes().size());

			// 6. Imprimir para comprobar que funciona
			System.out.println("\n===== DESPUES DE CARGAR =====");
			imprimirTodo(controladora);

		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println("Error de logica: " + e.getMessage());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error de disco: " + e.getMessage());
		}
	}

	private static void imprimirTodo(ControladoraWallRose controladora) {
		System.out.println("\n--- Clientes ---");
		for (Cliente c : controladora.obtenerListadoClientes()) {
			System.out.println(c.getId() + " | " + c.getNombre() + " | " + c.getEmail()
					+ " | ordenes: " + c.getOrdenes().size());
		}

		System.out.println("\n--- Productos ---");
		for (Producto p : controladora.obtenerListadoProductos()) {
			System.out.println(p.getCodigo() + " | " + p.getNombre() + " | " + dinero(p.getExistencias())
					+ " " + p.getUnidad() + " | precio " + dinero(p.getPrecio()));
		}

		System.out.println("\n--- Ordenes ---");
		for (Orden o : controladora.obtenerListadoOrdenes()) {
			System.out.println("Orden #" + o.getNumero() + " | " + o.getFecha() + " | " + o.getEstado()
					+ " | cliente: " + o.getCliente().getNombre());
			int n = 1;
			for (LineaOrden l : o.getLineas()) {
				System.out.println("   " + n++ + ") " + l.getProducto().getNombre() + " x "
						+ dinero(l.getCantidad()) + " = " + dinero(l.calcularCosto()));
			}
			System.out.println("   Monto: " + dinero(o.calcularMonto())
					+ " | Impuesto: " + dinero(o.calcularMontoImpuesto())
					+ " | Total: " + dinero(o.calcularMontoTotal()));
		}

		System.out.println("\nMonto total pendiente: " + dinero(controladora.obtenerMontoTotalPendiente()));
	}

	private static String dinero(Double valor) {
		return String.format(Locale.US, "%.2f", valor);
	}
}
