import java.util.Scanner;

/*
 * Programa que lee un numero entero o positivo y dice si corresponde a un número primo.
 * Entradas y Restricciones:
 * - Número entero y positivo.
 * Salidas:
 * - Resultado booleano si es primo o no.
 */
public class EsPrimo {

    public static boolean esPrimo(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Número debe ser Integer Positivo");
        }
        if (num == 1) {
            return false;
        }

        for (int m = 2; m <= (int) Math.sqrt(num); m++) {
            if (num % m == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Escriba un numero entero positivo:");
            int num = Integer.parseInt(sc.nextLine().trim());
            boolean result = esPrimo(num);
            System.out.println("Its " + result + " " + num + " is a prime number");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
