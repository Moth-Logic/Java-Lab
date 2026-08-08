import java.util.Scanner;

public class MCMEficiente {

    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long mcm(int a, int b) {
        int d = mcd(a, b); // paso 1
        return ((long) a * b) / d; // paso 2
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ingrese el segundo número: ");
        int b = Integer.parseInt(sc.nextLine().trim());

        long resultado = mcm(a, b);

        System.out.println("El MCM es: " + resultado);

        sc.close();
    }
}
