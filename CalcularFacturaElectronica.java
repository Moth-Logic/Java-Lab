import java.util.Scanner;

public class CalcularFacturaElectronica {

    public static double calcularTarifa(int mensajes, int minutosPlenos, int minutosReducidos) {
        double tarifaBase = 5000;
        double total = tarifaBase;

        // Mensajes (100 incluidos)
        if (mensajes > 100) {
            total += (mensajes - 100) * 5;
        }

        // Minutos plenos (60 incluidos)
        if (minutosPlenos > 60) {
            total += (minutosPlenos - 60) * 35;
        }

        // Minutos reducidos (todos se cobran)
        total += minutosReducidos * 20;

        // IVA 15%
        double totalConIva = total * 1.15;

        return totalConIva;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese cantidad de mensajes: ");
        int mensajes = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ingrese minutos plenos: ");
        int plenos = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ingrese minutos reducidos: ");
        int reducidos = Integer.parseInt(sc.nextLine().trim());

        double monto = calcularTarifa(mensajes, plenos, reducidos);

        System.out.println("Monto a pagar: " + monto);

        sc.close();
    }
}
