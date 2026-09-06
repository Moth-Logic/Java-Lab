package interfaz;

import java.util.Scanner;

import logica.SistemaTickets;
import logica.Ticket;

/**
 * Interfaz de texto para el Sistema de Tickets. Toda la logica vive
 * en el paquete logica; esta clase solo lee/escribe consola y atrapa
 * los errores que la logica pueda lanzar.
 */
public class Main {

    public static void main(String[] args) {
        SistemaTickets sistema = new SistemaTickets();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            sistema.mostrarEstado();
            mostrarMenu();
            String opcion = sc.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("ID del cliente: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre del cliente: ");
                        String nombre = sc.nextLine();
                        sistema.agregarCliente(id, nombre);
                        System.out.println("Cliente agregado.");
                        break;

                    case "2":
                        System.out.print("ID del cliente que solicita el tiquete: ");
                        String idTicket = sc.nextLine();
                        sistema.agregarTicket(idTicket);
                        System.out.println("Tiquete agregado a la cola.");
                        break;

                    case "3":
                        Ticket atendido = sistema.atenderTicket();
                        System.out.println("Atendiendo: " + atendido);
                        break;

                    case "4":
                        Ticket descartado = sistema.descartarTicket();
                        System.out.println("Tiquete descartado: " + descartado);
                        break;

                    case "5":
                        sistema.limpiarHistorial();
                        System.out.println("Historial limpiado.");
                        break;

                    case "6":
                        salir = true;
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

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