package control;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Blog;
import logica.Publicacion;

// Controladora — the single controller class of the system.
// Encapsulates every operation the user can perform and manages all the
// logic-layer objects (blogs).
// - Keeps a collection of blogs keyed by their numeric code.
// - Keeps one integer counter (consecutivo) used to assign each new blog
//   a unique code (1, 2, 3, ...).
// - Its methods never return references to logic-layer objects: they return
//   Strings, collections of Strings, or Maps with plain data.
// Restrictions already checked by the logic layer (e.g. non-empty title or
// text) are NOT re-checked here; the controller only checks what logic does
// not (e.g. that a blog code exists, that an email has a valid format).
public class Controladora {

	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	private int consecutivo;                       // Next code to assign to a blog
	private final Map<Integer, Blog> blogs;        // Blog code → Blog

	public Controladora() {
		this.consecutivo = 1;
		this.blogs = new HashMap<>();
	}

	// 1. Crear un blog: assigns the current consecutivo as its code, adds the
	// blog to the collection and increments the counter.
	// Name/description non-null and non-empty is validated by the Blog class.
	// Returns the assigned code (plain data, not a logic object).
	public Integer crearBlog(String nombre, String descripcion) throws Exception {
		Blog blog = new Blog(consecutivo, nombre, descripcion);
		blogs.put(consecutivo, blog);
		Integer codigo = consecutivo;
		consecutivo++;
		return codigo;
	}

	// 2. Borrar un blog: throws if the code does not exist, otherwise removes it.
	public void borrarBlog(Integer codigo) throws Exception {
		Blog blog = blogs.remove(codigo);
		if (blog == null) {
			throw new Exception("No existe un blog con el código " + codigo + ".");
		}
	}

	// 3. Obtener la colección de blogs: Map with blog codes as keys and blog
	// names as values.
	public Map<Integer, String> getBlogs() {
		Map<Integer, String> resultado = new HashMap<>();
		for (Map.Entry<Integer, Blog> entrada : blogs.entrySet()) {
			resultado.put(entrada.getKey(), entrada.getValue().getNombre());
		}
		return resultado;
	}

	// 4. Crear una publicación en un blog: throws if the blog code does not
	// exist; title/text/creator are validated by the logic layer.
	public void crearPublicacion(Integer codigoBlog, String titulo, String texto, String nombreCreador)
			throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		blog.agregarPublicacion(titulo, texto, nombreCreador);
	}

	// 5. Obtener la lista de publicaciones (número - título) de un blog.
	public List<String> getPublicaciones(Integer codigoBlog) throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		return blog.getTitulosPublicaciones();
	}

	// 6. Obtener una publicación (y sus comentarios) como String.
	// Throws if the blog code or the publication number is not valid.
	public String getPublicacion(Integer codigoBlog, Integer numeroPublicacion) throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		Publicacion publicacion = blog.getPublicacion(numeroPublicacion);
		return publicacion.toString();
	}

	// 7. Agregar un comentario en una publicación de un blog.
	// The email format is checked here because the logic layer does not check it.
	public void agregarComentario(Integer codigoBlog, Integer numeroPublicacion, String email, String ip, String texto)
			throws Exception {
		if (!esEmailValido(email)) {
			throw new Exception("El email no tiene un formato válido: " + email);
		}
		Blog blog = obtenerBlog(codigoBlog);
		blog.getPublicacion(numeroPublicacion).agregarComentario(email, ip, texto);
	}

	// 8. Borrar un comentario de una publicación de un blog.
	// The user-facing comment position is 1-based; the logic layer works
	// with 0-based list indexes, so we convert here.
	public void borrarComentario(Integer codigoBlog, Integer numeroPublicacion, Integer posicionComentario)
			throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		blog.getPublicacion(numeroPublicacion).eliminarComentario(posicionComentario - 1);
	}

	// Extra (funcionalidades 4 y 5): actualizar el nombre de un blog.
	public void actualizarNombreBlog(Integer codigoBlog, String nombre) throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		blog.setNombre(nombre);
	}

	// Extra (funcionalidades 6 y 7): actualizar la descripción de un blog.
	public void actualizarDescripcionBlog(Integer codigoBlog, String descripcion) throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		blog.setDescripcion(descripcion);
	}

	// Extra (funcionalidades 3, 5 y 7): resumen de un blog (código, nombre,
	// descripción y fecha de creación) en un solo String legible.
	public String getInfoBlog(Integer codigoBlog) throws Exception {
		Blog blog = obtenerBlog(codigoBlog);
		return "Código: " + blog.getCodigo() + "\n"
				+ "Nombre: " + blog.getNombre() + "\n"
				+ "Descripción: " + blog.getDescripcion() + "\n"
				+ "Fecha de creación: " + FORMATO.format(blog.getFechaCreacion());
	}

	// Returns the blog with the given code or throws if it does not exist.
	private Blog obtenerBlog(Integer codigo) throws Exception {
		Blog blog = blogs.get(codigo);
		if (blog == null) {
			throw new Exception("No existe un blog con el código " + codigo + ".");
		}
		return blog;
	}

	// Static helper: validates the format of an email address.
	public static boolean esEmailValido(String email) {
		return email != null && email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
	}
}
