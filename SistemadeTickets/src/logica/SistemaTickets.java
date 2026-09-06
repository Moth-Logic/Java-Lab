package logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

public class SistemaTickets {

    private final Map<String, Cliente> clientes;
    private final Queue<Ticket> colaTickets;
    private final List<Ticket> historial;

    public SistemaTickets() {
        this.clientes = new HashMap<>();
        this.colaTickets = new LinkedList<>();
        this.historial = new LinkedList<>();
    }

    public void agregarCliente(String id, String nombre) {
        if (clientes.containsKey(id)) {
            throw new IllegalStateException("Cliente ya existe: " + id);
        }
        Cliente cliente = new Cliente(id, nombre); // puede lanzar IllegalArgumentException
        clientes.put(id, cliente);
    }


    public void agregarTicket(String idCliente) {
        if (!clientes.containsKey(idCliente)) {
            throw new NoSuchElementException("Cliente no encontrado: " + idCliente);
        }
        colaTickets.add(new Ticket(idCliente));
    }


    public Ticket atenderTicket() {
        if (colaTickets.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        Ticket ticket = colaTickets.poll();
        historial.add(ticket);
        return ticket;
    }

    public Ticket descartarTicket() {
        if (colaTickets.isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        return colaTickets.poll();
    }

    /** Vacia el historial de tiquetes atendidos. */
    public void limpiarHistorial() {
        historial.clear();
    }

    public void mostrarEstado() {
        System.out.println("Clientes registrados:");
        System.out.println(clientes);
        System.out.println("Cola de atencion:");
        System.out.println(colaTickets);
        System.out.println("Historial:");
        System.out.println(historial);
    }
}