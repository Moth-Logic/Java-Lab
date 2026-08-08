import java.util.Scanner;

public class MCDEuclides {

    public static int mcdEuclides(int m, int n) {
        // Asegurar que M sea el mayor
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        while (n != 0) {
            int r = m % n; // residuo
            m = n;
            n = r;
        }

        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int m = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ingrese el segundo número: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int resultado = mcdEuclides(m, n);

        System.out.println("El MCD es: " + resultado);

        sc.close();
    }
}
