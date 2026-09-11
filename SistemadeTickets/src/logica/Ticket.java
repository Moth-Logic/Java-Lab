package logica;

// Ticket class — represents a service ticket in the queue system.
// Key OOP concepts:
// - Static field: 'consecutivo' is shared across ALL Ticket instances (class-level, not instance-level)
// - Auto-increment: each new ticket gets the next number (100, 101, 102, ...)
// - final fields: codigo and idCliente are set once and never change
// - Reuses Cliente.esIdValido() for validation (code reuse!)
public class Ticket {

    private static int consecutivo = 100;  // Shared counter — starts at 100, incremented for each ticket

    private final int codigo;          // Unique ticket number (auto-assigned)
    private final String idCliente;    // The client who requested this ticket

    // Constructor: validates the client ID, then assigns the next available ticket number.
    // The post-increment (consecutivo++) returns the current value, then increments it.
    public Ticket(String idCliente) {
        if (!Cliente.esIdValido(idCliente)) {
            throw new IllegalArgumentException("ID de cliente invalido para el ticket: " + idCliente);
        }
        this.idCliente = idCliente;
        this.codigo = consecutivo++;  // First ticket gets 100, next gets 101, etc.
    }

    public int getCodigo() {
        return codigo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Ticket [Codigo=" + codigo + ", ClienteID=" + idCliente + "]";
    }
}