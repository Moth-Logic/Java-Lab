import java.util.Scanner;

/*
 * Moth_Logic:
 * Este programa solicita un número entero mayor que 0 y aplica la conjetura de Collatz.
 * Si el número es par, se divide entre 2; si es impar, se multiplica por 3 y se le suma 1.
 * El proceso continúa hasta que el número llega a 1, imprimiendo cada valor intermedio.
 */
public class ConjeturaCollatz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero entero mayor que 0: ");
        long a = Long.parseLong(sc.nextLine().trim());

        if (a > 0) {
            if (a == 1) {
                System.out.println(1);
            } else {
                while (a != 1) {
                    if (a % 2 == 0) {
                        a = a / 2;
                    } else {
                        a = 3 * a + 1;
                    }

                    System.out.println(a);
                }
            }
        } else {
            System.out.println("ERROR: Numero debe ser mayor que 0");
        }

        sc.close();
    }
}
