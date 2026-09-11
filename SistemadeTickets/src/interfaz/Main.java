package interfaz;

import java.util.Scanner;

import logica.SistemaTickets;
import logica.Ticket;

// Main class — the console UI for the Ticket System.
// This class ONLY handles user input/output. All business logic lives in
// the logica package (SistemaTickets, Cliente, Ticket).
// This separation makes it easy to swap the UI (e.g., add a web interface)
// without changing the logic.
public class Main {

    public static void main(String[] args) {
        SistemaTickets sistema = new SistemaTickets();  // Create the ticket system
        Scanner sc = new Scanner(System.in);             // For reading user input from console
        boolean salir = false;                           // Controls the main loop

        // Main loop: keep showing the menu until the user chooses to exit.
        while (!salir) {
            sistema.mostrarEstado();  // Show current state (clients, queue, history)
            mostrarMenu();            // Show the menu options
            String opcion = sc.nextLine();  // Read user's choice as a string

            // Wrap everything in try-catch so errors don't crash the program.
            try {
                switch (opcion) {
                    case "1":
                        // Register a new client.
                        System.out.print("ID del cliente: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre del cliente: ");
                        String nombre = sc.nextLine();
                        sistema.agregarCliente(id, nombre);  // May throw if ID already exists
                        System.out.println("Cliente agregado.");
                        break;

                    case "2":
                        // Create a ticket for an existing client.
                        System.out.print("ID del cliente que solicita el tiquete: ");
                        String idTicket = sc.nextLine();
                        sistema.agregarTicket(idTicket);  // May throw if client not found
                        System.out.println("Tiquete agregado a la cola.");
                        break;

                    case "3":
                        // Serve the next ticket (FIFO order).
                        Ticket atendido = sistema.atenderTicket();  // May throw if queue is empty
                        System.out.println("Atendiendo: " + atendido);
                        break;

                    case "4":
                        // Discard (cancel) the next ticket without serving it.
                        Ticket descartado = sistema.descartarTicket();  // May throw if queue is empty
                        System.out.println("Tiquete descartado: " + descartado);
                        break;

                    case "5":
                        // Clear the history of served tickets.
                        sistema.limpiarHistorial();
                        System.out.println("Historial limpiado.");
                        break;

                    case "6":
                        // Exit the program.
                        salir = true;
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (Exception e) {
                // If anything goes wrong (invalid ID, empty queue, etc.),
                // show the error message and let the user try again.
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();  // Always close the scanner when done
    }

    // Display the menu options to the console.
    private static void mostrarMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Agregar tiquete a la cola");
        System.out.println("3. Atender siguiente tiquete");
        System.out.println("4. Descartar siguiente tiquete");
        System.out.println("5. Limpiar historial");
        System.out.println("6. Salir");
        System.out.print("Elija una opcion: ");
    }
}