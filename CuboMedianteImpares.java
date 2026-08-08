import java.util.Scanner;

/*
 * Moth_Logic:
 * Este programa solicita un número entero positivo n y calcula su cubo
 * utilizando la suma de números impares consecutivos. Primero encuentra
 * el n-ésimo número impar y luego suma los siguientes n números impares
 * para obtener n^3. Finalmente, imprime el resultado.
 */
public class CuboMedianteImpares {

    public static long cubo(int n) {
        int i = 1;
        long ini = 1;
        long acu = 0;

        // Encontrar el n-ésimo impar
        while (i <= n - 1) {
            ini = ini + (2 * i);
            i += 1;
        }

        acu = ini;
        i = 0;

        // Sumar los siguientes n-1 impares
        while (i < n - 1) {
            ini = ini + 2;
            acu = acu + ini;
            i += 1;
        }

        return acu;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indique el numero para elevar al cubo: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        if (n != 0) {
            if (n != 1) {
                long res = cubo(n);
                System.out.println("El cubo de " + n + " es: " + res);
            } else {
                System.out.println(n);
            }
        } else {
            System.out.println(n);
        }

        sc.close();
    }
}
