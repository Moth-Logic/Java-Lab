import java.util.Scanner;

public class VerificarCuadradoPerfecto {

    public static boolean esCuadradoPerfecto(long m) {
        if (m < 0) {
            return false;
        }

        long raiz = (long) Math.sqrt(m);
        return raiz * raiz == m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        long m = Long.parseLong(sc.nextLine().trim());

        if (esCuadradoPerfecto(m)) {
            System.out.println("Sí es un cuadrado perfecto");
        } else {
            System.out.println("No es un cuadrado perfecto");
        }

        sc.close();
    }
}
