import java.util.Scanner;

public class ListarNumerosPrimos {

    /*
     * Programa que lee un numero entero o positivo y imprime todos los numeros primos desde 2 hasta N.
     * Entradas y Restricciones:
     * - Número entero y positivo.
     * Salidas:
     * - Retorna true si num es primo, false en caso contrario
     */
    public static boolean esPrimo(int num) {
        if (num < 2) {
            throw new IllegalArgumentException("Número debe ser Integer Positivo mayor a 2");
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        // Solo revisar numeros impares
        for (int m = 3; m <= (int) Math.sqrt(num); m += 2) {
            if (num % m == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Escriba un numero entero positivo: ");
            int num = Integer.parseInt(sc.nextLine().trim());
            if (num < 2) {
                throw new IllegalArgumentException("Número debe ser mayor a 2");
            }
            System.out.println("Números primos desde 2 hasta " + num + ":");
            for (int i = 2; i <= num; i++) {
                if (esPrimo(i)) { // Revisar cada i, no "num"
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
