package logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

// SistemaTickets (Ticket System) — the main business logic class.
// Manages three data structures:
// - clientes (HashMap): fast lookup of clients by ID (O(1) access)
// - colaTickets (Queue): FIFO queue of tickets waiting to be served
// - historial (List): keeps a record of all tickets that have been served
// This class follows the "separation of concerns" principle:
// it handles logic only, no UI (the Main class handles the console UI).
public class SistemaTickets {

    private final Map<String, Cliente> clientes;    // HashMap for O(1) client lookup by ID
    private final Queue<Ticket> colaTickets;         // FIFO queue: first ticket in = first served
    private final List<Ticket> historial;             // History of all served tickets

    // Constructor: initialize all three data structures as empty.
    public SistemaTickets() {
        this.clientes = new HashMap<>();       // Map from client ID → Cliente object
        this.colaTickets = new LinkedList<>();  // LinkedList implements Queue interface
        this.historial = new LinkedList<>();    // Simple list to store past tickets
    }

    // Register a new client. Throws if the ID already exists (no duplicates).
    public void agregarCliente(String id, String nombre) {
        if (clientes.containsKey(id)) {
            throw new IllegalStateException("Cliente ya existe: " + id);
        }
        Cliente cliente = new Cliente(id, nombre);  // Cliente constructor validates the ID
        clientes.put(id, cliente);  // Add to the map for fast lookup later
    }

    // Create a ticket for an existing client and add it to the queue.
    // The client must be registered first (otherwise we don't know who they are).
    public void agregarTicket(String idCliente) {
        if (!clientes.containsKey(idCliente)) {
            throw new NoSuchElementException("Cliente no encontrado: " + idCliente);
        }
        colaTickets.add(new Ticket(idCliente));  // Ticket auto-generates its number
    }

    // Serve the next ticket (FIFO — oldest ticket first).
    // Moves the ticket from the queue to the history list.
    public Ticket atenderTicket() {
        if (colaTickets.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        Ticket ticket = colaTickets.poll();  // poll() removes and returns the front element
        historial.add(ticket);               // Record it in the history
        return ticket;
    }

    // Discard (cancel) the next ticket without serving it.
    // Unlike atenderTicket(), this does NOT add to history.
    public Ticket descartarTicket() {
        if (colaTickets.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        return colaTickets.poll();  // Just remove it, don't record it
    }

    // Clear the served-ticket history.
    public void limpiarHistorial() {
        historial.clear();
    }

    // Print the current state of all three data structures (for debugging/display).
    public void mostrarEstado() {
        System.out.println("Clientes registrados:");
        System.out.println(clientes);   // HashMap.toString() shows all key-value pairs
        System.out.println("Cola de atencion:");
        System.out.println(colaTickets);  // LinkedList.toString() shows all tickets in order
        System.out.println("Historial:");
        System.out.println(historial);
    }
}