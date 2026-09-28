package interfaz;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import control.Controladora;

// ProgramaPrincipal — console interface for the blog system.
// Responsibilities (per spec):
// - Print messages to the user
// - Read input
// - Invoke controller methods
// - Print information returned by the controller
// - Catch errors coming from the control layer
// Divided into subroutines, one per menu section.
public class ProgramaPrincipal {

	private static final Scanner sc = new Scanner(System.in);
	private static final Controladora control = new Controladora();

	public static void main(String[] args) {
		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			String opcion = sc.nextLine().trim();
			try {
				switch (opcion) {
					case "1": opcionCrearBlog(); break;
					case "2": opcionBorrarBlog(); break;
					case "3": opcionListarBlogs(); break;
					case "4": opcionInfoBlog(); break;
					case "5": opcionActualizarNombre(); break;
					case "6": opcionActualizarDescripcion(); break;
					case "7": opcionCrearPublicacion(); break;
					case "8": opcionListarPublicaciones(); break;
					case "9": opcionVerPublicacion(); break;
					case "10": opcionAgregarComentario(); break;
					case "11": opcionBorrarComentario(); break;
					case "0": salir = true; System.out.println("Saliendo..."); break;
					default: System.out.println("Opción inválida.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		sc.close();
	}

	private static void mostrarMenu() {
		System.out.println("\n===== SISTEMA DE BLOGS =====");
		System.out.println("1. Crear blog");
		System.out.println("2. Borrar blog");
		System.out.println("3. Listar blogs");
		System.out.println("4. Ver información de un blog");
		System.out.println("5. Actualizar nombre de un blog");
		System.out.println("6. Actualizar descripción de un blog");
		System.out.println("7. Crear publicación en un blog");
		System.out.println("8. Listar publicaciones de un blog");
		System.out.println("9. Ver una publicación (con sus comentarios)");
		System.out.println("10. Agregar comentario en una publicación");
		System.out.println("11. Borrar comentario de una publicación");
		System.out.println("0. Salir");
		System.out.print("Elija una opción: ");
	}

	// Helper: reads a non-empty line, re-prompting until valid.
	private static String leer(String mensaje) {
		System.out.print(mensaje);
		String valor = sc.nextLine().trim();
		while (valor.isEmpty()) {
			System.out.println("No puede quedar vacío.");
			System.out.print(mensaje);
			valor = sc.nextLine().trim();
		}
		return valor;
	}

	// Helper: reads a non-empty line and parses it as an integer,
	// re-prompting until valid.
	private static Integer leerEntero(String mensaje) {
		while (true) {
			String valor = leer(mensaje);
			try {
				return Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número entero.");
			}
		}
	}

	// 1. Crear blog
	private static void opcionCrearBlog() throws Exception {
		String nombre = leer("Nombre del blog: ");
		String descripcion = leer("Descripción del blog: ");
		Integer codigo = control.crearBlog(nombre, descripcion);
		System.out.println("Blog creado con el código " + codigo + ".");
	}

	// 2. Borrar blog
	private static void opcionBorrarBlog() throws Exception {
		Integer codigo = leerEntero("Código del blog a borrar: ");
		control.borrarBlog(codigo);
		System.out.println("Blog eliminado.");
	}

	// 3. Listar blogs (código y nombre)
	private static void opcionListarBlogs() throws Exception {
		Map<Integer, String> blogs = control.getBlogs();
		if (blogs.isEmpty()) {
			System.out.println("No hay blogs creados.");
			return;
		}
		System.out.println("Blogs:");
		for (Map.Entry<Integer, String> entrada : blogs.entrySet()) {
			System.out.println("  Código " + entrada.getKey() + " - " + entrada.getValue());
		}
	}

	// 4. Ver información de un blog
	private static void opcionInfoBlog() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		System.out.println(control.getInfoBlog(codigo));
	}

	// 5. Actualizar nombre de un blog
	private static void opcionActualizarNombre() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		String nombre = leer("Nuevo nombre: ");
		control.actualizarNombreBlog(codigo, nombre);
		System.out.println("Nombre actualizado.");
	}

	// 6. Actualizar descripción de un blog
	private static void opcionActualizarDescripcion() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		String descripcion = leer("Nueva descripción: ");
		control.actualizarDescripcionBlog(codigo, descripcion);
		System.out.println("Descripción actualizada.");
	}

	// 7. Crear publicación
	private static void opcionCrearPublicacion() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		String titulo = leer("Título de la publicación: ");
		String texto = leer("Texto de la publicación: ");
		String creador = leer("Nombre del creador: ");
		control.crearPublicacion(codigo, titulo, texto, creador);
		System.out.println("Publicación creada.");
	}

	// 8. Listar publicaciones (número - título)
	private static void opcionListarPublicaciones() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		List<String> titulos = control.getPublicaciones(codigo);
		if (titulos.isEmpty()) {
			System.out.println("El blog no tiene publicaciones.");
			return;
		}
		System.out.println("Publicaciones:");
		for (String titulo : titulos) {
			System.out.println("  " + titulo);
		}
	}

	// 9. Ver una publicación con sus comentarios
	private static void opcionVerPublicacion() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		Integer numero = leerEntero("Número de la publicación: ");
		System.out.println(control.getPublicacion(codigo, numero));
	}

	// 10. Agregar comentario
	private static void opcionAgregarComentario() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		Integer numero = leerEntero("Número de la publicación: ");
		String email = leer("Email del autor: ");
		String ip = leer("IP del autor: ");
		String texto = leer("Texto del comentario: ");
		control.agregarComentario(codigo, numero, email, ip, texto);
		System.out.println("Comentario agregado.");
	}

	// 11. Borrar comentario
	private static void opcionBorrarComentario() throws Exception {
		Integer codigo = leerEntero("Código del blog: ");
		Integer numero = leerEntero("Número de la publicación: ");
		Integer posicion = leerEntero("Posición del comentario a borrar: ");
		control.borrarComentario(codigo, numero, posicion);
		System.out.println("Comentario eliminado.");
	}
}
