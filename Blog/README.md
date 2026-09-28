# Tarea: Sistema de Blogs

Sistema de consola que permite administrar una serie de blogs con sus
publicaciones y comentarios de usuarios, organizado en tres capas
(paquetes): **lógica**, **control** e **interfaz**.

## Estructura del proyecto

```
Blog/src/
├── logica/     → Clases de negocio: Blog, Publicacion, Comentario
├── control/    → Controladora: administra los blogs y expone las
│                 funcionalidades del sistema (retorna Strings y
│                 colecciones de datos, nunca objetos de la lógica)
└── interfaz/   → ProgramaPrincipal: menú de consola que lee entradas,
                  invoca la controladora, imprime resultados y atrapa
                  los errores de las capas inferiores
```

## Modelo (funcionalidades de la lógica)

- **Blog**: `código` (numérico, asignado por la controladora), `nombre`,
  `descripción`, `fechaCreacion` (automática). Contiene publicaciones
  guardadas en orden de creación (las más nuevas al final) que se
  identifican por su posición en la secuencia (1-based).
- **Publicacion**: `título`, `texto`, `nombreCreador`, `fechaPublicacion`
  (automática) y una lista ordenada de comentarios.
- **Comentario**: `fechaCreacion` (automática), `email` del autor, `ip`
  y `texto`.

## Diagrama conceptual

Cajas = clases, flechas = asociaciones (nombre, multiplicidad y
navegabilidad).

```
┌─────────────────────┐ 1      contiene    * ┌──────────────────────┐
│        Blog         │───────────────────────│      Publicacion     │
├─────────────────────┤  tiene publicaciones  ├──────────────────────┤
│ - codigo            │ ◄────────────         │ - titulo             │
│ - nombre            │   (navegable          │ - texto              │
│ - descripcion       │    Blog→Publicacion)  │ - nombreCreador      │
│ - fechaCreacion     │                       │ - fechaPublicacion   │
└─────────────────────┘                       └──────────┬───────────┘
                                                         │ 1
                                                         │ recibe
                                                         │
                                                         │ *
                                                         ▼
                                              ┌──────────────────────┐
                                              │      Comentario      │
                                              ├──────────────────────┤
                                              │ - fechaCreacion      │
                                              │ - email              │
                                              │ - ip                 │
                                              │ - texto              │
                                              └──────────────────────┘
```

- `Blog 1 — * Publicacion`: asociación "tiene publicaciones",
  navegable de Blog a Publicacion (la lista vive en el Blog).
- `Publicacion 1 — * Comentario`: asociación "recibe comentarios",
  navegable de Publicacion a Comentario (la lista vive en la
  Publicacion).
- Comentarios y publicaciones se identifican por posición en la
  secuencia de cada colección (orden de inserción).

## Diagrama de clases completo

Atributos, constructores, getters/setters, métodos, navegabilidad,
multiplicidades y nombres de roles.

