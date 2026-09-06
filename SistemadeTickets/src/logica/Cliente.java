package logica;

/**
 * Representa un cliente del sistema.
 * El ID debe contener unicamente digitos y guiones.
 */
public class Cliente {

    private final String id;
    private final String nombre;

    public Cliente(String id, String nombre) {
        if (!esIdValido(id)) {
            throw new IllegalArgumentException("ID de cliente invalido: " + id);
        }
        this.id = id;
        this.nombre = nombre;
    }
    public static boolean esIdValido(String id) {
        return id != null && !id.isEmpty() && id.matches("[0-9-]+");
    }
    /**Crea un cliente validando el formato de su ID. Valida que un ID contenga solo digitos y guiones, y no este vacio.**/
    public static boolean esIdValido(String id) {
        return id != null && !id.isEmpty() && id.matches("[0-9-]+");
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nombre=" + nombre + "]";
    }
}