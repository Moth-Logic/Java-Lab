import java.util.Scanner;

/*
 * Moth_Logic:
 * Este programa recibe un número entero n y un dígito d. Recorre cada
 * dígito de n y construye un nuevo número eliminando todas las apariciones
 * del dígito d. Mantiene el orden original de los dígitos restantes.
 */
public class RemoverDigitoEntero {

    public static long elimina(int n, int d) {
        long res = 0;
        long fac = 1;

        while (n > 0) {
            int dig = n % 10;
            n = n / 10;

            if (dig != d) {
                res = res + dig * fac;
                fac = fac * 10;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ingrese el dígito a eliminar: ");
        int d = Integer.parseInt(sc.nextLine().trim());

        long resultado = elimina(n, d);
        System.out.println(resultado);

        sc.close();
    }
}