```
┌───────────────────────────────┐       ┌────────────────────────────────────┐
│            Blog               │ 1   * │            Publicacion             │
├───────────────────────────────┤───────├────────────────────────────────────┤
│ - codigo: Integer {final}     │ 1..*  │ - titulo: String                   │
│ - nombre: String              │       │   {valida: no vacío}               │
│ - descripcion: String         │       │ - texto: String {no vacío}         │
│ - fechaCreacion: LocalDateTime│       │ - nombreCreador: String {no vacío} │
│ - publicaciones: List         │       │ - fechaPublicacion: LocalDateTime  │
│   <Publicacion> {final}       │       │   {final, automática}              │
├───────────────────────────────┤       │ - comentarios: List<Comentario>    │
│ + Blog(codigo, nombre,        │       │   {final}                          │
│        descripcion)           │       ├────────────────────────────────────┤
│ + getCodigo(): Integer        │       │ + Publicacion(titulo, texto,       │
│ + getNombre()/setNombre()     │       │        nombreCreador)              │
│ + getDescripcion()            │       │ + getTitulo()/setTitulo()          │
│ + setDescripcion()            │       │ + getTexto()/setTexto()            │
│ + getFechaCreacion()          │       │ + getNombreCreador()               │
│ + agregarPublicacion(titulo,  │       │ + setNombreCreador()               │
│        texto, creador)        │       │ + getFechaPublicacion()            │
│ + getPublicacion(num): Publ.  │       │ + getComentarios(): List           │
│ + getPublicaciones(): List    │       │ + agregarComentario(email, ip,     │
│ + getTitulosPublicaciones():  │       │        texto)                      │
│        List<String>           │       │ + eliminarComentario(pos: int)     │
│ + toString(): String          │       │ + toString(): String               │
└───────────────────────────────┘       └─────────────┬──────────────────────┘
                                                      │ 1
                                                      │ 0..*
                                                      ▼
┌───────────────────────────────────┐  ┌──────────────────────────────────┐
│           Controladora            │  │           Comentario             │
├───────────────────────────────────┤  ├──────────────────────────────────┤
│ - consecutivo: int                │  │ - fechaCreacion: LocalDateTime   │
│ - blogs: Map<Integer, Blog>       │  │   {final, automática}            │
├───────────────────────────────────┤  │ - email: String {final}          │
│ + Controladora()                  │  │ - ip: String {final}             │
│ + crearBlog(nombre, descr):       │  │ - texto: String                  │
│        Integer                    │  ├──────────────────────────────────┤
│ + borrarBlog(codigo)              │  │ + Comentario(email, ip, texto)   │
│ + getBlogs(): Map<Integer,String> │  │ + getFechaCreacion()             │
│ + crearPublicacion(cod, titulo,   │  │ + getEmail()                     │
│        texto, creador)            │  │ + getIp()                        │
│ + getPublicaciones(cod): List     │  │ + getTexto()/setTexto()          │
│ + getPublicacion(cod, num):       │  │ + toString(): String             │
│        String                     │  └──────────────────────────────────┘
│ + agregarComentario(cod, num,     │
│        email, ip, texto)          │  usa ────────────────────────────►
│ + borrarComentario(cod, num,      │   (la Controladora usa Blog y
│        pos)                       │    Publicacion; navega por las
│ + actualizarNombreBlog(cod, nom)  │    asociaciones Blog→Publicacion
│ + actualizarDescripcionBlog(...)  │    →Comentario)
│ + getInfoBlog(cod): String        │
│ - obtenerBlog(cod): Blog {priv.}  │
│ + esEmailValido(email): boolean   │
└───────────────────────────────────┘

interfaz.ProgramaPrincipal ──usa──► control.Controladora
   (main: menú de consola con una subrutina por opción:
    crear/borrar/listar blogs, ver/actualizar info, crear
    publicaciones, listarlas, verlas y administrar comentarios;
    atrapa las excepciones de las capas inferiores)
```

Restricciones implementadas (defensive programming):

- Blog: nombre y descripción no nulos ni vacíos.
- Publicacion: título, texto y nombre de creador no nulos ni vacíos.
- Comentario: texto no nulo ni vacío.
- Controladora: el código de blog debe existir; el número de publicación
  debe ser válido; el email debe tener formato válido; el código de blog
  se asigna con el consecutivo (1, 2, 3, ...) que se incrementa tras
  cada creación.
- La interfaz atrapa cualquier excepción y muestra su mensaje sin
  detener el programa.

## Cómo ejecutar

Compilar (desde la carpeta del proyecto `Blog`):

```
javac -encoding UTF-8 -d bin src/logica/*.java src/control/*.java src/interfaz/*.java
java -cp bin interfaz.ProgramaPrincipal
```

O directamente desde Eclipse: clic derecho en `ProgramaPrincipal.java`
→ **Run As → Java Application**.
