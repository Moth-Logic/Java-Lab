import java.util.Scanner;

public class CalcularFactorial {

    /*
     * Funcion que calcula el factorial de un numero.
     * Entradas y restricciones:
     * - numero positivo entero
     * Salidas:
     * - Factorial del numero (long)
     */
    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("numero debe ser int positivo.");
        }
        long fact = 1;
        while (num > 1) {
            fact *= num;
            num -= 1;
        }
        return fact;
    }

    public static void main(String[] args) {
        // Programa Principal del factorial
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Escriba un numero entero positivo: ");
            int num = Integer.parseInt(sc.nextLine().trim());
            long result = factorial(num);
            System.out.println(num + "! = " + result);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
