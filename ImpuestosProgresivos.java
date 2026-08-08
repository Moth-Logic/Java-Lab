import java.util.Scanner;

public class ImpuestosProgresivos {

    public static double calcularImpuesto(double salario) {
        double impuesto = 0;

        if (salario > 1200) {
            impuesto += (salario - 1200) * 0.15;
            salario = 1200;
        }

        if (salario > 800) {
            impuesto += (salario - 800) * 0.10;
            salario = 800;
        }

        // De 0 a 800 es exento (no suma nada)

        return impuesto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el salario: ");
        double salario = Double.parseDouble(sc.nextLine().trim());

        double impuesto = calcularImpuesto(salario);

        System.out.println("Impuesto a pagar: " + impuesto);

        sc.close();
    }
}
