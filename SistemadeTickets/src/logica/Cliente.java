package logica;

// Cliente (Client) class — represents a person who can request tickets.
// Key OOP concepts:
// - final fields: id and nombre can never be changed after creation (immutable)
// - Static validation method: esIdValido() can be called without creating a Cliente
// - Regex validation: IDs must contain only digits and hyphens ([0-9-]+)
// - toString(): overridden for clean printing with System.out.println()
public class Cliente {

    private final String id;       // Client ID — 'final' means it can't be changed after creation
    private final String nombre;   // Client name — also immutable

    // Constructor: validates the ID format before accepting it.
    // If the ID is invalid, it throws IllegalArgumentException immediately.
    public Cliente(String id, String nombre) {
        if (!esIdValido(id)) {
            throw new IllegalArgumentException("ID de cliente invalido: " + id);
        }
        this.id = id;
        this.nombre = nombre;
    }

    // Static method: checks if a string is a valid client ID.
    // Can be called without a Cliente instance: Cliente.esIdValido("123-45")
    // Uses regex: null, empty, or anything with non-digit/non-hyphen characters is rejected.
    public static boolean esIdValido(String id) {
        return id != null && !id.isEmpty() && id.matches("[0-9-]+");
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // toString() lets us print the client with System.out.println(cliente).
    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nombre=" + nombre + "]";
    }
}